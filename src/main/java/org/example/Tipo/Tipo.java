package org.example.Tipo;

import java.util.HashMap;

public abstract class Tipo {
    protected String id;
    protected String tipo;
    protected HashMap efectividad;

    public String getId() {
        return this.id;
    }

    public double getEfectividad(String tipo) {
        return (double) efectividad.get(tipo);
    }


}
