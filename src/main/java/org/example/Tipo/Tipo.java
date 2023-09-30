package org.example.Tipo;

import java.util.Map;

public abstract class Tipo {
    protected String id;
    protected Map<String, Double> efectividad;

    public Double getEfectividad(String tipo){

        return efectividad.get(tipo);
    }
    public String getId(){
        return id;
    }
}
