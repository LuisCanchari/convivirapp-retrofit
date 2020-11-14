package edu.cientifica.convivirapp.network;


import edu.cientifica.convivirapp.model.PokemonRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListPokemon();

}
