package org.example.Item;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

public class Restaurador extends Item {

    private int hp;

    public Restaurador(int hp) {
        this.hp = hp;
    }

    @Override
    public void aplicarItem(Pokemon pokemon) { // Implementar curar() en Pokemon.java (puede ser cambiado)
        pokemon.modificarHp(hp);
    }
}
