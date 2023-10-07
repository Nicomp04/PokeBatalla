package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public abstract class Item {
    protected String nombre;


    public String getNombre() {
        return nombre;
    }

   // public abstract void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo);
    public abstract void aplicarItem(List<Pokemon> pokemones);
}
