package org.example.Tipo;

import java.util.HashMap;

public class Hielo extends Tipo{
    public Hielo(){

        this.id = "Hielo";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 0.5);
        efectividad.put("Bicho", 1.0);
        efectividad.put("Dragon", 2.0);
        efectividad.put("Electrico", 1.0);
        efectividad.put("Fantasma", 1.0);
        efectividad.put("Fuego", 1.0);
        efectividad.put("Hielo", 0.5);
        efectividad.put("Lucha", 1.0);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 2.0);
        efectividad.put("Psiquico", 1.0);
        efectividad.put("Roca", 1.0);
        efectividad.put("Tierra", 2.0);
        efectividad.put("Veneno", 1.0);
        efectividad.put("Volador", 2.0);
    }
}
