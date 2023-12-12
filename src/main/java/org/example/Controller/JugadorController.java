package org.example.Controller;
import org.example.Pokemon.Pokemon;
import org.example.Vista.JugadorVista;

import java.util.List;
import java.util.Scanner;


public class JugadorController {
    Scanner scanner = new Scanner(System.in);
    JugadorVista jugadorVista;

    public JugadorController(JugadorVista vista){
        this.jugadorVista = vista;
    }

    public int solicitarOpcion() {
        return scanner.nextInt();
    }

    public int pokemonAMover(List<Pokemon> pokemones){
         jugadorVista.mostrarPokemones(pokemones);
         return solicitarOpcion();
    }
}
