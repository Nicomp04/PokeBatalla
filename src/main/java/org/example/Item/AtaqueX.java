package org.example.Item;

import org.example.Pokemon.Pokemon;

import java.util.List;



public class AtaqueX extends Item {

    private int porcentaje;
    public AtaqueX(int valor) {
        this.porcentaje = valor;
        this.nombre = "AtaqueX";
    }
    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.setAtaque(this.porcentaje);
        this.setUsos(this.usos - 1);
    }

    @Override
    public List<Pokemon> posiblesPokemonesAAplicar(List<Pokemon> pokemones) {
        return pokemones;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        AtaqueX clonedAtaque = (AtaqueX) super.clone();
        // Realizar clonación profunda si es necesario
        // clonedRestaurador.algunCampo = algo;
        return clonedAtaque;
    }
}
