/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.prototype.PrototypeFactory;
import modelo.socket.Cliente;

/**
 *
 * @author Josh
 */
public class Jugador extends Cliente{
    
    private String nombre;
    private Scores puntuaciones;
    private HashMap<String,Guerrero> guerreros;
    private Socket sock;
    //Singleton
    public Jugador() {
        guerreros = new HashMap<>();
        puntuaciones = getPuntuaciones();
    }
    
    public void addGuerrero(Guerrero guerrero){
        if(guerreros.size() < 5){
            this.guerreros.put(guerrero.getName(), guerrero);
        }
        else {
            System.out.println("ya hay 5 guerreros");
        }
    }


    //entrar a la batalla (necesita dir);
    public void SetBatalla(String ip, int puerto){
        this.setHost(ip);
        this.setPuerto(puerto);
    }
    
    //getters y setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Scores getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(Scores puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
    
    public boolean revisarEquipo(String guerrero){
        boolean pertenece = false;
            if(guerreros.get(guerrero) != null){
                return true;
            }
        return pertenece;
    }
    
    public Guerrero getGuerrero(String name){
        return guerreros.get(name);
    }
    
    public int tamEquipo(){
        return guerreros.size();
    }
    
    public void selectGuerrero(String name){
        Guerrero guerrero = (Guerrero)PrototypeFactory.getPrototype("guerrero"+name);
        addGuerrero(guerrero);
    }
    
    public void selectArma(String guerrero, String name){
        Arma arma = (Arma)PrototypeFactory.getPrototype("arma" + name);
        getGuerrero(guerrero).addArma(arma);
    }
    
    public void run() {        
        DataInputStream in;
        try {
            //Crea socket para conectarme
            int puerto = getPuerto();
            String ip = getHost();
            sock = new Socket(ip, puerto);
            in = new DataInputStream(sock.getInputStream());
            
            while(true){
                
               // System.out.println(mensaje);   
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                if(mensaje.equals(">Rendicion")){
                    this.puntuaciones.ganadas++;
                }
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void enviarInfo(String mensaje) {
        time();
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(sock.getOutputStream());
            dos.writeUTF(mensaje);
            
        } catch (IOException ex) {
            Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    private void time(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean equipoCompleto(){
        boolean completo = true;
        if(tamEquipo() != 5){
            completo = false;
        }
        for(Map.Entry<String, Guerrero> entry : guerreros.entrySet()){
            if(entry.getValue().tamArmamento() != 5){
                    completo = false;
            }
        }
        return completo;
    }

    public HashMap<String, Guerrero> getGuerreros() {
        return guerreros;
    }

    public void vaciarEquipo() {
        guerreros.clear();
    }
}
