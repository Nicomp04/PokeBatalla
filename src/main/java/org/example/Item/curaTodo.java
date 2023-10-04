package org.example.Item;

import org.example.Estado.Estado;
import org.example.Estado.Normal;
import org.example.Pokemon.Pokemon;

public class curaTodo extends Item {

    public curaTodo(){
        this.nombre = "curaEstado";
    }
    @Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) {
        Estado curado = new Normal(); //Normal seria un estado neutral o podria ser un null (?)
        pokemonPropio.cambiarEstado(curado); //Implementar cambiarEstado(Estado: unEstado) en Pokemon.java
    }
}
