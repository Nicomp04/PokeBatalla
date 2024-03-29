package org.example.Item;

import org.example.Item.Item;
import org.example.Jugador;
import org.example.Pokemon.Pokemon;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Revivir extends Item {
    final Logger logger = LoggerFactory.getLogger(Revivir.class);
    public Revivir(int id){
        this.id = id;
        this.nombre = "Revivir";

    }

    @Override
    public void aplicarItem(Pokemon pokemon) {
            pokemon.revivir();
            logger.info("{} ha sido revivido.", pokemon);
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
        List<Pokemon> pokemonesMuertos = new ArrayList<>();

        Pokemon pokemon = new Pokemon();
        for(int i = 0; i < pokemones.size(); i++){
            pokemon = pokemones.get(i);
            if(pokemon.estaMuerto()){
                pokemonesMuertos.add(pokemon);
            }
        }
        if(pokemonesMuertos.isEmpty()){
            logger.info("No tienes Pokemones a revivir, el turno se consumio igual.");
        }
        return pokemonesMuertos;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Revivir clonedRevivir = (Revivir) super.clone();

        return clonedRevivir;
    }
}
