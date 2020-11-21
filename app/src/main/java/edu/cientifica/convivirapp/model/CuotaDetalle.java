package edu.cientifica.convivirapp.model;

public class CuotaDetalle {
    private int id;
    private Cuota cuota;
    private Concepto concepto;

    public CuotaDetalle() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Cuota getCuota() {
        return cuota;
    }
    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
    public Concepto getConcepto() {
        return concepto;
    }
    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }
}
