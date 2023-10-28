package org.example.Habilidades;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;
import org.example.Tipo.TipoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.Visitor;

import java.util.Random;

public class Ataque extends Habilidad {
    private Tipo tipo;
    private int poder;
    private TipoFactory tipoFactory;
    final Logger logger = LoggerFactory.getLogger(Ataque.class);

    public Ataque(int id, String nombre, int usosDisponibles, String tipo, int poder) {
        this.id = id;
        this.tipo = TipoFactory.getTipo(tipo);
        this.poder = poder;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.atacaAEnemigo = true;
        this.afectaAEnemigo = false;
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo) {
        visitor.visitAtaque(this, atacante, objetivo);
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
        logger.info("Calculando daño...");
        double efectividad = tipoAtacante.getEfectividad(tipoObjetivo.getId());

        double danio = 2.0 * atacante.getNivel() * calcularCritico() * this.poder * (atacante.getAtaque()/objetivo.getDefensa()) ;
        danio = ( (danio / 5) + 2 ) / 50;
        danio = danio * mismoTipo(atacante.getTipo()) * efectividad * rand();

        logger.info("El daño causado al oponente es de {}", danio);

        objetivo.serAtacado(danio);
    }



    private double rand() {
        Random random = new Random();
        int randomNum = random.nextInt(39) + 217;
        double resultado = randomNum * 1.0;
        resultado = resultado / 255.0;
        return resultado;
    }
}
