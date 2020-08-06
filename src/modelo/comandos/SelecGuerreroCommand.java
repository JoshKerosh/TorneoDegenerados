/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;
import java.util.Arrays;
import modelo.Jugador;
import modelo.prototype.PrototypeFactory;

/**
 *
 * @author Josh
 */
public class SelecGuerreroCommand extends BaseCommand{
    public static final String COMMAN_NAME = "SELPER";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        Jugador jugador = controlador.modelo.getJugadorLocal();
        if(validArgs(args,out, jugador)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            for(int i = 0; i < args.length; i++){
                controlador.modelo.getJugadorLocal().selectGuerrero(args[i]);  
            }
            String mensaje = "Agregado";
            if(args.length > 1){
                mensaje += "s";
            }
            write(out, mensaje);
        }
    }

    private boolean validArgs(String[] args, OutputStream out, Jugador jugador){
        boolean valid = true; 

        if (jugador.tamEquipo() == 5){
            write(out, "Equipo completo");
            valid = false;
        }
        else if(args == null){
            write(out, "Falta insertar el personaje a elegir");
            valid = false;
        }
        else if(5 < (args.length + jugador.tamEquipo())){
            write(out, "Al equipo solo le faltan " + (5 - jugador.tamEquipo()) + " guerreros");
            valid = false;
        } 
        else {
            for(int i = 0; i < args.length; i++){
                if(!guerreroExiste(args[i])){
                    write(out, "El guerrero " + args[i] + " no existe");
                    i = 5;//salir del for
                    valid = false;
                }
            }
        }
        return valid;
    }

    private boolean guerreroExiste(String guerrero) {
        boolean valid = false;
        try{
            PrototypeFactory.getPrototype("guerrero"+guerrero);
            valid = true;
        } catch(Exception e){}
        return valid;
    }
}
