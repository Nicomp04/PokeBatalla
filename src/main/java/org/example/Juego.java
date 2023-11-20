package org.example;

import org.example.Habilidades.RepositorioHabilidades;
import org.example.Pokemon.Pokemon;

import org.example.Vista.JuegoVista;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoDe1;
    private Jugador turnoActivo;
    private RepositorioHabilidades repositorioHabilidades;
    private Campo campoDeBatalla;
    final Logger logger = LoggerFactory.getLogger(Juego.class);

    private JuegoVista vista ;

    public Juego(Jugador j1, Jugador j2){
        this.jugador1 = j1;
        this.jugador2 = j2;
    }
    public Juego() {
        vista = new JuegoVista();
        Generador gen = new Generador();

        List<Jugador> jugadores = gen.generarPartida();
        this.jugador1 = jugadores.get(0);
        this.jugador2 = jugadores.get(1);

        this.campoDeBatalla = new Campo(jugador1.getPokemonActual(), jugador2.getPokemonActual());

        jugador1.entrarACampo(campoDeBatalla);
        jugador2.entrarACampo(campoDeBatalla);

        jugador1.elegirPokemonActivo();
        jugador2.elegirPokemonActivo();

        this.turnoActivo = definirPrimerTurno();

        vista.mostrarJuegoInicializado();

        this.habilitarTurno();
    }

    public Jugador definirPrimerTurno(){
        Pokemon pokemon1 = this.jugador1.getPokemonActual();//

        Pokemon pokemon2 = this.jugador2.getPokemonActual();

        if (pokemon1.getVelocidad() > pokemon2.getVelocidad()){
            return jugador1;
        }
        return jugador2;
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
        Jugador perdedor = this.perdedor();
        if(perdedor.seRindio())
            vista.mostrarCobarde(perdedor);
        vista.mostarPerdedor(perdedor.getNombre());
    }

    public Jugador perdedor(){
        if (jugador1.seRindio() || !jugador1.tienePokemones()){
            return jugador1;
        }
        return jugador2;
    }
    private boolean seRindio() {
        return jugador1.seRindio() || jugador2.seRindio();
    }

    public boolean quedanPokemones() {
        return jugador1.tienePokemones() && jugador2.tienePokemones();
    }
}