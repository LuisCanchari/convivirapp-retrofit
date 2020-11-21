package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.EstadoCuenta;
import edu.cientifica.convivirapp.view.adapter.EstCtaAdapter;
import edu.cientifica.convivirapp.view.adapter.EstCtaListener;
import edu.cientifica.convivirapp.viewmodel.EstCtaViewModel;

public class EstCtaFragmentbk extends Fragment
    implements EstCtaListener
{
    private RecyclerView recyclerViewEstCta;
    private EstCtaAdapter estCtaAdapter;
    private EstCtaViewModel estCtaViewModel;
    private List<EstadoCuenta> listaEstadoCuenta;
    private  NavController navController;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        estCtaViewModel = new ViewModelProvider(this).get(EstCtaViewModel.class);
        listaEstadoCuenta = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_est_cta, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewEstCta = view.findViewById(R.id.recyclerViewEstCta);
        navController = Navigation.findNavController(this.getActivity(), R.id.fragContenido);
        //
        estCtaAdapter =  new EstCtaAdapter(listaEstadoCuenta, getContext(),this);
        recyclerViewEstCta.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewEstCta.addItemDecoration(dividerItemDecoration);
        recyclerViewEstCta.setAdapter(estCtaAdapter);



        estCtaViewModel.getLiveDataEstCta().observe(getViewLifecycleOwner(), new Observer<List<EstadoCuenta>>() {
            @Override
            public void onChanged(List<EstadoCuenta> estadoCuentas) {
               //     listaEstadoCuenta.addAll(estadoCuentas);
                estCtaAdapter.setListaEstadoCuenta(estadoCuentas);
                listaEstadoCuenta=estadoCuentas;
                //estCtaAdapter = new EstCtaAdapter(estadoCuentas, view.getContext());
                //recyclerViewEstCta.setAdapter(estCtaAdapter);
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        EstadoCuenta estadoCuenta;
        listaEstadoCuenta = estCtaViewModel.getLiveDataEstCta().getValue();
        Toast.makeText(getContext(),listaEstadoCuenta.get(position).getNamePropietario(),Toast.LENGTH_LONG).show();
        estadoCuenta = listaEstadoCuenta.get(position);
        //Preparando Bunble
        Bundle bundle = new Bundle();
        bundle.putSerializable("estadoCuenta",estadoCuenta);

        //Navegar a formulario destino
        navController.navigate(R.id.navEstCtaCuotaFragment,bundle);
    }

    @Override
    public void onItemLongClick(int position) {
        listaEstadoCuenta = estCtaViewModel.getLiveDataEstCta().getValue();
        Toast.makeText(getContext(),listaEstadoCuenta.get(position).getNamePropietario(),Toast.LENGTH_LONG).show();
        //listaEstadoCuenta.remove(position);
        //estCtaAdapter.notifyItemRemoved(position);
    }
}