package org.example.Estado;

import org.example.Pokemon.Pokemon;

import java.util.Random;

public class Confundido implements EstadoPokemon {
    private int duracion;
    private int baliza;

    private boolean agotado;

    public Confundido() {
        this.duracion = 3;
    }

    @Override
    public int baliza(){
        return this.baliza;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        Random rand = new Random();
        double probabilidadHerirse = 1.0 / 3;

        if (rand.nextDouble() <= probabilidadHerirse) {
            System.out.println("¡El Pokémon está confuso y se hirió a sí mismo!");
            this.baliza = 1;
            double porcentajeDanio = 0.15;
            pokemon.modificarHp(-(pokemon.getVidaMaxima() * porcentajeDanio));
            restarTurno();
        } else {
            System.out.println("El Pokémon confuso realizó la habilidad seleccionada correctamente.");
            this.baliza = 0;
        }
        restarTurno();
    }

    public void restarTurno(){
        this.duracion = duracion -1;
    }
    public String getNombre(){
        return "Confundido";
    }
    public String getDuracion(){
        return Integer.toString(duracion);
    }
    public boolean seAgoto(){
        return this.duracion <= 0;
    }
}