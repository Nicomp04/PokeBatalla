package org.example;

import org.example.Clima.Clima;
import org.example.Habilidades.*;
import org.example.Pokemon.Pokemon;

public class PokemonVisitor implements Visitor {
    @Override
    public void visitAtaque(Ataque ataque, Pokemon atacante, Pokemon objetivo) {
        ataque.usarEnPokemon(atacante, objetivo);
    }

    @Override
    public void visitEfecto(Efecto efecto, Pokemon atacante, Pokemon objetivo) {
        efecto.usarEnPokemon(atacante, objetivo);
    }

    @Override
    public void visitModificacion(Modificacion modificacion, Pokemon atacante, Pokemon objetivo) {
        modificacion.usarEnPokemon(atacante, objetivo);
    }
    // Implementa otros métodos de visitas para cada tipo de habilidad si es necesario.
}
