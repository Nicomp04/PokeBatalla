package org.example.Item;

import org.example.Item.Item;
import org.example.Jugador;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Revivir extends Item {
    final Logger logger = LoggerFactory.getLogger(Revivir.class);
    public Revivir(){
        this.nombre = "Revivir";

    }


   /* public boolean aplicarItem(Pokemon pokemon){
        if (pokemon.estaMuerto()){
            logger.info("\nEl pokemon esta no esta muerto, no podes revivir\n"+
                    "Elegi otro pokemon \n");
            return false;
        }
        pokemon.revivir();
        return true;
    }*/
    @Override
    public void aplicarItem(List<Pokemon> pokemones) { //Implementar revivir() en Pokemon.java (puede ser cambiado)
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemonesMuertos = new ArrayList<>();

        Pokemon pokemon = new Pokemon();
        for(int i = 0; i < pokemones.size(); i++){
            pokemon = pokemones.get(i);
            if(pokemon.estaMuerto()){
                pokemonesMuertos.add(pokemon);
            }
        }
        if(pokemonesMuertos.isEmpty()){
            logger.info("No tienes Pokemones a revivir, el turno se consumio igual.");
        }
        else {
            logger.info("¿Cual de tus pokemones quieres revivir? \n", this.nombre);

            for(int i = 0; i < pokemonesMuertos.size(); i++){
                logger.info("{}: {} \n",i + 1 ,pokemones.get(i).getNombre());
            }
            //tenemos que hacerlo con un for para que solo muestre la cantidad de pokemon que tiene
            // Lee la entrada del usuario y almacenarla en una variable
            int pokemonElegido = scanner.nextInt();
            pokemonElegido = pokemonElegido - 1;
            pokemonesMuertos.get(pokemonElegido).revivir();
            logger.info("{} ha sido revivido.", pokemonElegido);
            this.setUsado(true);
        }

     }



    /*@Override
    public void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo) { //Implementar revivir() en Pokemon.java (puede ser cambiado)
        pokemonPropio.revivir();
    }*/
}
