package org.example;

abstract class Item {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public abstract void aplicarItem(Pokemon pokemon);
}
