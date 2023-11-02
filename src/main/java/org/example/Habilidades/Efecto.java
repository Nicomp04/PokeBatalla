package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Estado.Estados;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.Visitor;

public class Efecto extends Habilidad{
    private Estados estado;

    final Logger logger = LoggerFactory.getLogger(Efecto.class);

    public Efecto(int id, String nombre, int usosDisponibles, Estados estado) {
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estado = estado;
        this.atacaAEnemigo = false;
        this.afectaAEnemigo = true;
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo) {
        visitor.visitEfecto(this, atacante, objetivo);
    }
    @Override
    public void usarEnPokemon(Pokemon pokemonPropio, Pokemon objetivo) {
        if(afectaAEnemigo){
            if (objetivo.getEstado().estadoExistente(this.estado)) {
                logger.info("El pokemon ya tiene este estado alterado");
            }
            else{
                objetivo.getEstado().agregarEstado(this.estado);
            }
        }else{
            pokemonPropio.getEstado().agregarEstado(this.estado);
        }
    }
}
