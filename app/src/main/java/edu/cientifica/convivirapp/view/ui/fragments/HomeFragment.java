package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.EstadoCuenta;
import edu.cientifica.convivirapp.network.EstadoCuentaApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private static final String TAG = "CONVIVIRX";
    private Retrofit retrofit;

    ListView list;
    ArrayList<String> nombres = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:8080/convivir/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i(TAG," onCreate: ");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,nombres);
        list = view.findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        obtenerDatos(arrayAdapter);

    }
    private void obtenerDatos(ArrayAdapter arrayAdapter) {
        EstadoCuentaApiService service = retrofit.create(EstadoCuentaApiService.class);
        Call<List<EstadoCuenta>> call = service.obtenerListEstadoCuenta();
        call.enqueue(new Callback<List<EstadoCuenta>>() {
            @Override
            public void onResponse(Call<List<EstadoCuenta>> call, Response<List<EstadoCuenta>> response) {
                if (response.isSuccessful()){
                    List<EstadoCuenta> listEstadoCuenta = response.body();
                    for(EstadoCuenta estadoCuenta: listEstadoCuenta){
                        nombres.add(estadoCuenta.getNamePropietario());
                        Log.i(TAG," Propietario:"+estadoCuenta.getNamePropietario());
                    }
                }else{
                    Log.i(TAG,"onResponse: "+response.errorBody());
                }
                arrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<EstadoCuenta>> call, Throwable t) {

                Log.e(TAG,"onFailure " + t.getMessage());
            }
        });

    }
}