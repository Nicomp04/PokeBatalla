package org.example;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;
import org.example.Vista.JugadorVista;
import org.example.Vista.PantallaCambiarPokemones;

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

    public void elegirAccion(){
        int accionElegida = jugadorVista.mostrarOpciones(this);
        campoDeBatalla.climaAfecta();
        switch (accionElegida){
            case 1:
                campoDeBatalla.usarHabilidad(id);
                break;
            case 2:
                this.usarItem();
                break;
            case 3:
                this.elegirPokemonActivo();
                break;
            case 4:
                this.escapar();
                break;
        }
    }

    private void escapar() {this.rendirse = true;}

    private void usarItem() {
        int accionElegida = jugadorVista.elegirItem(items);
        Item itemElegido;
        switch (accionElegida){
            case 1:
                itemElegido = items.get(0);
                this.aplicarItem(itemElegido,id);
                break;
            case 2:
                itemElegido = items.get(1);
                this.aplicarItem(itemElegido,id);
                break;
            case 3:
                itemElegido = items.get(2);
                this.aplicarItem(itemElegido,id);
                break;
            case 4:
                itemElegido = items.get(3);
                this.aplicarItem(itemElegido,id);
                break;
            case 5:
                break;
        }
    }
    private void aplicarItem(Item itemElegido, int id) {
        itemElegido.aplicarItem(pokemones);
        if(itemElegido.getUsado())
            this.items.remove(itemElegido);
    }

    private boolean HayPokemonesVivos() {
        boolean HayPokemonesVivos = false;
        for(int i = 0; i < pokemones.size(); i++){
            if (!pokemones.get(i).estaMuerto()){
                HayPokemonesVivos = true;

            }
        }
        return HayPokemonesVivos;
    }

    public void usarTurno(){
        Pokemon pokemonActivo = getPokemonActual();

        if (!(pokemonActivo.estaMuerto())){
            elegirAccion();
        }
        else {
            this.elegirPokemonActivo();
        }
        campoDeBatalla.validarEstadoEnvenenado(pokemonActivo);
        pokemonActivo.restarTurnoEstados();
    }

    public void setController(JugadorController jugadorControllerMock) {
        jugadorVista.setController(jugadorControllerMock);
    }

    public void setNombre(String j2) {
        this.nombre = j2;
    }
}