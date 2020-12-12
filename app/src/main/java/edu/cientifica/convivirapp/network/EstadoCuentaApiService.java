package edu.cientifica.convivirapp.network;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuenta;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface EstadoCuentaApiService {

    @GET("estadocuenta/all")
    Call<List<EstadoCuenta>> obtenerListEstadoCuenta();

}
