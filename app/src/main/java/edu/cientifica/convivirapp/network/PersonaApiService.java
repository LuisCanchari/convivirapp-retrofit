package edu.cientifica.convivirapp.network;

import java.util.List;

import edu.cientifica.convivirapp.model.Persona;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface PersonaApiService {
    String API_ROUTE = "persona/all";

    @GET(API_ROUTE)
    Call<List<Persona>> getListaPersona();
}
