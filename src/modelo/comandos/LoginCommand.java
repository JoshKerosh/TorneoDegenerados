/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jugador;
import modelo.ModeloTorneo;
import modelo.Scores;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author josh
 */
public class LoginCommand extends BaseCommand{
    public static final String COMMAN_NAME = "LOGIN";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            Jugador jugador = ValidateUser(args[0]);
            if(jugador != null){
                write(out, "Usuario Logeado");
                controlador.getModelo().cargarJugador(jugador);
                controlador.cambiarImgFondo("charSelect");
            } else {
                //jugador = createUser(args[0]);
                write(out, "Usuario no existe");
            }
            
        }
    }

    private boolean validArgs(String[] args, OutputStream out){
        boolean valid = true; 
        if((args == null)){
            write(out, "No inserto el nombre de usuario");
            valid = false;
        } else if((args.length > 1)){
            write(out, "solamente insertar un nombre de usuario");
            valid = false;
        }
        return valid;
    }

    private Jugador ValidateUser(String user) {
        Jugador jugador = null;
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader;
            reader = new FileReader("C:\\Users\\Josh\\Desktop\\Netbeans Projects\\TorneoComandos\\src\\recursos\\usersDB.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray userList = (JSONArray) obj;
             
            int i = 0;
            while(jugador == null && i < userList.size()){
                jugador = validate_load((JSONObject) userList.get(i), user);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModeloTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jugador;
    }
    
    private Jugador validate_load(JSONObject users, String user) {
        
        Jugador member = null;
        JSONObject userObject = (JSONObject) users.get("user");
        String userName = (String) userObject.get("userName");  
        if (user.equals(userName)){
            member = loadPlayer(userObject);
        }
        return member;
    }
  
    private Jugador loadPlayer(JSONObject userObject) {
        Jugador j = new Jugador();
        j.setNombre((String) userObject.get("userName"));
        Scores p = new Scores(j, Integer.parseInt((String)userObject.get("ataquesLetales")), 
                                             Integer.parseInt((String)userObject.get("ataquesFallados")), 
                                             Integer.parseInt((String)userObject.get("muertes")),     
                                             Integer.parseInt((String)userObject.get("ganadas")),
                                             Integer.parseInt((String)userObject.get("perdidas")),
                                             Integer.parseInt((String)userObject.get("rendiciones"))
                                            );
        j.setPuntuaciones(p);
        return j;
    }
    /*
    private Jugador createUser(String name){
        Jugador j = new Jugador();
        j.setNombre(name);
        Puntuaciones p = new Puntuaciones(j,0,0,0,0,0,0);
        j.setPuntuaciones(p);
        
        
        return j;
    }*/
}
