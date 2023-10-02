package org.example.Tipo;

import java.util.HashMap;

public abstract class Tipo {
    protected String id;
    protected HashMap efectividad;

    public String getId() {
        return id;
    }

    public double getEfectividad(String tipo) {
        return (double) efectividad.get(tipo);
    }
}
