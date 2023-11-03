package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Estado.Estados;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.Visitor;

public class Efecto extends Habilidad{
    private Estados estado;
    private String climaCambiar;

    final Logger logger = LoggerFactory.getLogger(Efecto.class);

    public Efecto(int id, String nombre, int usosDisponibles, Estados estado, boolean afectaAEnemigo, String tipo) {
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estado = estado;
        this.estado.setDuracion(usosDisponibles);
        this.atacaAEnemigo = false;
        this.afectaAEnemigo = afectaAEnemigo;
        this.climaCambiar = tipo;
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo,Clima clima) {
        visitor.visitEfecto(this, atacante, objetivo,clima);
    }
    @Override
    public void usarEnPokemon(Pokemon pokemonPropio, Pokemon objetivo, Clima clima) {
        if(afectaAEnemigo){
            if (objetivo.getEstados().contains(this.estado)) {
                logger.info("El pokemon ya tiene este estado alterado");
            }
            else{
                objetivo.agregarEstado(this.estado);
            }
        }else{
                clima.cambiar(this.climaCambiar);
        }
    }
}
