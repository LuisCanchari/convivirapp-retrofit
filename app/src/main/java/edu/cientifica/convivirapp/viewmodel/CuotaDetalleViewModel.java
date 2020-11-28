package edu.cientifica.convivirapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.cientifica.convivirapp.model.CuotaDetalle;
import edu.cientifica.convivirapp.model.EstadoCuentaCuota;
import edu.cientifica.convivirapp.network.EndPointApiService;
import edu.cientifica.convivirapp.network.apiadapter.RestApiAdapter;
import edu.cientifica.convivirapp.network.responsemodel.CuotaDetalleResponse;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaCuotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CuotaDetalleViewModel extends ViewModel {
    private static final String TAG = "CONVIVIRX";
    private MutableLiveData<List<CuotaDetalle>> cuotaDetalleLiveData;
    Retrofit retrofit;

    public LiveData<List<CuotaDetalle>> getCuotaDetalleLiveData(int i) {
        if(cuotaDetalleLiveData==null){
            cuotaDetalleLiveData =  new MutableLiveData<List<CuotaDetalle>>();
            cargarDatos(i);
        }
        return cuotaDetalleLiveData;
    }

    private void cargarDatos(int cuotaId) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApiService service = restApiAdapter.establecerConexionRest();

        Call<CuotaDetalleResponse> call = service.obtenerListaCuotaDetalleByCuota(cuotaId);
        call.enqueue(new Callback<CuotaDetalleResponse>() {
            @Override
            public void onResponse(Call<CuotaDetalleResponse> call, Response<CuotaDetalleResponse> response) {
                if (response.isSuccessful()){
                    Log.i(TAG, "onResponse: " + response.raw());
                    cuotaDetalleLiveData.setValue(response.body().getListaCuotaDetalle());
                    Log.i(TAG, "onResponse: Numero de registros en body: "+cuotaDetalleLiveData.getValue().size());

                }else{
                    Log.e(TAG, "onResponse: "+response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<CuotaDetalleResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });

    }


}
