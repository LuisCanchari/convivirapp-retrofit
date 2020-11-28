package edu.cientifica.convivirapp.network.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import edu.cientifica.convivirapp.model.CuotaDetalle;

public class CuotaDetalleResponse {
    @SerializedName("data")
    private List<CuotaDetalle> listaCuotaDetalle;

    public List<CuotaDetalle> getListaCuotaDetalle() {
        return listaCuotaDetalle;
    }

    public void setListaCuotaDetalle(List<CuotaDetalle> listaCuotaDetalle) {
        this.listaCuotaDetalle = listaCuotaDetalle;
    }

    @Override
    public String toString() {
        return "CuotaDetalleResponse{" +
                "listaCuotaDetalle=" + listaCuotaDetalle +
                '}';
    }
}
