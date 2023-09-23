package org.example.Item;

import org.example.Item.ModificadorItem;
import org.example.Pokemon.Pokemon;

public class AtaqueX extends ModificadorItem {

    @Override
    public void aplicarItem(Pokemon pokemon) { //Implementar modificarAtaque() en Pokemon.java (puede ser cambiado)
        pokemon.modificarAtaque(this.porcentaje);
    }
}
