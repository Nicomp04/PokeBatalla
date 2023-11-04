package org.example.Vista;

import java.util.Scanner;

public class HabildadVista {
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostarDanio(double danio) {
        mostrarMensaje("Calculando daño...");
        mostrarMensaje("El daño causado fue de " + danio);
    }
}
