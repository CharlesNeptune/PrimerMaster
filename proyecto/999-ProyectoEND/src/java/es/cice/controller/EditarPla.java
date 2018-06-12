
package es.cice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarPla extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //Obtener datos del formulario
        String id_plataforma = req.getParameter("id_plataforma");
        String txt_consola = req.getParameter("txt_consola");
              
        
        //Sentencia sql
        String sqlPlataforma = "UPDATE consolasadm SET plataforma='"+txt_consola+"' WHERE id_consola="+id_plataforma;
        
         String sqlConsPub = "UPDATE conspub SET id_consola="+id_plataforma;
         
        //Ejecutamos y redireccionamos
        BDManager bdManager = new BDManager();
        bdManager.execute(sqlPlataforma);
        bdManager.execute(sqlConsPub);
        resp.sendRedirect("pla.jsp");
        
        
    }
    
}
