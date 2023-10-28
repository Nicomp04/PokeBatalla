package org.example;

import java.util.Scanner;

public class JugadorVista {
    private Scanner scanner;
    public JugadorVista(){
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int solicitarOpcion() {
        System.out.print("Ingrese accion: ");
        return scanner.nextInt();
    }

    public int mostrarOpciones(Jugador jugador){
        mostrarMensaje(String.format("Es turno de %s ¿que accion quiere realizar?", jugador.getNombre()));
        mostrarMensaje("\n" +
                "1: Usar Habilidad \n" +
                "2: Usar Item \n" +
                "3: Cambiar de Pokemon\n" +
                "4: Escapar de la batalla\n"
        );
        return solicitarOpcion();
    }
}
