package edu.cientifica.convivirapp.model;

import java.sql.Date;

public class Abono {
    private int id;
    private int tipoAbono;
    private Date fechaAbono;
    private Cuota cuota;
    private double montoAbono;
    private int validado;

    public Abono() {
        super();
    }

    public Abono(int id, int tipoAbono, Date fechaAbono, Cuota cuota, double montoAbono, int validado) {
        super();
        this.id = id;
        this.tipoAbono = tipoAbono;
        this.fechaAbono = fechaAbono;
        this.cuota = cuota;
        this.montoAbono = montoAbono;
        this.validado = validado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(int tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public double getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(double montoAbono) {
        this.montoAbono = montoAbono;
    }

    public int getValidado() {
        return validado;
    }

    public void setValidado(int validado) {
        this.validado = validado;
    }
}
