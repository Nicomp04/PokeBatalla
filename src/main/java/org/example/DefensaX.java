package org.example;

public class DefensaX extends Modificador{
    @Override
    public void aplicarItem(Pokemon pokemon) { //Implementar modificarDefensa() en Pokemon.java (puede ser cambiado)
        pokemon.modificarDefensa(this.porcentaje);
    }
}
