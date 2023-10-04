package org.example.Item;

import org.example.Pokemon.Pokemon;

public class AtaqueX extends ModificadorItem {

    public AtaqueX (){
        this.nombre = "AtaqueX";
    }
    @Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) {pokemonPropio.setAtaque(this.porcentaje); // es para el propio o el enemigo??
    }

}
