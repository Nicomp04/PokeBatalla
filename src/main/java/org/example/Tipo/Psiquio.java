package org.example.Tipo;

import java.util.HashMap;

public class Psiquio extends Tipo{
    public Psiquio(){

        this.id = "Psiquio";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 1.0);
        efectividad.put("Bicho", 1.0);
        efectividad.put("Dragon", 1.0);
        efectividad.put("Electrico", 1.0);
        efectividad.put("Fantasma", 1.0);
        efectividad.put("Fuego", 1.0);
        efectividad.put("Hielo", 1.0);
        efectividad.put("Lucha", 2.0);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 1.0);
        efectividad.put("Psiquico", 0.5);
        efectividad.put("Roca", 1.0);
        efectividad.put("Tierra", 1.0);
        efectividad.put("Veneno", 2.0);
        efectividad.put("Volador", 1.0);
    }
}
