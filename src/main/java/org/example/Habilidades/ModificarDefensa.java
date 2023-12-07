package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;

public class ModificarDefensa extends Modificacion{
    private int estadistica;

    public ModificarDefensa(int id, String nombre, int usosDisponibles, int estadistica, int valor, String tipo) {
        super(id, nombre, usosDisponibles, valor, tipo);
    }

    @Override
    public void usarEnPokemon(Pokemon propio, Pokemon enemigo, Clima clima) {

        Pokemon objetivo;

        if (afectaAEnemigo) {
            objetivo = enemigo;
        } else {
            objetivo = propio;
        }

        objetivo.setDefensa(this.valor);
        this.usosDisponibles = usosDisponibles - 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ModificarDefensa clonedAtaque = (ModificarDefensa) super.clone();
        // Aquí puedes realizar copias profundas de propiedades si es necesario
        return clonedAtaque;
    }

    // Método para clonar un Ataque
    @Override
    public Habilidad clonar() {
        try {
            return (ModificarDefensa) clone();
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción si la clonación no es compatible
            e.printStackTrace();
            return null;
        }
    }
}
