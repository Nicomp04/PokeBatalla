package org.example.Habilidades;
import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.TipoFactory;
import org.example.Visitor;

import java.util.*;

public abstract class Habilidad implements Cloneable {
    protected int id;

    protected String nombre;
    protected int usosDisponibles;
    protected int usosMax;
    protected boolean atacaAEnemigo;
    protected boolean afectaAEnemigo;
    protected TipoFactory tipoFactory;
    private static Map<Integer, Habilidad> mapaHabilidades = new HashMap<>();

    protected String tipo;

    public Habilidad(){}

    public abstract void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo, Clima clima);

    public int getUsosDisponibles(){return this.usosDisponibles;}

    public abstract void usarEnPokemon(Pokemon pokemon, Pokemon objetivo,Clima clima);

    public boolean getAfectaAEnemigo() {
        return afectaAEnemigo;
    }

    public boolean getAtacaAEnemigo() {
        return atacaAEnemigo;
    }
    public int getUsosMax(){return this.usosMax;}

    public String getNombre() {
        return this.nombre;
    }

    public Integer getId() {return this.id;}

    public String getTipo() {return this.tipo;}


    public Habilidad clonar() {
        try {
            return (Habilidad) clone();
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción si la clonación no es compatible
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Habilidad clonedHabilidad = (Habilidad) super.clone();
        // Aquí puedes realizar copias profundas de propiedades si es necesario
        return clonedHabilidad;
    }
}
