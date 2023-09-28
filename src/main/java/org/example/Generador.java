package org.example;

import org.example.Estado.Estado;
import org.example.Item.Item;
import org.example.Item.Revivir;
import org.example.Pokemon.Bulbasur;
import org.example.Pokemon.Charizard;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.*;
import org.example.Estado.Normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generador {

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

    public List<Pokemon> generarSetPokemon1(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        Pokemon pokemon = new Charizard("carlitos", 6,Tipo.Fuego,100,  10, 10, 30);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Pokemon> generarSetPokemon2(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();

        for (int i = 1 ; i <= cantidadDePokemones;i++) {
            Pokemon pokemon = new Bulbasur("tobi", 10, Tipo.Agua, 120, 6, 30, 15);
            pokemones.add(pokemon);
        }


        return pokemones;
    }

    public List<Item> generarSetItems(){
        List<Item> items = new ArrayList<Item>();
        Item item = new Revivir();
        items.add(item);

        return  items;
    }
}
