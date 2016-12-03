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
public class ServletActualizarLibro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        int id= Integer.parseInt(request.getParameter("id")); 
        float precio=Float.parseFloat(request.getParameter("precio"));
       
        try{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement actu=con.prepareCall("{call ACTUALIZAR_LIBRO(?,?)}");  /// call y el nombre de tu procedimiento Y EL NUMERO DE PROCEDIMIENTOS QUE TENGAMOS
        
        actu.setInt(1,id);
        actu.setFloat(2,precio);   ///tantos campos como se necesiten de nuestro proyecto de los my_ y respetrando su tipo de dato
        
        actu.execute();
       
        out.println("Se actualizo el precio  del libro");
        }catch(Exception e){
        out.println(e.getMessage());  //invocaremos la exception
    }
}
}