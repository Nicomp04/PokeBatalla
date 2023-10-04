package org.example.Item;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

public class Revivir extends Item {
    public Revivir(){
        this.nombre = "Revivir";
    }

    @Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) { //Implementar revivir() en Pokemon.java (puede ser cambiado)
        pokemonPropio.revivir();
    }
}
