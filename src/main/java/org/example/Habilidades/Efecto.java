package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Estado.EstadoPokemon;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

public class Efecto extends Habilidad{
    private EstadoPokemon estado;

    public Efecto(int id, String nombre, EstadoPokemon estado, int usos, boolean afectaAEnemigo, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.usosDisponibles = usos;
        this.afectaAEnemigo = afectaAEnemigo;
        this.tipo = tipo;
        this.usosMax = usosDisponibles;
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo,Clima clima) {
        visitor.visitEfecto(this, atacante, objetivo,clima);
    }
    @Override
    public void usarEnPokemon(Pokemon pokemonPropio, Pokemon objetivo, Clima clima) {
        if(afectaAEnemigo) {
            objetivo.agregarEstado(this.estado);
        }
        this.usosDisponibles = usosDisponibles - 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Efecto clonedAtaque = (Efecto) super.clone();
        // Aquí puedes realizar copias profundas de propiedades si es necesario
        return clonedAtaque;
    }

    // Método para clonar un Ataque
    @Override
    public Habilidad clonar() {
        try {
            return (Efecto) clone();
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción si la clonación no es compatible
            e.printStackTrace();
            return null;
        }
    }
}
