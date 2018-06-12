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
public class DeletePub extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtener el valor del id_publicacion
        String id_publicacion = req.getParameter("id_publicacion");
        //2º Sentencia
        BDManager bdManager = new BDManager();
        String sql = "DELETE FROM noticias WHERE id_publicacion ="+id_publicacion;
        bdManager.execute(sql);
        
        sql = "DELETE FROM conspub WHERE id_publicacion ="+id_publicacion;
        bdManager.execute(sql);
        //3º Sentencia
        resp.sendRedirect("noticia.jsp");
        
    }

   
    
}
