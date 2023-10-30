package org.example;

import java.util.Scanner;

public class JuegoVista {
    private Scanner scanner;
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarJuegoInicializado() {
        mostrarMensaje("Juego Inicializado con exito!");
    }

    public void mostarPerdedor(String perdedor) {
        mostrarMensaje(String.format("%s perdio la PokeBatalla!", perdedor));
    }

    public void mostrarCobarde(Jugador perdedor) {
        mostrarMensaje("El enemigo se escapo!");
    }
}
