
package es.cice.models;


public class Plataforma{
    private int id_plataforma;
    String plataforma;

    public Plataforma(int id_plataforma, String plataforma) {
        this.id_plataforma = id_plataforma;
        this.plataforma = plataforma;
    }

    public int getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(int id_plataforma) {
        this.id_plataforma = id_plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    
}
