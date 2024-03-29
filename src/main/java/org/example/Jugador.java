package org.example;

import org.example.Controller.JugadorController;
import org.example.Item.Item;
import org.example.Pokemon.Pokemon;
import org.example.Vista.JugadorVista;

import java.util.List;

public class Jugador {

    int contadorDeTurnosDormido;
    private String nombre;
    private List<Integer> itemsParseo;
    private List<Integer> pokemonesParseo;
    private List<Pokemon> pokemones;
    private List<Item> items;
    private int id;
    private boolean rendirse;
    private Campo campoDeBatalla;
    private JugadorVista jugadorVista;
    private JugadorController jugadorController;

    public int getId() {
        return id;
    }
    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public Jugador(String nombre, List<Pokemon> pokemones, List<Item> items, int id) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.id = id;
        this.contadorDeTurnosDormido = 0;
        this.rendirse = false;

        this.jugadorVista = new JugadorVista();
        this.jugadorController = new JugadorController(jugadorVista);
    }

    public Jugador(String nombre, List<Integer> items, List<Integer> pokemones) {
        this.nombre = nombre;
        this.pokemonesParseo = pokemones;
        this.itemsParseo = items;
    }

    public Jugador() {
    }

    public List<Integer> getPokemonesParseo() {
        return this.pokemonesParseo;
    }

    public List<Integer> getItemsParseo() {
        return itemsParseo;
    }

    public Pokemon getPokemonActual() {
        return pokemones.get(0);
    }

    public void entrarACampo(Campo campoDeBatalla) {
        this.campoDeBatalla = campoDeBatalla;
    }

    public String getNombre(){
        return this.nombre;
    }
    public Item getItem(int pos){return this.items.get(pos);}

    public boolean tienePokemones() {
        return HayPokemonesVivos();
    }

    public boolean seRindio() {
        return this.rendirse;
    }

    public void elegirPokemonActivo() {
        int pokemonAMover=0;
        int posicionAPoner;
        Pokemon pokemon1;
        Pokemon pokemon2;

        while (pokemonAMover != -1) {
            pokemonAMover = jugadorController.pokemonAMover(pokemones);

            if (pokemonAMover == -1) {
                break;
            }

            if (pokemones.get(pokemonAMover - 1).estaMuerto()) {
                jugadorVista.mostrarPokemonInvalido();
                continue;
            }

            posicionAPoner = jugadorVista.elegirPosiciones(pokemones.size());

            pokemonAMover--;
            posicionAPoner--;
            pokemon1 = pokemones.get(pokemonAMover);
            pokemon2 = pokemones.get(posicionAPoner);
            pokemones.set(pokemonAMover, pokemon2);
            pokemones.set(posicionAPoner, pokemon1);

            campoDeBatalla.cambiarPokemon(pokemones.get(0), id);
        }
    }

    public void escapar() {this.rendirse = true;}


    private boolean HayPokemonesVivos() {
        boolean HayPokemonesVivos = false;
        for(int i = 0; i < pokemones.size(); i++){
            if (!pokemones.get(i).estaMuerto()){
                HayPokemonesVivos = true;

            }
        }
        return HayPokemonesVivos;
    }


    public void setController(JugadorController jugadorControllerMock) {
        jugadorVista.setController(jugadorControllerMock);
    }

    public void setNombre(String j2) {
        this.nombre = j2;
    }

    public List<Item> getItems() {return this.items;}

    public void elegirPokemon(int posicion) {
        if (posicion != -1){
            if(!pokemones.get(posicion).estaMuerto() || !(pokemones.size() < posicion)){

                Pokemon pokemonActivar = pokemones.get(posicion);
                Pokemon pokemonDesactivar = pokemones.get(0);

                pokemones.set(0, pokemonActivar);
                pokemones.set(posicion, pokemonDesactivar);

                campoDeBatalla.cambiarPokemon(pokemones.get(0), id);
            }
        }
    }
}