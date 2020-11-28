package edu.cientifica.convivirapp.model;

public class Concepto {
    private int id;
    private String nombreCorto;
    private String nombreLargo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCorto() {
        return nombreCorto;
    }
    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }
    public String getNombreLargo() {
        return nombreLargo;
    }
    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    @Override
    public String toString() {
        return "Concepto{" +
                "id=" + id +
                ", nombreCorto='" + nombreCorto + '\'' +
                ", nombreLargo='" + nombreLargo + '\'' +
                '}';
    }
}
