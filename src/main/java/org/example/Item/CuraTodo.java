package org.example.Item;

import org.example.Pokemon.Pokemon;
import org.json.simple.JSONObject;

import java.util.List;

public class CuraTodo extends Item {
    public CuraTodo(int id){
        this.id = id;
        this.nombre = "CuraTodo";
    }


    @Override
    public void aplicarItem(Pokemon pokemon) {
        pokemon.getEstados().clear();
        this.setUsos(this.usos - 1);
    }

    @Override
    public JSONObject getJSON() {
        JSONObject jsonItem = new JSONObject();
        jsonItem.put("id", id);
        jsonItem.put("usos", getUsos());
        return jsonItem;
    }

    @Override
    public List<Pokemon> posiblesPokemonesAAplicar(List<Pokemon> pokemones) {
        return pokemones;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        CuraTodo clonedCura = (CuraTodo) super.clone();

        return clonedCura;
    }
}
