package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class DefensaX extends Item {
    private int porcentaje;
    public DefensaX(int valor){
        this.porcentaje = valor;
        this.nombre = "DefensaX";
    }

    public void aplicarItem(List<Pokemon> pokemones) {
        Pokemon pokemon = pokemones.get(0);
        pokemon.setDefensa(this.porcentaje);
        this.setUsos(this.usos - 1);
    }
}
