package org.example;

import org.example.Clima.Clima;
import org.example.Estado.EstadoPokemon;
import org.example.Habilidades.Habilidad;
import org.example.Parsers.ParserClima;
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

        Clima clima = new Clima();
        this.clima = sortearInicial();
    }

    public Clima sortearInicial(){
        Random random = new Random();
        ParserClima parser = new ParserClima("src/main/resources/Climas.json");
        double probabilidad = random.nextDouble();

        if (probabilidad < 2.0 / 3.0) {
            return parser.getClima("Normal");
        } else {
            return  parser.climaAleatorio();
        }
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

    private void eliminarEstadoAgotado(Pokemon pokemonAtacante){

        List<EstadoPokemon> estadosAgotados = new ArrayList<>();

        for(EstadoPokemon estado: pokemonAtacante.getEstados()){
            if(estado.seAgoto()){
                estadosAgotados.add(estado);
            }
        }

        for(EstadoPokemon estado: estadosAgotados){
            System.out.println("Se quito el estado " + estado.getNombre());
            pokemonAtacante.quitarEstado(estado);
        }
    }

    public void usarHabilidad(Habilidad habilidad){
        int baliza = 0;

        for(EstadoPokemon estado: pokemonAtacante.getEstados()){
            estado.aplicarEfecto(pokemonAtacante);
            baliza = baliza - estado.baliza();
        }

        eliminarEstadoAgotado(pokemonAtacante);

        if (baliza == 0){
            this.aplicarHabilidad(habilidad);
        }

        campoVista.mostrarClima(clima);
        clima.restarTurno();
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
        if(clima.esClimaPeligroso()){
            for (Pokemon pokemon: pokemonesActivos)
                if(!clima.compararTipos(pokemon)){
                    pokemon.modificarHp(- (pokemon.getVidaActual() * 3 / 100));
                }
        }

    }

    public Clima getClima() {
        return this.clima;
    }

    public Pokemon getPokemonAtacado() {
        return this.pokemonAtacado;
    }
    public Pokemon getPokemonAtacante() {
        return this.pokemonAtacante;
    }
}
