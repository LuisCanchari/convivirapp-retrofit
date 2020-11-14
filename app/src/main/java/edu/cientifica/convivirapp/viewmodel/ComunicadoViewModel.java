package edu.cientifica.convivirapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.model.Comunicado;

public class ComunicadoViewModel extends ViewModel {
    private MutableLiveData<List<Comunicado>> listComunicadoLiveData;
    private List<Comunicado> listComunicado;

    public List<Comunicado> getListComunicado() {
        return listComunicado;
    }

    public void setListComunicado(List<Comunicado> listComunicado) {
        this.listComunicado = listComunicado;
    }

    public MutableLiveData<List<Comunicado>> getListComunicdadoLiveData() {
        if (listComunicadoLiveData ==null) {

            listComunicadoLiveData = new MutableLiveData<List<Comunicado>>();
            cargaDatos();
        }

        return listComunicadoLiveData;
    }

    private void cargaDatos() {
        //cargarlosdatos
        listComunicado = new ArrayList<>();
        listComunicado.add(new Comunicado(1,"Convocatoria de Reunion","Comunicado","Se convoca a reunion para tratar la siguiente agenda"));
        listComunicado.add(new Comunicado(2,"Vencimiento de Cuota","Aviso","Se informa sobre fecha de vencimiento de cuota"));
        listComunicado.add(new Comunicado(3,"Comunicacion de trabajos","Comunicado","Se convoca a reunion para tratar la siguiente agenda"));
      /*  listComunicado.add(new Comunicado(4,"Corte de agua","Aviso","Se convoca a reunion para tratar la siguiente agenda"));
        listComunicado.add(new Comunicado(5,"Vencimiento de Pago","Aviso","Se convoca a reunion para tratar la siguiente agenda"));
        listComunicado.add(new Comunicado(6,"Instalacion de Gas","Comunicado","Se convoca a reunion para tratar la siguiente agenda"));
        listComunicado.add(new Comunicado(7,"Pintura de fachada","Comunicado","Se convoca a reunion para tratar la siguiente agenda"));
        listComunicado.add(new Comunicado(8,"Reparación del puerta de ingreso","Comunicado","Se convoca a reunion para tratar la siguiente agenda"));
        listComunicado.add(new Comunicado(9,"Incidente en Porteria","Comunicado","Se convoca a reunion para tratar la siguiente agenda"));*/

        listComunicadoLiveData.setValue(listComunicado);
    }


    public void setListComunicdadoLiveData(MutableLiveData<List<Comunicado>> listComunicdadoLiveData) {
        this.listComunicadoLiveData = listComunicdadoLiveData;
    }
}
