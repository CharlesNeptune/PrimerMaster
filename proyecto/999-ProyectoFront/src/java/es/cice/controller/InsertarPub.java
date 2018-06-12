
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

/**
 *
 * @author Carlos Sanchez
 */
public class InsertarPub extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1º Obtener los datos del formulario
        String txt_titulo = req.getParameter("txt_titulo");
        String txt_publicacion = req.getParameter("txt_publicacion");
        String plataforma = req.getParameter("plataforma");  
       
        //2º Obtenemos la fecha de la publicacion
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
        Date date = new Date();
        String fecha = sdf.format(date);
        
        System.out.println(txt_titulo+" "+fecha+" id_consola:"+plataforma);
        insertNoticia(txt_titulo,txt_publicacion,plataforma,fecha);
        resp.sendRedirect("noticia.jsp");
        
    }
    
    //Funciones propias
    public void insertNoticia(String txt_titulo, String txt_publicacion, String plataforma, String fecha){
        
        BDManager bdManager = new BDManager();
        String sql = "INSERT INTO noticias (titulo, texto, consola, fecha) VALUES ('"+txt_titulo+"','"+txt_publicacion+"','"+plataforma+"','"+fecha+"')";
        bdManager.execute(sql);

        //Seleccionamos la ultima publicacion insertada para obtener su id  
        sql = "SELECT id_publicacion FROM noticias ORDER BY id_publicacion DESC LIMIT 1";
       
        ResultSet result = bdManager.execSelect(sql);
        try{
            while(result.next()){
                String id_publicacion = result.getString("id_publicacion");
                //Insertamos en la tabla que relaciona publicacion con plataforma
                
                 sql = "SELECT id_consola FROM consolasadm ORDER BY id_consola DESC LIMIT 1";
                 
                bdManager.execute(sql);
                String id_consola = result.getString("id_consola");
                
                
                sql ="INSERT INTO conspub (id_publicacion, id_consola) VALUES ("+id_publicacion+","+id_consola+")";
                bdManager.execute(sql);
                
            }
        }catch(Exception e){
            System.out.println("Error en el while");
            e.printStackTrace();
        }
            
    }
    
}
