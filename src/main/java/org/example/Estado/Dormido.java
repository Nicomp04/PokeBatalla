package org.example.Estado;

import org.example.Pokemon.Pokemon;

import java.util.Random;

public class Dormido implements EstadoPokemon {
    private int duracion;
    private int baliza;

    private boolean agotado;

    public Dormido() {
        this.duracion = 0;
    }

    @Override
    public int baliza(){
        return this.baliza;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        Random rand = new Random();
        double probDespertar = 0.25 + this.duracion * 0.25;
        if (rand.nextDouble() <= probDespertar || this.duracion >= 4) {
            System.out.println("¡El Pokémon se ha despertado!");
            this.baliza = 0;
        } else {
            System.out.println("El Pokémon sigue dormido.");
            this.baliza = 1;
        }
        restarTurno();
    }

    public void restarTurno(){
        this.duracion = duracion +1;
    }
    public String getNombre(){
        return "Dormido";
    }
    public String getDuracion(){
        return Integer.toString(duracion);
    }
    public boolean seAgoto(){
        return this.duracion >= 4;
    }
}