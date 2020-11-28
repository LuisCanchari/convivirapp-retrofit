package edu.cientifica.convivirapp.network;

public final class ConstantesRestApi {
    public static final String ROOT_URL = "http://192.168.1.6:8080/convivir/rest/";
    public static final String VERSION = "/v1/";
    public static final String ACCESS_TOKEN = "";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_INFORMATIO_USER = "?access_token=";

    public static final String URL_GET_ESTADOCUENTA_UPRIVADA_ALL = "estadocuenta/uprivada/all";
    public static final String URL_GET_ESTADOCUENTA_CUOTA_BY_UPRIVADA = "estadocuenta/cuota/uprivada/{id}";
    public static final String URL_GET_CUOTA_DETALLE_BY_CUOTA = "detalle/cuota/{id}";
    public static final String URL_POST_CUOTA_ABONO = "abono";

    public static final String URL_GET_PERSONA_ALL = "persona/all";


}
