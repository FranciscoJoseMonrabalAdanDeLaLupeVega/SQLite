package com.example.a2dam.sqlite;

/**
 * Created by 2dam on 22/01/2018.
 */

public class Asignatura {

    private int id;
    private String nombre, horas;

    public Asignatura () {

    }

    public Asignatura (int id, String nombre, String horas) {

        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
}
