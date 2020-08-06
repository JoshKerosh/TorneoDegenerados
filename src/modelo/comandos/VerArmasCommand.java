/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;
import java.util.Arrays;
import modelo.Jugador;

/**
 *
 * @author Josh
 */
public class VerArmasCommand extends BaseCommand{
    public static final String COMMAN_NAME = "VERARMAS";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            String SArmas = "";
            for(int i = 0; i < controlador.modelo.getListaArmas().size(); i++){
                SArmas += controlador.modelo.getListaArmas().get(i).getName() + " ";
            }
            write(out, SArmas);
            
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
