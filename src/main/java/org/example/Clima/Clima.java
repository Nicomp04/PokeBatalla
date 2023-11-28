package org.example.Clima;

import org.example.Parsers.ParserClima;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Clima {

    public String nombre;
    public List<Tipo> tipos;
    private TipoClima tipoClima;
    private int turnos;


    public Clima(String nombre, TipoClima tipoClima, List<Tipo> tipos) {
        this.nombre = nombre;
        this.tipos = tipos;
        this.tipoClima = tipoClima;
        this.turnos = 5;
    }

    public Clima() {

    }

    public int getTurno() {
        return turnos;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoClima getTipoClima() {
        return tipoClima;
    }


    public void cambiar(String clima){
        ParserClima parser = new ParserClima("src/main/resources/Clima.json");
        Clima nuevoClima = parser.getClima(clima);
        this.nombre = nuevoClima.getNombre();
        this.tipos = nuevoClima.getTipos();
        this.tipoClima = nuevoClima.getTipoClima();
        this.turnos = 5;
    }

    private List<Tipo> getTipos() {
        return this.tipos;
    }


    public Clima sortearInicial(){
        Random random = new Random();
        ParserClima parser = new ParserClima("src/main/resources/Clima.json");
        double probabilidad = random.nextDouble();

        if (probabilidad < 2.0 / 3.0) {
            return parser.getClima("Normal");
        } else {
            return  parser.climaAleatorio();
        }
    }

    public void restarTurno(){
        if(turnos > 0) {
            this.turnos--;
        }
    }

    public boolean compararTipos(Pokemon pokemon){
        for(Tipo tp: tipos){
            if(Objects.equals(tp.getId(), pokemon.getTipo().getId())){
                return true;
            }
        }
        return false;
    }

    public double mejoraPorTipo(Pokemon pokemon, double ataque){
        if(compararTipos(pokemon)){
            return (ataque * 10)/100;
        }
        return 0;
    }

    public boolean esClimaPeligroso(){
        return tipoClima == TipoClima.PELIGROSO;
    }

}

