package org.example.Parsers;

import org.example.Estado.*;
import org.example.Habilidades.*;
import org.example.Habilidades.Habilidad;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

                // Utiliza la clase base y sus extensiones según el estilo
                Habilidad habilidad = crearHabilidadSegunEstilo(id, nombre, usos, estilo, tipo, jsonHabilidad);

                mapaHabilidades.put(id, habilidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapaHabilidades;
    }
    private Habilidad crearHabilidadSegunEstilo(int id, String nombre, int usos, String estilo, String tipo, JSONObject jsonHabilidad) {
        switch (estilo) {
            case "Ataque":
                return crearAtaque(id, nombre, usos, tipo, jsonHabilidad.getInt("valor"));
            case "ModificacionDeAtaque":
                return crearModificacionDeAtaque(id, nombre, usos, tipo, jsonHabilidad.getInt("estadistica"), jsonHabilidad.getInt("valor"));
            case "ModificacionDeVida":
                return crearModificacionDeVida(id, nombre, usos, tipo, jsonHabilidad.getInt("estadistica"), jsonHabilidad.getInt("valor"));
            case "ModificacionDeDefensa":
                return crearModificacionDeDefensa(id, nombre, usos, tipo, jsonHabilidad.getInt("estadistica"), jsonHabilidad.getInt("valor"));
            case "ModificacionDeVelocidad":
                return crearModificacionDeVelocidad(id, nombre, usos, tipo, jsonHabilidad.getInt("estadistica"), jsonHabilidad.getInt("valor"));
            case "CambiaClima":
                return crearCambiaClima(id, nombre, usos, tipo);
            default:
                return crearEfecto(id, nombre, usos, jsonHabilidad.getString("estado"), jsonHabilidad.getBoolean("afectaAEnemigo"), tipo);
        }
    }

    private Habilidad crearAtaque(int id, String nombre, int usos, String tipo, int valor) {
        return new Ataque(id, nombre, usos, tipo, valor);
    }

    private Habilidad crearModificacionDeAtaque(int id, String nombre, int usos, String tipo, int estadistica, int valor) {
        return new ModificarAtaque(id, nombre, usos, estadistica, valor, tipo);
    }

    private Habilidad crearModificacionDeVida(int id, String nombre, int usos, String tipo, int estadistica, int valor) {
        return new ModificarHp(id, nombre, usos, estadistica, valor, tipo);
    }

    private Habilidad crearModificacionDeDefensa(int id, String nombre, int usos, String tipo, int estadistica, int valor) {
        return new ModificarDefensa(id, nombre, usos, estadistica, valor, tipo);
    }

    private Habilidad crearModificacionDeVelocidad(int id, String nombre, int usos, String tipo, int estadistica, int valor) {
        return new ModificarVelocidad(id, nombre, usos, estadistica, valor, tipo);
    }

    private Habilidad crearCambiaClima(int id, String nombre, int usos, String tipo) {
        return new CambiaClima(id, nombre, usos, tipo);
    }

    private Habilidad crearEfecto(int id, String nombre, int usos, String estado, boolean afectaAEnemigo, String tipo) {

        EstadoPokemon estadoNuevo = switch (estado) {
            case "PARALIZADO" -> new Paralizado();
            case "ENVENENADO" -> new Envenenado();
            case "CONFUNDIDO" -> new Confundido();
            case "DORMIDO" -> new Dormido();
            default -> null;
        };

        return new Efecto(id, nombre, estadoNuevo, afectaAEnemigo, tipo);
    }

}
