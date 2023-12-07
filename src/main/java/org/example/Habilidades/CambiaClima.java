package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

public class CambiaClima extends Habilidad{

    private String climaCambiar;

    public CambiaClima(int id, String nombre, int usosDisponibles, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.climaCambiar = tipo;
        this.tipo = tipo;
        this.usosMax = usosDisponibles;
    }

    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo, Clima clima){
        visitor.visitCambiaClima(this, atacante, objetivo,clima);
    }
    public void usarEnPokemon(Pokemon pokemon, Pokemon objetivo, Clima clima){
        clima.cambiar(climaCambiar);
        this.usosDisponibles = usosDisponibles - 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CambiaClima clonedAtaque = (CambiaClima) super.clone();
        return clonedAtaque;
    }

    // Método para clonar un Ataque
    @Override
    public Habilidad clonar() {
        try {
            return (CambiaClima) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
