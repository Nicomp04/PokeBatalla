package org.example.Pokemon;

import org.example.Clima.Clima;
import org.example.Habilidades.*;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

public class PokemonVisitor implements Visitor {
    @Override
    public void visitAtaque(Ataque ataque, Pokemon atacante, Pokemon objetivo,Clima clima) {
        ataque.usarEnPokemon(atacante, objetivo,clima);
    }

    @Override
    public void visitEfecto(Efecto efecto, Pokemon atacante, Pokemon objetivo,Clima clima) {
        efecto.usarEnPokemon(atacante, objetivo,clima);
    }

    @Override
    public void visitModificacion(Modificacion modificacion, Pokemon atacante, Pokemon objetivo,Clima clima) {
        modificacion.usarEnPokemon(atacante, objetivo,clima);
    }
    // Implementa otros métodos de visitas para cada tipo de habilidad si es necesario.
}
