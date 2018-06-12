
package es.cice.controller;

import es.cice.models.Plataforma;
import es.cice.models.Noticia;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WordManager {
    
    public Noticia getNoticia(String id_publicacion){
        BDManager bdManager = new BDManager();
        String sql = "SELECT * FROM noticias WHERE id_publicacion="+id_publicacion;
        ResultSet result = bdManager.execSelect(sql);
        
        try{
            while(result.next()){
                String id_pub = result.getString("id_publicacion");
                String titulo = result.getString("titulo");
                String texto = result.getString("texto");
                String consola = result.getString("consola");
                String fecha = result.getString("fecha");
               
		Noticia pub = new Noticia(id_pub, titulo, texto, consola, fecha);
                return pub;
            }
        }catch(Exception e){
            System.out.println("error en el while");
        }
        
        return null;
    }
    public ArrayList<Plataforma> getPlataformas(){
        BDManager bdManager = new BDManager();
        String sql = "SELECT * FROM consolasadm";
        ArrayList<Plataforma> listaPlataformas = new ArrayList<>();
        ResultSet result = bdManager.execSelect(sql);
        
        try{
            while(result.next()){
                int id_consola = result.getInt("id_consola");
                String plataforma = result.getString("plataforma");
				
                Plataforma pla  =  new Plataforma (id_consola, plataforma);
                listaPlataformas.add(pla);
            }
        }catch (Exception e){
            System.out.println("Error al listar Consolas");
            e.printStackTrace();
        }
        return listaPlataformas;
    }
    
    public int getPlaFromNoticia(String id_publicacion){
        BDManager bdManager = new BDManager();
        String sql = "SELECT id_consola FROM conspub WHERE id_publicacion="+id_publicacion;
        ResultSet result = bdManager.execSelect(sql);
        try{
            result.next();
            return result.getInt("id_consola");
        }catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
        return -1;
    } 
    public Plataforma getPlataforma(String id_plataforma){
        BDManager bdManager = new BDManager();
        String sql = "SELECT * FROM consolasadm WHERE id_consola="+id_plataforma;
        ResultSet result = bdManager.execSelect(sql);
        
        try{
            while(result.next()){
                int id_cons = result.getInt("id_consola");
                String plataforma = result.getString("plataforma");
                
               
		Plataforma pla = new Plataforma(id_cons, plataforma);
                return pla;
            }
        }catch(Exception e){
            System.out.println("error en el while");
        }
        
        return null;
    }

}
