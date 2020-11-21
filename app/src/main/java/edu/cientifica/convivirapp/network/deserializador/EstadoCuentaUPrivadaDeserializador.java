package edu.cientifica.convivirapp.network.deserializador;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.cientifica.convivirapp.model.EstadoCuentaUPrivada;
import edu.cientifica.convivirapp.model.Propietario;
import edu.cientifica.convivirapp.model.TipoUnidad;
import edu.cientifica.convivirapp.model.UnidadInmobiliaria;
import edu.cientifica.convivirapp.model.UnidadPrivada;
import edu.cientifica.convivirapp.network.JsonKeys;
import edu.cientifica.convivirapp.network.responsemodel.EstadoCuentaResponse;

import static android.text.TextUtils.substring;

public class EstadoCuentaUPrivadaDeserializador implements JsonDeserializer<EstadoCuentaResponse> {
    private static final String TAG = "CONVIVIRX";

    @Override
    public EstadoCuentaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.i(TAG, "deserialize: ");

        Gson gson =  new Gson();
        EstadoCuentaResponse estadoCuentaResponse = gson.fromJson(json, EstadoCuentaResponse.class);


        //Obtiene el array de resultados
        JsonArray estadoCuentaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.ESTADOCUENTA_UP_RESPONSE_ARRAY);

        //deserializa el array con la funcion deserializarEstadoCuentaDeJson
        estadoCuentaResponse.setListaEstadoCuentaResponse(deserializarEstadoCuentaDeJson(estadoCuentaResponseData));
        return estadoCuentaResponse;
    }

    private List<EstadoCuentaUPrivada> deserializarEstadoCuentaDeJson(JsonArray estadoCuentaResposeData){
        List<EstadoCuentaUPrivada> estadoCuentaUPrivadas = new ArrayList<>();
        //Log.i(TAG, "deserializarEstadoCuentaDeJson: inicia la serializacion " + estadoCuentaResposeData.size());

        for (int i = 0; i < estadoCuentaResposeData.size(); i++) {

            //Obtiene el objeto estadocuenta
            JsonObject estadoCuentaResposeDataObject  = estadoCuentaResposeData.get(i).getAsJsonObject();
            //Valores primitivos
            Integer ec_id =  estadoCuentaResposeDataObject.get(JsonKeys.ESTADOCUENTA_UP_ID).getAsInt();
            Double monto_cargo = estadoCuentaResposeDataObject.get(JsonKeys.ESTADOCUENTA_UP_TOTAL_CARGO).getAsDouble();
            Double monto_abono = estadoCuentaResposeDataObject.get(JsonKeys.ESTADOCUENTA_UP_TOTAL_ABONO).getAsDouble();


            //Obtiene la unidad privada
            JsonObject unidadPrivadaDataObject = estadoCuentaResposeDataObject.getAsJsonObject(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA);
            //valores primitivos
            Integer up_id = unidadPrivadaDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_ID).getAsInt();
            String numeracion = unidadPrivadaDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_NUMERACION).getAsString();
            String zona = unidadPrivadaDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_ZONA).getAsString();

            //TipoUnidad
            JsonObject tipoUnidadDataObject = unidadPrivadaDataObject.getAsJsonObject(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_TIPOUNIDAD);
            Integer tu_id = tipoUnidadDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_TIPOUNIDAD_ID).getAsInt();
            String tu_descripcion = tipoUnidadDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_DESCRIPCION).getAsString();

            //UnidadInmobiliaria
            JsonObject unidadInmobiliariaDataObject = unidadPrivadaDataObject.getAsJsonObject(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_UINMOBILIARIA);
            Integer ui_id = unidadInmobiliariaDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_UINMOBILIARIA_ID).getAsInt();



            //Propietario
            JsonObject propietarioDataObject = unidadPrivadaDataObject.getAsJsonObject(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO);
            Integer p_id = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_ID).getAsInt();
            Integer tipo_doc = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_TIPODOCUMENTO).getAsInt();
            String num_doc = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_NUMDOCUMENTO).getAsString();
            String nombre = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_NOMBRE).getAsString();
            String primer_apellido = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_PRIMERAPELLIDO).getAsString();
            String segundo_apellido = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_SEGUNDOAPELLIDO).getAsString();
            String fecha_nac = propietarioDataObject.get(JsonKeys.ESTADOCUENTA_UP_UNIDAD_PRIVADA_PROPIETARIO_FECHANACIMIENTO).toString();

            //modificar la fecha con el formato adecuado oara  fecha de nacimiento
            try {
                //Arma el objeto nuevamente
                Propietario propietario = new Propietario();
                propietario.setId(p_id);
                propietario.setNombre(nombre);
                propietario.setPrimerApellido(primer_apellido);
                propietario.setSegundoApellido(segundo_apellido);
                propietario.setFechaNacimiento(substring(fecha_nac,1,11));
                //LocalDate.parse("2018-10-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));


                //Propietario propietario = new Propietario(p_id,tipo_doc,num_doc,nombre,primer_apellido,segundo_apellido,jsontoDate(fecha_nac));
                UnidadInmobiliaria unidadInmobiliaria = new UnidadInmobiliaria();
                unidadInmobiliaria.setId(ui_id);
                TipoUnidad tipoUnidad = new TipoUnidad();
                tipoUnidad.setId(tu_id);
                tipoUnidad.setDescripcion(tu_descripcion);

                UnidadPrivada unidadPrivada = new UnidadPrivada(up_id,numeracion,zona,tipoUnidad,unidadInmobiliaria,propietario);
                EstadoCuentaUPrivada estadoCuentaUPrivada = new EstadoCuentaUPrivada(unidadPrivada);
                estadoCuentaUPrivada.setId(ec_id);
                estadoCuentaUPrivada.setTotalCargo(monto_cargo);
                estadoCuentaUPrivada.setTotalAbono(monto_abono);
                //agregar a la lista
                estadoCuentaUPrivadas.add(estadoCuentaUPrivada);


            } catch (Exception e){
                Log.e(TAG, "deserializarEstadoCuentaDeJson: " + e.getMessage());
            }
        }
        return estadoCuentaUPrivadas;
    }

}


