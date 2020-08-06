/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;

/**
 *
 * @author Josh
 */
public class ChatCommand extends BaseCommand{
    public static final String COMMAN_NAME = "CHAT";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = "";
            for(int i = 0;i<args.length; i++){
                message += args[i];
            }
            log(getCommandName() + " [" + message + "]");
            //message es el mensaje
            
        }
    }

    private boolean validArgs(String[] args, OutputStream out){
        boolean valid = true; 
        if((args == null)){
            write(out, "se esperan un mensaje");
            valid = false;
        } 
        return valid;
    }
}
