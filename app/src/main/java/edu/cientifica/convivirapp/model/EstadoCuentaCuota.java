package edu.cientifica.convivirapp.model;

public class EstadoCuentaCuota extends EstadoCuentaMaster{
    private Cuota cuota;

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
}
