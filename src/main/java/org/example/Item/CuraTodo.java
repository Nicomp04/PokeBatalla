package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class CuraTodo extends Item {
    public CuraTodo(){
        this.nombre = "CuraTodo";
    }


    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.getEstados().clear();
        this.setUsos(this.usos - 1);
    }

    @Override
    public List<Pokemon> posiblesPokemonesAAplicar(List<Pokemon> pokemones) {
        return pokemones;
    }
}
