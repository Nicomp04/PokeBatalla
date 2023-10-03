package org.example.Habilidades;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;
import java.util.Random;

public class Ataque extends Habilidad {
    private Tipo tipo;
    private int poder;

    public Ataque(String nombre, int usosDisponibles, Tipo tipo, int poder) {
        this.tipo = tipo;
        this.poder = poder;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
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

    public double mismoTipo(Tipo tipoDelPokemon){
        if (tipoDelPokemon == this.tipo){
            return 1.5;
        }
        return 1.0;
    }
    @Override
    public void usarEnPokemon(Pokemon atacante, Pokemon objetivo) {
        Tipo tipoAtacante = atacante.getTipo();
        Tipo tipoObjetivo = objetivo.getTipo();

        double danio = 2.0 * atacante.getNivel() * calcularCritico() * this.poder * (atacante.getAtaque()/objetivo.getDefensa()) ;
        danio = ( (danio / 5) + 2 ) / 50;
        danio = danio * mismoTipo(atacante.getTipo()) * tipoAtacante.getEfectividad(tipoObjetivo.getId()) * rand();

        objetivo.modificarHp(-danio);
    }

    @Override
    public void usarEnPokemon(Pokemon pokemon) {

    }


    private double rand() {
        Random random = new Random();
        int randomNum = random.nextInt(39) + 217;
        double resultado = randomNum * 1.0;
        resultado = resultado / 255.0;
        return resultado;
    }
}
