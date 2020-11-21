package edu.cientifica.convivirapp.model;

import java.io.Serializable;

public class EstadoCuentaUPrivada extends EstadoCuentaMaster implements Serializable {
    private UnidadPrivada unidadPrivada;

    public EstadoCuentaUPrivada(UnidadPrivada unidadPrivada) {
        this.unidadPrivada = unidadPrivada;
    }

    public UnidadPrivada getUnidadPrivada() {
        return unidadPrivada;
    }

    public void setUnidadPrivada(UnidadPrivada unidadPrivada) {
        this.unidadPrivada = unidadPrivada;
    }

    @Override
    public String toString() {
        return "EstadoCuentaUPrivada{" +
                "unidadPrivada=" + unidadPrivada + super.toString()+
                '}';
    }
}
