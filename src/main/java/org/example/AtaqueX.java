package org.example;

public class AtaqueX extends Modificador{

    @Override
    public void aplicarItem(Pokemon pokemon) { //Implementar modificarAtaque() en Pokemon.java (puede ser cambiado)
        pokemon.modificarAtaque(this.porcentaje);
    }
}
