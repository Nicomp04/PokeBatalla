package org.example;

import org.example.Estado.Estados;
import org.example.Habilidades.*;
import org.example.Item.*;
import org.example.Pokemon.ControladorPokemon;
import org.example.Pokemon.Pokemon;
import org.example.Pokemon.VistaPokemon;
import org.example.Tipo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Generador {

    private ParserHabilidad parserHabilidad;
    private ParserPokemon parserPokemon;
    private ParserItems parserItems;
    private ParserPartida parserPartida;

    public Map<Integer, Pokemon> pokemonMap;
    public Map<Integer, Habilidad> habilidadMap;
    public Map<Integer, Item> itemMap;

    public RepositorioHabilidades repositorioHabilidades;

    public Generador() {
        this.repositorioHabilidades = new RepositorioHabilidades();
    }
/*
    public List<Pokemon> generarSetPokemon1(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        List<Habilidad> habilidades1 = new ArrayList<Habilidad>();
        List<Habilidad> habilidades2 = new ArrayList<Habilidad>();

        habilidades1.add(new Ataque("Llamarada",5, new Fuego(), 20));
        habilidades1.add(new Efecto("Veneno",1, Estados.ENVENENADO, true));
        habilidades1.add(new Modificacion("Modif. def", 1 , 3, 80,true));

        habilidades2.add(new Modificacion("Modif. Salud", 1 , 1, 10,true));
        habilidades2.add(new Ataque("Rayo", 3 , new Electrico(), 30));

        Pokemon pokemon = new Pokemon("Charizard", 6, new Fuego(), 10, 20, 10,15,habilidades1);
        Pokemon pokemon2 = new Pokemon("Vulpix", 6, new Hielo(), 12, 20, 15,15,habilidades2);
        Pokemon pokemon3 = new Pokemon("Pikachu", 2, new Electrico(), 10, 30, 10,25,habilidades2);
        VistaPokemon vista = new VistaPokemon();
        pokemon.setVista(vista);

        pokemon2.setVista(vista);

        pokemon3.setVista(vista);

        pokemones.add(pokemon);
        pokemones.add(pokemon2);
        pokemones.add(pokemon3);

        return pokemones;
    }

    public List<Pokemon> generarSetPokemon2(int cantidadDePokemones){
        List<Pokemon> pokemones = new ArrayList<Pokemon>();
        List<Habilidad> habilidades = new ArrayList<Habilidad>();
        habilidades.add(new Ataque("Llamarada",5, new Fuego(), 20));
        Pokemon pokemon = new Pokemon("Bulbasur", 10, new Bicho(), 15, 15, 25, 12,habilidades);
        VistaPokemon vista = new VistaPokemon();
        pokemon.setVista(vista);
        pokemones.add(pokemon);

        return pokemones;
    }

    public List<Item> generarSetItems(){
        List<Item> items = new ArrayList<Item>();
        Item item = new Revivir();
        Item item2 = new AtaqueX(100);
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
*/

    public List<Jugador> generarPartida(){
        ParserHabilidad parserHabilidad = new ParserHabilidad();
        ParserItems parserItems = new ParserItems();
        ParserPokemon parserPokemon = new ParserPokemon();
        ParserPartida parserPartida = new ParserPartida();
        this.habilidadMap = parserHabilidad.parsearHabilidades("src/main/resources/Habilidades.json");
        this.repositorioHabilidades.cargarMapa(habilidadMap);
        this.itemMap = parserItems.parsearItems("src/main/resources/Items.json");
        this.pokemonMap = parserPokemon.parsearPokemones("src/main/resources/pokemones.json",repositorioHabilidades);
        List<Jugador> resultados = new ArrayList<>();
        resultados = parserPartida.parsearJugadores("src/main/resources/Partida.json");

        Jugador jugador;
        jugador = resultados.get(0);

        List<Pokemon> pokemones = this.obtenerPokemones(jugador.getPokemonesParseo());
        List<Item> items = this.obtenerItems(jugador.getItemsParseo());

        Jugador jugador1 = new Jugador(jugador.getNombre(),pokemones,items,1);

        jugador = resultados.get(1);

        List<Pokemon> pokemones2 = this.obtenerPokemones(jugador.getPokemonesParseo());
        List<Item> items2 = this.obtenerItems(jugador.getItemsParseo());

        Jugador jugador2 = new Jugador(jugador.getNombre(),pokemones2,items2,1);

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        return jugadores;
    }

    private List<Item> obtenerItems(List<Integer> itemsParseo) {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < itemsParseo.size(); i += 2){
            Item item = obtenerItemPorId(itemsParseo.get(i));
            int cantidad = (itemsParseo.get(i+1));
            for (int j = 0 ; j < cantidad; j++)
                items.add(item);
        }

        return items;
    }

    private Item obtenerItemPorId(int id) {
        return itemMap.get(id);
    }

    private List<Pokemon> obtenerPokemones(List<Integer> pokemonesParseo){
        List<Pokemon> pokemones = new ArrayList<>();
        for (int i = 0; i < pokemonesParseo.size(); i++){
            pokemones.add(obtenerPokemonPorId(pokemonesParseo.get(i)));
        }
        return pokemones;
    }

    public Pokemon obtenerPokemonPorId(int id) {
        return pokemonMap.get(id);
    }
}
