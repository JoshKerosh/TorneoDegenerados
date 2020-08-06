/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Josh
 */
public class Scores {
    Jugador jugador;
    
    int ataquesLetales;
    int ataquesFallados;
    int muertes;
    int ganadas;
    int perdidas;
    int rendiciones;

    public Scores(Jugador jugador, int ataquesLetales, int ataquesFallados, int muertes, int ganadas, int perdidas, int rendiciones) {
        this.jugador = jugador;
        this.ataquesLetales = ataquesLetales;
        this.ataquesFallados = ataquesFallados;
        this.muertes = muertes;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.rendiciones = rendiciones;
    }

    
    
    public void addAtaquesLetal() {
        this.ataquesLetales++;
    }
    
    public void addAtaquesFallado() {
        this.ataquesFallados++;
    }
    
    public void addMuerte() {
        this.muertes++;
    }
    
    public void addGanada() {
        this.ganadas++;;
    }
    
    public void addPerdida() {
        this.perdidas++;
    }
    
    public void addRendicion() {
        this.rendiciones++;
    }
    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getAtaquesLetales() {
        return ataquesLetales;
    }

    public int getAtaquesFallados() {
        return ataquesFallados;
    }

    public int getMuertes() {
        return muertes;
    }

    public int getGanadas() {
        return ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getRendiciones() {
        return rendiciones;
    } 
    
}
