package org.example;

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
}
