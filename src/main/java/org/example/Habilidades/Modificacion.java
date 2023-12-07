package org.example.Habilidades;
import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

public abstract class Modificacion extends Habilidad{

    protected int valor;

    public Modificacion(int id, String nombre, int usosDisponibles, int valor,String tipo) {
        this.id = id;
        this.valor = -valor;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.atacaAEnemigo = false;
        this.afectaAEnemigo = true;
        this.tipo = tipo;
        this.usosMax = usosDisponibles;
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo,Clima clima) {
        visitor.visitModificacion(this, atacante, objetivo,clima);
    }

    public abstract void usarEnPokemon(Pokemon propio, Pokemon enemigo, Clima clima);

}
