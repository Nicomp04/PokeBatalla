package org.example.Tipo;

import java.util.HashMap;

public class Lucha extends Tipo{
    public Lucha(){

        this.id = "Lucha";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 1.0);
        efectividad.put("Bicho", 0.5);
        efectividad.put("Dragon", 1.0);
        efectividad.put("Electico", 1.0);
        efectividad.put("Fantasma", 0.0);
        efectividad.put("Fuego", 1.0);
        efectividad.put("Hielo", 2.0);
        efectividad.put("Lucha", 1.0);
        efectividad.put("Normal", 2.0);
        efectividad.put("Planta", 1.0);
        efectividad.put("Psiquico", 0.5);
        efectividad.put("Roca", 2.0);
        efectividad.put("Tierra", 1.0);
        efectividad.put("Veneno", 0.5);
        efectividad.put("Volador", 0.5);
    }
}
