package edu.cientifica.convivirapp.network.apiadapter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.cientifica.convivirapp.network.ConstantesRestApi;
import edu.cientifica.convivirapp.network.EndPointApiService;
import edu.cientifica.convivirapp.network.deserializador.EstadoCuentaUPrivadaDeserializador;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    private static final String TAG = "CONVIVIRX";

    public EndPointApiService establecerConexionRest(){

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) //desearilizacion automatica
                .build();

        return retrofit.create(EndPointApiService.class);
    }

    public EndPointApiService establecerConexionRest(Gson gson){

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPointApiService.class);
    }

    public Gson contruyeGsonDeserializadorEstadoCuentaUprivada(){
        Log.i(TAG, "contruyeGsonDeserializadorEstadoCuentaUprivada: ");
        GsonBuilder gsonBuilder= new GsonBuilder();
        gsonBuilder.registerTypeAdapter(EstadoCuentaResponse.class, new EstadoCuentaUPrivadaDeserializador());
        return gsonBuilder.create();
    }
}
