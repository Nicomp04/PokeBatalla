package org.example.Tipo;

import java.util.HashMap;

public class Roca extends Tipo{
    private Roca(){
        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 1.0);
        efectividad.put("Bicho", 2.0);
        efectividad.put("Dragon", 1.0);
        efectividad.put("Electico", 1.0);
        efectividad.put("Fantasma", 1.0);
        efectividad.put("Fuego", 2.0);
        efectividad.put("Hielo", 2.0);
        efectividad.put("Lucha", 0.5);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 1.0);
        efectividad.put("Psiquico", 1.0);
        efectividad.put("Roca", 1.0);
        efectividad.put("Tierra", 0.5);
        efectividad.put("Veneno", 1.0);
        efectividad.put("Volador", 2.0);
    }
}
