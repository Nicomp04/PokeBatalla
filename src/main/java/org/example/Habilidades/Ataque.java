package org.example.Habilidades;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;
import java.util.Random;

public class Ataque extends Habilidad{
    private Tipo tipo;
    private int poder;

    public Ataque(String nombre, int energia, Tipo tipo, int poder) {
        this.tipo = tipo;
        this.poder = poder;
        this.nombre = nombre;
        this.energia = energia;
    }

    public void usarHabilidad(Pokemon pokemon, int lvl, int ataque, Tipo tipo){
        int daño = 2 * lvl * calcularCritico() * this.poder * (ataque / pokemon.getDefensa());
        daño = ( (daño / 5) + 2 ) / 50;
        daño = daño * mismoTipo() * tipo.calcularEfectividad(pokemon.getTipo()); // A implementar
        pokemon.modificarHp(-1 * daño);
    }
    private int calcularCritico(){
        Random rand = new Random();
        double probabilidad = rand.nextDouble();
        if (probabilidad < 0.009) { // 0.9% de probabilidad
            return 2;
        } else {
            return 1;
        }
    }
}
