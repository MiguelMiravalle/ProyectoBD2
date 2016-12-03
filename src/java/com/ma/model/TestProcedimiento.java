/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.model;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author HP
 */
public class TestProcedimiento {
     public static void main(String args[])throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call ActualizarLibro(?,?,?,?,?,?)}");  /// call y el nombre de tu procedimiento
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setInt(1,1);
        callate.setString(1,"sangre de campeon");
        callate.setString(1,"Diamante");
        callate.setString(1,"calos sanchez");
        callate.setFloat(1,250.5f);
        callate.setInt(1,1234);  
///tantos campos como se necesiten
      
        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("El id ingresado es:"+pk);
    }
    
}
    
    
