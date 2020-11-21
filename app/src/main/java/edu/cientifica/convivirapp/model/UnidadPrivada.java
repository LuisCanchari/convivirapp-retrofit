package edu.cientifica.convivirapp.model;

public class UnidadPrivada {

    private int id;
    private String numeracion;
    private String zona;
    private TipoUnidad tipoUnidad;
    private UnidadInmobiliaria unidadInmobiliaria;
    private Propietario propietario;


    public UnidadPrivada() {
        super();

    }

    public UnidadPrivada(int id, String numeracion, String zona, TipoUnidad tipoUnidad, UnidadInmobiliaria unidadInmobiliaria, Propietario propietario) {
        this.id = id;
        this.numeracion = numeracion;
        this.zona = zona;
        this.tipoUnidad = tipoUnidad;
        this.unidadInmobiliaria = unidadInmobiliaria;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public TipoUnidad getTipoUnidad() {
        return tipoUnidad;
    }


    public void setTipoUnidad(TipoUnidad tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }


    public String getNumeracion() {
        return numeracion;
    }


    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }


    public String getZona() {
        return zona;
    }


    public void setZona(String zona) {
        this.zona = zona;
    }


    public UnidadInmobiliaria getUnidadInmobiliaria() {
        return unidadInmobiliaria;
    }


    public void setUnidadInmobiliaria(UnidadInmobiliaria unidadInmobiliaria) {
        this.unidadInmobiliaria = unidadInmobiliaria;
    }


    public Propietario getPropietario() {
        return propietario;
    }


    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }


    @Override
    public String toString() {
        return "UnidadPrivada [id=" + id + ", tipoUnidad=" + tipoUnidad + ", numeracion=" + numeracion + ", zona="
                + zona + ", unidadInmobiliaria=" + unidadInmobiliaria + ", propietario=" + propietario + "]";
    }

}
