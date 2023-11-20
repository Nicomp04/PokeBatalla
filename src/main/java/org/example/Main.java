package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Bienvenido a la Batalla");
        Juego juego = new Juego();
    }
}