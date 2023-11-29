package org.example.Item;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurador extends Item {

    private int hp;

    public Restaurador(String nombre ,int hp) {

        this.hp = hp;
        this.nombre = nombre;
    }

    public List<Pokemon> posiblesPokemonesAAplicar(List<Pokemon> pokemones){
        List<Pokemon> pokemonesVivos = new ArrayList<>();
        int pokemonElegido = 0;
        Pokemon pokemon;
        for(int i = 0; i < pokemones.size(); i++){
            pokemon = pokemones.get(i);
            if(!pokemon.estaMuerto()){
                pokemonesVivos.add(pokemon);
            }
        }
        if(pokemonesVivos.isEmpty()){
            logger.info("No tienes Pokemones a restaurar, el turno se consumio igual.");
        }
        return pokemonesVivos;
    }
    public void aplicarItem(Pokemon pokemon) {

            Pokemon pokemonARestaurar = pokemon;

            if (nombre.equals("Pocion Molesta Alumnos")){
                pokemonARestaurar.modificarHp(hp * pokemonARestaurar.getVidaActual());
            }
            else {
                pokemonARestaurar.modificarHp(hp);
            }

            logger.info("{} ha sido restaurado.", pokemonARestaurar);
            this.setUsos(this.usos - 1);
    }
}
