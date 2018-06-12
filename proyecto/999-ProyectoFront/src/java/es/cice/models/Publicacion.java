/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cice.models;

/**
 *
 * @author formador
 */
public class Publicacion {
    private String id_publicacion,nombre,precio,fecha;

    public Publicacion(String id_publicacion, String nombre, String precio, String fecha) {
        this.id_publicacion = id_publicacion;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getId_Publicacion() {
        return id_publicacion;
    }

    public void setId_Publicacion(String id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
