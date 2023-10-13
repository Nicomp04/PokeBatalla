package org.example;

import org.example.Habilidades.Ataque;
import org.example.Pokemon.Pokemon;
import org.example.Habilidades.*;

public interface Visitor {
    void visitAtaque(Ataque ataque, Pokemon atacante, Pokemon objetivo);
    void visitEfecto(Efecto efecto, Pokemon atacante, Pokemon objetivo);
    void visitModificacion(Modificacion modificacion, Pokemon atacante, Pokemon objetivo);
    // Aquí podrías añadir más métodos para cada tipo de habilidad si es necesario.
}
