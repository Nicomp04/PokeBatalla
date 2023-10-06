package org.example;

import org.example.Estado.Estados;
import org.example.Item.Item;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Jugador {

    int contadorDeTurnosDormido;
    private String nombre;
    private List<Pokemon> pokemones;
    private List<Item> items;
    private int id;
    private boolean rendirse;
    private Campo campoDeBatalla;
    final Logger logger = LoggerFactory.getLogger(Jugador.class);

    public Jugador(String nombre, List<Pokemon> pokemones, List<Item> items, int id){
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.id = id;
        this.contadorDeTurnosDormido = 0;
        this.rendirse = false;
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

    public boolean tienePokemones() {
        return !pokemones.isEmpty();
    }

    public boolean seRindio() {
        return this.rendirse;
    }

    private void elegirPokemonActivo() {
        Scanner scanner = new Scanner(System.in);

        int pokemonAMover = 0;
        int posicionAPoner = 0;
        Pokemon pokemon1;
        Pokemon pokemon2;

        while (pokemonAMover != -1) {
            logger.info("Es su turno, ¿qué Pokémon quiere cambiar de lugar? Ingrese -1 para terminar.");

            for (int i = 0; i < pokemones.size(); i++) {
                logger.info("{}: {}\n", i + 1, pokemones.get(i).getNombre());
            }
            pokemonAMover = scanner.nextInt();

            if (pokemonAMover == -1) {
                break;
            }

            logger.info("¿En qué posición quiere ubicarlo?");
            for (int i = 0; i < pokemones.size(); i++) {
                logger.info("Posición {}\n", i + 1);
            }
            posicionAPoner = scanner.nextInt();

            if (pokemonAMover < 1 || pokemonAMover > pokemones.size() || posicionAPoner < 1 || posicionAPoner > pokemones.size()) {
                logger.info("Entrada inválida. Asegúrese de elegir una posición válida.");
                continue;
            }

            pokemonAMover--;
            posicionAPoner--;

            pokemon1 = pokemones.get(pokemonAMover);
            pokemon2 = pokemones.get(posicionAPoner);

            pokemones.set(pokemonAMover, pokemon2);
            pokemones.set(posicionAPoner, pokemon1);
            logger.info("{}", pokemones.get(0));

            campoDeBatalla.cambiarPokemon(pokemones.get(0), id);
        }
    }

    public void elegirAccion(){


        //logger
        logger.info("Es turno de {} ¿que accion quiere realizar?", this.getNombre());
        logger.info("\n" +
                "1: Usar Habilidad \n" +
                "2: Usar Item \n" +
                "3: Cambiar de Pokemon\n" +
                "4: Escapar de la batalla\n"
        );
        logger.info("Accion ->  ");

        //Input
        Scanner scanner = new Scanner(System.in);
        int accionElegida = scanner.nextInt();
        logger.info("\n");

        //Realizar accion
        switch (accionElegida){
            case 1:
                campoDeBatalla.elejirHabilidad(id);
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

        //logger
        logger.info("Es su turno ¿que Item quiere utilizar?");

        //Lista Items
        for(int i = 0; i < items.size(); i++){
            logger.info("{}: {} \n", (i + 1) ,items.get(i).getNombre());
        }

        //Input
        Scanner scanner = new Scanner(System.in);
        int accionElegida = scanner.nextInt();

        //Item
        Item itemAAplicar = items.get(accionElegida);

        //Pokemon
        logger.info("Elegiste el item {}. En que pokemon lo desea utilizar? ", itemAAplicar.getNombre());
        Pokemon pokemonAAplicar = pokemones.get(elegirPokemon());

        //Aplica
        itemAAplicar.aplicarItem(pokemonAAplicar);
    }


    private int elegirPokemon() {


        mostrarInfoPokemons();
        logger.info("Pokemon ->  ");

        Scanner scanner = new Scanner(System.in);
        int pokemonElegido = scanner.nextInt();

        logger.info("\n");

        return pokemonElegido;
    }

    private void mostrarInfoPokemons() {
        for (int i = 0; i < pokemones.size(); i ++){
            Pokemon pokemon = pokemones.get(i);
            logger.info("\n" +
                    "{}: ", (i+1) +
                    "Nombre: {} \n", pokemon.getNombre() +
                    "Tipo: {}    ", pokemon.getTipo().getId() +
                    "Estado: {}   ", pokemon.getEstadoString() +
                    "Vida: {}     \n", pokemon.getVidaActual() +
                    "Ataque: {}   ", pokemon.getAtaque() +
                    "Defensa: {}   ", pokemon.getDefensa() +
                    "Nivel: {}   ", pokemon.getNivel()
            );
        }
    }

    public void usarTurno(){
        if (!(getPokemonActual().estaMuerto())){
            elegirAccion();
        }
        else {
            elegirPokemon();
        }
        getPokemonActual().checkearEnvenenamiento();
    }
}
