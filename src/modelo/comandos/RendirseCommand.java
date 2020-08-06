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
public class RendirseCommand extends BaseCommand{
    public static final String COMMAN_NAME = "RENDIRSE";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            message = controlador.modelo.getJugadorLocal().getNombre() + " se ha rendido";
            write(out, "Te has rendido");
            log(message);
            controlador.modelo.getJugadorLocal().enviarInfo(">Rendicion");
            controlador.vista.lblInstruccion.setText("Torneo");
            controlador.Limpiar();
            controlador.menuSel();
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

