/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.Utilities;
import modelo.ModeloTorneo;
import modelo.comandos.CommandManager;
import modelo.comandos.CommandUtil;
import modelo.comandos.ICommand;
import vista.PantallaTorneo;

/**
 *
 * @author Josh
 */
public abstract class ControladorComandos extends Observable implements KeyListener {
    
    public OutputStream cmdOut;
    public PantallaTorneo vista;
    public ModeloTorneo modelo;
    //Comandos
    public CommandManager manager;
    
    public OutputStream getCmdOut() {
        if(cmdOut == null){
            cmdOut = new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    Write(""+(char)(b & 0xFF));
                }
            };
        }
        return cmdOut;
    } 
    
    public PantallaTorneo getVista() {
        return vista;
    }

    public ModeloTorneo getModelo() {
        return modelo;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            try {
                int end = vista.commandLine.getDocument().getLength();
                int start = Utilities.getRowStart(vista.commandLine, end);
                
                String text = vista.commandLine.getText(start, end - start);
                if(text.equals(">")){
                    addCommandReceiver();
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            String linea = getLine();
            if(!linea.isEmpty()){
                EjecutarLinea(linea);    
                addCommandReceiver();
            }
            else {
                addCommandReceiver();
            }
        }
    }
    public abstract void _init_();
    
    private String getLine(){
        try {
            int end = vista.commandLine.getDocument().getLength();
            int start = Utilities.getRowStart(vista.commandLine, end);
        
            
            if (start == end) //elimina la linea vacia luego del enter
            {
                end--;
                start = Utilities.getRowStart(vista.commandLine, end);
            }
            
            String text = vista.commandLine.getText(start, end - start);
            try{ //elimina los ">" y luego los " " del inicio de la linea
                
                while(text.substring(0, 1).equals(">") || text.isEmpty()){
                    text = text.substring(1, text.length());
                }
                while(text.substring(0, 1).equals(" ") || text.isEmpty()){
                    text = text.substring(1, text.length());
                }
            } catch(Exception e){
                
            }     
            return text;
        
        } catch (BadLocationException ex) {
            return "No Command";
        }
    }

    public void addCommandReceiver() {
        Style style = vista.commandLine.getStyle("commandLineStyle");
        StyleConstants.setForeground(style, Color.green);
        try {
            int currentLine = vista.commandLine.getDocument().getLength();
            vista.commandLine.getStyledDocument().insertString(currentLine , "> ", style);
            vista.commandLine.setCaretPosition(vista.commandLine.getDocument().getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Write(String text){
        int line = vista.commandLine.getDocument().getLength();
        Style style = vista.commandLine.getStyle("commandLineStyle");
        try {
            StyleConstants.setForeground(style, Color.white);
            vista.commandLine.getStyledDocument().insertString(line , text , style);  
        } catch (BadLocationException ex) {
            Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Limpiar(){
        vista.commandLine.setText("");
    }
    
    //Comandos
    
    public void EjecutarLinea(String line) {   
        String[] commands = CommandUtil.tokenizerArgs(line);               
        String commandName = commands[0];
        
        if (ValidateCommand(commandName)){
            String[] commandArgs = null;  
            if (commands.length > 1) {                   
                commandArgs = Arrays.copyOfRange(commands, 1, commands.length);   
            }
            ICommand command = manager.getCommand(commandName);
            command.execute(commandArgs, getCmdOut(), (ControladorTorneo) this);
        }
        if(!"".equals(vista.commandLine.getText())){
            Write("\n");
        }
            
    }

    

    private boolean ValidateCommand(String commandName) {
        boolean valid = true;
        if("LOGIN".equals(commandName.toUpperCase())){
            if(hayJugadorLocal()){
                Write("Ya esta alguien logeado");
                valid = false;
            }
        } 
        else {
            if(!hayJugadorLocal()){
                Write("Debe logearse");
                valid = false;
            }
            else if("LOGOUT".equals(commandName.toUpperCase())){
                valid = LogoutConfirmation();
            }
        }
        
        return valid;
    }
    
    public boolean hayJugadorLocal(){
        return (modelo.Logeado());
    }
    
    private boolean LogoutConfirmation() {
            /*Write("Confirmar Logout Y/N");
            String yn ;
            // RECIBIR CONFIRMACION del input
            yn = "Y";
            
            if ("Y".equals(yn)){
                return true;
                
            }
            if("N".equals(yn)){
                return false;
            }
            else {
                return LogoutConfirmation();
            }*/
            
            return true;
    }

    

    
}
