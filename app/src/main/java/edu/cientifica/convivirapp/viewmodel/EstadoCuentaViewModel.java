package edu.cientifica.convivirapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuenta;
import edu.cientifica.convivirapp.network.EstadoCuentaApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EstadoCuentaViewModel extends ViewModel {

    private MutableLiveData<List<EstadoCuenta>> listEstadoCuentaLiveData;
    private List<EstadoCuenta> estadoCuentaList;
    private MutableLiveData<Boolean> isLoading;
    private Retrofit retrofit;
    private static final String TAG = "CONVIVIRX";

    public void setEstadoCuentaList(List<EstadoCuenta> estadoCuentaList) {
        this.estadoCuentaList = estadoCuentaList;
    }

    public MutableLiveData<List<EstadoCuenta>> getEstadoCuentaLiveData(){
        if (listEstadoCuentaLiveData==null){
            listEstadoCuentaLiveData =  new MutableLiveData<List<EstadoCuenta>>();
          //  estadoCuentaList = new ArrayList<>();
        //    isLoading.setValue(Boolean.FALSE);
            cargaInicial();
           // refescarDatos();

            //processFinished();
            //Log.i("ControlLiveData", "Estado de cuenta");
        }
        return listEstadoCuentaLiveData;

    }
    public MutableLiveData<Boolean> getIsLoading(){
        if(isLoading==null){
            isLoading=new MutableLiveData<Boolean>();
            isLoading.setValue(Boolean.FALSE);
        }
        return isLoading;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuentaList.add(estadoCuenta);
        listEstadoCuentaLiveData.setValue(estadoCuentaList);
    }

    public void processFinished(){
        isLoading.setValue(true);
    }

    private void cargaInicial() {
        estadoCuentaList.add(new EstadoCuenta(1,1,"1001","Vivienda","Ana Asto","310.00"));
        estadoCuentaList.add(new EstadoCuenta(1,2,"1002","Vivienda","Beto Buendia","320.00"));
        estadoCuentaList.add(new EstadoCuenta(1,3,"1003","Vivienda","Carlos Camarena","330.00"));
        estadoCuentaList.add(new EstadoCuenta(1,4,"1004","Vivienda","Daniel Diaz","340.00"));
        estadoCuentaList.add(new EstadoCuenta(2,5,"101","Departamento","Ana Arce","200.00"));
        estadoCuentaList.add(new EstadoCuenta(2,6,"102","Departamento","Beatriz Buendia","210.00"));
        estadoCuentaList.add(new EstadoCuenta(2,7,"103","Departamento","Carlos Castro","220.00"));
        estadoCuentaList.add(new EstadoCuenta(2,8,"104","Departamento","Dante Diaz","230.00"));
        estadoCuentaList.add(new EstadoCuenta(2,9,"105","Departamento","Ernesto Egas","240.00"));
        estadoCuentaList.add(new EstadoCuenta(2,10,"106","Departamento","Fabio Fernendez","250.00"));
        estadoCuentaList.add(new EstadoCuenta(2,11,"107","Departamento","Guillermo Garcia","260.00"));
        estadoCuentaList.add(new EstadoCuenta(2,12,"108","Departamento","Humberto Higa","270.00"));

        listEstadoCuentaLiveData.setValue(estadoCuentaList);
    }
    private void refescarDatos() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:8080/convivir/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i(TAG," onCreate: ");

        obtenerDatos();
        listEstadoCuentaLiveData.setValue(estadoCuentaList);
    }
    private  void obtenerDatos(){
        EstadoCuentaApiService service = retrofit.create(EstadoCuentaApiService.class);
        Call<List<EstadoCuenta>> call = service.obtenerListEstadoCuenta();
        call.enqueue(new Callback<List<EstadoCuenta>>() {
            @Override
            public void onResponse(Call<List<EstadoCuenta>> call, Response<List<EstadoCuenta>> response) {
                if (response.isSuccessful()){
                    estadoCuentaList = response.body();
                    listEstadoCuentaLiveData.setValue(estadoCuentaList);
                    Log.i(TAG," Registros cargados: "+estadoCuentaList.size());
                    //List<EstadoCuenta> listEstadoCuenta = response.body();
                    for(EstadoCuenta estadoCuenta: estadoCuentaList){
                        //nombres.add(estadoCuenta.getNamePropietario());
                       Log.i(TAG,estadoCuenta.toString());
                    }
                }else{
                    Log.e(TAG,"onResponse: "+response.errorBody());
                }
                //arrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<EstadoCuenta>> call, Throwable t) {

                Log.e(TAG,"onFailure " + t.getMessage());
            }
        });

    }

}
