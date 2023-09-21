package org.example;

public class Revivir extends Item{

    @Override
    public void aplicarItem(Pokemon pokemon) { //Implementar revivir() en Pokemon.java (puede ser cambiado)
        pokemon.revivir();
    }
}
