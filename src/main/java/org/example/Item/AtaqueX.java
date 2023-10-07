package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class AtaqueX extends ModificadorItem {

    public AtaqueX(int porcentaje) {
        super(porcentaje);
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
