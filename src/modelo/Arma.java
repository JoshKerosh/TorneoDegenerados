/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.prototype.IPrototype;

/**
 *
 * @author Josh
 */
public class Arma implements IPrototype<Arma>{
    
    private String name;
    private String imagen;
    //type

    public Arma(String name, String imagen) {
        this.name = name;
        this.imagen = imagen;
    }
    
    @Override
    public Arma clone() {
        Arma clone = new Arma(this.name, this.imagen);
        return clone;
    }

    @Override
    public Arma deepClone() {
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

    
}
