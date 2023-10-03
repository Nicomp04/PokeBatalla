package org.example.Habilidades;

import org.example.Estado.Estado;
import org.example.Pokemon.Pokemon;

public class Efecto extends Habilidad{
    private Estado estado;

    public Efecto(String nombre, int usosDisponibles, Estado estado) {
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estado = estado;
    }

    @Override
    public void usarEnPokemon(Pokemon pokemon, Pokemon objetivo) {

    }

    @Override
    public void usarEnPokemon(Pokemon pokemon) {
        if (pokemon.tieneUnEstado()) {
            //supongo q hay algun mensaje.
        }
        else{
            pokemon.cambiarEstado(this.estado);
        }

    }
}
