package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class DefensaX extends Item {
    private int porcentaje;
    public DefensaX(int valor){
        this.porcentaje = valor;
        this.nombre = "DefensaX";
    }
    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.setDefensa(this.porcentaje);
        this.setUsos(this.usos - 1);
    }

    @Override
    public List<Pokemon> posiblesPokemonesAAplicar(List<Pokemon> pokemones) {
        return pokemones;
    }
}
