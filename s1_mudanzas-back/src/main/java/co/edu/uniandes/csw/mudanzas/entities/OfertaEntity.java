/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mudanzas.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Andres Gonzalez
 */

@Entity
public class OfertaEntity extends BaseEntity implements Serializable{
    
     /**
     * Atributo que representa comentario dado por el proveedor. 
     */
    private String comentario;
    
     /**
     * Atributo que representa el valor de la oferta de un proveedor. 
     */
    private double valor;
    
    public OfertaEntity()
    {
        
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}