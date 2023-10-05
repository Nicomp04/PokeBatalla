package org.example;

import org.example.Estado.Estados;
import org.example.Habilidades.Ataque;
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
    private List<Pokemon> pokemonesActivos = new ArrayList<>();

    final Logger logger = LoggerFactory.getLogger(Campo.class);

    public Campo(Pokemon pokemon1, Pokemon pokemon2){
        pokemonesActivos.add(pokemon1);
        pokemonesActivos.add(pokemon2);

    }

    public void usarHabilidad (int idAtacante){
        //Pokemon pokemonAtacante = identificarAtacante(idAtacante);
        //Habilidad habilidad = pokemonAtacante.elegirHabilidad();

    }

    public void elejirHablidad (Pokemon pokemonAtacante){
       // int habilidadElegida = pokemonAtacante.elegirHabilidad();  // tenemos repetido este metodo
     }

 /*   public int usarHabilidad2 (int hablilidadElegida ){

        if (pokemonAtacante.getHabilidad(hablilidadElegida).afectaAHpEnemigo()){ // no entiendo mucho esto
            //int hp = pokemonAtacante.usarHabilidad(pokemonAtacado.getTipo());
        }
        //else if (pokemonAtacante.elegirHabilidad())
        return 0;
    }*/

    private void identificarAtacante(int id) {
        if (id == 1 ){
            pokemonAtacado = pokemonesActivos.get(1);
            pokemonAtacante = pokemonesActivos.get(0);
            pokemonAtacado = pokemonesActivos.get(1);
        }
        else {
            pokemonAtacante = pokemonesActivos.get(1);
            pokemonAtacado = pokemonesActivos.get(0);
            pokemonAtacante = pokemonesActivos.get(1);
        }

    }

    public boolean validarEstadoParalizado(Pokemon pokemon){
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        return ((pokemon.getEstado() == Estados.PARALIZADO) && (valorAleatorio < 0.005));
    }

    /*
    Identifica que habilidad se va a usar
     */
    public void elejirHabilidad (int idAtacante){
        identificarAtacante(idAtacante);
        Habilidad habilidad = pokemonAtacante.mostrarYelegirHabilidad();
        validarEstadoDespierto(habilidad);
    }

    private void validarEstadoDespierto(Habilidad habilidad){
        if(pokemonAtacante.getEstado() == Estados.DORMIDO){
            logger.info("el pokemon esta Dormido, No Puede Atacar");
            pokemonAtacante.cambiarEstado(null);// falta agregar lo del contador de turnos.
        }else {
            aplicarHabilidad(habilidad);
        }
    }

    public void empezarTurno(Jugador turnoActivo) {

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
