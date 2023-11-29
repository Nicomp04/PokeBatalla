package org.example;

import org.example.Clima.Clima;
import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Pokemon.PokemonVisitor;
import org.example.Vista.PokemonVista;
import org.example.Vista.CampoVista;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Campo {
    private Pokemon pokemonAtacante;
    private Pokemon pokemonAtacado;
    private List<Pokemon> pokemonesActivos;
    private Clima clima;
    private CampoVista campoVista;
    private PokemonVista pokemonVista;
    public Campo(Pokemon pokemon1, Pokemon pokemon2){
        pokemonesActivos = new ArrayList<>();
        pokemonesActivos.add(pokemon1);
        pokemonesActivos.add(pokemon2);
        this.campoVista = new CampoVista();
        this.pokemonVista = new PokemonVista();

        this.clima = new Clima("sin clima");
    }

    public Pokemon getPokemonesActivos(int num) {
        return pokemonesActivos.get(num);
    }

    public void identificarAtacante(int id) {
        if (id == 1 ){
            pokemonAtacante = pokemonesActivos.get(0);
            pokemonAtacado = pokemonesActivos.get(1);
        }
        else {
            pokemonAtacado = pokemonesActivos.get(0);
            pokemonAtacante = pokemonesActivos.get(1);
        }
    }


    /*public void usarHabilidad(int idAtacante){
        boolean despierto;
        boolean paralizado;
        boolean confundido;

        identificarAtacante(idAtacante);
        pokemonAtacante.mostrarHabilidades();
        Habilidad habilidad = this.elegirHabilidad(pokemonAtacante);

        despierto = validarEstadoDespierto(pokemonAtacante.getEstados());
        paralizado = validarEstadoParalizado(pokemonAtacante.getEstados());

        if (pokemonAtacante.getEstados().contains(Estados.CONFUNDIDO))
            this.verQueTanConfundido(pokemonAtacante);

        if (despierto && !paralizado){
            this.aplicarHabilidad(habilidad);
        }
        campoVista.mostrarClima(clima);
        clima.restarTurno();
    }*/

    public void usarHabilidad(Habilidad habilidad){
        boolean despierto;
        boolean paralizado;
        boolean confundido;
        despierto = validarEstadoDespierto(pokemonAtacante.getEstados());
        paralizado = validarEstadoParalizado(pokemonAtacante.getEstados());

        if (pokemonAtacante.getEstados().contains(Estados.CONFUNDIDO))
            this.verQueTanConfundido(pokemonAtacante);

        if (despierto && !paralizado){
            this.aplicarHabilidad(habilidad);

        }
        campoVista.mostrarClima(clima);
        clima.restarTurno();
    }

    public void verQueTanConfundido(Pokemon pokemon) {
        Random random = new Random();
        double valorAleatorio = random.nextDouble();

        if(valorAleatorio < 0.3){
            double resto = ((pokemon.getVidaActual() * 15) / 100);
            campoVista.mostrarConfundido(pokemon.getNombre(), resto);
            pokemon.modificarHp(-resto);
        }
    }

    public boolean validarEstadoParalizado(List<Estados> estados) {
        return estados.contains(Estados.PARALIZADO);
    }

    public boolean validarEstadoDespierto(List<Estados> estados) {
        return !estados.contains(Estados.DORMIDO);
    }
    public void validarEstadoEnvenenado(Pokemon pokemon) {
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        if(pokemon.getEstados().contains((Estados.ENVENENADO))){
            double resto = ((pokemon.getVidaActual() * 5) / 100);
            pokemon.modificarHp(-resto);
            campoVista.mostrarEnvenenado(pokemon.getNombre(), resto);
        }
    }

    private Habilidad elegirHabilidad(Pokemon pokemonAtacante) {

        Scanner scanner = new Scanner(System.in);
        int habilidadElegida = scanner.nextInt();

        if (habilidadElegida < 1 || habilidadElegida > pokemonAtacante.getNumeroDeHabilidades()){
            campoVista.entradaInvalida();
            return elegirHabilidad(pokemonAtacante);
        }
        return pokemonAtacante.getHabilidad(habilidadElegida - 1);
    }

    public void aplicarHabilidad(Habilidad habilidadElegida){
        PokemonVisitor visitor = new PokemonVisitor();
        habilidadElegida.aceptar(visitor, pokemonAtacante, pokemonAtacado, clima);
    }

    public void cambiarPokemon(Pokemon pokemon, int id){
        this.pokemonesActivos.set(id-1,pokemon);
    }


    public void climaAfecta() {
        if(clima.climaPeligroso()){
            for (Pokemon pokemon: pokemonesActivos)
                if(!clima.compararTipos(pokemon)){
                    pokemon.modificarHp(- (pokemon.getVidaActual() * 3 / 100));
                }
        }

    }
}
