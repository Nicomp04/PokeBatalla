package org.example;

public class Restaurador extends Item{

    private Int hp;

    public Restaurador(Int hp) {
        this.hp = hp;
    }

    @Override
    public void aplicarItem(Pokemon pokemon) { // Implementar curar() en Pokemon.java (puede ser cambiado)
        pokemon.modificarHp(hp);
    }
}
