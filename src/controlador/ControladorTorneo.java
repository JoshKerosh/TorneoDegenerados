/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import modelo.Arma;
import modelo.Guerrero;
import modelo.ModeloTorneo;
import modelo.comandos.CommandManager;
import vista.PantallaTorneo;

/**
 *
 * @author Josh
 */
public class ControladorTorneo extends ControladorComandos{
    
    //Singleton
    public ControladorTorneo(){
        vista = PantallaTorneo.getInstance();
        modelo = new ModeloTorneo();
        manager = CommandManager.getInstance();
        _init_();
    }
    
    public void _init_(){
        //CommandLine
        vista.commandLine.addKeyListener(this);
        for (MouseListener mouseListener : vista.commandLine.getMouseListeners()) {
            vista.commandLine.removeMouseListener(mouseListener);
        }
        Style style = vista.commandLine.addStyle("commandLineStyle", null);
        StyleConstants.setForeground(style, Color.green);
        addCommandReceiver();
    }
    
    public void cambiarImgFondo(String imagen){
        ImageIcon icon;
        switch(imagen){    
            case "charSelect":
                icon = new ImageIcon(getClass().getResource("/recursos/charSelect.png"));
                break;
            case "batalla":
                icon = new ImageIcon(getClass().getResource("/recursos/imgBatalla.png"));
                break;
            case "portada":
                icon = new ImageIcon(getClass().getResource("/recursos/imgPortada.png"));
                break;
            default :
                icon = new ImageIcon(getClass().getResource("/recursos/imgPortada.png"));
                break;
        }
        vista.imgFondo.setIcon(icon);
    }

    public void Iniciar(){
        cambiarImgFondo("portada");
        vista.pnlBatalla.setVisible(false);
        vista.setVisible(true);
    }

    public void cargarPantallaBatalla() {
        ArrayList<String> nomGuerreros = new ArrayList<>();
        
        HashMap<String, Guerrero> guerreros = modelo.getJugadorLocal().getGuerreros();
        
        for(Map.Entry<String, Guerrero> entry : guerreros.entrySet()){
            nomGuerreros.add(entry.getKey());
        }
        ImageIcon icon;
        icon = new ImageIcon(getClass().getResource("/recursos/" +  guerreros.get(nomGuerreros.get(0)).getImagen()));
        vista.lGuerreroImg1.setIcon(icon);
        icon = new ImageIcon(getClass().getResource("/recursos/" +  guerreros.get(nomGuerreros.get(1)).getImagen()));
        vista.lGuerreroImg2.setIcon(icon);
        icon = new ImageIcon(getClass().getResource("/recursos/" +  guerreros.get(nomGuerreros.get(2)).getImagen()));
        vista.lGuerreroImg3.setIcon(icon);
        icon = new ImageIcon(getClass().getResource("/recursos/" +  guerreros.get(nomGuerreros.get(3)).getImagen()));
        vista.lGuerreroImg4.setIcon(icon);
        icon = new ImageIcon(getClass().getResource("/recursos/" +  guerreros.get(nomGuerreros.get(4)).getImagen()));
        vista.lGuerreroImg5.setIcon(icon);
        
        Mostrar(nomGuerreros.get(0));
    }
    
    public void Mostrar(String name){
        
        Guerrero guerrero = this.modelo.getJugadorLocal().getGuerrero(name);
        vista.lGuerreroName.setText(name);
        vista.lGuerreroHP.setText("" + guerrero.getVida());
        
        ArrayList<String> nomArmas = new ArrayList<>();
        
        HashMap<String, Arma> armas;
        armas = modelo.getJugadorLocal().getGuerrero(name).getArmas();
        
        for(Map.Entry<String, Arma> entry : armas.entrySet()){
            nomArmas.add(entry.getKey());
        }
        vista.lArma1.setText(nomArmas.get(0));
        vista.lArma2.setText(nomArmas.get(1));
        vista.lArma3.setText(nomArmas.get(2));
        vista.lArma4.setText(nomArmas.get(3));
        vista.lArma5.setText(nomArmas.get(4));
    
        
        FocusGuerrero(name);
    }

    private void FocusGuerrero(String name) {
        int pos = 0;
        int res;
        for(Map.Entry<String, Guerrero> entry : modelo.getJugadorLocal().getGuerreros().entrySet()){
            if(entry.getKey() == name){
                MarcarBorde(pos);
            }
            else{
                pos++;
            }
        }   
    }

    private void MarcarBorde(int pos) {
        vista.lGuerreroImg5.setOpaque(false);

        vista.lGuerreroImg5.setOpaque(false);

        vista.lGuerreroImg5.setOpaque(false);

        vista.lGuerreroImg5.setOpaque(false);

        vista.lGuerreroImg5.setOpaque(false);

        switch(pos){
            case 0:
                vista.lGuerreroImg1.setOpaque(true);
                break;
            case 1:
                vista.lGuerreroImg2.setOpaque(true);
                break;
            case 2:
                vista.lGuerreroImg3.setOpaque(true);
                break;
            case 3:
                vista.lGuerreroImg4.setOpaque(true);
                break;
            case 4:
                vista.lGuerreroImg5.setOpaque(true);
                break;
        }
    }

    public void reset() {
        cambiarImgFondo("portada");
        vista.pnlBatalla.setVisible(false);
    }
    
    public void menuSel() {
        cambiarImgFondo("charSelect");
        vista.pnlBatalla.setVisible(false);
    }
 
}