package org.example.Item;

import org.example.Estado.Estados;
import org.example.Pokemon.Pokemon;

public class curaTodo extends Item {
    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.cambiarEstado(null);
    }
}
