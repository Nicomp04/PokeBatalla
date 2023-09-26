package org.example.Habilidades;
import org.example.Pokemon.Pokemon;

public abstract class Habilidad{
    protected String nombre;
    protected int energia; //cantidad de veces que se puede usar la habilidad
    public void usarHabilidad(Pokemon pokemon){}
}
