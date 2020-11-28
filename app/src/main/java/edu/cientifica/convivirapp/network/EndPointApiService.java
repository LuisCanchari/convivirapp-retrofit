package edu.cientifica.convivirapp.network;

import java.util.List;

import edu.cientifica.convivirapp.model.Abono;
import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;
import edu.cientifica.convivirapp.network.responsemodel.CuotaDetalleResponse;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaCuotaResponse;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EndPointApiService {

    @GET(ConstantesRestApi.URL_GET_ESTADOCUENTA_UPRIVADA_ALL)
    Call<EstadoCuentaResponse> obtenerEstadoCuentaUPrivada();


    @GET(ConstantesRestApi.URL_GET_ESTADOCUENTA_UPRIVADA_ALL)
    Call<List<EstadoCuentaUPrivada>> obtenerListaEstadoCuentaUPrivada();

    @GET(ConstantesRestApi.URL_GET_ESTADOCUENTA_CUOTA_BY_UPRIVADA)
    /* URL_GET_ESTADOCUENTA_CUOTA_BY_UPRIVADA = "estadocuenta/cuota/uprivada/{id}"*/
    Call<EstadoCuentaCuotaResponse> obtenerListaEstadoCuentaCuotaByUprivada(@Path("id") int uprivadaId);

    @GET(ConstantesRestApi.URL_GET_CUOTA_DETALLE_BY_CUOTA)
    Call<CuotaDetalleResponse> obtenerListaCuotaDetalleByCuota(@Path("id") int cuotaId);

    @Headers("Content-Type: application/json")
    @POST(ConstantesRestApi.URL_POST_CUOTA_ABONO)
    Call<Abono> registrarAbono(@Body Abono abono);



}
