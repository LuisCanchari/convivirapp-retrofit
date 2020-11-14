package edu.cientifica.convivirapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuenta;
import edu.cientifica.convivirapp.network.EstadoCuentaApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EstCtaViewModel extends ViewModel {
    private MutableLiveData<List<EstadoCuenta>> liveDataEstCta;
    private Retrofit retrofit;
    private static final String TAG = "CONVIVIRX";


    public LiveData<List<EstadoCuenta>> getLiveDataEstCta() {
        if(liveDataEstCta==null){
            liveDataEstCta = new MutableLiveData<List<EstadoCuenta>>();
            loadData();
        }
        return liveDataEstCta;
    }


    private void loadData() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:8080/convivir/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EstadoCuentaApiService service = retrofit.create(EstadoCuentaApiService.class);
        Call<List<EstadoCuenta>> call = service.obtenerListEstadoCuenta();


        call.enqueue(new Callback<List<EstadoCuenta>>() {
            @Override
            public void onResponse(Call<List<EstadoCuenta>> call, Response<List<EstadoCuenta>> response) {
                if (response.isSuccessful()){
                    liveDataEstCta.setValue(response.body());
                    Log.i(TAG," Registros cargados: "+liveDataEstCta.getValue().size());
                    for(EstadoCuenta estadoCuenta: liveDataEstCta.getValue()){
                        Log.i(TAG,estadoCuenta.toString());
                    }
                }else{
                    Log.e(TAG,"onResponse: "+response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<List<EstadoCuenta>> call, Throwable t) {
                Log.e(TAG,"onFailure " + t.getMessage());
            }
        });
    }

}
