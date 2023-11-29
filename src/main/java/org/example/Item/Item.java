package org.example.Item;

import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {

    protected int usos;

    protected String nombre;
    protected boolean usado = false;

    public final Logger logger = LoggerFactory.getLogger(Revivir.class);
    public String getNombre() {
        return nombre;
    }

    public boolean seAcabo(){return this.usos <= 0;}

   // public abstract void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo);
    public abstract void aplicarItem(List<Pokemon> pokemones);

    public int getUsos() {return this.usos;}

    public void setUsos(int usos) {this.usos = usos;}
}
