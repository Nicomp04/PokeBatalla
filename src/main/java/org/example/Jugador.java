package org.example;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;
import org.example.Campo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private List<Pokemon> pokemones;
    private List<Item> items;
    private int id;
    private Campo campoDeBatalla;
    final Logger logger = LoggerFactory.getLogger(Jugador.class);

    public Jugador(String nombre, List<Pokemon> pokemones, List<Item> items, int id){


        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.id = id;
    }

    public void usarTurno(){
        int accionElegida = 0;
        //INPUT
        Scanner scanner = new Scanner(System.in);

        logger.info("Es su turno ¿que accion quiere realizar?");
        logger.info("\n 1: Usar Habilidad \n" +
                    "2: Usar Item \n" +
                    "3: Cambiar de Pokemon\n" +
                    "4: Escapar de la batalla\n");
        // Lee la entrada del usuario y almacenarla en una variable
        accionElegida = scanner.nextInt();

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

        int accionElegida = 0; //INPUT
        Pokemon objetivo = null;
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


    public Pokemon getPokemonActual() {
        return pokemones.get(0);
    }

    public void entrarACampo(Campo campoDeBatalla) {
        this.campoDeBatalla = campoDeBatalla;
    }
}
