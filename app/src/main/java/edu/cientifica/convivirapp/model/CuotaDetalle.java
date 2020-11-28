package edu.cientifica.convivirapp.model;

import java.io.Serializable;

public class CuotaDetalle  implements Serializable {
    private int id;
    private Cuota cuota;
    private Concepto concepto;
    private double monto;


    public CuotaDetalle() {
        super();

    }



    public CuotaDetalle(int id, Cuota cuota, Concepto concepto) {
        super();
        this.id = id;
        this.cuota = cuota;
        this.concepto = concepto;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "CuotaDetalle [id=" + id + ", cuota=" + cuota + ", concepto=" + concepto + ", monto=" + monto + "]";
    }

}
