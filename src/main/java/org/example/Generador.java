package org.example;

import org.example.Habilidades.*;
import org.example.Item.*;
import org.example.Parsers.ParserHabilidad;
import org.example.Parsers.ParserItems;
import org.example.Parsers.ParserPartida;
import org.example.Parsers.ParserPokemon;
import org.example.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Item> items1 = this.obtenerItems(jugador.getItemsParseo());

        Jugador jugador1 = new Jugador(jugador.getNombre(),pokemones,items1,1);

        jugador = resultados.get(1);

        List<Pokemon> pokemones2 = this.obtenerPokemones(jugador.getPokemonesParseo());
        List<Item> items2 = this.obtenerItems(jugador.getItemsParseo());

        Jugador jugador2 = new Jugador(jugador.getNombre(),pokemones2,items2,2);

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
            boolean sePuedeAgregarItem = true;
            for (int j = 0 ; j < cantidad; j++) {
                if (sePuedeAgregarItem) {
                    items.add(item);
                    sePuedeAgregarItem = chekearItem(item);
                }
            }
            sePuedeAgregarItem = true;
        }

        return items;
    }

    private boolean chekearItem(Item item){
        if (item.getNombre() == "Pocion Molesta Alumnos"){
            return false;
        }
        return true;
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
