package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.EstadoCuenta;
import edu.cientifica.convivirapp.model.EstadoCuentaCuota;
import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;
import edu.cientifica.convivirapp.view.adapter.EstadoCuentaCuotaAdapter;
import edu.cientifica.convivirapp.view.adapter.EstadoCuentaCuotaListener;
import edu.cientifica.convivirapp.viewmodel.EstadoCuentaCuotaViewModel;


public class EstCtaCuotaFragment extends Fragment
implements EstadoCuentaCuotaListener {
    private static final String TAG = "CONVIVIRX";
    private TextView tvTipoNumero;
    private TextView tvPropietario;
    private TextView tvMontoTotal;
    private RecyclerView recyclerView;
    private EstadoCuentaCuotaAdapter estadoCuentaCuotaAdapter;
    private EstadoCuentaCuotaViewModel estadoCuentaCuotaViewModel;
    private List<EstadoCuentaCuota> listaEstadoCuentaCuota;
    private NavController navController;

    public EstCtaCuotaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        estadoCuentaCuotaViewModel = new ViewModelProvider(this).get(EstadoCuentaCuotaViewModel.class);
        listaEstadoCuentaCuota =  new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_est_cta_cuota, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EstadoCuentaUPrivada ec = (EstadoCuentaUPrivada) this.getArguments().getSerializable("estadoCuenta");
        int unidadprivada_id = ec.getUnidadPrivada().getId();

        recyclerView = view.findViewById(R.id.recyclerView);
        navController = Navigation.findNavController(this.getActivity(), R.id.fragContenido);
        estadoCuentaCuotaAdapter =  new EstadoCuentaCuotaAdapter(listaEstadoCuentaCuota,this,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(estadoCuentaCuotaAdapter);


        estadoCuentaCuotaViewModel.getEstadoCuentaCuotaLiveData(unidadprivada_id)
                .observe(getViewLifecycleOwner(), new Observer<List<EstadoCuentaCuota>>() {
            @Override
            public void onChanged(List<EstadoCuentaCuota> estadoCuentaCuotas) {
                estadoCuentaCuotaAdapter.setListaEstadoCuentaCuota(estadoCuentaCuotas);
                listaEstadoCuentaCuota = estadoCuentaCuotas;
            }
        });

        tvTipoNumero = view.findViewById(R.id.tvTipoNumero);
        tvPropietario = view.findViewById(R.id.tvPropietario);
        tvMontoTotal = view.findViewById(R.id.tvMontoTotal);

        Log.i(TAG, "onViewCreated: " + ec.toString());

        tvTipoNumero.setText("UNIDAD : "+ec.getUnidadPrivada().getTipoUnidad().getDescripcion() + " "
                + ec.getUnidadPrivada().getNumeracion());

        tvPropietario.setText("PROPIETARIO : "+ec.getUnidadPrivada().getPropietario().getNombre() + " "
                + ec.getUnidadPrivada().getPropietario().getPrimerApellido() + " "
                + ec.getUnidadPrivada().getPropietario().getSegundoApellido());
        tvMontoTotal.setText("DEUDA : "+String.valueOf(ec.getTotalCargo() - ec.getTotalAbono()));



    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }
}