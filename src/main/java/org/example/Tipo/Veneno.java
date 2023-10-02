package org.example.Tipo;

import java.util.HashMap;

public class Veneno extends Tipo{
    private Veneno(){

        this.id = "Veneno";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 1.0);
        efectividad.put("Bicho", 2.0);
        efectividad.put("Dragon", 1.0);
        efectividad.put("Electico", 1.0);
        efectividad.put("Fantasma", 0.5);
        efectividad.put("Fuego", 1.0);
        efectividad.put("Hielo", 1.0);
        efectividad.put("Lucha", 1.0);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 2.0);
        efectividad.put("Psiquico", 1.0);
        efectividad.put("Roca", 0.5);
        efectividad.put("Tierra", 0.5);
        efectividad.put("Veneno", 0.5);
        efectividad.put("Volador", 1.0);
    }
}
