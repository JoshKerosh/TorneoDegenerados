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
public interface ICommand {       
    public String getCommandName();       
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador);   
}
