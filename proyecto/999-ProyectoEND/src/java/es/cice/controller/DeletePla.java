/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cice
 */
public class DeletePla extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtener el valor del id_publicacion
        
        try {
      
        String id_plataforma = req.getParameter("id_plataforma");
        //2º Sentencia
        BDManager bdManager = new BDManager();
        String sql = "DELETE FROM consolasadm WHERE id_consola ="+id_plataforma;
        bdManager.execute(sql);
        
        sql = "DELETE FROM conspub WHERE id_consola ="+id_plataforma;
        bdManager.execute(sql);
        
         } catch (Exception e) {
        System.out.println("error al delete");
        e.printStackTrace();
    }
        
        //3º Sentencia
        resp.sendRedirect("pla.jsp");
        
    }

   
    
}