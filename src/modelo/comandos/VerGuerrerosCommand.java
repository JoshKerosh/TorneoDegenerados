/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;
import java.util.Arrays;

/**
 *
 * @author Josh
 */
public class VerGuerrerosCommand extends BaseCommand{
    public static final String COMMAN_NAME = "VERGUERREROS";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            String SGuerreros = "";
            for(int i = 0; i < controlador.modelo.getListaGuerreros().size(); i++){
                SGuerreros += controlador.modelo.getListaGuerreros().get(i).getName() + " ";
            }
            write(out, SGuerreros);
            
        }
    }

    private boolean validArgs(String[] args, OutputStream out){
        boolean valid = true; 
        if((args != null)){
            write(out, "No se esperan argumentos");
            valid = false;
        } 
        return valid;
    }
}
