package org.example;

import org.example.Controller.PantallaBatallaController;
import org.example.Habilidades.Habilidad;
import org.example.Habilidades.RepositorioHabilidades;
import org.example.Pokemon.Pokemon;
import org.example.Item.*;

import org.example.Vista.JuegoVista;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
            crearInforme();
        }
    }

    public void crearInforme(){
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(this.jugador1);
        jugadores.add(this.jugador2);

        JSONArray jsonArray = new JSONArray();
        for (Jugador jugador : jugadores) {
            JSONObject jugadorJson = new JSONObject();
            jugadorJson.put("nombre", jugador.getNombre());
            jugadorJson.put("ganador", !jugador.seRindio());

            JSONObject itemsJson = new JSONObject();
            jugador.getItems().forEach((item) -> itemsJson.put(String.valueOf(item.getId()), item.getUsos()));
            jugadorJson.put("items", itemsJson);

            JSONArray pokemonsJson = new JSONArray();
            for (Pokemon pokemon : jugador.getPokemones()) {
                JSONObject pokemonJson = new JSONObject();
                pokemonJson.put("id", pokemon.getId());
                pokemonJson.put("vidaRestante", pokemon.getVidaActual());
                pokemonJson.put("estado", pokemon.getEstados());
                pokemonsJson.put(pokemonJson);
            }
            jugadorJson.put("pokemons", pokemonsJson);

            jsonArray.put(jugadorJson);
        }

        // Escribir el JSON en un archivo
        try (FileWriter fileWriter = new FileWriter("src/main/resources/informe.json")) {
            fileWriter.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void notificarDerrota(Jugador perdedor) {
        if (observador != null) {
            observador.mostrarDerrota(perdedor);
        }
    }

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


}