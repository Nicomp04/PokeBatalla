package org.example.Estado;

import org.example.Pokemon.Pokemon;

public interface EstadoPokemon {
    void aplicarEfecto(Pokemon pokemon);
    int baliza();
    void restarTurno();
    String getNombre();
    String getDuracion();
    boolean seAgoto();
}

