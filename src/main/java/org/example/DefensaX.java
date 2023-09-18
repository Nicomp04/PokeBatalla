package org.example;

public class Modificador extends Item{

    private Int mejora;

    public Modificador(Int mejora) { // Porcentaje de mejora de Ataque o Defensa
        this.mejora = mejora;
    }

    @Override
    public void aplicarItem(Pokemon pokemon) {

    }
}
