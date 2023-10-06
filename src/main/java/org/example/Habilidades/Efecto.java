package org.example.Habilidades;

import org.example.Estado.Estados;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Efecto extends Habilidad{
    private Estados estado;

    final Logger logger = LoggerFactory.getLogger(Efecto.class);

    public Efecto(String nombre, int usosDisponibles, Estados estado,boolean afectaAenemigo) {
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estado = estado;
        this.atacaAEnemigo = false;
        this.afectaAEnemigo = afectaAenemigo;
    }

    @Override
    public void usarEnPokemon(Pokemon pokemonPropio, Pokemon objetivo) {
        if(afectaAEnemigo){
            if (objetivo.tieneUnEstado()) {
                logger.info("El pokemon ya tiene su estado alterado");
            }
            else{
                objetivo.cambiarEstado(this.estado);
            }
        }else{
            pokemonPropio.cambiarEstado(this.estado);
        }
    }
}
