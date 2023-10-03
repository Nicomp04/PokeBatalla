package org.example;

import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.List;

public class Campo {
    private Pokemon pokemonAtacante;
    private Pokemon pokemonAtacado;
    private List<Pokemon> pokemonesActivos;


    public void usarHabilidad (int idAtacante){
        //Pokemon pokemonAtacante = identificarAtacante(idAtacante);
        Pokemon pokemonAtacante = identificarAtacante(idAtacante);
        Habilidad habilidad = pokemonAtacante.elegirHabilidad();

    }

    public void elejirHablidad (Pokemon pokemonAtacante){
       // int habilidadElegida = pokemonAtacante.elegirHabilidad();  // tenemos repetido este metodo
     }

    public int usarHabilidad2 (int hablilidadElegida ){

        if (pokemonAtacante.getHabilidad(hablilidadElegida).afectaAHpEnemigo()){ // no entiendo mucho esto
            //int hp = pokemonAtacante.usarHabilidad(pokemonAtacado.getTipo());
        }
        //else if (pokemonAtacante.elegirHabilidad())
        return 0;
    }

    private Pokemon identificarAtacante(int id) {
        if (id == 1 ){
            pokemonAtacado = pokemonesActivos.get(1);
            pokemonAtacante = pokemonesActivos.get(0);
        }
        else {
            pokemonAtacado = pokemonesActivos.get(0);
            pokemonAtacante = pokemonesActivos.get(1);
        }
        return pokemonAtacante;
    }
}
