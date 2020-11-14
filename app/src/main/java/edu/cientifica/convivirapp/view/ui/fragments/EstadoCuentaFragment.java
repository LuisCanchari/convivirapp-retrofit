package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.EstadoCuenta;
import edu.cientifica.convivirapp.view.adapter.EstadoCuentaAdapter;
import edu.cientifica.convivirapp.view.adapter.EstadoCuentaListener;
import edu.cientifica.convivirapp.viewmodel.EstadoCuentaViewModel;

public class EstadoCuentaFragment extends Fragment /*implements EstadoCuentaListener*/ {

    private RecyclerView recyclerViewEstadocuenta;
    private RelativeLayout rlBaseEstadoCuenta;
    private EstadoCuentaViewModel estadoCuentaViewModel;
    private EstadoCuentaAdapter estadoCuentaAdapter;
    private static final String TAG = "CONVIVIRX";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estado_cuenta, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewEstadocuenta = view.findViewById(R.id.recyclerViewEstadocuenta);
        rlBaseEstadoCuenta = view.findViewById(R.id.rlBase);
        recyclerViewEstadocuenta.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false ));
        recyclerViewEstadocuenta.setAdapter(estadoCuentaAdapter);


        estadoCuentaViewModel = new ViewModelProvider(this).get(EstadoCuentaViewModel.class);
        //estadoCuentaViewModel.getEstadoCuentaLiveData(); //aqui se llena de datos




        //recyclerViewEstadocuenta

        observeViewModel();

    }

    private void observeViewModel() {
        final  Observer<List<EstadoCuenta>> listObserver = new Observer<List<EstadoCuenta>>() {
            @Override
            public void onChanged(List<EstadoCuenta> estadoCuentas) {
                Log.i(TAG, "onChanged estadoCuentas "+estadoCuentas.size());
                //estadoCuentaAdapter.updateData(estadoCuentas);
                estadoCuentaAdapter = new EstadoCuentaAdapter(estadoCuentas);
                recyclerViewEstadocuenta.setAdapter(estadoCuentaAdapter);
            }
        };
        estadoCuentaViewModel.getEstadoCuentaLiveData().observe(getViewLifecycleOwner(),listObserver);




        final Observer<Boolean> booleanObserver = new Observer<Boolean>(){

            @Override
            public void onChanged(Boolean it) {
                if(it!=null)
                    rlBaseEstadoCuenta.setVisibility(View.INVISIBLE);
            }
        };
        estadoCuentaViewModel.getIsLoading().observe(getViewLifecycleOwner(),booleanObserver);

    }

}