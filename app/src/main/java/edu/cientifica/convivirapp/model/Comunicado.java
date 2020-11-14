package edu.cientifica.convivirapp.model;

public class Comunicado {
    private  int id;
    private String titulo;
    private String tipo;
    private String mensaje;

    public Comunicado(int id, String titulo, String tipo, String mensaje) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public Comunicado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
