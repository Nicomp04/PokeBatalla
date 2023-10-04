package org.example.Item;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

public class Restaurador extends Item {

    private int hp;

    public Restaurador(int hp) {
        this.hp = hp;
        this.nombre = "Restaurador";
    }

    @Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) { // Implementar curar() en Pokemon.java (puede ser cambiado)
        pokemonPropio.modificarHp(hp);
    }
}
