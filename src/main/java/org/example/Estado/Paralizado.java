package org.example.Estado;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;

import java.util.Random;

public class Paralizado implements EstadoPokemon{
    private int baliza;

    private boolean agotado;
    private String mensaje;

    public Paralizado() {
        this.mensaje = null;
    }

    @Override
    public int baliza(){
        return this.baliza;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        Random rand = new Random();
        if (rand.nextDouble() <= 0.5) {
            this.mensaje = "¡El Pokémon está paralizado y no puede realizar la habilidad seleccionada!";
            this.baliza = 1;
        } else {
            this.mensaje = "El Pokémon resistio la paralisis.";
            this.baliza = 0;
        }
    }

    public void restarTurno(){
        //restara un turno si se desea implementar
    }

    public String getNombre(){
        return "Envenenado";
    }
    public int getDuracion(){
        return -1;
    }
    public boolean seAgoto(){
        return false;
    }

    public void setAgotado(boolean agotado) {
        this.agotado = agotado;
    }
    @Override
    public Image getUrl(){
        return new Image("Paralizado.png");
    }

    @Override
    public String getMensaje(){
        return this.mensaje;
    }
}
