package edu.cientifica.convivirapp.demo;


import edu.cientifica.convivirapp.demo.PokemonRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListPokemon();

}
