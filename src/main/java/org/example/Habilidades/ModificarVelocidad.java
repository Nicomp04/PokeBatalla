package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;

public class ModificarVelocidad extends Modificacion{
    public ModificarVelocidad(int id, String nombre, int usosDisponibles, int estadistica, int valor) {
        super(id, nombre, usosDisponibles, valor);
    }

    @Override
    public void usarEnPokemon(Pokemon propio, Pokemon enemigo, Clima clima) {

        Pokemon objetivo;

        if (afectaAEnemigo) {
            objetivo = enemigo;
        } else {
            objetivo = propio;
        }

        objetivo.setVelocidad(this.valor);
    }
}
