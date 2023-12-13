package org.example.Estado;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;

import java.util.Random;

public class Confundido implements EstadoPokemon {
    private int duracion;
    private int baliza;

    private boolean agotado;
    private String mensaje;

    public Confundido() {
        this.duracion = 3;
        this.mensaje = null;
    }

    @Override
    public int baliza(){
        return this.baliza;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        Random rand = new Random();
        double probabilidadHerirse = 1.0 / 3;

        if (rand.nextDouble() <= probabilidadHerirse) {
            this.mensaje = "¡El Pokémon está confuso y se hirió a sí mismo!";
            this.baliza = 1;
            double porcentajeDanio = 0.15;
            pokemon.modificarHp(-(pokemon.getVidaMaxima() * porcentajeDanio));
            restarTurno();
        } else {
            this.mensaje = "El Pokémon realizó la habilidad, Ya no esta confundido.";
            this.baliza = 0;
        }
        restarTurno();
    }

    public void restarTurno(){
        this.duracion = duracion -1;
    }
    public String getNombre(){
        return "Confundido";
    }
    public int getDuracion(){
        return duracion;
    }
    public boolean seAgoto(){
        return this.duracion <= 0;
    }
    @Override
    public Image getUrl(){
        return new Image("Confundido.png");
    }
    @Override
    public String getMensaje(){
        return this.mensaje;
    }
}