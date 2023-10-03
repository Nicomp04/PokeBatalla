package org.example.Tipo;

import java.util.HashMap;

public class Fuego extends Tipo{
    public Fuego(){

        this.id = "Fuego";

        this.efectividad = new HashMap<>();
        efectividad.put("Agua", 0.5);
        efectividad.put("Bicho", 2.0);
        efectividad.put("Dragon", 0.5);
        efectividad.put("Electico", 1.0);
        efectividad.put("Fantasma", 1.0);
        efectividad.put("Fuego", 0.5);
        efectividad.put("Hielo", 2.0);
        efectividad.put("Lucha", 1.0);
        efectividad.put("Normal", 1.0);
        efectividad.put("Planta", 2.0);
        efectividad.put("Psiquico", 1.0);
        efectividad.put("Roca", 0.5);
        efectividad.put("Tierra", 1.0);
        efectividad.put("Veneno", 1.0);
        efectividad.put("Volador", 1.0);
    }
}
