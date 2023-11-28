package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;



public class AtaqueX extends Item {

    private int porcentaje;
    public AtaqueX(int valor) {
        this.porcentaje = valor;
        this.nombre = "AtaqueX";
    }
    @Override
    public void aplicarItem(List<Pokemon> pokemones) {
        Pokemon pokemon = pokemones.get(0);
        pokemon.setAtaque(this.porcentaje);
        this.setUsado(true);
    }
    /*public boolean aplicarItem(Pokemon pokemon) {
        return false;
    }*/
}
