package org.example.Tipo;

import java.util.Map;

public abstract class Tipo {
    protected Map<String, Double> efectividad;

    public Double getEfectividad(Tipo tipo){
        return efectividad.get(tipo);
    }
}
