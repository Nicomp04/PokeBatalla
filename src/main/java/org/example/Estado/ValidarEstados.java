package org.example.Estado;

import org.example.Campo;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ValidarEstados {

    final Logger logger = LoggerFactory.getLogger(Campo.class);

    public boolean validarEstadoDespierto(Pokemon pokemonAtacante){
        if(pokemonAtacante.getEstado() == Estados.DORMIDO) {
            logger.info("el pokemon esta Dormido, No Puede Atacar");
            pokemonAtacante.setEstado(null);// falta agregar lo del contador de turnos.
            return false;
        }
        return true;
    }
    public boolean validarEstadoParalizado(Pokemon pokemon){
        if (pokemon.getEstado() == Estados.PARALIZADO){
            Random random = new Random();
            double valorAleatorio = random.nextDouble();
            if (valorAleatorio < 0.5)
                logger.info("el pokemon esta paralizado, No Puede Moverse!!!");
            return true;
        }
        return false;
    }
    public void validarEstadoEnvenenado(Pokemon pokemon){
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        if(pokemon.getEstado() == Estados.ENVENENADO){
            double resto = ((pokemon.getVidaActual() * 5) / 100);
            pokemon.modificarHp(-resto);
            logger.info("El pokemon {} esta Envenenado, pierde {} de vida", pokemon.getNombre(), resto);
        }
    }

    public boolean validarEstadoConfundido(Pokemon pokemon){
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        if(pokemon.getEstado() == Estados.CONFUNDIDO  && valorAleatorio < 0.3){
            double resto = ((pokemon.getVidaActual() * 15) / 100);
            pokemon.modificarHp(-resto);
            logger.info("El pokemon {} esta Confundido, esta tan confundido que se hirio asi mismo y pierde {} de vida", pokemon.getNombre(), resto);
            return true;
        }
        return false;
    }
}
