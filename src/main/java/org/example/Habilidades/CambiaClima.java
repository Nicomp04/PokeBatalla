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
    }

    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo, Clima clima){
        visitor.visitCambiaClima(this, atacante, objetivo,clima);
    }
    public void usarEnPokemon(Pokemon pokemon, Pokemon objetivo, Clima clima){
        clima.cambiar(climaCambiar);
    }
}
