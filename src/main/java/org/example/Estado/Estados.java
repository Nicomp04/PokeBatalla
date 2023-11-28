package org.example.Estado;

public enum Estados {
    DORMIDO,
    PARALIZADO,
    ENVENENADO,
    CONFUNDIDO;

    private int duracion;

    public void restarTurno() {
            this.duracion = duracion -1;
    }

    public String getNombre() {return this.name();}

    public int getDuracion() {return duracion;}

    public boolean seAgoto(){return duracion <= 0;}
    public void setDuracion(int usosDisponibles) {
        this.duracion = usosDisponibles;
    }
}
