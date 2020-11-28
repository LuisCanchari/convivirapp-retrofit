package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.R;
import edu.cientifica.convivirapp.model.Abono;
import edu.cientifica.convivirapp.model.CuotaDetalle;
import edu.cientifica.convivirapp.model.EstadoCuentaCuota;
import edu.cientifica.convivirapp.network.EndPointApiService;
import edu.cientifica.convivirapp.network.apiadapter.RestApiAdapter;
import edu.cientifica.convivirapp.viewmodel.CuotaDetalleViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CuotaDetalleFragment extends Fragment {

    private static final String TAG = "CONVIVIRX";
    private CuotaDetalleViewModel cuotaDetalleViewModel;
    private List<CuotaDetalle> listaCuotaDetalle;

    private Button btVerDetalles, btPagar;
    private TextView tvTituloCuota, tvNumAnioMes, tvFEmi_FVen, tvSaldoTotal, tvDetalles;
    private RadioButton rbPagoTotal, rbPagoParcial;
    private RadioGroup rgRadioGrupo;
    private EditText etMontoPagar;
    private Abono abonoResponse;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cuotaDetalleViewModel = new ViewModelProvider(this).get(CuotaDetalleViewModel.class);
        listaCuotaDetalle = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuota_detalle, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btVerDetalles = view.findViewById(R.id.btVerDetalles);
        btPagar = view.findViewById(R.id.btPagar);
        tvDetalles = view.findViewById(R.id.tvDetalles);
        tvTituloCuota = view.findViewById(R.id.tvTituloCuota);
        tvNumAnioMes = view.findViewById(R.id.tvNumAnioMes);
        tvFEmi_FVen = view.findViewById(R.id.tvFEmi_FVen);
        tvSaldoTotal = view.findViewById(R.id.tvSaldoTotal);
        etMontoPagar = view.findViewById(R.id.etMontoPagar);
        rbPagoTotal = view.findViewById(R.id.rbPagoTotal);
        rbPagoParcial = view.findViewById(R.id.rbPagoParcial);
        rgRadioGrupo = view.findViewById(R.id.rgRadioGrupo);

        EstadoCuentaCuota estadoCuentaCuota = (EstadoCuentaCuota) this.getArguments().getSerializable("estadoCuentaCuota");
        int cuotaId = estadoCuentaCuota.getCuota().getId();

        cuotaDetalleViewModel.getCuotaDetalleLiveData(cuotaId).observe(getViewLifecycleOwner(), new Observer<List<CuotaDetalle>>() {
            @Override
            public void onChanged(List<CuotaDetalle> cuotaDetalles) {
                listaCuotaDetalle = cuotaDetalles;
            }
        });

        tvTituloCuota.setText(estadoCuentaCuota.getCuota().getTitulo());
        tvNumAnioMes.setText(estadoCuentaCuota.getCuota().getNumCuota() + "-"
                + estadoCuentaCuota.getCuota().getAnio() + " "
                + estadoCuentaCuota.getCuota().getMes() + " ("
                + estadoCuentaCuota.getCuota().getId() + ")");

        tvFEmi_FVen.setText("Emitido: " + estadoCuentaCuota.getCuota().getFechaEmision() + " y Vence: "
                + estadoCuentaCuota.getCuota().getFechaVencimiento());

        tvSaldoTotal.setText("El Saldo a Pagar: " + (estadoCuentaCuota.getTotalCargo() - estadoCuentaCuota.getTotalAbono()));


        btVerDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linea, concepto;
                Double monto_concepto;
                int detalle_id;
                Log.i(TAG, "onViewCreated: " + cuotaId + " " + listaCuotaDetalle.size());
                tvDetalles.setText("");
                for (CuotaDetalle cuotaDetalle : listaCuotaDetalle) {
                    concepto = cuotaDetalle.getConcepto().getNombreCorto();
                    monto_concepto = cuotaDetalle.getMonto();
                    detalle_id = cuotaDetalle.getId();
                    tvDetalles.append(detalle_id + " : " + String.format("%-30s", concepto) + " " + monto_concepto + "\n");
                }
            }
        });

        rgRadioGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                double saldo;
                saldo = estadoCuentaCuota.getTotalCargo() - estadoCuentaCuota.getTotalAbono();
                if (rbPagoTotal.isChecked()) {
                    etMontoPagar.setText(String.valueOf(saldo));
                }
            }
        });
        btPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double monto_abono;
                monto_abono =Double.parseDouble(etMontoPagar.getText().toString());


                Abono abono = new Abono();
                abono.setCuota(estadoCuentaCuota.getCuota());
                abono.setMontoAbono(monto_abono);

                registrarAbono(abono);

            }

        });

    }

    private void registrarAbono(Abono abono) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApiService service = restApiAdapter.establecerConexionRest();

        Call<Abono> call =  service.registrarAbono(abono);
        call.enqueue(new Callback<Abono>() {
            @Override
            public void onResponse(Call<Abono> call, Response<Abono> response) {
                if(response.isSuccessful()){
                    abonoResponse = response.body();
                    Log.i(TAG, "onResponse: "+abonoResponse.toString());
                    Log.i(TAG, "onResponse: "+ response.raw());

                }else {
                    Log.e(TAG, "onResponse: "+response.errorBody().toString());

                }
            }

            @Override
            public void onFailure(Call<Abono> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}