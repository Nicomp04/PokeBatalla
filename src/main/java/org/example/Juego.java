package org.example;

import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.Map;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoDe1;
    private Jugador turnoActivo;

    public Juego() {
        Generador gen = new Generador();

        Jugador jugador1 = new Jugador("Juan", gen.generarSetPokemon1(1),gen.generarSetItems());
        Jugador jugador2 = new Jugador("Pedro", gen.generarSetPokemon2(1),gen.generarSetItems());

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        //this.turnoDe1 = definirPrimerTurno();
        this.turnoActivo = definirPrimerTurno();
    }

    public Jugador definirPrimerTurno(){ // Lo pense asi, puede cambiarse mas adelante
        Pokemon pokemon1 = this.jugador1.pokemonActual();//
        Pokemon pokemon2 = this.jugador2.pokemonActual();

        //return (pokemon1.getVelocidad() < pokemon2.getVelocidad());
        if (pokemon1.getVelocidad() < pokemon2.getVelocidad()){
            return jugador1;
        }
        return jugador2;
    }


    public void avanzarTurno(){ // A implementar...

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public boolean getTurnoDe1() {
        return turnoDe1;
    }

    public void habilitarTurno(){
        if (turnoActivo.equals(jugador1)){
            jugador1.usarTurno();
        }
        jugador2.usarTurno();
    }
}

