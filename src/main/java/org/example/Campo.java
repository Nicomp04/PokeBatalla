package org.example;

import org.example.Clima.Clima;
import org.example.Clima.ClimaTempestuoso;
import org.example.Estado.Estado;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Pokemon.PokemonVista;
import org.example.Pokemon.PokemonVista;
import org.example.Tipo.Tipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
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
        List<Tipo> tipos = new ArrayList<Tipo>();
        this.clima = new Clima("normal" ,tipos);
    }

    public Pokemon getPokemonesActivos(int num) {
        return pokemonesActivos.get(num);
    }

    private void identificarAtacante(int id) {
        if (id == 1 ){
            pokemonAtacante = pokemonesActivos.get(0);
            pokemonAtacado = pokemonesActivos.get(1);
        }
        else {
            pokemonAtacado = pokemonesActivos.get(0);
            pokemonAtacante = pokemonesActivos.get(1);
        }
    }


    public void usarHabilidad(int idAtacante){
        boolean despierto;
        boolean paralizado;
        boolean confundido;

        identificarAtacante(idAtacante);
        pokemonAtacante.mostrarHabilidades();
        Habilidad habilidad = this.elegirHabilidad(pokemonAtacante);

        despierto = pokemonAtacante.getEstado().validarEstadoDespierto();
        paralizado = pokemonAtacante.getEstado().validarEstadoParalizado();
        confundido = pokemonAtacante.getEstado().validarEstadoConfundido(pokemonAtacado);

        if (despierto && !paralizado && !confundido){
            this.aplicarHabilidad(habilidad);
        }
    }

    private Habilidad elegirHabilidad(Pokemon pokemonAtacante) {

        Scanner scanner = new Scanner(System.in);
        int habilidadElegida = scanner.nextInt();

        if (habilidadElegida < 1 || habilidadElegida > pokemonAtacante.getNumeroDeHabilidades()){
            campoVista.entradaInvalida();
            return elegirHabilidad(pokemonAtacante);
        }
        return pokemonAtacante.getHabilidades(habilidadElegida - 1);
    }

    public void aplicarHabilidad(Habilidad habilidadElegida){
        PokemonVisitor visitor = new PokemonVisitor();
        habilidadElegida.aceptar(visitor, pokemonAtacante, pokemonAtacado, clima);
    }

    public void cambiarPokemon(Pokemon pokemon, int id){
        this.pokemonesActivos.set(id-1,pokemon);
    }


    public void efectoDelClima(Pokemon pokemon) {
        if(clima.compararTipos(pokemon)){
            pokemon.modificarHp(- (pokemon.getVidaActual() * 3 / 100));
        }
    }
}
