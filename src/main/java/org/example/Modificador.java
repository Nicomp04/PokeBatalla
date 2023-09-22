package org.example;

abstract class Modificador extends Item{
    protected int porcentaje;

    public void Restaurador(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
