package edu.cientifica.convivirapp.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.EstadoCuenta;

public class EstadoCuentaAdapter
        extends RecyclerView.Adapter<EstadoCuentaAdapter.ViewHolderEC> implements View.OnClickListener {

    private List<EstadoCuenta> estadoCuentaList;
    private View.OnClickListener listener;
    //EstadoCuentaListener estadoCuentaListener;

    public EstadoCuentaAdapter(List<EstadoCuenta> estadoCuentaList) {
        this.estadoCuentaList = estadoCuentaList;
        Log.i("adapter", "EstadoCuentaAdapter constructor: ");
    }


   /* public EstadoCuentaAdapter(EstadoCuentaListener estadoCuentaListener){
        this.estadoCuentaListener = estadoCuentaListener;
    }*/

    @NonNull
    @Override
    public EstadoCuentaAdapter.ViewHolderEC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estado_cuenta,parent,false);
        //parent o null
        return new ViewHolderEC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoCuentaAdapter.ViewHolderEC holder, int position) {
        holder.setDatatView(estadoCuentaList.get(position));
        //EstadoCuenta estadoCuenta;
        //estadoCuenta = estadoCuentaList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"click en "+v.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }



    public void updateData(List<EstadoCuenta> data){
        estadoCuentaList.clear();
        estadoCuentaList.addAll(data);
        notifyDataSetChanged();
        Log.i("adapter", "updateData: ");
    }

    @Override
    public int getItemCount() {
        return estadoCuentaList.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    public class ViewHolderEC extends RecyclerView.ViewHolder {
        TextView tvTipoNumero;
        TextView tvPropietario;
        TextView tvMontoTotal;

        public ViewHolderEC(@NonNull View itemView) {
            super(itemView);
            tvTipoNumero = itemView.findViewById(R.id.tvTipoNumero);
            tvPropietario = itemView.findViewById(R.id.tvPropietario);
            tvMontoTotal = itemView.findViewById(R.id.tvMontoTotal);
        }
        public void setDatatView(EstadoCuenta estadoCuenta){
            tvTipoNumero.setText("Unidad: "+estadoCuenta.getTipoVivienda()+" "+estadoCuenta.getNumVivienda());
            tvPropietario.setText("Propietario: "+estadoCuenta.getNamePropietario());
            tvMontoTotal.setText("Deuda: "+estadoCuenta.getMontoTotal());
        }
    }
}
