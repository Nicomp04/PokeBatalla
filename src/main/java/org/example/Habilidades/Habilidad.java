package org.example.Habilidades;
import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.TipoFactory;
import org.example.Visitor;

import java.util.*;

public abstract class Habilidad{
    protected int id;

    protected String nombre;
    protected int usosDisponibles;
    protected boolean atacaAEnemigo;
    protected boolean afectaAEnemigo;
    protected TipoFactory tipoFactory;
    private static Map<Integer, Habilidad> mapaHabilidades = new HashMap<>();
    protected String tipo;

    public Habilidad(){}

    public abstract void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo, Clima clima);

    public int getUsosDisponibles(){return this.usosDisponibles;}
    public void usarHabilidad(Pokemon pokemonAtacante, Pokemon pokemonAtacado){}

    public abstract void usarEnPokemon(Pokemon pokemon, Pokemon objetivo,Clima clima);

    public boolean getAfectaAEnemigo() {
        return afectaAEnemigo;
    }

    public boolean getAtacaAEnemigo() {
        return atacaAEnemigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getId() {return this.id;}

    public String getTipo() {return this.tipo;}
}
