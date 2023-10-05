package org.example.Item;

import org.example.Pokemon.Pokemon;

public class AtaqueX extends ModificadorItem {

    public AtaqueX(int porcentaje) {
        super(porcentaje);
    }

    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.setAtaque(this.porcentaje);
    }
}
