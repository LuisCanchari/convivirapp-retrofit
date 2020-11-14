package edu.cientifica.convivirapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.model.Residente;

public class ResidenteViewModel extends ViewModel {

    private MutableLiveData<List<Residente>> residentes;
    private List<Residente> residenteList;


    public MutableLiveData<List<Residente>> getResidentes() {
        if(residentes==null){
            residentes = new MutableLiveData<List<Residente>>();
            residenteList=new ArrayList<>();
            cargaInicial();
            Log.i("ControlLiveData", " Residente");
        }
        return residentes;
    }
    public void insertarResidente(Residente residente){
        residenteList.add(residente);
        Log.i("insertarResidente", residente.toString());
        residentes.setValue(residenteList);
    }

    private void cargaInicial() {

        residenteList.add(new Residente(1,"Luis","12345678"));
        residenteList.add(new Residente(2,"Juan","22222222"));
        residenteList.add(new Residente(3,"Pedro","33333333"));
        residenteList.add(new Residente(4,"Miguel","44444444"));

        residentes.setValue(residenteList);

    }

}
