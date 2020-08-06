/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;


import controlador.ControladorTorneo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author josh
 */

public abstract class BaseCommand implements ICommand {       
    
    @Override       
    public abstract String getCommandName();       
    
    @Override       
    public abstract void execute(String[] args, OutputStream out, ControladorTorneo controlador);       
    
    public void log( String message) {           
        try {   
            try {//"C:\\Users\\Josh\\Desktop\\Netbeans Projects\\TorneoComandos\\src\\recursos\\log.txt"
                File logFile = new File("C:\\Users\\Josh\\Desktop\\Netbeans Projects\\TorneoComandos\\src\\recursos\\log.txt");
                FileWriter writer = new FileWriter( logFile , true);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date(); 
                writer.write(formatter.format(date) + " : " + message + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }        
        } 
        catch (Exception e) {   
            
        }   
    }    
    public void write(OutputStream out, String message) {  
        
        try {  
            
            out.write(message.getBytes());   
            out.flush();  
            
        } 
        catch (Exception e) {   
            e.printStackTrace();   
        }   
    } 
    
}
