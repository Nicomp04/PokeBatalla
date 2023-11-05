package org.example.Item;

import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {


    protected String nombre;
    protected boolean usado = false;

    final Logger logger = LoggerFactory.getLogger(Revivir.class);
    public String getNombre() {
        return nombre;
    }

    public boolean getUsado(){return this.usado;}

    public void setUsado(boolean bolean){this.usado = bolean;}

    public abstract void aplicarItem(List<Pokemon> pokemones);
}
