package org.example.Item;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

public class Revivir extends Item {

    @Override
    public void aplicarItem(Pokemon pokemon) { //Implementar revivir() en Pokemon.java (puede ser cambiado)
        pokemon.revivir();
    }
}
