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
import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;

public class EstadoCuentaUPrivadaAdapter
        extends RecyclerView.Adapter<EstadoCuentaUPrivadaAdapter.ViewHolder> {
    private static final String TAG="CONVIVIRX";
    private List<EstadoCuentaUPrivada> listaEstadoCuentaUPrivada;
    private EstadoCuentaUPrivadaListener estadoCuentaUPrivadaListener;
    Context context;

    public EstadoCuentaUPrivadaAdapter(List<EstadoCuentaUPrivada> listaEstadoCuentaUPrivada,
                                       EstadoCuentaUPrivadaListener estadoCuentaUPrivadaListener,
                                       Context context) {
        this.listaEstadoCuentaUPrivada = listaEstadoCuentaUPrivada;
        this.estadoCuentaUPrivadaListener = estadoCuentaUPrivadaListener;
        this.context = context;
    }

    public void setEstadoCuentaUPrivadaListener(EstadoCuentaUPrivadaListener estadoCuentaUPrivadaListener) {
        this.estadoCuentaUPrivadaListener = estadoCuentaUPrivadaListener;
    }

    public void setListaEstadoCuentaUPrivada(List<EstadoCuentaUPrivada> listaEstadoCuentaUPrivada) {
        this.listaEstadoCuentaUPrivada = listaEstadoCuentaUPrivada;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estado_cuenta,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EstadoCuentaUPrivada estadoCuentaUPrivada = listaEstadoCuentaUPrivada.get(position);
        holder.tvTipoNumero.setText("Unidad: "+estadoCuentaUPrivada.getUnidadPrivada().getTipoUnidad().getDescripcion()
                            +" "+estadoCuentaUPrivada.getUnidadPrivada().getNumeracion());
        holder.tvPropietario.setText("Propietario: "+estadoCuentaUPrivada.getUnidadPrivada().getPropietario().getNombre()
        +" "+estadoCuentaUPrivada.getUnidadPrivada().getPropietario().getPrimerApellido());
        holder.tvMontoTotal.setText("Deuda: "+String.valueOf(estadoCuentaUPrivada.getTotalCargo()-estadoCuentaUPrivada.getTotalAbono()));
    }

    @Override
    public int getItemCount() {
        return listaEstadoCuentaUPrivada.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
                    estadoCuentaUPrivadaListener.onItemClick(getLayoutPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    estadoCuentaUPrivadaListener.onItemLongClick(getLayoutPosition());
                    return true;
                }
            });

        }
    }
}
