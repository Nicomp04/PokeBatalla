package org.example.Item;

import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    protected String nombre;

    final Logger logger = LoggerFactory.getLogger(Revivir.class);
    public String getNombre() {
        return nombre;
    }

   // public abstract void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo);
    public abstract void aplicarItem(List<Pokemon> pokemones);
}
