package edu.cientifica.convivirapp.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.Comunicado;

public class ComunicadoAdapter
        extends RecyclerView.Adapter<ComunicadoAdapter.ViewHolder> {

    private static final String TAG="ComunicadoAdapter";
    int count=0;
    private List<Comunicado> comunicadoList;
    private ComunicadoListener comunicadoListener;

    public ComunicadoAdapter(List<Comunicado> comunicadosList, ComunicadoListener comunicadoListener) {
        this.comunicadoList = comunicadosList;
        this.comunicadoListener = comunicadoListener;
    }

    @NonNull
    @Override
    public ComunicadoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: "+count++);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_comunicado, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComunicadoAdapter.ViewHolder holder, int position) {

        holder.tvTitulo.setText(comunicadoList.get(position).getTitulo());
        holder.tvTipo.setText(comunicadoList.get(position).getTipo());
        holder.tvMensaje.setText(comunicadoList.get(position).getMensaje());
    }

    @Override
    public int getItemCount() {
        return comunicadoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitulo, tvTipo, tvMensaje;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTituloComunicado);
            tvTipo = itemView.findViewById(R.id.tvTipoComunicado);
            tvMensaje=itemView.findViewById(R.id.tvMensajeComunicado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comunicadoListener.onItemClick(getLayoutPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //comunicadoList.remove(getLayoutPosition());
                    //notifyItemRemoved(getLayoutPosition());
                    comunicadoListener.onItemLongClick(getLayoutPosition());
                    return true;
                }
            });
        }
    }
}
