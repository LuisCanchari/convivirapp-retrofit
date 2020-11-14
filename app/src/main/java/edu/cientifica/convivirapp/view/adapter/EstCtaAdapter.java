package edu.cientifica.convivirapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.EstadoCuenta;

public class EstCtaAdapter
        extends RecyclerView.Adapter<EstCtaAdapter.ViewHolder> {

    private static final String TAG="ComunicadoAdapter";
    private List<EstadoCuenta> listaEstadoCuenta;
    private EstCtaListener estCtaListener;
    Context context;

    public EstCtaAdapter(List<EstadoCuenta> listaEstadoCuenta, Context context, EstCtaListener estCtaListener) {
        this.listaEstadoCuenta = listaEstadoCuenta;
        this.context = context;
        this.estCtaListener=estCtaListener;
    }

    public void setEstCtaListener(EstCtaListener estCtaListener) {
        this.estCtaListener = estCtaListener;
    }

    @NonNull
    @Override
    public EstCtaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estado_cuenta,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstCtaAdapter.ViewHolder holder, int position) {
        EstadoCuenta estadoCuenta =  listaEstadoCuenta.get(position);
        holder.tvTipoNumero.setText("Unidad: "+estadoCuenta.getTipoVivienda()+" "+estadoCuenta.getNumVivienda());
        holder.tvPropietario.setText("Propietario: "+estadoCuenta.getNamePropietario());
        holder.tvMontoTotal.setText("Deuda: "+estadoCuenta.getMontoTotal());
    }

    @Override
    public int getItemCount() {
        return listaEstadoCuenta.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTipoNumero;
        TextView tvPropietario;
        TextView tvMontoTotal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTipoNumero = itemView.findViewById(R.id.tvTipoNumero);
            tvPropietario = itemView.findViewById(R.id.tvPropietario);
            tvMontoTotal = itemView.findViewById(R.id.tvMontoTotal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    estCtaListener.onItemClick(getLayoutPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    estCtaListener.onItemLongClick(getLayoutPosition());
                    return true;
                }
            });
        }
    }

    public void setListaEstadoCuenta(List<EstadoCuenta> listaEstadoCuenta) {
        this.listaEstadoCuenta = listaEstadoCuenta;
        notifyDataSetChanged();
    }


}
