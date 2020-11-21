package edu.cientifica.convivirapp.network.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuentaCuota;


public class EstadoCuentaCuotaResponse {
    @SerializedName("data")
    private List<EstadoCuentaCuota> listaEstadoCuentaCuotaResponse;

    public List<EstadoCuentaCuota> getListaEstadoCuentaCuotaResponse() {
        return listaEstadoCuentaCuotaResponse;
    }

    public void setListaEstadoCuentaCuotaResponse(List<EstadoCuentaCuota> listaEstadoCuentaCuotaResponse) {
        this.listaEstadoCuentaCuotaResponse = listaEstadoCuentaCuotaResponse;
    }
}
