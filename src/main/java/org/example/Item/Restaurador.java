package org.example.Item;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurador extends Item {

    private int hp;

    public Restaurador(int hp) {
        this.hp = hp;
        this.nombre = "Restaurador";
    }

    public void aplicarItem(List<Pokemon> pokemones) {
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemonesVivos = new ArrayList<>();
        int pokemonElegido = 0;
        Pokemon pokemon;
        for(int i = 0; i < pokemones.size(); i++){
            pokemon = pokemones.get(i);
            if(!pokemon.estaMuerto()){
                pokemonesVivos.add(pokemon);
            }
        }
        if(pokemonesVivos.isEmpty()){
            logger.info("No tienes Pokemones a restaurar, el turno se consumio igual.");
        }
        else {
            logger.info("¿Cual de tus pokemones quieres restaurar? \n", this.nombre);

            for(int i = 0; i < pokemonesVivos.size(); i++){
                logger.info("{}: {} \n",i + 1 ,pokemones.get(i).getNombre());
            }
            pokemonElegido = scanner.nextInt();
            pokemonElegido = pokemonElegido - 1;
            pokemonesVivos.get(pokemonElegido).modificarHp(hp);
            logger.info("{} ha sido restaurado.", pokemonElegido);

        }

    }
  /*  @Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) { // Implementar curar() en Pokemon.java (puede ser cambiado)
        pokemonPropio.modificarHp(hp);
    }*/
}
