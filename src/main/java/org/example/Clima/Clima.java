package org.example.Clima;

import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.List;

public class Clima {
    private String clima;
    private int tunros;
    private List<Tipo> tipos;

    public Clima(String clima, List<Tipo> tipos) {
        this.clima = clima;
        this.tipos = tipos;
        this.tunros = 5;
    }

    public boolean compararTipos(Pokemon pokemon){
        return tipos.contains(pokemon.getTipo());
    }

    public int mejoraPorTipo(Pokemon pokemon){
        if(compararTipos(pokemon)){
            return 10;
        }
        return 1;
    }
}
