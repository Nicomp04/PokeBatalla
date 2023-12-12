package org.example;

import org.example.Controller.PantallaBatallaController;
import org.example.Habilidades.Habilidad;
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
    private PantallaBatallaController observador;

    private Jugador turnoNoActivo;

    public void notificarCambio(Jugador noActivo) {
        if (observador != null) {
            observador.actualizarInterfaz(noActivo);
        }
    }

    public Juego(Jugador j1, Jugador j2){
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public Juego(PantallaBatallaController pantalla) {
        this.observador = pantalla;
        Generador gen = new Generador();

        List<Jugador> jugadores = gen.generarPartida();
        this.jugador1 = jugadores.get(0);
        this.jugador2 = jugadores.get(1);

        this.campoDeBatalla = new Campo(jugador1.getPokemonActual(), jugador2.getPokemonActual());

        jugador1.entrarACampo(campoDeBatalla);
        jugador2.entrarACampo(campoDeBatalla);

        //jugador1.elegirPokemonActivo();
        //jugador2.elegirPokemonActivo();

        this.turnoActivo = definirPrimerTurno();
    }
    public Jugador getTurnoActivo(){return this.turnoActivo;}

    public Jugador getTurnoNoActivo(){return turnoNoActivo;}

    public Jugador definirPrimerTurno(){
        Pokemon pokemon1 = this.jugador1.getPokemonActual();//

        Pokemon pokemon2 = this.jugador2.getPokemonActual();

        if (pokemon1.getVelocidad() > pokemon2.getVelocidad()){
            return jugador1;
        }
        return jugador2;
    }

    public void ordenarEstados(){
        limpiarItems();
        this.habilitarTurno();
    }

    private void limpiarItems() {
        for(int i = 0 ; i < jugador1.getItems().size(); i++){
            if (jugador1.getItem(i).seAcabo()){
                jugador1.getItems().remove(i);
            }
        }
        for (int j = 0 ; j < jugador2.getItems().size(); j++) {
            if (jugador2.getItem(j).seAcabo()) {
                jugador2.getItems().remove(j);
            }
        }
    }

    public void limpiarHabilidades() {
        List<Habilidad> habilidades = turnoActivo.getPokemonActual().getHabilidades();
        for(int i = 0 ; i < habilidades.size(); i++){
            if (habilidades.get(i).getUsosDisponibles() <= 0){
                turnoActivo.getPokemonActual().getHabilidades().remove(i);
            }
        }
    }

    public void habilitarTurno(){
        if (turnoActivo.equals(jugador1)) {
            turnoActivo = jugador2;
            turnoNoActivo = jugador1;

            notificarCambio(turnoNoActivo);
        } else {
            turnoActivo = jugador1;
            turnoNoActivo = jugador2;
            notificarCambio(turnoNoActivo);
        }

        if(turnoActivo.getPokemonActual().estaMuerto() && turnoActivo.tienePokemones()){

            observador.cambiarPokemones();
            turnoActivo = jugador1;
            turnoNoActivo = jugador2;
        }


        if(!quedanPokemones() || seRindio()){
            Jugador perdedor = this.perdedor();
            notificarDerrota(perdedor);
        }
    }

    private void notificarDerrota(Jugador perdedor) {
        if (observador != null) {
            observador.mostrarDerrota(perdedor);
        }
    }
        /*Jugador perdedor = this.perdedor();
        if(perdedor.seRindio())
            vista.mostrarCobarde(perdedor);
        vista.mostarPerdedor(perdedor.getNombre());*/


    public Jugador perdedor(){
        if (jugador1.seRindio() || !jugador1.tienePokemones()){
            return jugador1;
        }
        return jugador2;
    }
    public boolean seRindio() {
        return jugador1.seRindio() || jugador2.seRindio();
    }

    public boolean quedanPokemones() {
        return jugador1.tienePokemones() && jugador2.tienePokemones();
    }

    public Jugador getJugador1() {
        return this.jugador1;
    }
    public Jugador getJugador2(){
        return this.jugador2;
    }

    public Campo getCampo() {return this.campoDeBatalla;}

    public void setTurnoActivo(Jugador jugador2) {this.turnoActivo = jugador2;}

}