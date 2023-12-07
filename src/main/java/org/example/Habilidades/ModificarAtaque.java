package org.example.Habilidades;

import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;

public class ModificarAtaque extends Modificacion{
    private int estadistica;

    public ModificarAtaque(int id, String nombre, int usosDisponibles, int estadistica, int valor, String tipo) {
        super(id, nombre, usosDisponibles, valor,tipo);
    }

    @Override
    public void usarEnPokemon(Pokemon propio, Pokemon enemigo, Clima clima) {

        Pokemon objetivo;

        if (afectaAEnemigo) {
            objetivo = enemigo;
        } else {
            objetivo = propio;
        }

        objetivo.setAtaque(this.valor);
        this.usosDisponibles = usosDisponibles - 1;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ModificarAtaque clonedAtaque = (ModificarAtaque) super.clone();
        // Aquí puedes realizar copias profundas de propiedades si es necesario
        return clonedAtaque;
    }

    // Método para clonar un Ataque
    @Override
    public Habilidad clonar() {
        try {
            return (ModificarAtaque) clone();
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción si la clonación no es compatible
            e.printStackTrace();
            return null;
        }
    }
}
