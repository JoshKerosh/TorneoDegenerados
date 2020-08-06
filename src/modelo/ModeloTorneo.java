/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

import modelo.fabrica.FabricaArmas;
import modelo.fabrica.FabricaGuerreros;
/**
 *
 * @author Josh
 */
public class ModeloTorneo {
    
    private ArrayList<Guerrero> listaGuerreros;
    private ArrayList<Arma> listaArmas;
    
    //Servidor
    private Batalla batalla;
    //Cliente
    private ArrayList<Jugador> jugadores;
    
    public Thread tBatalla;
    public Thread tJugador1;
    public Thread tJugador2;
    
    
    
    public ModeloTorneo(){   
        jugadores = new ArrayList<>();
        listaGuerreros = FabricaGuerreros.crearGuerreros();
        listaArmas = FabricaArmas.crearArmas();
        
    }
    
    public boolean isBatalla(){
        return !(batalla == null); 
    }
    
    public ArrayList<Guerrero> getListaGuerreros() {
        return listaGuerreros;
    }

    public ArrayList<Arma> getListaArmas() {
        return listaArmas;
    }
    
    public Jugador getJugadorLocal(){
        return jugadores.get(0);
    }
    
    public Jugador getJugadorVisita(){
        return jugadores.get(1);
    }
    
    public void cargarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
    
    public boolean Logeado(){
        return (jugadores.size() > 0);
    }
    
    public void deslogearJugadorLocal(){
        jugadores.clear();
        batalla = null;
        tBatalla = null;
        tJugador1 = null;
        tJugador2 = null;
    }
    
    public boolean cargarJugadorVisita(Jugador jugador){
        boolean cargado = false;
        if(jugadores.size() == 1){
            jugadores.add(jugador);
            cargado = true;
        }
        return cargado;
    }
    
    public void borrarJugadorVista(){
        jugadores.remove(1);
    }

    public Batalla getBatalla() {
        return batalla;
    }

    public void setBatalla(Batalla batalla) {
        this.batalla = batalla;
    }
    
    
}
