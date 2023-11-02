package org.example;

import org.example.Item.Item;
import org.example.Pokemon.Pokemon;
import org.example.Pokemon.PokemonVista;

import java.util.List;
import java.util.Scanner;

public class JugadorVista {
    private Scanner scanner;

    private PokemonVista pokemonVista;
    public JugadorVista(){
        this.scanner = new Scanner(System.in);
        this.pokemonVista = new PokemonVista();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int solicitarOpcion() {
        System.out.print("Ingrese accion: ");
        return scanner.nextInt();
    }

    public int mostrarOpciones(Jugador jugador){
        mostrarMensaje(String.format("\n" +
                "Es turno de %s ¿que accion quiere realizar?", jugador.getNombre()));
        mostrarMensaje("\n" +
                "1: Usar Habilidad \n" +
                "2: Usar Item \n" +
                "3: Cambiar de Pokemon\n" +
                "4: Escapar de la batalla\n"
        );
        return solicitarOpcion();
    }

    public int elegirPokemones(List<Pokemon> pokemones){
        mostrarPokemones(pokemones);
        return scanner.nextInt();
    }

    public void mostrarPokemones(List<Pokemon> pokemones) {
        mostrarMensaje("Es su turno, ¿qué Pokémon quiere cambiar de lugar? Ingrese -1 para terminar.");
        for (int i = 0; i < pokemones.size(); i ++){
            Pokemon pokemon = pokemones.get(i);
            this.pokemonVista.mostrarse(pokemon,i+1);
        }
    }

    public void mostrarPokemonInvalido() {
        mostrarMensaje("Entrada inválida. Asegúrese de elegir un pokemon vivo válida.");
    }

    public int elegirPosiciones(int max){
        this.mostrarPosiciones(max);
        return scanner.nextInt();
    }
    public void mostrarPosiciones(int max) {
        mostrarMensaje("¿En que posicion quiere ubicarlo?");
        for (int i = 0; i < max; i++) {
            mostrarMensaje("Posición {}\n"+ (i + 1));
        }
    }

    public int elegirItem(List<Item> items){
        mostrarItems(items);
        return scanner.nextInt();
    }

    public void mostrarItems(List<Item> items) {
        mostrarMensaje("Es su turno ¿que Item quiere utilizar?");
        for(int i = 0; i < items.size(); i++){
            mostrarMensaje((i + 1) + ": "+ items.get(i).getNombre());
        }
    }
}
