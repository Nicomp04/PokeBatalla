package org.example;

import org.example.Clima.Clima;
import org.example.Habilidades.Ataque;
import org.example.Pokemon.Pokemon;
import org.example.Habilidades.*;

public interface Visitor {
    void visitAtaque(Ataque ataque, Pokemon atacante, Pokemon objetivo,Clima clima);
    void visitEfecto(Efecto efecto, Pokemon atacante, Pokemon objetivo,Clima clima);
    void visitModificacion(Modificacion modificacion, Pokemon atacante, Pokemon objetivo,Clima clima);
    // Aquí podrías añadir más métodos para cada tipo de habilidad si es necesario.
}
