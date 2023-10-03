package org.example;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;
import org.example.Campo;

import java.util.List;

public class Jugador {
    private String nombre;
    private List<Pokemon> pokemones;
    private List<Item> items;
    private int id;
    private Campo campoDeBatalla;

    public Jugador(String nombre, List<Pokemon> pokemones, List<Item> items, int id){
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.id = id;
    }

    public void usarTurno(){
        int accionElegida = 0; //INPUT
        switch (accionElegida){
            case 1:
                campoDeBatalla.elejirHabilidad(id);
                break;
            case 2:
                usarItem();
                break;
            case 3:
                elegirPokemonActivo();
                break;
            case 4:
                break;
        }
    }

    private void elegirPokemonActivo() {
        int pokemonAMover = 0; //vamos a tener q hacer una funcion cn un input para q elija lo que quiera hacer.
        int posicionAPoner = 0; //vamos a tener q hacer una funcion cn un input para q elija lo que quiera hacer.
        Pokemon pokemon1;
        Pokemon pokemon2;
        pokemon1 = pokemones.get(pokemonAMover);
        pokemon2 = pokemones.get(posicionAPoner);
        pokemones.add(posicionAPoner,pokemon1);
        pokemones.add(pokemonAMover,pokemon2);
    }

    private void usarItem() {
       // vamos a tener q hacer una funcion cn un input para q elija lo que quiera hacer.
        int accionElegida = 0;
        Pokemon objetivo = new Pokemon("cahrizard", 1, 1, 1, 1, 1); // FALTA CAMPO E NUEVA IMPLEMENTACION
        Item itemElegido;
        switch (accionElegida){
            case 1:
                itemElegido = items.get(0);
                itemElegido.aplicarItem(objetivo);
                break;
            case 2:
                itemElegido = items.get(1);
                itemElegido.aplicarItem(objetivo);
                break;
            case 3:
                itemElegido = items.get(2);
                itemElegido.aplicarItem(objetivo);
                break;
            case 4:
                itemElegido = items.get(3);
                itemElegido.aplicarItem(objetivo);
                break;
            case 5:
                break;
        }

    }


    public Pokemon pokemonActual() {
        return pokemones.get(0);
    }

    public Pokemon getPokemonActivo() {
        return getPokemonActivo();
    }

    public void entrarACampo(Campo campoDeBatalla) {
        this.campoDeBatalla = campoDeBatalla;
    }
}
