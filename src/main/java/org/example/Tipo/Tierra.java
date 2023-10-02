package org.example.Tipo;

import java.util.HashMap;

public class Tierra extends Tipo{
    private Tierra(){

        this.id = "Tierra";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 1.0);
        efectividad.put("Bicho", 0.5);
        efectividad.put("Dragon", 1.0);
        efectividad.put("Electico", 2.0);
        efectividad.put("Fantasma", 1.0);
        efectividad.put("Fuego", 2.0);
        efectividad.put("Hielo", 1.0);
        efectividad.put("Lucha", 1.0);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 0.5);
        efectividad.put("Psiquico", 1.0);
        efectividad.put("Roca", 2.0);
        efectividad.put("Tierra", 1.0);
        efectividad.put("Veneno", 2.0);
        efectividad.put("Volador", 0.0);
    }
}
