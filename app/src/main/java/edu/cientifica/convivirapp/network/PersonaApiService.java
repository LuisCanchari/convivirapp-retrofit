package edu.cientifica.convivirapp.network;

import java.util.List;

import edu.cientifica.convivirapp.model.Persona;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonaApiService {

    @GET(ConstantesRestApi.URL_GET_PERSONA_ALL)
    Call<List<Persona>> getListaPersona();
}
