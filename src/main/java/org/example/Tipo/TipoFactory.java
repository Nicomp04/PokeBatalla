package org.example.Tipo;

import java.util.HashMap;
import java.util.Map;

public class TipoFactory {
    private static final Map<String, Tipo> tipoMap = new HashMap<>();

    static {
        tipoMap.put("agua", new Agua());
        tipoMap.put("bicho", new Bicho());
        tipoMap.put("dragon", new Dragon());
        tipoMap.put("electrico", new Electrico());
        tipoMap.put("hielo", new Hielo());
        tipoMap.put("lucha", new Lucha());
        tipoMap.put("normal", new Normal());
        tipoMap.put("planta", new Planta());
        tipoMap.put("psiquico", new Psiquio());
        tipoMap.put("roca", new Roca());
        tipoMap.put("veneno", new Veneno());
        tipoMap.put("volador", new Volador());
        tipoMap.put("fuego", new Fuego());
        tipoMap.put("tierra", new Tierra());
        tipoMap.put("fantasma", new Fantasma());

    }

    public static Tipo getTipo(String tipoNombre) {
        return tipoMap.get(tipoNombre);
    }
}
