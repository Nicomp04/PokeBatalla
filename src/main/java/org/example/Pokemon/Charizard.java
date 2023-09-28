package org.example.Pokemon;

import org.example.Estado.Normal;
import org.example.Habilidades.Habilidad;
import org.example.Tipo.Fuego;
import org.example.Tipo.Tipo;


import java.util.List;

public class Charizard extends Pokemon{
    private Fuego fuego;
    private Normal normal;

    public Charizard(String nombre, int nivel, Tipo tipo, int vidaMaxima, int velocidad, int defensa, int ataque) {
        super(nombre, nivel,tipo, vidaMaxima, velocidad, defensa, ataque);
    }

    @Override
    public void usarHabilidad(Habilidad habilidad, Pokemon objetivo) {
        habilidad.usarEnPokemon(this, objetivo);
    }
}
