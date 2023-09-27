package org.example.Habilidades;

import org.example.Estado.Estado;
import org.example.Pokemon.Pokemon;

public class Efecto extends Habilidad{
    private Estado estado;

    public Efecto(String nombre, int usosDisponibles, Estado estado) {
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estado = estado;
    }

    public void usarHabilidad(Pokemon pokemon){
        pokemon.cambiarEstado(this.estado);
    }
}