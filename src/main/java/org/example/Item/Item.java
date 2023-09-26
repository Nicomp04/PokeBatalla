package org.example.Item;

import org.example.Pokemon.Pokemon;

public abstract class Item {
    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public abstract void aplicarItem(Pokemon pokemon);
}
