package es.cice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertarPla extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1º Obtener los datos del formulario
        String txt_plataforma = req.getParameter("txt_plataforma");
        
        System.out.println(txt_plataforma);
        insertConsola(txt_plataforma);
        resp.sendRedirect("pla.jsp");
        
    }
    
    //Funciones propias
    public void insertConsola(String plataforma){
        
        BDManager bdManager = new BDManager();
        String sql = "INSERT INTO consolasadm (plataforma) VALUES ('"+plataforma+"')";
        bdManager.execute(sql);
       
        sql = "SELECT id_consola FROM consolasadm ORDER BY id_consola DESC LIMIT 1";
        ResultSet result = bdManager.execSelect(sql);
        
            
    }
    
}