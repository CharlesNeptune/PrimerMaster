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
import javax.servlet.http.HttpSession;


public class InsertarAmi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1º Obtener los datos del formulario
        String id_usuario = req.getParameter("id_usuario");
        String id_segui = req.getParameter("id_segui");
        
        System.out.println(id_usuario);
        insertAmigo(id_usuario, id_segui);
        resp.sendRedirect("seguidos.jsp");
        

    }
    
    //Funciones propias
    public void insertAmigo(String id_usuario, String id_segui){
        
        BDManager bdManager = new BDManager();
        String sql = "INSERT INTO amigos (id_publicador, id_seguidor) VALUES ('"+id_usuario+"', '"+id_segui+"')";
        bdManager.execute(sql);
       
        sql = "SELECT nick FROM usuarios WHERE id =(SELECT id_publicador FROM amigos WHERE id_seguidor='"+id_segui+"'); ";
        ResultSet result = bdManager.execSelect(sql);
        
            
    }
    
}