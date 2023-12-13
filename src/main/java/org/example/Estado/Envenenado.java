package org.example.Estado;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;

public class Envenenado implements EstadoPokemon {
    private boolean agotado;
    private String mensaje;

    public Envenenado(){
        agotado = false;
        this.mensaje = null;
    }

    @Override
    public int baliza(){
        return 0;
    }

    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        double veneno = (5 * pokemon.getVidaMaxima()) / 100;
        pokemon.modificarHp(-veneno);
        this.mensaje = "el veneno causa efecto a " + pokemon.getNombre() + ", Pierde: " + String.format("%.2f", veneno) + " PS";
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
        return new Image("Envenenado.png");
    }

    @Override
    public String getMensaje(){
        return this.mensaje;
    }
}
