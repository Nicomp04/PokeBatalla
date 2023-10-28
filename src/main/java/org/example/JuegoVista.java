package org.example;

import java.util.Scanner;

public class JuegoVista {
    private Scanner scanner;
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarNombre() {
        System.out.print("Por favor, ingrese su nombre: ");
        return scanner.nextLine();
    }

    public int solicitarCantidadPokemones() {
        System.out.print("Por favor, cantidad de Pokemones: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese una cantidad válida (1-6)");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public void configuracionJugador() {
        mostrarMensaje("Comencemos con la configuracion");

    }

    public void mostrarJuegoInicializado() {
        mostrarMensaje("Juego Inicializado con exito!");
    }

    public void mostarPerdedor(String perdedor) {
        mostrarMensaje(String.format("%s perdio la PokeBatalla!", perdedor));
    }

    public void mostrarCobarde(Jugador perdedor) {
    }
}
