package org.example.Pokemon;

import org.example.Estado.Normal;
import org.example.Habilidades.Habilidad;
import org.example.Tipo.Agua;
import org.example.Tipo.Fuego;
import org.example.Tipo.Tipo;

import java.util.List;

public class Bulbasur extends Pokemon {
    private Agua agua;
    private Normal normal;

    public Bulbasur(String nombre, int nivel, Tipo tipo, int vidaMaxima, int velocidad, int defensa, int ataque) {
        super(nombre, nivel,tipo, vidaMaxima, velocidad, defensa, ataque);
    }

    @Override
    public void usarHabilidad(Habilidad habilidad, Pokemon objetivo) {
        habilidad.usarEnPokemon(this, objetivo);
    }
}
