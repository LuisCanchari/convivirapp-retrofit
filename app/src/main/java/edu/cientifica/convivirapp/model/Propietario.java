package edu.cientifica.convivirapp.model;

import java.time.LocalDate;
import java.util.Date;

public class Propietario extends Persona{
    public Propietario() {
        super();
    }
    public Propietario(int id, int tipoDocumento, String numDocumento, String nombre, String primerApellido, String segundoApellido, String fechaNacimiento) {
        super(id, tipoDocumento, numDocumento, nombre, primerApellido,segundoApellido, fechaNacimiento);

    }

    @Override
    public String toString() {
        return "Propietario{"+super.toString()+"}";
    }
}
