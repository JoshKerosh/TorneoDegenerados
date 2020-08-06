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
public class ExitCommand extends BaseCommand{
    public static final String COMMAN_NAME = "EXIT";

    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(!(args == null)){
            write(out, "No se esperan parametros");
        }
        else{
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExitCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            String message = getCommandName();    
            log(message);
            System.exit(0);
        }
    }

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
}
