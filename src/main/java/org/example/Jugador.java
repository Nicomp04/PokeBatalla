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

    public boolean tienePokemones() {
        return !pokemones.isEmpty();
    }

    public boolean seRindio() {
        return this.rendirse;
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

    public void usarTurno(){
        int accionElegida = 0;
        //INPUT
        Scanner scanner = new Scanner(System.in);

        logger.info("Es turno de {} ¿que accion quiere realizar?", this.nombre);
        logger.info("\n" +
                "1: Usar Habilidad \n" +
                "2: Usar Item \n" +
                "3: Cambiar de Pokemon\n" +
                "4: Escapar de la batalla\n"
        );
        logger.info("Accion ->  ");
        // Lee la entrada del usuario y almacenarla en una variable
        accionElegida = scanner.nextInt();
        logger.info("\n");
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
                // escapar();
                break;
        }

        if(getPokemonActual().getEstado() == Estados.ENVENENADO){
            getPokemonActual().aplicarVeneno();
        }
    }

    private void usarItem() {
        int itemElegido = 0;

        Scanner scanner = new Scanner(System.in);

        logger.info("Decidiste utilizar un Item ¿que item desea aplicar?");
        logger.info("\n" +
                "1: {} \n", items.get(0).getNombre() +
                "2: {} \n", items.get(1).getNombre() +
                "3: {} \n", items.get(2).getNombre() +
                "4: {} \n", items.get(3).getNombre()
        );
        logger.info("Item ->  ");
        itemElegido = scanner.nextInt();
        logger.info("\n");
        Item itemAAplicar = items.get(itemElegido);
        Pokemon pokemonAAplicar = pokemones.get(elegirPokemon(itemAAplicar));

        itemAAplicar.aplicarItem(pokemonAAplicar);
    }

    private int elegirPokemon(Item item) {

        int pokemonElegido = 0;

        Scanner scanner = new Scanner(System.in);
        mostrarInfoPokemons();

        logger.info("Decidiste {} ¿en que Pokemon deseas utilizarlo?", item.getNombre());
        mostrarInfoPokemons();
        logger.info("Pokemon ->  ");
        pokemonElegido = scanner.nextInt();
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

}
