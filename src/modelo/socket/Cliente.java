
package modelo.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Torneo Comandos
 */
public class Cliente extends Observable implements Runnable {
    
    private String host;
    private int puerto;
    
    public Cliente() {
    }
    
    public Cliente(String host) {
            this.host = host;
            this.puerto = 5000;
    }

    @Override
    public void run() {        
        DataInputStream in;
        try {
            //Crea socket para conectarme
            Socket sc = new Socket(host, puerto);
            in = new DataInputStream(sc.getInputStream());
            while(true){
                
                String mensaje = in.readUTF();
                System.out.println("Servidor envia: " + mensaje);
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
            }
        } catch (IOException ex) {
            System.out.println(ex);
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    public int getPuerto() {
        return puerto;
    }
    
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
 
}
