package org.example.Habilidades;

import org.example.Estado.Estado;
import org.example.Pokemon.Pokemon;

public class Efecto extends Habilidad{
    private Estado estado;

    public Efecto(String nombre, int energia, Estado estado) {
        this.estado = estado;
        this.nombre = nombre;
        this.energia = energia;
    }

    public void usarHabilidad(Pokemon pokemon){
        pokemon.cambiarEstado(this.estado);
    }
}
