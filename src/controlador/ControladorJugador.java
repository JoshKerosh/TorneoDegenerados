/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloTorneo;
import vista.PantallaTorneo;

/**
 *
 * @author josh
 */
public class ControladorJugador extends ControladorComandos{
    
    //Singleton
    public ControladorJugador(ModeloTorneo modelo){
        vista = PantallaTorneo.getInstance();
        this.modelo = modelo;
        _init_();
        
    }
    
    public void _init_(){
        //primero elegir personajes y armas
        
        //luego iniciar batalla
        
    }
    
    public void IniciarBatalla(){
        PrepararEquipo();
    }
    
    public void PrepararEquipo(){
        
    }
    
    
    
}
