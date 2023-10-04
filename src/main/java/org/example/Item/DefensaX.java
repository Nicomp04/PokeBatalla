package org.example.Item;

import org.example.Pokemon.Pokemon;

public class DefensaX extends ModificadorItem {
    public DefensaX(){
        this.nombre = "DefensaX";
    }
    @Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) { pokemonPropio.setDefensa(this.porcentaje);}// es para el propio o el enemigo?
}
