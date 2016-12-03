/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.controladores;

import com.ma.model.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class ServletBorrarLibro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int id= Integer.parseInt(request.getParameter("id"));
      
        try{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
        CallableStatement otro=con.prepareCall("{call BORRAR_LIBRO(?)}");  
        
        otro.setInt(1,id); 
        otro.execute();  
        out.println("Se borro el libro");
        }catch(Exception e){
        out.println(e.getMessage());  //invocaremos la exception
    }
}
}