/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.model;

/**
 *
 * @author T-206
 */


import java.sql.*;   
import java.util.*;
import org.codehaus.jackson.map.ObjectMapper;
public class PersistenciaLibro {
//crearemos un metod que se metera a la base de datos y sacar la informacion
    public static String buscarTodosLosLibros() throws Exception{    //BUSCARtODOS no lleva argumentos
        //primero: nos conectamos a oracle con la clase conxion
        
        Connection con=Conexion.conectarse();
        //segundo: generamos un statemenr de sql con la conexion anterior
             Statement st=con.createStatement();
             //3: llevamos a cabo la consulta select 
             ResultSet res=st.executeQuery("select * from libro");  //reset arreglo enmutado de java  estructura de  datos
             System.out.println("depues del select");
             int indice=0;
             ArrayList<Libro> libros=new ArrayList<Libro>();
             while(res.next()){   //del primero hasta el ultimo prod que vea SI PONGO SECUENCIA NO ENTRA AL WHILE
                                   Integer id=  res.getInt(1);     
                                   Integer autor=res.getInt(2);
                                   Integer editorial=res.getInt(3);
                                   String nombre=res.getString(4);
                                   Float precio=res.getFloat(5);
                                  
                 ///llenamos el arrayList en cada vuelta
                      libros.add(new Libro(id,autor,editorial,nombre,precio));
                      
                      System.out.println("estoy en el array list despues del select");
             }
             
             //el paso final, transformamos a objeto json con jackson
             ObjectMapper maper=new ObjectMapper();   //mapeo a objeto jackson
             
             st.close();
             con.close();
             System.out.println("convirtiendo el json");
             return maper.writeValueAsString(libros);
             
    }
    public static void main(String[] args) throws Exception{
       System.out.println(buscarporId(2));  
    }
    
    public static String buscarporId(Integer id) throws Exception{    //BUSCARtODOS no lleva argumentos
        //primero: nos conectamos a oracle con la clase conxion
        
        Connection con=Conexion.conectarse();
        //segundo: generamos un statemenr de sql con la conexion anterior
             Statement st=con.createStatement();
             //3: llevamos a cabo la consulta select 
             ResultSet res=st.executeQuery("select * from libro where id_libro="+id);  //reset arreglo enmutado de java  estructura de  datos
             System.out.println("depues del select");
             int indice=0;
             ArrayList<Libro> libros=new ArrayList<Libro>();
             while(res.next()){   //del primero hasta el ultimo prod que vea SI PONGO SECUENCIA NO ENTRA AL WHILE
                                  Integer miid=  res.getInt(1);     
                                   Integer autor=res.getInt(2);
                                   Integer editorial=res.getInt(3);
                                   String nombre=res.getString(4);
                                   Float precio=res.getFloat(5);
                                  
                 ///llenamos el arrayList en cada vuelta
                      libros.add(new Libro(id,autor,editorial, nombre, precio ));
                      
                      System.out.println("estoy en el array list despues del select");
             }
             
             //el paso final, transformamos a objeto json con jackson
             ObjectMapper maper=new ObjectMapper();   //mapeo a objeto jackson
             
             st.close();
             con.close();
             System.out.println("convirtiendo el json");
             return maper.writeValueAsString(libros);
             
    }
   
    
}

