package org.example.Parsers;
import org.example.Clima.Clima;
import org.example.Estado.*;
import org.example.Habilidades.*;
import org.json.JSONArray;
import org.json.JSONObject;

//import javax.xml.parsers.ParserConfigurationException;
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
                int estadistica = jsonHabilidad.getInt("estadistica");
                boolean afectaAEnemigo = jsonHabilidad.getBoolean("afectaAEnemigo");
                int valor = jsonHabilidad.getInt("valor");


                String estadoInt = jsonHabilidad.getString("estado");
                EstadoPokemon estado = null;
                if(Objects.equals(estadoInt, "PARALIZADO")){
                    estado = new Paralizado();
                }else if(Objects.equals(estadoInt, "ENVENENADO")){
                    estado = new Envenenado();
                }else if(Objects.equals(estadoInt, "CONFUNDIDO")){
                    estado = new Confundido();
                }else if(Objects.equals(estadoInt, "DORMIDO")){
                    estado = new Dormido();
                }

                Habilidad habilidad; // ver de cambiar a algo mas escalable
                if (estilo.equals("Ataque")) {
                    habilidad = new Ataque(id, nombre, usos, tipo, valor);
                } else if (estilo.equals("ModificacionDeAtaque")) {
                    habilidad = new ModificarAtaque(id, nombre, usos, estadistica, valor,tipo);
                } else if (estilo.equals("ModificacionDeVida")) {
                    habilidad = new ModificarHp(id, nombre, usos, estadistica, valor,tipo);
                } else if (estilo.equals("ModificacionDeDefensa")) {
                    habilidad = new ModificarDefensa(id, nombre, usos, estadistica, valor,tipo);
                } else if (estilo.equals("ModificacionDeVelocidad")) {
                    habilidad = new ModificarVelocidad(id, nombre, usos, estadistica, valor, tipo);
                }else if(estilo.equals("CambiaClima")){
                    habilidad = new CambiaClima(id, nombre, usos, tipo);
                } else{
                    habilidad = new Efecto(id, nombre, estado, afectaAEnemigo, tipo);
                }
                mapaHabilidades.put(id, habilidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapaHabilidades;
    }
}
