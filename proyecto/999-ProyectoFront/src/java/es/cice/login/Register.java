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
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Obtener los datos del formulario
        String nick = req.getParameter("txtNick");
        String nombre = req.getParameter("txtNombre");
        String apellidos = req.getParameter("txtApellidos");
        String correo = req.getParameter("txtCorreo");
        String password = req.getParameter("txtPassword");
        String repassword = req.getParameter("retxtPassword");

        //Comprobar que usario y contraseña son correctos
        int id;
        if ((id = comprobarRegister(correo, nick)) != -1) {

            resp.sendRedirect("error.jsp");
        } else {

            //Comprobamos que la password y las repassword son iguales
            //if (password.equals(repassword)) {

                //almacenamos todos los datos que hemos recogido en el HTML
                rellenarDatos(nick, nombre, apellidos, correo, password);

                System.out.println("Paso por rellenar Datos");
                //Creamos una sesion del usuario
                HttpSession session = req.getSession();
                //almacenamos la variable en la session
                session.setAttribute("id_publicador", id);

                //redireccionamos
                resp.sendRedirect("principal.jsp");
            //} else {
              //  resp.sendRedirect("error.jsp");

            //}
        }
    }

    private int comprobarRegister(String correo, String nick) {
        /*
         1-conectar con la BBDD 
         2-crear la sentencia sql y ejecutarla
         3-si recibimos datos, usuario y contraseña correcto
         sino recibimos datos, usuario y contraseña incorrectos
         */

        BDManager bdManager = new BDManager();//conectamos
        String sql = "SELECT * FROM usuarios WHERE  nick='" + nick + "' AND correo='" + correo + "'";
        ResultSet result = bdManager.execSelect(sql);
        try {
            while (result.next()) {
                //Obtenemos la id del usuario
                int id = result.getInt("id");
                //crear una sesión...

                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }
        return -1;
    }

    private int rellenarDatos(String nick, String nombre, String apellidos, String correo, String password) {

        BDManager bdmanager = new BDManager(); //conectamos
        String sql = "INSERT INTO usuarios (nick ,nombre, apellidos, correo, password) VALUES ('" + nick + "','" + nombre + "','" + apellidos + "','" + correo + "','" + password + "')";

        try {
            bdmanager.execute(sql);
           
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }
    }
}
