package edu.cientifica.convivirapp.view.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.LimitExceededException;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.Persona;
import edu.cientifica.convivirapp.view.adapter.EstadoCuentaAdapter;
import edu.cientifica.convivirapp.view.adapter.PersonaAdapter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PersonaAdapter adapter;
    private List<Persona> listaPersona;

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        setUpView();
        lanzarPeticion();
    }

    private void lanzarPeticion() {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:8080/convivir/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
      /*  WebServiceClient client = retrofit.create(WebServiceClient.class);*/


    }

    private void setUpView() {
    listaPersona = new ArrayList<>();
    /*
    adapter=new PersonaAdapter(listaPersona);
    recyclerView = findViewById(R.id.recyclerViewPersona);
    LinearLayoutManager lim =  new LinearLayoutManager(this);
    lim.setOrientation(RecyclerView.VERTICAL);
    recyclerView.setLayoutManager(lim);
    recyclerView.setAdapter(adapter);
*/


    }
}