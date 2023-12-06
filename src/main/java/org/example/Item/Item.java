package org.example.Item;

import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Item implements Cloneable{

    protected int usos;

    protected String nombre;
    protected boolean usado = false;

    public final Logger logger = LoggerFactory.getLogger(Revivir.class);
    protected String desc;

    public String getNombre() {
        return nombre;
    }

    public boolean seAcabo(){return this.usos <= 0;}

   // public abstract void aplicarItem(Pokemon pokemonPropio, Pokemon pokemonObjetivo);
    public abstract void aplicarItem(Pokemon pokemon);
    public abstract List<Pokemon> posiblesPokemonesAAplicar(List<Pokemon> pokemones);

    public int getUsos() {return this.usos;}

    public void setUsos(int usos) {this.usos = usos;}

    public String getDesc() {return this.desc;
    }

    public void setDesc(String desc) { this.desc = desc;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Item clonedItem = (Item) super.clone();
        return clonedItem;
    }


    // Método para clonar un Item
    public Item clonar() {
        try {
            return (Item) clone();
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción si la clonación no es compatible
            e.printStackTrace();
            return null;
        }
    }
}
