package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;

public class ModificarAtaque extends Modificacion{
    public ModificarAtaque(int id, String nombre, int usosDisponibles, int estadistica, int valor,String tipo) {
        super(id, nombre, usosDisponibles, valor,tipo);
    }

    @Override
    public void usarEnPokemon(Pokemon propio, Pokemon enemigo, Clima clima) {

        Pokemon objetivo;

        if (afectaAEnemigo) {
            objetivo = enemigo;
        } else {
            objetivo = propio;
        }

        objetivo.setAtaque(this.valor);
    }
}