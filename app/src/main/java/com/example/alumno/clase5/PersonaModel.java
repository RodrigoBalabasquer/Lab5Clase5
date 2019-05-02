package com.example.alumno.clase5;

/**
 * Created by alumno on 25/04/2019.
 */

public class PersonaModel {
    private String nombre;
    private String apellido;
    private String telefono;
    private String imagen;
    private boolean procesar;
    private byte[] imagenValor;
    public PersonaModel(){
        this.procesar = false;
    }
    public PersonaModel(String nombre, String apellido, String telefono){
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.procesar = false;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return apellido;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getImagen(){return  imagen;}
    public void setImagen(String imagen){ this.imagen = imagen;}
    public boolean getProcesar(){return this.procesar;}
    public void  setProcesar(boolean procesar){ this.procesar = procesar;}
    public void setImagenValor(byte[] imagenValor){this.imagenValor = imagenValor;}
    public byte[] getImagenValor(){return  this.imagenValor;}
    @Override
    public String toString() {
        return "PersonaModel{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Telefono='" + telefono + '\'' +
                '}';
    }

}
