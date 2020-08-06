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
public class MostrarCommand extends BaseCommand{
    public static final String COMMAN_NAME = "MOSTRAR";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            
        }
    }

    private boolean validArgs(String[] args, OutputStream out){
        boolean valid = true; 
        if((args == null)){
            write(out, "Se esperan un argumento");
            valid = false;
        } else if((args.length != 1)){
            write(out, "Se esperan unicamente un argumento");
            valid = false;
        } 
        return valid;
    }
}
