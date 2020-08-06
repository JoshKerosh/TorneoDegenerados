/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josh
 */
public class LogoutCommand extends BaseCommand{
    public static final String COMMAN_NAME = "LOGOUT";
    
    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }

    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) {
        
        if(validArgs(args, out)){
            /*
                ELIMINAR JUGADOR DEL MODELO
            */
            controlador.getModelo().deslogearJugadorLocal();
            write(out, "Usuario DesLogeado");
            String message = getCommandName();   
            log(message);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogoutCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            controlador.Limpiar();
            controlador.reset();
            /*
                PONER PANTALLA PRINCIPAL
            */

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
