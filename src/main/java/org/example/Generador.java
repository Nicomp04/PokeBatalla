package org.example;

import org.example.Item.Item;
import org.example.Item.Revivir;
import org.example.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generador {

    public List<Pokemon> generarSetPokemon1(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Pokemon("Charisard", 6, 70, 20, 10,15);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Pokemon> generarSetPokemon2(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Pokemon("Bulbasur", 10,  150, 15, 25, 12);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Item> generarSetItems(){
        List<Item> items = new ArrayList<Item>();
        Item item = new Revivir();
        items.add(item);

        return  items;
    }

    public String generarNombreJugador(){
        Scanner datoIngresado =  new Scanner(System.in);
        System.out.println("Ingrese el nombre del Jugador: ");
        String nombre = datoIngresado.next();
        return nombre;
    };

    public Integer generarCantidadPokemones(){
        Scanner datoIngresado = new Scanner(System.in);
        System.out.println("Indique la cantidad de pokemones que desea guardar.El maximo es 6 ");
        Integer cantidad = datoIngresado.nextInt();

        if (cantidad < 0  || cantidad > 6 ){
            System.out.println("Ingreso un dato inválido");
            generarCantidadPokemones();
        }
        return cantidad;
    }
}
