package edu.cientifica.convivirapp.model;

import java.io.Serializable;

public class EstadoCuenta implements Serializable {

    private int idUPrivada;
    private int idUInmobiliaria;
    private String numVivienda;
    private String tipoVivienda;
    private String namePropietario;
    private String montoTotal;

    public EstadoCuenta() {
    }

    public EstadoCuenta(int idUInmobiliaria, int idUPrivada, String numVivienda, String tipoVivienda, String namePropietario, String montoTotal) {
        this.idUInmobiliaria = idUInmobiliaria;
        this.idUPrivada = idUPrivada;
        this.numVivienda = numVivienda;
        this.tipoVivienda = tipoVivienda;
        this.namePropietario = namePropietario;
        this.montoTotal = montoTotal;
    }

    public int getIdUInmobiliaria() {
        return idUInmobiliaria;
    }

    public void setIdUInmobiliaria(int idUInmobiliaria) {
        this.idUInmobiliaria = idUInmobiliaria;
    }

    public int getIdUPrivada() {
        return idUPrivada;
    }

    public void setIdUPrivada(int idUPrivada) {
        this.idUPrivada = idUPrivada;
    }

    public String getNumVivienda() {
        return numVivienda;
    }

    public void setNumVivienda(String numVivienda) {
        this.numVivienda = numVivienda;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getNamePropietario() {
        return namePropietario;
    }

    public void setNamePropietario(String namePropietario) {
        this.namePropietario = namePropietario;
    }

    public String getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "EstadoCuenta{" +
                "idUInmobiliaria=" + idUInmobiliaria +
                ", idUPrivada=" + idUPrivada +
                ", numVivienda='" + numVivienda + '\'' +
                ", tipoVivienda='" + tipoVivienda + '\'' +
                ", namePropietario='" + namePropietario + '\'' +
                ", montoTotal='" + montoTotal + '\'' +
                '}';
    }
}
