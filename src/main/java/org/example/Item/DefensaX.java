package org.example.Item;

import org.example.Pokemon.Pokemon;

public class DefensaX extends ModificadorItem {
    @Override
    public void aplicarItem(Pokemon pokemon) { //Implementar modificarDefensa() en Pokemon.java (puede ser cambiado)
        pokemon.setDefensa(this.porcentaje);
    }
}
