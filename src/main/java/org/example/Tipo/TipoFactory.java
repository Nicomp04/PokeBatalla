package org.example.Tipo;

import java.util.HashMap;
import java.util.Map;

public class TipoFactory {
    private static final Map<String, Tipo> tipoMap = new HashMap<>();

    static {
        tipoMap.put("Agua", new Agua());
        tipoMap.put("Bicho", new Bicho());
        tipoMap.put("Dragon", new Dragon());
        tipoMap.put("Electrico", new Electrico());
        tipoMap.put("Hielo", new Hielo());
        tipoMap.put("Lucha", new Lucha());
        tipoMap.put("Normal", new Normal());
        tipoMap.put("Planta", new Planta());
        tipoMap.put("Psiquico", new Psiquio());
        tipoMap.put("Roca", new Roca());
        tipoMap.put("Veneno", new Veneno());
        tipoMap.put("Volador", new Volador());
        tipoMap.put("Fuego", new Fuego());
        tipoMap.put("Tierra", new Tierra());
        tipoMap.put("Fantasma", new Fantasma());

    }

    public static Tipo getTipo(String tipoNombre) {
        return tipoMap.get(tipoNombre);
    }
}
