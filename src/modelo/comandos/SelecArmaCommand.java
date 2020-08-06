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
public class SelecArmaCommand extends BaseCommand{
    public static final String COMMAN_NAME = "SELARM";

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
            controlador.modelo.getJugadorLocal().selectArma(args[1], args[0]);
            write(out, args[0] + " agregada a " + args[1]);
        }
    }

    private boolean validArgs(String[] args, OutputStream out, Jugador jugador){
        boolean valid = true; 
        if((args == null)){
            write(out, "Falta insertar el arma a elegir");
            valid = false;
        }
        else if(!armaExiste(args[0])){
            write(out, "El arma no existe");
            valid = false;
        }
        else if((args.length == 1)){
            write(out, "Falta el jugador al cual agregar el arma");
            valid = false;
        }
        else if(!jugador.revisarEquipo(args[1])){
            write(out, "El guerrero no pertenece al equipo");
            valid = false;
        }
        else if(jugador.getGuerrero(args[1]).tamArmamento() >= 5){
            write(out, "El guerrero ya tiene 5 armas");
            valid = false;
        }
        else if(jugador.getGuerrero(args[1]).revisarArma(args[0])){
            write(out, "El guerrero ya tiene esa arma");
            valid = false;
        }
        else if((args.length > 2)){
            write(out, "hay parametros extra");
            valid = false;
        }
        return valid;
    }

    private boolean armaExiste(String arma) {
        boolean valid = false;
        try{
            PrototypeFactory.getPrototype("arma"+arma);
            valid = true;
        } catch(Exception e){}
        return valid;
    }

}
