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
public class Noticia {
    private String id_publicacion,titulo,texto,consola,fecha;

    public Noticia(String id_publicacion, String titulo, String texto, String consola,String fecha) {
        this.id_publicacion = id_publicacion;
        this.titulo = titulo;
        this.texto = texto;
        this.consola = consola;
        this.fecha = fecha;
    }

    public String getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(String id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}