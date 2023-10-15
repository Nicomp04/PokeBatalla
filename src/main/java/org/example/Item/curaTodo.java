package org.example.Item;

import org.example.Estado.Estados;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class curaTodo extends Item {
    public curaTodo(){this.nombre = "curaEstado";}

    @Override
    public void aplicarItem(List<Pokemon> pokemones) {
        Pokemon pokemon = pokemones.get(0);
        pokemon.setEstado(null);
        this.setUsado(true);
    }
}
