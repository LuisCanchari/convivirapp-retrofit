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
import edu.cientifica.convivirapp.model.EstadoCuentaCuota;

public class EstadoCuentaCuotaAdapter extends RecyclerView.Adapter<EstadoCuentaCuotaAdapter.ViewHolder> {
    private static final String TAG = "CONVIVIRX";
    private List<EstadoCuentaCuota> listaEstadoCuentaCuota;
    private EstadoCuentaCuotaListener estadoCuentaCuotaListener;
    Context context;

    public EstadoCuentaCuotaAdapter(List<EstadoCuentaCuota> listaEstadoCuentaCuota, EstadoCuentaCuotaListener estadoCuentaCuotaListener, Context context) {
        this.listaEstadoCuentaCuota = listaEstadoCuentaCuota;
        this.estadoCuentaCuotaListener = estadoCuentaCuotaListener;
        this.context = context;
    }

    public void setEstadoCuentaCuotaListener(EstadoCuentaCuotaListener estadoCuentaCuotaListener) {
        this.estadoCuentaCuotaListener = estadoCuentaCuotaListener;
    }

    public void setListaEstadoCuentaCuota(List<EstadoCuentaCuota> listaEstadoCuentaCuota) {
        this.listaEstadoCuentaCuota = listaEstadoCuentaCuota;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EstadoCuentaCuotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estado_cuenta_uprivada, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoCuentaCuotaAdapter.ViewHolder holder, int position) {
        EstadoCuentaCuota estadoCuentaCuota = listaEstadoCuentaCuota.get(position);
        holder.tvTituloCuota.setText(estadoCuentaCuota.getCuota().getTitulo());
        holder.tvNumAnioMes.setText("Cuota Numero: " + estadoCuentaCuota.getCuota().getNumCuota() + " del "
                + estadoCuentaCuota.getCuota().getAnio() + "-" + estadoCuentaCuota.getCuota().getMes());
        holder.tvFEmi_FVen.setText("Emitido el:" + estadoCuentaCuota.getCuota().getFechaEmision()
                + " Vence el " + estadoCuentaCuota.getCuota().getFechaVencimiento());
        holder.tvSaldoTotal.setText("Saldo que adeuda: S/."
                +String.valueOf(estadoCuentaCuota.getTotalCargo()-estadoCuentaCuota.getTotalAbono()));
    }

    @Override
    public int getItemCount() {
        return listaEstadoCuentaCuota.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTituloCuota;
        TextView tvNumAnioMes;
        TextView tvFEmi_FVen;
        TextView tvSaldoTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTituloCuota = itemView.findViewById(R.id.tvTituloCuota);
            tvNumAnioMes = itemView.findViewById(R.id.tvNumAnioMes);
            tvFEmi_FVen = itemView.findViewById(R.id.tvFEmi_FVen);
            tvSaldoTotal = itemView.findViewById(R.id.tvSaldoTotal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    estadoCuentaCuotaListener.onItemClick(getLayoutPosition());

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    estadoCuentaCuotaListener.onItemLongClick(getLayoutPosition());
                    return true;
                }
            });


        }
    }
}
