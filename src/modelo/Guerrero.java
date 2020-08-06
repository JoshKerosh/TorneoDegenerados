/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.prototype.IPrototype;

/**
 *
 * @author Josh
 */
public class Guerrero implements IPrototype<Guerrero> {
    
    private String name;
    private String tipo;
    private String imagen;
    private HashMap<String,Arma> armas;
    private int HP;

    public Guerrero(String name, String tipo, String imagen) {
        this.name = name;
        this.tipo = tipo;
        this.imagen = imagen;
        armas = new HashMap<>();
        HP = 100;
    }

    @Override
    public Guerrero clone() {
        Guerrero clone = new Guerrero(this.name, this.tipo, this.imagen);
        return clone;
    }

    @Override
    public Guerrero deepClone() {
        return clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void addArma(Arma arma){
        armas.put(arma.getName(), arma);
    }
    
    public boolean revisarArma(String arma){
        boolean pertenece = false;
            if(armas.get(arma) != null){
                return true;
            }
        return pertenece;
    }
    
    public boolean Herida(int amnt){
        HP = HP - amnt;
        
        return HP < 1;
    }
    
    public int tamArmamento(){
        return armas.size();
    }
    
    public int getVida(){
        return HP;
    }

    public HashMap<String, Arma> getArmas() {
        return armas;
    }
    
    
}
