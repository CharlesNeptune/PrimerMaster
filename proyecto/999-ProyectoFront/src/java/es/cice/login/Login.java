/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cice.login;

import es.cice.controller.BDManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cice
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //Obtener los datos del formulario
        String correo = req.getParameter("txtCorreo");
        String password = req.getParameter("txtPassword");
        
        
        //Comprobar que usario y contraseña son correctos
        int id;
        if((id=comprobarLogin(correo, password))!=-1){ 
           
            //Creamos una sesion del usuario
            HttpSession session = req.getSession();
            //almacenamos la variable en la session
            session.setAttribute("id_publicador", id);
            //redireccionamos
            resp.sendRedirect("principal.jsp");
        }else{
            resp.sendRedirect("error.jsp");
        }
        
    }
private int comprobarLogin(String correo, String password){
    /*
    1-conectar con la BBDD 
    2-crear la sentencia sql y ejecutarla
    3-si recibimos datos, usuario y contraseña correcto
        sino recibimos datos, usuario y contraseña incorrectos
    */
    BDManager bdmanager = new BDManager(); //conectamos
    String sql = "SELECT * FROM usuarios WHERE correo='"+correo+"' AND password= '"+password+ "'";
    ResultSet result = bdmanager.execSelect(sql);
    try{
    while(result.next()){
         //Obtenemos la id del usuario
        int id = result.getInt("id");
        //crear una sesión...
        
        return id;
    }
    }catch(Exception e){
        return -1;
    }
    return -1;
}

}
