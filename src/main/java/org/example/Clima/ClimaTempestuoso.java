package org.example.Clima;

import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.List;

public class ClimaTempestuoso extends Clima{
    public ClimaTempestuoso(String clima, List<Tipo> tipos) {
        super(clima);
    }

    public void herirPokemon(Pokemon pokemon){
        if (!compararTipos(pokemon)){
            pokemon.serAtacado(-(pokemon.getVidaActual() * 3 / 100));
        }
    }
}
