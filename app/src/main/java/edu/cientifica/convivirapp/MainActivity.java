package edu.cientifica.convivirapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import edu.cientifica.convivirapp.model.Residente;
import edu.cientifica.convivirapp.viewmodel.ResidenteViewModel;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar((Toolbar) findViewById(R.id.tbPrincipal));

        configView();
/*
        ResidenteViewModel model =  new ViewModelProvider(this).get(ResidenteViewModel.class);
        model.getResidentes().observe(this, new Observer<List<Residente>>() {
            @Override
            public void onChanged(List<Residente> residentes) {
                //actualizar la ui
                String nombres="";
                for (Residente residente : residentes) {
                    nombres=nombres+residente.getNombre()+"\n";

                }
                Toast.makeText(getApplication(), "mensaje "+nombres , Toast.LENGTH_SHORT).show();
            }
        });*/

    }


    private void configView() {
        bottomNavigationView = findViewById(R.id.bnvMenu);
        NavController navController = Navigation.findNavController(this, R.id.fragContenido);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
      /*  bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            }
        });*/
    }


}