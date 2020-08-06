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
 * @author josh
 */
public class ErrorCommand extends BaseCommand{
    private static final String COMMAND_NAME = "ERROR";       
    
    @Override       
    public String getCommandName() {   
        return COMMAND_NAME;   
    }       
    
    @Override       
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) {           
        String message = "Error al invocar el comando";   
        write(out, message);
        log(message);
    }   
    
}
