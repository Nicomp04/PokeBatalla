package org.example;

import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoDe1;
    private Jugador turnoActivo;
    private Campo campoDeBatalla;

    public Juego() {
        final Logger logger = LoggerFactory.getLogger(Juego.class);
        Generador gen = new Generador();

        System.out.println("Comenzaremos con la configuración del Jugador 1");
        Jugador jugador1 = new Jugador(gen.generarNombreJugador(), gen.generarSetPokemon1(gen.generarCantidadPokemones()),gen.generarSetItems(), 1);
        System.out.println("Seguiremos con la configuración del Jugador 2");
        Jugador jugador2 = new Jugador(gen.generarNombreJugador(), gen.generarSetPokemon2(gen.generarCantidadPokemones()),gen.generarSetItems(), 2);

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;


        this.campoDeBatalla = new Campo(jugador1.getPokemonActual(), jugador2.getPokemonActual());

        jugador1.entrarACampo(campoDeBatalla);
        jugador2.entrarACampo(campoDeBatalla);

        logger.info("Juego inicializado con exito!");


        //this.turnoDe1 = definirPrimerTurno();
        this.turnoActivo = definirPrimerTurno();
    }

    public Jugador definirPrimerTurno(){ // Lo pense asi, puede cambiarse mas adelante
        Pokemon pokemon1 = this.jugador1.getPokemonActual();//
        Pokemon pokemon2 = this.jugador2.getPokemonActual();

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

