package org.example;

import org.example.Pokemon.Pokemon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoDe1;
    private Jugador turnoActivo;
    private Campo campoDeBatalla;
    final Logger logger = LoggerFactory.getLogger(Juego.class);
    public Juego() {

        Generador gen = new Generador();

        logger.info("Comenzaremos con la configuración del Jugador 1");
        Jugador jugador1 = new Jugador(gen.generarNombreJugador(), gen.generarSetPokemon1(gen.generarCantidadPokemones()),gen.generarSetItems(), 1);
        logger.info("Seguiremos con la configuración del Jugador 2");
        Jugador jugador2 = new Jugador(gen.generarNombreJugador(), gen.generarSetPokemon2(gen.generarCantidadPokemones()),gen.generarSetItems(), 2);

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;



        this.campoDeBatalla = new Campo(jugador1.getPokemonActual(), jugador2.getPokemonActual());

        jugador1.entrarACampo(campoDeBatalla);
        jugador2.entrarACampo(campoDeBatalla);

        jugador1.elegirPokemonActivo();
        jugador2.elegirPokemonActivo();

        this.turnoActivo = definirPrimerTurno();

        logger.info("Juego inicializado con exito!");

        this.habilitarTurno();
    }

    public Jugador definirPrimerTurno(){ // Lo pense asi, puede cambiarse mas adelante
        Pokemon pokemon1 = this.jugador1.getPokemonActual();//
        Pokemon pokemon2 = this.jugador2.getPokemonActual();

        //return (pokemon1.getVelocidad() < pokemon2.getVelocidad());
        if (pokemon1.getVelocidad() > pokemon2.getVelocidad()){
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
        while(quedanPokemones() && !seRindio()) {
            if (turnoActivo.equals(jugador1)) {
                jugador1.usarTurno();
                turnoActivo = jugador2;
            } else {
                jugador2.usarTurno();
                turnoActivo = jugador1;
            }
        }
        logger.info("El contrincante se ha escapado!");
        logger.info("Contundente victoria de {} !!!",turnoActivo.getNombre());
    }

    private boolean seRindio() {
        return jugador1.seRindio() || jugador2.seRindio();
    }

    private boolean quedanPokemones() {
        return jugador1.tienePokemones() && jugador2.tienePokemones();
    }

}