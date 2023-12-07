package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Estado.EstadoPokemon;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

public class Efecto extends Habilidad{
    private EstadoPokemon estado;


    public Efecto(int id, String nombre, EstadoPokemon estado, boolean afectaAEnemigo, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.afectaAEnemigo = afectaAEnemigo;
        this.tipo = tipo;
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
    }
}
