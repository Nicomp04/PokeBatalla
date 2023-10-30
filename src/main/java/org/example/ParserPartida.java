package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserPartida {
    public List<Jugador> parsearJugadores(String nombreArchivo) {
        List<Jugador> resultados = new ArrayList<>();
        try {
            // Lee el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));

            // Parsear el JSON
            JSONArray jsonArray = new JSONArray(contenido);

            // Recorrer los objetos de jugador en el array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonJugador = jsonArray.getJSONObject(i);
                String nombre = jsonJugador.getString("nombre");

                JSONObject items = jsonJugador.getJSONObject("items");
                List<Integer> listaItems = new ArrayList<>();
                for (String key : items.keySet()) {
                    int idItem = Integer.parseInt(key);
                    int cantidad = items.getInt(key);
                    listaItems.add(idItem);
                    listaItems.add(cantidad);
                }

                JSONArray pokemones = jsonJugador.getJSONArray("pokemons");
                List<Integer> listaPokemones = new ArrayList<>();
                for (int j = 0; j < pokemones.length(); j++) {
                    listaPokemones.add(pokemones.getInt(j));
                }

                Jugador resultado = new Jugador(nombre, listaItems, listaPokemones);

                resultados.add(resultado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultados;
    }
}
