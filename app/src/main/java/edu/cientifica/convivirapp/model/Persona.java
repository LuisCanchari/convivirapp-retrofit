package edu.cientifica.convivirapp.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Persona {
    @SerializedName("id")
    private int id;
    @SerializedName("tipoDocumento")
    private int tipoDocumento;
    @SerializedName("numDocumento")
    private String numDocumento;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("primerApellido")
    private String primerApellido;
    @SerializedName("segundoApellido")
    private String segundoApellido;
    @SerializedName("fechaNacimiento")
    private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(int id, int tipoDocumento, String numDocumento, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
