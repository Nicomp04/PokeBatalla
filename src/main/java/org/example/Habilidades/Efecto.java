package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Clima.TipoClima;
import org.example.Estado.Estados;
import org.example.Pokemon.Pokemon;
import org.example.Visitor;

public class Efecto extends Habilidad{
    private Estados estado;
    private String climaCambiar;


    public Efecto(int id, String nombre, int usosDisponibles, Estados estado, boolean afectaAEnemigo, String tipo) {
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estado = estado;
        this.estado.setDuracion(usosDisponibles);
        this.afectaAEnemigo = afectaAEnemigo;
        this.climaCambiar = tipo;
        this.tipo = tipo;
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo,Clima clima) {
        visitor.visitEfecto(this, atacante, objetivo,clima);
    }
    @Override
    public void usarEnPokemon(Pokemon pokemonPropio, Pokemon objetivo, Clima clima) {
        if(afectaAEnemigo){
            objetivo.agregarEstado(this.estado);
        }else{
            clima.cambiar(this.climaCambiar);
        }
    }
}
