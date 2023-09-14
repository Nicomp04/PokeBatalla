package org.example;

import java.util.List;

public class Jugador {
    private String nombre;
    private List<Pokemon> pokemones;
    //agregar lista de items


    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
