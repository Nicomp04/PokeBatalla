package org.example.Habilidades;
import org.example.Pokemon.Pokemon;

public abstract class Habilidad{
    protected String nombre;
    public Habilidad(){

    }
    protected int usosDisponibles; //cantidad de veces que se puede usar la habilidad
    public void usarHabilidad(Pokemon pokemonAtacante, Pokemon pokemonAtacado){}

    public abstract void usarEnPokemon(Pokemon pokemon, Pokemon objetivo);
    public abstract void usarEnPokemon(Pokemon pokemon);

    public boolean afectaAEnemigo() { //a implementar
        return true;
    }

    public boolean atacaAEnemigo() {
        return true; //cambiar
    }

    public String getNombre() {
        return this.nombre;
    }
}
