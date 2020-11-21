package edu.cientifica.convivirapp.model;

public class UnidadInmobiliaria {
    private int id;
    private String nombreCorto;
    private String nombreLargo;
    private String direccion;
    private String ubigeo;
    private String latitud;
    private String longitud;

    public UnidadInmobiliaria() {
        super();
    }
    public UnidadInmobiliaria(int id, String nombreCorto, String nombreLargo, String direccion, String ubigeo,
                              String latitud, String longitud) {
        super();
        this.id = id;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.direccion = direccion;
        this.ubigeo = ubigeo;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCorto() {
        return nombreCorto;
    }
    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }
    public String getNombreLargo() {
        return nombreLargo;
    }
    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getUbigeo() {
        return ubigeo;
    }
    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }
    public String getLatitud() {
        return latitud;
    }
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    @Override
    public String toString() {
        return "UnidadInmobiliaria [id=" + id + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
                + ", direccion=" + direccion + ", ubigeo=" + ubigeo + ", latitud=" + latitud + ", longitud=" + longitud
                + "]";
    }
}
