/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Miriam
 */
public class InsertarLibro {
    public static String guardarLibro(Integer idLibro,Integer autor, Integer editorial, String nombre, Float precio) throws Exception{
       Conexion c=new Conexion();
        Connection con=c.conectarse();
        
     CallableStatement guarda=con.prepareCall("{call GUARDAR_LIBRO(?,?,?,?,?)}");
    
            
        guarda.setInt(1,idLibro);//registerOutParameter(1,java.sql.Types.INTEGER);
        guarda.setInt(2,autor);
        guarda.setInt(3,editorial);
        guarda.setString(4,nombre);
        guarda.setFloat(5,precio);
        
        
        guarda.execute();
        con.close();
        
        return "Se guardo la el libro con id:"+ nombre; 
    }
     public static void main(String[] args) throws Exception{
       //System.out.println(guardarLibro(Integer idLibro,Integer autor, Integer editorial, String nombre, Float precio));  
    }
    
    
}
