package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.Residente;
import edu.cientifica.convivirapp.viewmodel.ResidenteViewModel;


public class ResidentesFragment extends Fragment {


    private ResidenteViewModel residenteViewModel;
    TextView tvResidentes;
    Button btAgregar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_residentes, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvResidentes =  view.findViewById(R.id.tvResidentes);
        btAgregar=view.findViewById(R.id.btAgregar);

        residenteViewModel= new ViewModelProvider(this).get(ResidenteViewModel.class);

      /*  residenteViewModel.getResidentes().observe(getViewLifecycleOwner(), new Observer<List<Residente>>() {
            @Override
            public void onChanged(List<Residente> residentes) {

                String nombres="";
                for (Residente residente : residentes) {
                    nombres=nombres+residente.getNombre()+"\n";
                }
                tvResidentes.setText(nombres);
               // Toast.makeText(getActivity(), "mensajito"+nombres , Toast.LENGTH_SHORT).show();
            }
        });*/

        final Observer<List<Residente>> listaResidenteObserver = new Observer<List<Residente>>() {
            @Override
            public void onChanged(List<Residente> residentes) {
                String texto="";
                for (Residente r: residentes){
                     texto = texto +r.getId()+" "+r.getNombre()+r.getNumDocumento()+"\n";

                }
                tvResidentes.setText(texto);
                //tvResidentes.setText(residentes.toString());
            }
        };
        //suscripcion del observabe al observador
        residenteViewModel.getResidentes().observe(getViewLifecycleOwner(),listaResidenteObserver);


        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                residenteViewModel.insertarResidente(new Residente(9,"Lulu","99999"));


              //  residenteViewModel.insertarResidente();

               // residenteViewModel.getResidentes().setValue();

               // String nombres="";
               // tvResidentes.setText(nombres);

                //tvresidenteViewModel
                //tvResidentes.setText();
            }
        });



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        /*residenteViewModel= new ViewModelProvider(requireActivity()).get(ResidenteViewModel.class);
        residenteViewModel.getResidentes().observe(getViewLifecycleOwner(), new Observer<List<Residente>>() {
            @Override
            public void onChanged(List<Residente> residentes) {

                String nombres="";
                for (Residente residente : residentes) {
                    nombres=nombres+residente.getNombre()+"\n";

                }
                Toast.makeText(getActivity(), "mensaje1 "+nombres , Toast.LENGTH_SHORT).show();
            }
        });*/
    }


}