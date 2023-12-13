package org.example.Parsers;

import org.example.Item.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ParserItems {
    public Map<Integer, Item> parsearItems(String nombreArchivo) {
        Map<Integer, Item> mapaItem = new HashMap<>();
        Map<Integer, Item> plantillasItems = new HashMap<>();

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));


            JSONArray jsonItems = new JSONArray(contenido);

            for (int i = 0; i < jsonItems.length(); i++) {
                JSONObject jsonItem = jsonItems.getJSONObject(i);
                String nombre = jsonItem.getString("nombre");
                int id = jsonItem.getInt("id");
                String estilo = jsonItem.getString("estilo");
                String desc = jsonItem.getString("desc");
                int valor = jsonItem.getInt("valor");

                Item plantilla = plantillasItems.get(id);

                if (plantilla == null) {
                    plantilla = crearItemSegunEstilo(id,estilo, valor,nombre);
                    plantillasItems.put(id, plantilla);
                }

                Item item = plantilla.clonar();
                item.setDesc(desc);

                mapaItem.put(id, item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapaItem;
    }

    private Item crearItemSegunEstilo(int id,String estilo, int valor, String nombre) {
        Item item;
        if (estilo.equals("Restaurador")) {
            item = new Restaurador(id,nombre, valor);
            item.setUsos(2);
        } else if (estilo.equals("CuraTodo")) {
            item = new CuraTodo(id);
            item.setUsos(2);
        } else if (estilo.equals("Revivir")) {
            item = new Revivir(id);
            item.setUsos(1);
        } else if (estilo.equals("DefensaX")) {
            item = new DefensaX(id, valor);
            item.setUsos(1);
        } else if (estilo.equals("AtaqueX")) {
            item = new AtaqueX(id, valor);
            item.setUsos(1);
        } else {
            item = null;
        }
        return item;
    }
}
