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
        Habilidad habilidad = pokemonAtacante.elegirHabilidad(0);

    }

    public void elejirHablidad (Pokemon pokemonAtacante){
        int habilidadElegida = pokemonAtacante.elegirHabilidad();
    }
    public int Usarhabilidad (int hablilidadElegida ){
        if (pokemonAtacante.getHabilidad(hablilidadElegida).afectaAHpEnemigo() == true){
            int hp = pokemonAtacante.usarHabilidad(pokemonAtacado.getTipo());
        }
        else if (pokemonAtacante.elegirHabilidad())
    }

    private void identificarPokemones(int id) {
        if (id == 1 ){
            pokemonAtacado = pokemonesActivos.get(1);
            pokemonAtacante = pokemonesActivos.get(0);
        }
        else {
            pokemonAtacado = pokemonesActivos.get(0);
            pokemonAtacante = pokemonesActivos.get(1);
        }
    }
}
