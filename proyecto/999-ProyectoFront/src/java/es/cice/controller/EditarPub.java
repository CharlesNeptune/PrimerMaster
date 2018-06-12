
package es.cice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarPub extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //Obtener datos del formulario
        String id_publicacion = req.getParameter("id_publicacion");
        String txt_titulo = req.getParameter("txt_titulo");
        String txt_texto = req.getParameter("txt_texto");
        String plataforma = req.getParameter("plataforma");
              
        
        //Sentencia sql
        String sqlNoticia = "UPDATE noticias SET titulo='"+txt_titulo+"'," 
        + "texto='"+txt_texto+"',consola='"+plataforma+"' WHERE id_publicacion="+id_publicacion;
          
   
        String id_plataforma = "SELECT id_plataforma FROM consola WHERE consola = "+plataforma;
                        
                
        String sqlConsPub2 = "UPDATE conspub SET id_consola="+id_plataforma+""
                + "WHERE id_publicacion="+id_publicacion;
        //Ejecutamos y redireccionamos
        BDManager bdManager = new BDManager();
        bdManager.execute(sqlNoticia);
        bdManager.execute(sqlConsPub2);
        resp.sendRedirect("noticia.jsp");
        
        
    }
    
}
