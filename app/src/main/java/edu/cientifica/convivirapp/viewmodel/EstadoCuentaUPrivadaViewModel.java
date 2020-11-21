package edu.cientifica.convivirapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;
import edu.cientifica.convivirapp.network.EndPointApiService;
import edu.cientifica.convivirapp.network.apiadapter.RestApiAdapter;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EstadoCuentaUPrivadaViewModel extends ViewModel {
    private static final String TAG = "CONVIVIRX";
    private MutableLiveData<List<EstadoCuentaUPrivada>> estadoCuentaUPrivadaLiveData;
    private Retrofit retrofit;

    public LiveData<List<EstadoCuentaUPrivada>> getEstadoCuentaUPrivadaLiveData() {
        if(estadoCuentaUPrivadaLiveData == null){
            estadoCuentaUPrivadaLiveData = new MutableLiveData<List<EstadoCuentaUPrivada>>();
            cargarDatos();
        }
        return estadoCuentaUPrivadaLiveData;
    }

    private void cargarDatos() {


        RestApiAdapter restApiAdapter = new RestApiAdapter();
        /**CONFIGURA EL ACCESO AL API CON DESEARILIZADOR PERSONALIZADO**/
        Gson gsonEstadoCuentaUprivada = restApiAdapter.contruyeGsonDeserializadorEstadoCuentaUprivada();
        EndPointApiService service = restApiAdapter.establecerConexionRest(gsonEstadoCuentaUprivada);

        /**CONFIGURA EL ACCESO AL API CON DESEARILIZADOR POR DEFECTO**/
        //EndPointApiService service = restApiAdapter.establecerConexionRest();

        Call<EstadoCuentaResponse> call = service.obtenerEstadoCuentaUPrivada();
        call.enqueue(new Callback<EstadoCuentaResponse>() {
            @Override
            public void onResponse(Call<EstadoCuentaResponse> call, Response<EstadoCuentaResponse> response) {
                if (response.isSuccessful()){
                    //RECUPERA DATOS DEL BODY Y CARGA AL VIEW MODEL
                    Log.i(TAG, "onResponse: "+response.raw());
                    estadoCuentaUPrivadaLiveData.setValue(response.body().getListaEstadoCuentaResponse());

                    Log.i(TAG, "onResponse: " + estadoCuentaUPrivadaLiveData.getValue().size());
                }else {
                    Log.e(TAG, "onResponse: " + response.errorBody().toString());
                    Log.e(TAG, "onResponse: " + response.errorBody().source().toString());
                }
            }
            @Override
            public void onFailure(Call<EstadoCuentaResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " +t.getMessage());
                Log.e(TAG, "onFailure: " +t.toString());
            }
        });
    }
}
