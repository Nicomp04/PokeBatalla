package org.example.Tipo;

import java.util.HashMap;

public class Electrico extends Tipo{
    public Electrico(){

        this.id = "Electrico";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 2.0);
        efectividad.put("Bicho", 1.0);
        efectividad.put("Dragon", 0.5);
        efectividad.put("Electrico", 0.5);
        efectividad.put("Fantasma", 1.0);
        efectividad.put("Fuego", 1.0);
        efectividad.put("Hielo", 1.0);
        efectividad.put("Lucha", 1.0);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 0.5);
        efectividad.put("Psiquico", 1.0);
        efectividad.put("Roca", 1.0);
        efectividad.put("Tierra", 0.0);
        efectividad.put("Veneno", 1.0);
        efectividad.put("Volador", 2.0);
    }
}