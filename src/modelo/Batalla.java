/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.socket.Servidor;

/**
 *
 * @author Josh
 */
public class Batalla extends Servidor{
    String battleLog;
    
    //Singleton
    public Batalla(){
        super();
        battleLog = "batalla Creada \n";
        
    }

    
    public void run() {
        try {
            ServerSocket servidor = null;
            servidor = new ServerSocket(this.getPuerto());
            System.out.println("Servidor iniciado ...");
                
            //conecta el primer jugador
            Socket sc1 = servidor.accept();
            DataInputStream in1 = new DataInputStream(sc1.getInputStream());
            this.addCliente(sc1);
            this.enviarInfoLocal("jugador local");
            addToLog("Jugador1 conectado");
            System.out.println("Jugador1 conectado ...");
            this.enviarInfoLocal(">IniciarBatalla");
            
            //espera 2do jugador
            Socket sc2 = servidor.accept();
            DataInputStream in2 = new DataInputStream(sc2.getInputStream());
            this.addCliente(sc2);
            this.enviarInfoVisita("jugador visita");
            addToLog("Jugador1 conectado");
            System.out.println("Jugador2 conectado ...");
            this.enviarInfoVisita(">IniciarBatalla");
            //Inicia batalla
            boolean ingame = true;
            while(ingame){
                //ronda (un turno cada uno)
                String message;
                //iniciar turno jugador 1
                enviarInfoLocal(">IniTurno");
                message = in1.readUTF();
                
                enviarInfoVisita(message);
                if(">RENDICION".equals(message.toUpperCase())){
                    ingame = false;
                    break;
                }
                
                //finalizar turno jugador1
                enviarInfoLocal(">FinTurno");
                enviarInfoVisita(">IniTurno");
                //iniciar turno jugador2
                message = in2.readUTF();
                
                enviarInfoLocal(message);
                
                enviarInfoVisita(">FinTurno");
                //finalizar turno pj2
            
            
            }
            servidor.close();
            terminarBatalla();
                
                
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addToLog(String message){
        battleLog += (message + "\n");
    }

    private void enviarInfoLocal(String mensaje) {
        time();
        DataOutputStream dos = null;
        try {
            Socket sock = clientes.get(0);
            dos = new DataOutputStream(sock.getOutputStream());
            dos.writeUTF(mensaje);
            
        } catch (IOException ex) {
            Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void enviarInfoVisita(String mensaje) {
        time();
        DataOutputStream dos = null;
        try {
            Socket sock = clientes.get(1);
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

    private void terminarBatalla() {
        
    }
}
