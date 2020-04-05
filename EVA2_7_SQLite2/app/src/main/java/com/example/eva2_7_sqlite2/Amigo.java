package com.example.eva2_7_sqlite2;

public class Amigo {
    private String nombre;
    private String telefono;

    public Amigo(String n, String t){
        this.nombre = n;
        this.telefono = t;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

