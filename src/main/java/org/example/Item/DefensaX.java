package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;

public class DefensaX extends ModificadorItem {
    public DefensaX(int valor){
        super(valor);
        this.nombre = "DefensaX";
    }

    public void aplicarItem(List<Pokemon> pokemones) {
        Pokemon pokemon = pokemones.get(0);
        pokemon.setDefensa(this.porcentaje);
        this.setUsado(true);
    }
}
