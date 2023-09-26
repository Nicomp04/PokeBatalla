package org.example.Habilidades;
import org.example.Pokemon.Charizard;
import org.example.Pokemon.Pokemon;

public abstract class Habilidad{
    protected String nombre;
    protected int usosDisponibles; //cantidad de veces que se puede usar la habilidad
    public void usarHabilidad(Pokemon pokemon){}

    public void usarEnPokemon(Pokemon pokemon, Pokemon objetivo) {}
}
