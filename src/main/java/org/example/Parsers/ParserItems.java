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
        try {
            // Lee el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));

            // Parsear el JSON
            JSONArray jsonItems = new JSONArray(contenido);

            // Recorrer los items en el array JSON
            for (int i = 0; i < jsonItems.length(); i++) {
                JSONObject jsonItem = jsonItems.getJSONObject(i);
                String nombre = jsonItem.getString("nombre");
                int id = jsonItem.getInt("id");
                String estilo = jsonItem.getString("estilo");
                int valor = jsonItem.getInt("valor");

                Item item;
                if (estilo.equals("Restaurador")) {
                    item = new Restaurador(nombre, valor);
                } else if (estilo.equals("CuraTodo")) {
                    item = new CuraTodo();
                } else if (estilo.equals("Revivir")){
                    item = new Revivir();
                } else if (estilo.equals("DefensaX")) {
                    item = new DefensaX(valor);
                } else if (estilo.equals("AtaqueX")){
                    item = new AtaqueX(valor);
                } else{
                    item = null;
                }

                mapaItem.put(id, item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapaItem;
    }
}
