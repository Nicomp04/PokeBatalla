package org.example;

import org.example.Habilidades.Ataque;
import org.example.Habilidades.Efecto;
import org.example.Habilidades.Habilidad;
import org.example.Habilidades.Modificacion;
import org.example.Item.DefensaX;
import org.example.Item.Item;
import org.example.Item.Restaurador;
import org.example.Item.curaTodo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                    item = new Restaurador(id, nombre, valor);
                } else if (estilo.equals("curaTodo")) {
                    item = new curaTodo(id, nombre);
                } else{
                    item = new DefensaX(id, valor);
                }
                mapaItem.put(id, item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapaItem;
    }
}
