package org.example.Parsers;

import org.example.Clima.Clima;
import org.example.Clima.TipoClima;
import org.example.Tipo.Tipo;
import org.example.Tipo.TipoFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParserClima{

    Map<Integer, Clima> mapaClimaParser = new HashMap<>();

    public ParserClima(String nombreArchivo) {
        try {
            // Lee el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));

            // Parsear el JSON
            JSONArray jsonArchivo = new JSONArray(contenido);

            // Recorrer los climas en el array JSON
            for (int i = 0; i < jsonArchivo.length(); i++) {

                JSONObject jsonClima = jsonArchivo.getJSONObject(i);
                String nombre = jsonClima.getString("nombre");
                TipoClima tipo = TipoClima.valueOf(jsonClima.getString("tipoClima"));
                JSONArray tipoJSON = jsonClima.getJSONArray("tipos");
                int id = jsonClima.getInt("id");
                String url = jsonClima.getString("url");
                List<Tipo> tipos = new ArrayList<>();
                for (int j = 0; j < tipoJSON.length(); j++) {
                    tipos.add(TipoFactory.getTipo(tipoJSON.getString(j)));
                }

                Clima clima = new Clima(nombre, tipo, tipos, url);
                this.mapaClimaParser.put(i, clima);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Clima climaAleatorio(){
        Random random = new Random();

        Collection<Clima> valores = mapaClimaParser.values();

        List<Clima> ListaValores = new ArrayList<>(valores);

        Integer indiceAleatorio = random.nextInt(ListaValores.size());

        return ListaValores.get(indiceAleatorio);
    }

    public Clima getClima(String tipo){

        Clima climaResultado = new Clima();

        Collection<Clima> valores = mapaClimaParser.values();

        List<Clima> ListaValores = new ArrayList<>(valores);

        for (Clima clima: ListaValores){
            if(Objects.equals(clima.getNombre(), tipo)){
                climaResultado = clima;
            }
        }
        return climaResultado;

    }

    public Map<Integer, Clima> getMapaClimaParser() {
        return mapaClimaParser;
    }
}
