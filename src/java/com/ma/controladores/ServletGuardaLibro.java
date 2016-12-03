/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.controladores;

import com.ma.model.Conexion;
import com.ma.model.InsertarLibro;
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
 * @author Miriam
 */
public class ServletGuardaLibro extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       int id= Integer.parseInt(request.getParameter("id"));
       int autor= Integer.parseInt(request.getParameter("autor"));
       int editorial= Integer.parseInt(request.getParameter("editorial"));
       String nombre= request.getParameter("nombre");
       Float precio= Float.parseFloat(request.getParameter("precio"));
       
          try{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
        CallableStatement guarda=con.prepareCall("{call GUARDAR_LIBRO(?,?,?,?,?)}");  /// call y el nombre de tu procedimiento Y EL NUMERO DE PROCEDIMIENTOS QUE TENGAMOS
        
        guarda.setInt(1,id);
        guarda.setInt(2,autor);   ///tantos campos como se necesiten de nuestro proyecto de los my_ y respetrando su tipo de dato
        guarda.setInt(3,editorial);
        guarda.setString(4,nombre);
        guarda.setFloat(5,precio);
        
        guarda.execute();
       
        out.println("Se guardo el  libro");
        }catch(Exception e){
        out.println(e.getMessage());  //invocaremos la exception
        }
      }  

}
