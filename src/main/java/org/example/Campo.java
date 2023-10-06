package org.example;

import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Item.Item;
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
            if (valorAleatorio < 0.005)
                logger.info("el pokemon esta paralizado, No Puede Moverse!!!");
            return true;
        }
        return false;
    }

    private boolean validarEstadoDespierto(Habilidad habilidad){
        if(pokemonAtacante.getEstado() == Estados.DORMIDO) {
            logger.info("el pokemon esta Dormido, No Puede Atacar");
            pokemonAtacante.cambiarEstado(null);// falta agregar lo del contador de turnos.
            return false;
        }
        return true;
    }


    /*
    Identifica que habilidad se va a usar
     */
    public void elejirHabilidad (int idAtacante){
        boolean despierto;
        boolean paralizado;
        identificarAtacante(idAtacante);
        Habilidad habilidad = pokemonAtacante.mostrarYElegirHabilidad();
        despierto = validarEstadoDespierto(habilidad);
        paralizado = validarEstadoParalizado(pokemonAtacante);
        if (despierto && !paralizado){
            this.aplicarHabilidad(habilidad);
        }

    }

    public void aplicarHabilidad (Habilidad habilidadElegida){
        habilidadElegida.usarEnPokemon(pokemonAtacante, pokemonAtacado);
    }

    /* Yo creo que el aplicarHabilidad de arriba esta mal, la idea de polimorfismo es justamente ahorrarse todos esos ifs, para mi puede ser asi
    *
    *  public void aplicarHabilidad (Habilidad habilidadElegida){
    *       habilidadElegida(pokemonAtacante, pokemonPropio);
    * }
    *
    * AL USAR DOBLE PARAMETRO NOS AHORRAMOS LOS IFS DE AFECTA A ENEMIGO O NO
    *
    *
    *
    * */


  /*  public void aplicarItem(Item itemElegido, int id) {
        identificarAtacante(id);
        itemElegido.aplicarItem(pokemonAtacante);
    }*/

    public void cambiarPokemon(Pokemon pokemon, int id){
        this.pokemonesActivos.set(id-1,pokemon);
    }
}
