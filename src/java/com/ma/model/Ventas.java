/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.model;

/**
 *
 * @author HP
 */
public class Ventas {
    
    private Integer idVentas;
    private String nombre;

    public Ventas() {
    }

    public Ventas(Integer idVentas, String nombre) {
        this.idVentas = idVentas;
        this.nombre = nombre;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
