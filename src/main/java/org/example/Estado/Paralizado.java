package org.example.Estado;

import org.example.Pokemon.Pokemon;

import java.util.Random;

public class Paralizado implements EstadoPokemon{
    private int baliza;

    private boolean agotado;

    public Paralizado() {
    }

    @Override
    public int baliza(){
        return this.baliza;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        Random rand = new Random();
        if (rand.nextDouble() <= 0.5) {
            System.out.println("¡El Pokémon está paralizado y no puede realizar la habilidad seleccionada!");
            this.baliza = 1;
        } else {
            System.out.println("El Pokémon realiza la habilidad seleccionada.");
            this.baliza = 0;
        }
    }

    public void restarTurno(){
        //restara un turno si se desea implementar
    }
    public String getNombre(){
        return "Envenenado";
    }
    public String getDuracion(){
        return "-";
    }
    public boolean seAgoto(){
        return false;
    }

    public void setAgotado(boolean agotado) {
        this.agotado = agotado;
    }
}
