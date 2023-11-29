package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class CuraTodo extends Item {
    public CuraTodo(){
        this.nombre = "CuraTodo";
    }

    @Override
    public void aplicarItem(List<Pokemon> pokemones) {
        Pokemon pokemon = pokemones.get(0);
        pokemon.getEstados().clear();
        this.setUsos(this.usos - 1);
    }
}
