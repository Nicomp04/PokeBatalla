package org.example;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnoDe;

    public int definirPrimerTurno(){ // Lo pense asi, puede cambiarse mas adelante
        pokemon1 = this.jugador1.pokemonActual();// Agregar a Jugador.java el atributo pokemonActual
        pokemon2 = this.jugador2.pokemonActual();
        return (pokemon1.getVelocidad() < pokemon2.getVelocidad());
    }

    public void ejecutarTurno(){ // A implementar...

    }

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoDe = definirPrimerTurno();
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public int getTurnoDe() {
        return turnoDe;
    }
}
