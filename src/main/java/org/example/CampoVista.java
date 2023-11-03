package org.example;

import org.example.Clima.Clima;

import java.util.Scanner;

public class CampoVista {
    private Scanner scanner;
    public CampoVista(){
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }


    public void entradaInvalida() {
        mostrarMensaje("Entrada invalida, por favor ingrese un valor existente.");
    }

    public void mostrarClima(Clima clima){
        mostrarMensaje("--------------------------");
        mostrarMensaje(clima.getClima() + " -> " + clima.getTurno());
    }

    public void mostrarEnvenenado(String nombre,double resto) {
        mostrarMensaje("El pokemon " + nombre + " esta Envenenado, pierde " + resto + " de vida");
    }

    public void mostrarConfundido(String nombre, double resto) {
        mostrarMensaje("El pokemon " + nombre + " esta Confundido, esta tan confundido que se hirio asi mismo y pierde " + resto + " de vida");
    }
}
