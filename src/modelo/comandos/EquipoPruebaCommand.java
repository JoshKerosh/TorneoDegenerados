/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.comandos;

import controlador.ControladorTorneo;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.Arma;
import modelo.Guerrero;
import modelo.Jugador;
import modelo.prototype.PrototypeFactory;

/**
 *
 * @author Josh
 */
public class EquipoPruebaCommand extends BaseCommand{
    public static final String COMMAN_NAME = "EQUIPOPRUEBA";

    @Override
    public String getCommandName() {
        return COMMAN_NAME;   
    }
    
    @Override
    public void execute(String[] args, OutputStream out, ControladorTorneo controlador) { 
        if(validArgs(args,out)){
            String message = getCommandName() + " " + Arrays.toString(args);    
            log(message);
            
            Jugador jugador = controlador.modelo.getJugadorLocal();
            ArrayList<String> guerrerosPrueba = new ArrayList<>();
            guerrerosPrueba.add("Gaskull");
            guerrerosPrueba.add("Anemik");
            guerrerosPrueba.add("Natas");
            guerrerosPrueba.add("Duji");
            guerrerosPrueba.add("Vanyi" );
            ArrayList<String> armasPrueba = new ArrayList<>();
            armasPrueba.add("Palo");
            armasPrueba.add("Espada");
            armasPrueba.add("Arco");
            armasPrueba.add("Tabla");
            armasPrueba.add("Piedra");
            for(int i = 0; i < 5; i++){
                Guerrero guerrero = (Guerrero) PrototypeFactory.getPrototype("guerrero" + guerrerosPrueba.get(i));
                jugador.addGuerrero(guerrero);
                for(int j = 0; j < 5; j++){
                    Arma arma = (Arma) PrototypeFactory.getPrototype("arma" + armasPrueba.get(j));
                    jugador.getGuerrero(guerrerosPrueba.get(i)).addArma(arma);
                }
            }
            
            write(out, "equipoPruebaListo");
            
        }
    }

    private boolean validArgs(String[] args, OutputStream out){
        boolean valid = true; 
        if((args != null)){
            write(out, "No se esperan argumentos");
            valid = false;
        } 
        return valid;
    }
}
