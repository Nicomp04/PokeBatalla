package org.example.Item;

import org.example.Pokemon.Pokemon;

public class DefensaX extends ModificadorItem {
    public DefensaX(int porcentaje) {
        super(porcentaje);
    }

    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.setDefensa(this.porcentaje);
    }
}
