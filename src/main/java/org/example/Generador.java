package org.example;

import org.example.Estado.Estado;
import org.example.Item.Item;
import org.example.Item.Revivir;
import org.example.Pokemon.Bulbasur;
import org.example.Pokemon.Charizard;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Fuego;
import org.example.Estado.Normal;
import org.example.Tipo.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Generador {

    public List<Pokemon> generarSetPokemon1(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Charizard("carlitos", 6, 100,  10, 10, 30);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Pokemon> generarSetPokemon2(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Bulbasur("tobi", 10, 120,  6, 30, 15);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Item> generarSetItems(){
        List<Item> items = new ArrayList<Item>();
        Item item = new Revivir();
        items.add(item);

        return  items;
    }
}
