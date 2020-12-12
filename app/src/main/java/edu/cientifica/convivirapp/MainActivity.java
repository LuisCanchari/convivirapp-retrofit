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
    }

    private void configView() {
        bottomNavigationView = findViewById(R.id.bnvMenu);
        NavController navController = Navigation.findNavController(this, R.id.fragContenido);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }


}