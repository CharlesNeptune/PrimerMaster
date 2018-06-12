
package es.cice.controller;

import es.cice.models.Plataforma;
import es.cice.models.Publicacion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Manager {
    //QUEDA POR CAMBIAR TODAS LAS SELECT
    /*FUNCIÓN QUE DEVUELVE UN ARRAY CON OBJETOS TIPO ENTRADA*/
    public ArrayList<Publicacion> getEntradas(){
        String sql = "SELECT * FROM entradas ORDER BY id DESC";
        BDManager bDManager = new BDManager();
        ResultSet result = bDManager.execSelect(sql);
        ArrayList<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
        try{
            while(result.next()){
                String id_plataforma = result.getString("id_plataforma");
                String nombre = result.getString("nombre");
                String precio = result.getString("precio");
                String fecha = result.getString("fecha");
                Publicacion publicacion = new Publicacion(id_plataforma, nombre, precio, fecha);
                listaPublicaciones.add(publicacion);
            }
        }catch(Exception e){
            System.out.println("error al listar entradas");
        }
        return listaPublicaciones;
    }
    
    /*OBJETOS TIPO ENTRADA SEGUN LA CATEGORÍA*/
    public ArrayList<Publicacion> getEntradasCat(String id_cat){
        //SQL
     String sql = "SELECT entradas.* FROM entradas "
                + "INNER JOIN entcat "
                + "ON entcat.id_entrada = entradas.id "
                + "WHERE entcat.id_cat="+id_cat;
        BDManager bdManager = new BDManager();
        ResultSet result = bdManager.execSelect(sql);
        ArrayList<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
        try{
            while(result.next()){
                String id_plataforma = result.getString("id_plataforma");
                String nombre = result.getString("nombre");
                String precio = result.getString("precio");
                String fecha = result.getString("fecha");
                Publicacion publicacion = new Publicacion(id_plataforma, nombre, precio, fecha);
                listaPublicaciones.add(publicacion);
            }
        }catch(Exception e){
            System.out.println("Error sentencia");
        }
        return listaPublicaciones;
    }
    
    /*FUNCIÓN QUE DEVUELVE UN ARRAY CON OBJETOS TIPO CATEGORIA*/
    public ArrayList<Plataforma> getCategorias(){
        String sql = "SELECT * FROM categorias";
        BDManager bDManager = new BDManager();
        ResultSet result = bDManager.execSelect(sql);
        ArrayList<Plataforma> listaCat = new ArrayList<Plataforma>();
        try{
            while(result.next()){
                int id_plataforma = result.getInt("id_plataforma");
                String nombre = result.getString("nombre");
                Plataforma cat = new Plataforma(id_plataforma, nombre);
                listaCat.add(cat);
            }
        }catch(Exception e){
            System.out.println("Error listar cat");
        }
        return listaCat;
    }
}
