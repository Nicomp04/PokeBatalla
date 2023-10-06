package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Bienvenido a la Batalla");
        Juego juego = new Juego();
        /*Jugador j1 = juego.getJugador1();
        Jugador j2 = juego.getJugador2();
        System.out.println(j1.getNombre());
        System.out.println(j2.getNombre());
        System.out.println(j1.getPokemones().toString()); testeo*/

    }
}