package edu.cientifica.convivirapp.view.ui.fragments;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.Comunicado;
import edu.cientifica.convivirapp.view.adapter.ComunicadoAdapter;
import edu.cientifica.convivirapp.view.adapter.ComunicadoListener;
import edu.cientifica.convivirapp.viewmodel.ComunicadoViewModel;


public class ComunicadosFragment extends Fragment implements ComunicadoListener {
    private static final String TAG = "CONVIVIRX";
    private RecyclerView recyclerView;
    private ComunicadoAdapter comunicadoAdapter;
    private ComunicadoViewModel comunicadoViewModel;
    private List<Comunicado> comunicadoList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comunicadoViewModel =  new ViewModelProvider(this).get(ComunicadoViewModel.class);
        comunicadoList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comunicados, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewComunicados);


        comunicadoList = comunicadoViewModel.getListComunicdadoLiveData().getValue();

        comunicadoAdapter = new ComunicadoAdapter(comunicadoList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(comunicadoAdapter);

        }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(),comunicadoList.get(position).getTitulo(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onItemLongClick(int position) {
        comunicadoList.remove(position);
        comunicadoAdapter.notifyItemRemoved(position);

    }
}