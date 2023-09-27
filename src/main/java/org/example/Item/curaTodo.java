package org.example.Item;

import org.example.Estado.Estado;
import org.example.Estado.Normal;
import org.example.Pokemon.Pokemon;

public class curaTodo extends Item {
    @Override
    public void aplicarItem(Pokemon pokemon) {
        Estado curado = new Normal(); //Normal seria un  estado neutral o podria ser un null (?)
        pokemon.cambiarEstado(curado); //Implementar cambiarEstado(Estado: unEstado) en Pokemon.java
    }
}
