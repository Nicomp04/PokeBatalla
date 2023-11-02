package org.example.Clima;

import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.List;

public class Clima {
    private String clima;
    private int turnos;
    private List<Tipo> tipos;

    public Clima(String clima, List<Tipo> tipos) {
        this.clima = clima;
        this.tipos = tipos;
        this.turnos = 5;
    }

    public boolean compararTipos(Pokemon pokemon){
        return tipos.contains(pokemon.getTipo());
    }

    public double mejoraPorTipo(Pokemon pokemon, double ataque){
        if(compararTipos(pokemon)){
            return ataque * 10/100;
        }
        return 0;
    }

    public void restarTurno(){
        if(turnos > 0) {
            this.turnos--;
        }
    }
}
