package org.example.Vista;

import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;

import java.util.List;

public class PokemonVista {
    public void mostrarMensaje(String mensaje) {
            System.out.println(mensaje);
    }
    public void mostrarHabilidades(List<Habilidad> habilidades) {
        mostrarMensaje("Es su turno, ¿qué habilidad quiere realizar?");
        for (int i = 0; i < habilidades.size(); i++) {
            mostrarMensaje((i + 1) + ": " + habilidades.get(i).getNombre());
        }
    }
    public void mostrarVida(Pokemon pokemon) {
        mostrarMensaje("El pokemon " + pokemon.getNombre() + " tiene " + pokemon.getVidaActual() + " de vida.");
    }

    public void mostrarDerrotado() {
        mostrarMensaje("El pokemon fue derrotado.");
    }

    public void mostrarse(Pokemon pokemon, int num){
        mostrarMensaje("- " + String.valueOf(num));
        mostrarMensaje("Nombre: " + pokemon.getNombre());
        mostrarMensaje("Tipo: " + pokemon.getTipo().getId());
        mostrarMensaje("Estados: ");
        for (Estados estados : pokemon.getEstados())
            mostrarMensaje(" - " + estados.name());
        mostrarMensaje("Vida: " + pokemon.getVidaActual());
        mostrarMensaje("Ataque: " + pokemon.getAtaque());
        mostrarMensaje("Defensa: " + pokemon.getDefensa());
        mostrarMensaje("Nivel: " + pokemon.getNivel());
        mostrarMensaje("--------------------------------------");
    }
}

