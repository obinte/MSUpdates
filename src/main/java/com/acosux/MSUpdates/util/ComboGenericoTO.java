/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acosux.MSUpdates.util;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jtabango
 */

@Entity
public class ComboGenericoTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private BigDecimal clave;
    private String valor;

    public ComboGenericoTO() {
    }

    public ComboGenericoTO(BigDecimal clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }

    
    public BigDecimal getClave() {
        return clave;
    }

    public void setClave(BigDecimal clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    

}
