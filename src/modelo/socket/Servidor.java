
package modelo.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Torneo Comandos
 */
public class Servidor implements Runnable {

    public ArrayList<Socket> clientes;
    
    private int puerto;
    
    public Servidor() {
        this.puerto = 5000;
        this.clientes = new ArrayList<>();
    }
    
    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado ...");
                
            //conecta el primer jugador
            sc = servidor.accept();
            this.addCliente(sc);
            System.out.println("Cliente conectado ...");
            sc.close();
                
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarInfo(String mensaje){
        for(Socket sock: clientes){
            try {
                DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
                dos.writeUTF(mensaje);
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    public int getPuerto() {
        return puerto;
    }
    
    public void addCliente(Socket sc){
        clientes.add(sc);
    }
    public int cantClientes(){
        return clientes.size();
    }
}
