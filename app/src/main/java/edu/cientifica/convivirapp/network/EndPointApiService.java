package edu.cientifica.convivirapp.network;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaCuotaResponse;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPointApiService {

    @GET(ConstantesRestApi.URL_GET_ESTADOCUENTA_UPRIVADA_ALL)
    Call<EstadoCuentaResponse> obtenerEstadoCuentaUPrivada();


    @GET(ConstantesRestApi.URL_GET_ESTADOCUENTA_UPRIVADA_ALL)
    Call<List<EstadoCuentaUPrivada>> obtenerListaEstadoCuentaUPrivada();

    @GET(ConstantesRestApi.URL_GET_ESTADOCUENTA_CUOTA_BY_UPRIVADA)
    Call<EstadoCuentaCuotaResponse> obtenerListaEstadoCuentaCuotaByUprivada(@Path("id") int uprivadaId);

}
