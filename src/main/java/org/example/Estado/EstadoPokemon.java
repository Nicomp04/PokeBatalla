package org.example.Estado;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;

public interface EstadoPokemon {
    void aplicarEfecto(Pokemon pokemon);
    int baliza();
    void restarTurno();
    String getNombre();
    int getDuracion();
    boolean seAgoto();
    Image getUrl();
}

