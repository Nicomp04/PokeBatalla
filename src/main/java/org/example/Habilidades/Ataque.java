package org.example.Habilidades;
import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;
import org.example.Tipo.TipoFactory;
import org.example.Vista.HabildadVista;
import org.example.Visitor;

import java.util.Random;

public class Ataque extends Habilidad {
    private Tipo tipo;
    private int poder;
    private TipoFactory tipoFactory;

    private HabildadVista habilidadVista;


    public Ataque(int id, String nombre, int usosDisponibles, String tipo, int poder) {
        this.id = id;
        this.tipo = TipoFactory.getTipo(tipo);
        this.poder = poder;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.atacaAEnemigo = true;
        this.afectaAEnemigo = false;

        this.habilidadVista = new HabildadVista();
    }

    @Override
    public void aceptar(Visitor visitor, Pokemon atacante, Pokemon objetivo, Clima clima) {
        visitor.visitAtaque(this, atacante, objetivo,clima);
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
    public void usarEnPokemon(Pokemon atacante, Pokemon objetivo,Clima clima) {
        Tipo tipoAtacante = atacante.getTipo();
        Tipo tipoObjetivo = objetivo.getTipo();

        double efectividad = tipoAtacante.getEfectividad(tipoObjetivo.getId());

        double danio = 2.0 * atacante.getNivel() * calcularCritico() * this.poder * (atacante.getAtaque()/objetivo.getDefensa()) ;
        danio = ( (danio / 5) + 2 ) / 50;
        danio = danio * mismoTipo(atacante.getTipo()) * efectividad * rand();

        danio = danio + clima.mejoraPorTipo(atacante,danio);
        objetivo.serAtacado(danio);
        habilidadVista.mostarDanio(danio);
    }



    private double rand() {
        Random random = new Random();
        int randomNum = random.nextInt(39) + 217;
        double resultado = randomNum * 1.0;
        resultado = resultado / 255.0;
        return resultado;
    }
}
