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

    public Jugador(String nombre, List<Pokemon> pokemones, List<Item> items){
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
    }

    public Pokemon pokemonActual() {
        return pokemones.get(0);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }
}
