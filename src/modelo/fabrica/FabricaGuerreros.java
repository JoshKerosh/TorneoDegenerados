/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.fabrica;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FabricaGuerreros implements IFabrica{
    
    public static ArrayList<Guerrero> crearGuerreros(){
        ArrayList<Guerrero> guerreros = new ArrayList<>();
        
        addPrototype();
        
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader;
            reader = new FileReader("src/recursos/guerreros.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray guerrerosList = (JSONArray) obj;
             
            for(int i = 0; i < guerrerosList.size(); i++){
                Guerrero guerrero;
                guerrero = createGuerrero((JSONObject) guerrerosList.get(i));
                guerreros.add(guerrero);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModeloTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return guerreros;
    }

    private static Guerrero createGuerrero(JSONObject guerreros) {
        
        JSONObject guerreroObject = (JSONObject) guerreros.get("guerrero");
        
        Guerrero guerrero = (Guerrero) PrototypeFactory.getPrototype("guerrero");
        guerrero.setName((String) guerreroObject.get("nombre"));
        guerrero.setTipo((String) guerreroObject.get("tipo"));
        guerrero.setImagen((String) guerreroObject.get("img"));
        
        PrototypeFactory.addPrototype("guerrero" + guerrero.getName(), guerrero);
        return guerrero;
        
    }

    private static void addPrototype() {
        PrototypeFactory.addPrototype("guerrero", new Guerrero("nombre","tipo","imagen"));
    }
    
}
