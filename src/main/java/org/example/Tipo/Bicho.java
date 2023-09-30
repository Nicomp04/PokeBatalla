package org.example.Tipo;

import java.util.HashMap;

public class Bicho extends Tipo{
    private Bicho(){
        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 1.0);
        efectividad.put("Bicho", 1.0);
        efectividad.put("Dragon", 1.0);
        efectividad.put("Electico", 1.0);
        efectividad.put("Fantasma", 0.5);
        efectividad.put("Fuego", 0.5);
        efectividad.put("Hielo", 1.0);
        efectividad.put("Lucha", 0.5);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 2.0);
        efectividad.put("Psiquico", 2.0);
        efectividad.put("Roca", 1.0);
        efectividad.put("Tierra", 1.0);
        efectividad.put("Veneno", 2.0);
        efectividad.put("Volador", 0.5);
    }
}
