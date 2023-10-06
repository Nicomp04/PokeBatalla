package org.example;

import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Campo {
    private Pokemon pokemonAtacante;
    private Pokemon pokemonAtacado;
    private List<Pokemon> pokemonesActivos;

    final Logger logger = LoggerFactory.getLogger(Campo.class);

    public Campo(Pokemon pokemon1, Pokemon pokemon2){
        pokemonesActivos = new ArrayList<>();
        pokemonesActivos.add(pokemon1);
        pokemonesActivos.add(pokemon2);

    }

    private void identificarAtacante(int id) {
        if (id == 1 ){
            pokemonAtacante = pokemonesActivos.get(0);
            pokemonAtacado = pokemonesActivos.get(1);
        }
        else {
            pokemonAtacado = pokemonesActivos.get(0);
            pokemonAtacante = pokemonesActivos.get(1);
        }

    }

    public boolean validarEstadoParalizado(Pokemon pokemon){

        if (pokemon.getEstado() == Estados.PARALIZADO){
            Random random = new Random();
            double valorAleatorio = random.nextDouble();
            return (valorAleatorio < 0.005);
        }
        return false;
    }

    private void validarEstadoDespierto(Habilidad habilidad){
        if(pokemonAtacante.getEstado() == Estados.DORMIDO){
            logger.info("el pokemon esta Dormido, No Puede Atacar");
            pokemonAtacante.cambiarEstado(null);// falta agregar lo del contador de turnos.
        }else {
            aplicarHabilidad(habilidad);
        }
    }


    /*
    Identifica que habilidad se va a usar
     */
    public void elejirHabilidad (int idAtacante){
        identificarAtacante(idAtacante);
        Habilidad habilidad = pokemonAtacante.ElegirHabilidad();
        validarEstadoDespierto(habilidad);
    }

    /*
    Segurn si afecta al enemigo o al atacante se llama a la habilidad para que se active
     */
    public void aplicarHabilidad (Habilidad habilidadElegida){
        if(validarEstadoParalizado(pokemonAtacante)){
            logger.info("el pokemon esta paralizado, No Puede Moverse!!!");
        }
        else if (habilidadElegida.atacaAEnemigo()){
            habilidadElegida.usarEnPokemon(pokemonAtacante, pokemonAtacado);
        }
        else if (habilidadElegida.afectaAEnemigo()){
            habilidadElegida.usarEnPokemon(pokemonAtacado);
        }
        else {
            habilidadElegida.usarEnPokemon(pokemonAtacante);
        }
    }

}
