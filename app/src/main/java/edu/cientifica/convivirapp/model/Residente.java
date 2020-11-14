package edu.cientifica.convivirapp.model;

public class Residente {
    private int id;
    private String nombre;
    private String numDocumento;

    public Residente() {
    }

    public Residente(int id, String nombre, String numDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.numDocumento = numDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
}
