package org.example.Parsers;
import org.example.Estado.Estados;
import org.example.Habilidades.Ataque;
import org.example.Habilidades.Efecto;
import org.example.Habilidades.Habilidad;
import org.example.Habilidades.Modificacion;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ParserHabilidad {
    public Map<Integer, Habilidad> parsearHabilidades(String nombreArchivo) {
        Map<Integer, Habilidad> mapaHabilidades = new HashMap<>();
        try {
            // Lee el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));

            // Parsear el JSON
            JSONArray jsonHabilidades = new JSONArray(contenido);

            // Recorrer las habilidades en el array JSON
            for (int i = 0; i < jsonHabilidades.length(); i++) {
                JSONObject jsonHabilidad = jsonHabilidades.getJSONObject(i);
                int id = jsonHabilidad.getInt("id");
                String nombre = jsonHabilidad.getString("nombre");
                int usos = jsonHabilidad.getInt("usos");
                String estilo = jsonHabilidad.getString("estilo");
                String tipo = jsonHabilidad.getString("tipo");
                int estadistica = jsonHabilidad.getInt("estadistica");
                boolean afectaAEnemigo = jsonHabilidad.getBoolean("afectaAEnemigo");
                int valor = jsonHabilidad.getInt("valor");
                String estadoInt = jsonHabilidad.getString("estado");
                Estados estado = Estados.valueOf(estadoInt);

                Habilidad habilidad;
                if (estilo.equals("Ataque")) {
                    habilidad = new Ataque(id, nombre, usos, tipo, valor);
                } else if (estilo.equals("Modificacion")) {
                    habilidad = new Modificacion(id, nombre, usos, estadistica, valor);
                } else{
                    habilidad = new Efecto(id, nombre, usos, estado,afectaAEnemigo,tipo);
                }
                mapaHabilidades.put(id, habilidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapaHabilidades;
    }
}
