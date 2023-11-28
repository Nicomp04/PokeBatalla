package org.example.Habilidades;
import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.TipoFactory;
import org.example.Visitor;

import java.util.*;

public abstract class Habilidad{
    protected int id;

    protected String nombre;
    protected boolean afectaAEnemigo;
    protected TipoFactory tipoFactory;
    private static Map<Integer, Habilidad> mapaHabilidades = new HashMap<>();
    public Habilidad(){}

    public abstract void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo, Clima clima);

    protected int usosDisponibles; //cantidad de veces que se puede usar la habilidad

    public abstract void usarEnPokemon(Pokemon pokemon, Pokemon objetivo,Clima clima);

    public boolean getAfectaAEnemigo() {
        return afectaAEnemigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getId() {return this.id;}
}
