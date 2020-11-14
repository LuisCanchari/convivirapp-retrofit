package edu.cientifica.convivirapp.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.cientifica.convivirapp.R;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaAdapterHolder> {


    @NonNull
    @Override
    public PersonaAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PersonaAdapterHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvDocumento;
        private TextView tvTipoDocumento;
        private TextView tvFechaNacimiento;


        public PersonaAdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvName);
            tvDocumento = itemView.findViewById(R.id.tvDocumento);
            tvTipoDocumento = itemView.findViewById(R.id.tvTipoDocumento);
            tvFechaNacimiento = itemView.findViewById(R.id.tvFechaNacimiento);

        }
    }
}
