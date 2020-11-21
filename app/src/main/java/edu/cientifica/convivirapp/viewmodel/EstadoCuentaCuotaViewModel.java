package edu.cientifica.convivirapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuentaCuota;
import edu.cientifica.convivirapp.network.EndPointApiService;
import edu.cientifica.convivirapp.network.apiadapter.RestApiAdapter;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaCuotaResponse;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EstadoCuentaCuotaViewModel extends ViewModel {
    private static final String TAG = "CONVIVIRX";
    private MutableLiveData<List<EstadoCuentaCuota>> estadoCuentaCuotaLiveData;
    Retrofit retrofit;

    public LiveData<List<EstadoCuentaCuota>> getEstadoCuentaCuotaLiveData(int i) {
        if (estadoCuentaCuotaLiveData == null){
            estadoCuentaCuotaLiveData = new MutableLiveData<List<EstadoCuentaCuota>>();
            cargarDatos(i);
        }
        return estadoCuentaCuotaLiveData;
    }

    private void cargarDatos(int unidad_privada) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        /**CONFIGURA EL ACCESO AL API CON DESEARILIZADOR POR DEFECTO**/
        EndPointApiService service = restApiAdapter.establecerConexionRest();

       Call<EstadoCuentaCuotaResponse> call = service.obtenerListaEstadoCuentaCuotaByUprivada(unidad_privada);
       call.enqueue(new Callback<EstadoCuentaCuotaResponse>() {
           @Override
           public void onResponse(Call<EstadoCuentaCuotaResponse> call, Response<EstadoCuentaCuotaResponse> response) {
               if(response.isSuccessful()){
                   Log.i(TAG, "onResponse: "+response.raw());
                   estadoCuentaCuotaLiveData.setValue(response.body().getListaEstadoCuentaCuotaResponse());

               }else {
                   Log.e(TAG, "onResponse: "+response.errorBody().toString());
               }
           }
           @Override
           public void onFailure(Call<EstadoCuentaCuotaResponse> call, Throwable t) {
               Log.e(TAG, "onFailure: " +t.getMessage());
           }
       });
    }
}
