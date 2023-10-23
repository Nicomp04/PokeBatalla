package org.example.Habilidades;
import org.example.Estado.Estados;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

import java.util.Random;

public abstract class Habilidad{
    protected String nombre;
    protected boolean atacaAEnemigo;
    protected boolean afectaAEnemigo;
    public Habilidad(){}

    public abstract void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo);

    protected int usosDisponibles; //cantidad de veces que se puede usar la habilidad
    public void usarHabilidad(Pokemon pokemonAtacante, Pokemon pokemonAtacado){}

    public abstract void usarEnPokemon(Pokemon pokemon, Pokemon objetivo);

    public boolean getAfectaAEnemigo() {
        return afectaAEnemigo;
    }

    public boolean getAtacaAEnemigo() {
        return atacaAEnemigo;
    }

    public String getNombre() {
        return this.nombre;
    }

}
