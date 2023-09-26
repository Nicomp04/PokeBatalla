package org.example;

import org.example.Estado.Estado;
import org.example.Pokemon.Bulbasur;
import org.example.Pokemon.Charizard;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Fuego;
import org.example.Estado.Normal;

import java.util.ArrayList;
import java.util.List;

public class Generador {

    public List<Pokemon> generarSet1(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Charizard("carlitos", 6, 100,  10, 10, 30);
        pokemones.add(pokemon);
        return pokemones;
    }

    public List<Pokemon> generarSet2(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Bulbasur("tobi", 10, 120,  6, 30, 15);
        pokemones.add(pokemon);
        return pokemones;
    }
}
