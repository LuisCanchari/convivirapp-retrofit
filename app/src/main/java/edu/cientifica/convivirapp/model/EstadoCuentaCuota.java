package edu.cientifica.convivirapp.model;

import java.io.Serializable;

public class EstadoCuentaCuota extends EstadoCuentaMaster implements Serializable {
    private Cuota cuota;

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
}
