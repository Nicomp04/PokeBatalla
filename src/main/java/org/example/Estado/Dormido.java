package org.example.Estado;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;

import java.util.Random;

public class Dormido implements EstadoPokemon {
    private int duracion;
    private int baliza;

    private boolean agotado;
    private String mensaje;

    public Dormido() {
        this.duracion = 0;
        this.mensaje = null;
    }

    @Override
    public int baliza(){
        return this.baliza;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        Random rand = new Random();
        double probDespertar = 0.25 + (this.duracion * 0.25);
        if (rand.nextDouble() <= probDespertar || this.duracion >= 4) {
            this.mensaje = "¡El Pokémon se ha despertado!";
            this.baliza = 0;
        } else {
            this.mensaje = "El Pokémon sigue dormido.";
            this.baliza = 1;
        }
        restarTurno();
    }

    public void restarTurno(){
        this.duracion = duracion +1;
    }
    public String getNombre(){
        return "Dormido";
    }
    public int getDuracion(){
        return duracion;
    }
    public boolean seAgoto(){
        return this.duracion >= 4;
    }
    @Override
    public Image getUrl(){
        return new Image("Dormido.png");
    }

    public void setDuracion(int i) {
        this.duracion = i;
    }
    @Override
    public String getMensaje(){
        return this.mensaje;
    }
}