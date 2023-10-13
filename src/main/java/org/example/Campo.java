package org.example;

import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
            if (valorAleatorio < 0.005)
                logger.info("el pokemon esta paralizado, No Puede Moverse!!!");
            return true;
        }
        return false;
    }

    private boolean validarEstadoDespierto(Habilidad habilidad){
        if(pokemonAtacante.getEstado() == Estados.DORMIDO) {
            logger.info("el pokemon esta Dormido, No Puede Atacar");
            pokemonAtacante.setEstado(null);// falta agregar lo del contador de turnos.
            return false;
        }
        return true;
    }

    public void usarHabilidad(int idAtacante){
        boolean despierto;
        boolean paralizado;

        identificarAtacante(idAtacante);
        pokemonAtacante.mostrarHabilidades();
        Habilidad habilidad = this.elegirHabilidad(pokemonAtacante);

        despierto = validarEstadoDespierto(habilidad);
        paralizado = validarEstadoParalizado(pokemonAtacante);

        if (despierto && !paralizado){
            this.aplicarHabilidad(habilidad);
        }

    }

    private Habilidad elegirHabilidad(Pokemon pokemonAtacante) {
        logger.info("Habilidad ->  ");
        Scanner scanner = new Scanner(System.in);
        int habilidadElegida = scanner.nextInt();

        if (habilidadElegida < 1 || habilidadElegida > 4){
            logger.info("La hablilidad {} es invalida ingresela nuevamente \n", habilidadElegida);
            return elegirHabilidad(pokemonAtacante);
        }
        return pokemonAtacante.getHabilidades(habilidadElegida - 1);
    }

    /*public void aplicarHabilidad (Habilidad habilidadElegida){
        habilidadElegida.usarEnPokemon(pokemonAtacante, pokemonAtacado);
    }*/
    public void aplicarHabilidad(Habilidad habilidadElegida){
        PokemonVisitor visitor = new PokemonVisitor();
        habilidadElegida.aceptar(visitor, pokemonAtacante, pokemonAtacado);
    }

    public void cambiarPokemon(Pokemon pokemon, int id){
        this.pokemonesActivos.set(id-1,pokemon);
    }

   /* public void atacaA(Pokemon pokemon,double danio) {
        logger.info("El pokemon {} tiene {} de vida.",pokemon.getNombre(),pokemon.getVidaActual());
        pokemon.modificarHp(-danio);
    }*/
}
