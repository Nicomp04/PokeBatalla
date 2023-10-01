package org.example;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Pokemon> pokemones;
    private List<Item> items;
    private Pokemon pokemonActivo;

    public Jugador(String nombre, List<Pokemon> pokemones, List<Item> items){
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.pokemonActivo = elegirPokemonActivo();
    }

    public Pokemon pokemonActual() {
        return pokemones.get(0);
    }
    public void usarTurno(){
        int accionElegida = 0; //vamos a tener q hacer una funcion cn un input para q elija lo que quiera hacer.
        switch (accionElegida){
            case 1:
                usarHabilidad();
                break;
            case 2:
                usarItem();
                break;
            case 3:
                elegirPokemonActivo();
                break;
            case 4:
                rendirse();
                break;
        }
    }

    private void usarHabilidad() { //falta implementar
    }

    private void usarItem() {  //falta implementar
    }

    private Pokemon elegirPokemonActivo() {  //falta implementar
        return pokemones.get(0);
    }

    private void rendirse() { //falta implementar
    }
}

