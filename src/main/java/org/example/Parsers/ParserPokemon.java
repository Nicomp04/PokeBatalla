package org.example.Parsers;

import org.example.Pokemon.Pokemon;
import org.example.Habilidades.RepositorioHabilidades;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserPokemon {
    public Map<Integer, Pokemon> parsearPokemones(String nombreArchivo, RepositorioHabilidades repositorioHabilidades) {
        Map<Integer, Pokemon> pokemonesMap = new HashMap<>();
        Map<Integer, Pokemon> plantillasPokemones = new HashMap<>();

        try {
            // Lee el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));

            // Parsear el JSON
            JSONObject jsonObject = new JSONObject(contenido);
            JSONArray pokemones = jsonObject.getJSONArray("pokemones");

            // Recorrer los objetos Pokemon en el array
            for (int i = 0; i < pokemones.length(); i++) {
                JSONObject jsonPokemon = pokemones.getJSONObject(i);
                String nombre = jsonPokemon.getString("nombre");
                int id = jsonPokemon.getInt("id");
                int nivel = jsonPokemon.getInt("nivel");
                String tipo = jsonPokemon.getString("tipo");
                String historia = jsonPokemon.getString("historia");
                int vidaMaxima = jsonPokemon.getInt("vidaMaxima");
                int velocidad = jsonPokemon.getInt("velocidad");
                int defensa = jsonPokemon.getInt("defensa");
                int ataque = jsonPokemon.getInt("ataque");
                JSONArray habilidadesJSON = jsonPokemon.getJSONArray("habilidades");
                String url = jsonPokemon.getString("url");
                List<Integer> habilidades = new ArrayList<>();
                for (int j = 0; j < habilidadesJSON.length(); j++) {
                    habilidades.add(habilidadesJSON.getInt(j));
                }

                // Verificar si ya existe una plantilla para esta especie de Pokémon
                Pokemon plantilla = plantillasPokemones.get(id);

                if (plantilla == null) {
                    // Si no existe, crear una nueva plantilla y almacenarla en el mapa
                    plantilla = new Pokemon(nombre, id, tipo, nivel, vidaMaxima, velocidad, defensa, ataque, habilidades, repositorioHabilidades, url);
                    plantillasPokemones.put(id, plantilla);
                }

                // Clonar la plantilla para obtener una nueva instancia
                Pokemon pokemon = plantilla.clonar();

                // Puedes ajustar cualquier propiedad específica que necesites

                // Almacenar la nueva instancia en el mapa
                pokemonesMap.put(id, pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemonesMap;
    }
}
