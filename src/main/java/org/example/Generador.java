package org.example;

import org.example.Estado.Estados;
import org.example.Habilidades.Ataque;
import org.example.Habilidades.Efecto;
import org.example.Habilidades.Habilidad;
import org.example.Habilidades.Modificacion;
import org.example.Item.*;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generador {

    public List<Pokemon> generarSetPokemon1(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        List<Habilidad> habilidades1 = new ArrayList<Habilidad>();
        List<Habilidad> habilidades2 = new ArrayList<Habilidad>();

        habilidades1.add(new Ataque("Llamarada",5, new Fuego(), 20));
        habilidades1.add(new Efecto("Veneno",1, Estados.ENVENENADO, true));
        habilidades1.add(new Modificacion("Modif. def", 1 , 3, 10,true));

        habilidades2.add(new Modificacion("Modif. Salud", 1 , 1, 10,true));
        habilidades2.add(new Ataque("Rayo", 3 , new Electrico(), 30));

        Pokemon pokemon = new Pokemon("Charizard", 6, new Fuego(), 10, 20, 10,15,habilidades1);
        Pokemon pokemon2 = new Pokemon("Vulpix", 6, new Hielo(), 12, 20, 15,15,habilidades2);
        Pokemon pokemon3 = new Pokemon("Pikachu", 2, new Electrico(), 10, 30, 10,25,habilidades2);
        pokemones.add(pokemon);
        pokemones.add(pokemon2);
        pokemones.add(pokemon3);

        return pokemones;
    }

    public List<Pokemon> generarSetPokemon2(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        List<Habilidad> habilidades = new ArrayList<Habilidad>();
        habilidades.add(new Ataque("Llamarada",5, new Fuego(), 20));
        Pokemon pokemon = new Pokemon("Bulbasur", 10, new Agua(), 15, 15, 25, 12,habilidades);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Item> generarSetItems(){
        List<Item> items = new ArrayList<Item>();
        Item item = new Revivir();
        Item item2 = new AtaqueX(5);
        Item item3 = new Restaurador(5);
        Item item4 = new curaTodo();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);

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
