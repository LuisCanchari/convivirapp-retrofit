package edu.cientifica.convivirapp.network.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;

public class EstadoCuentaResponse {
    @SerializedName("data")
    private List<EstadoCuentaUPrivada> listaEstadoCuentaResponse;


    public List<EstadoCuentaUPrivada> getListaEstadoCuentaResponse() {
        return listaEstadoCuentaResponse;
    }

    public void setListaEstadoCuentaResponse(List<EstadoCuentaUPrivada> listaEstadoCuentaResponse) {
        this.listaEstadoCuentaResponse = listaEstadoCuentaResponse;
    }
}
