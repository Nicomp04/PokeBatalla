package org.example.Estado;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;

public class Envenenado implements EstadoPokemon {
    private boolean agotado;

    public Envenenado(){
        agotado = false;
    }

    @Override
    public int baliza(){
        return 0;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        double veneno = (5 * pokemon.getVidaMaxima()) / 100;
        pokemon.modificarHp(-veneno);
        System.out.println("el veneno causa efecto a " + pokemon.getNombre());
    }

    public void restarTurno(){
        //restara un turno si se desea implementar
    }
    public String getNombre(){
        return "Envenenado";
    }
    public String getDuracion(){
        return "-";
    }
    public boolean seAgoto(){
        return false;
    }

    public void setAgotado(boolean agotado) {
        this.agotado = agotado;
    }
    @Override
    public Image getUrl(){
        return new Image("Envenenado.png");
    }
}
