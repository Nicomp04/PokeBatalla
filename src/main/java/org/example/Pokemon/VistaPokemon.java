package org.example.Pokemon;

import org.example.Habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

public class VistaPokemon {
        public void mostrarMensaje(String mensaje) {
            System.out.println(mensaje);
        }

        public void mostrarHabilidades(List<Habilidad> habilidades) {
            mostrarMensaje("Es su turno, ¿qué habilidad quiere realizar?");
            for (int i = 0; i < habilidades.size(); i++) {
                mostrarMensaje((i + 1) + ": " + habilidades.get(i).getNombre());
            }
        }
    }

