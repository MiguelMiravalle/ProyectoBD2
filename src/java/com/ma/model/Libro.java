/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author T-206
 */
public class Libro {
    private Integer idLibro;
    private Integer autor;
    private Integer editorial;
    private String nombre;
    private Float precio;

    public Libro( Integer idLibro,Integer autor, Integer editorial, String nombre, Float precio) {
        this.idLibro = idLibro;
        this.autor = autor;
        this.editorial = editorial;
        this.nombre = nombre;
        this.precio = precio;
    }  
    
    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getAutor() {
        return autor;
    }

    public void setAutor(Integer autor) {
        this.autor = autor;
    }

    public Integer getEditorial() {
        return editorial;
    }

    public void setEditorial(Integer editorial) {
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

}