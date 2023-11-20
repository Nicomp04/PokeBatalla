package org.example;
import java.util.Scanner;

public class JugadorController {
    Scanner scanner = new Scanner(System.in);

    public JugadorController(){

    }
    public int solicitarOpcion() {

        return scanner.nextInt();
    }
}
