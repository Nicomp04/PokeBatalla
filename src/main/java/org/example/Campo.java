package org.example;

import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.List;

public class Campo {
    private Pokemon pokemonAtacante;
    private Pokemon pokemonAtacado;
    private List<Pokemon> pokemonesActivos;

    public Campo(Pokemon pokemon1, Pokemon pokemon2){
        pokemonesActivos.add(pokemon1);
        pokemonesActivos.add(pokemon2);
    }
    private void identificarPokemones(int id) {
        if (id == 1 ){
            pokemonAtacante = pokemonesActivos.get(0);
            pokemonAtacado = pokemonesActivos.get(1);
        }
        else {
            pokemonAtacante = pokemonesActivos.get(1);
            pokemonAtacado = pokemonesActivos.get(0);
        }
    }

    /*
    Identifica que habilidad se va a usar
     */
    public void elejirHabilidad (int idAtacante){
        identificarPokemones(idAtacante);
        int habilidad = pokemonAtacante.elegirHabilidad();
        usarHabilidad(habilidad);
    }

    /*
    Segurn si afecta al enemigo o al atacante se llama a la habilidad para que se active
     */
    public void usarHabilidad (int habilidadElegida ){
        Habilidad habilidad = pokemonAtacante.getHabilidad(habilidadElegida);
        if (habilidad.atacaAEnemigo()){
            habilidad.usarEnPokemon(pokemonAtacado, pokemonAtacante);
        }
        else if (habilidad.afectaAEnemigo()){
            habilidad.usarEnPokemon(pokemonAtacado);
        }
        else {
            habilidad.usarEnPokemon(pokemonAtacante);
        }
    }


}
