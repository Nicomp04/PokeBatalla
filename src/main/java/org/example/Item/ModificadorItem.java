package org.example.Item;

abstract class ModificadorItem extends Item {
    protected int porcentaje;

    public ModificadorItem(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
