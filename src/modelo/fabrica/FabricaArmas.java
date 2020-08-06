/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.fabrica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Arma;
import modelo.Guerrero;
import modelo.ModeloTorneo;
import modelo.prototype.PrototypeFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Josh
 */
public class FabricaArmas implements IFabrica{
    
    
    public static ArrayList<Arma> crearArmas(){
        ArrayList<Arma> armas = new ArrayList<>(); 
        
        addPrototype();
        
        JSONParser jsonParser = new JSONParser();
        try {
          
            
            
            FileReader reader = new FileReader("src/recursos/armas.json"); 
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray armasList = (JSONArray) obj;
             
            for(int i = 0; i < armasList.size(); i++){
                Arma arma;
                arma = createArma((JSONObject) armasList.get(i));
                armas.add(arma);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModeloTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return armas;
    }

    private static void addPrototype() {
        PrototypeFactory.addPrototype("arma", new Arma("nombre","imagen"));
    }

    private static Arma createArma(JSONObject armas) {
        JSONObject armaObject = (JSONObject) armas.get("arma");
        
        Arma arma = (Arma) PrototypeFactory.getPrototype("arma");
        arma.setName((String) armaObject.get("nombre"));
        arma.setImagen((String) armaObject.get("img"));
        PrototypeFactory.addPrototype("arma" + arma.getName(), arma);
        return arma;
    }
    
}
