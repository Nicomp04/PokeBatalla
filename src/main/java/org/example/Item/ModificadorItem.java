package org.example.Item;

abstract class ModificadorItem extends Item {
    protected int porcentaje;

    public void Restaurador(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
