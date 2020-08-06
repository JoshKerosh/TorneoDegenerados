/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import modelo.Batalla;

/**
 *
 * @author Josh
 */
public class RetarCommand extends BaseCommand{
    public static final String COMMAN_NAME = "RETAR";
    
    @Override
    public String getCommandName() {
        return COMMAN_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) {
        String message = getCommandName() + " " + Arrays.toString(args);
        log(message);
        if(!controlador.modelo.getJugadorLocal().equipoCompleto()){
            message = "equipo incompleto";
            write(out, message);
            log(message);
        }
        else{
            boolean servidor = false; 
            if(args == null){ //esperar reto 
                servidor = crearBatalla(controlador); 
                servidor = agregarJugador("localhost", 5000, controlador);
            }
            else if(validArgs(args,out)){ //retar a alguien
                servidor = agregarJugador(args[0], 5000, controlador);
            }
        
            if(servidor){
                controlador.vista.pnlBatalla.setVisible(true);
                controlador.cambiarImgFondo("batalla");
                controlador.cargarPantallaBatalla();
                controlador.modelo.getJugadorLocal().addObserver(controlador.vista);
                message = "conexion exitosa";
                write(out, message);
                log(message);
            }
            else{
                message = "conexion fallida";
                write(out, message);
                log(message);
            }
        } 
    }  
    
    private boolean validArgs(String[] args, OutputStream out){
        boolean valid = true;  
        if((args.length > 1)){
            write(out, "solamente se espera un parametro");
            valid = false;
        }
        return valid;
    }
    
    private boolean agregarJugador(String direccion, int puerto, ControladorTorneo controlador){
        
        boolean valid = false;
        try{
            controlador.modelo.getJugadorLocal().SetBatalla("localhost", 5000);
            if(controlador.modelo.getBatalla() != null){
                
                controlador.modelo.tJugador1 = new Thread(controlador.modelo.getJugadorLocal());
                controlador.modelo.tJugador1.start();
                valid = true;
                controlador.vista.setTitle("Torneo de los degenerados : Jugador Local");
            }else {
                try{
                    controlador.modelo.tJugador2 = new Thread(controlador.modelo.getJugadorLocal());
                    controlador.modelo.tJugador2.start();
                    controlador.vista.setTitle("Torneo de los degenerados : Jugador Visita");
                    
                    valid = true;
                }catch(Exception e){}
            }
        } catch(Exception e){}
        return valid;
        
        
        
    }

    private boolean crearBatalla(ControladorTorneo controlador) {
        try{
            Batalla batalla = new Batalla();
            controlador.modelo.setBatalla(batalla);
            controlador.modelo.tBatalla = new Thread(batalla);
            controlador.modelo.tBatalla.start();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
        
      
}
