package org.example.Estado;

import org.example.Campo;
import org.example.Pokemon.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estado {
    private List<Estados> estados;
    final Logger logger = LoggerFactory.getLogger(Campo.class);

    public Estado() {
        this.estados = new ArrayList<>();
    }

    public boolean estadoExistente(Estados estado){
        return this.estados.contains(estado);
    }

    public void agregarEstado(Estados estado) {
        if (!estadoExistente(estado)){
            this.estados.add(estado);
        }
    }

    public void quitarEstado(Estados estado){
        if (!estadoExistente(estado)){   // lugar perfecto para agregar una excepcion
            this.estados.remove(estado);
        }
    }

    public void resetEstado(){
        this.estados.clear();
    }

    public boolean hayEstados(){
        return this.estados.isEmpty();
    }

    public String EstadosAString(){
        StringBuilder resultado = new StringBuilder();
        for (Estados i : estados) {
            resultado.append(i.name()).append(" ");
        }
        return resultado.toString();
    }

    public boolean validarEstadoDespierto(){
        if(estadoExistente(Estados.DORMIDO)) {
            logger.info("el pokemon esta Dormido, No Puede Atacar");
            quitarEstado(Estados.DORMIDO);// falta agregar lo del contador de turnos.
            return false;
        }
        return true;
    }

    public boolean validarEstadoParalizado(){
        if (estadoExistente(Estados.PARALIZADO)){
            Random random = new Random();
            double valorAleatorio = random.nextDouble();
            if (valorAleatorio < 0.5)
                logger.info("el pokemon esta paralizado, No Puede Moverse!!!");
            return true;
        }
        return false;
    }

    public void validarEstadoEnvenenado(Pokemon pokemon){
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        if(estadoExistente(Estados.ENVENENADO)){
            double resto = ((pokemon.getVidaActual() * 5) / 100);
            pokemon.modificarHp(-resto);
            logger.info("El pokemon {} esta Envenenado, pierde {} de vida", pokemon.getNombre(), resto);
        }
    }

    public boolean validarEstadoConfundido(Pokemon pokemon){
        Random random = new Random();
        double valorAleatorio = random.nextDouble();
        if(estadoExistente(Estados.CONFUNDIDO)  && valorAleatorio < 0.3){
            double resto = ((pokemon.getVidaActual() * 15) / 100);
            pokemon.modificarHp(-resto);
            logger.info("El pokemon {} esta Confundido, esta tan confundido que se hirio asi mismo y pierde {} de vida", pokemon.getNombre(), resto);
            return true;
        }
        return false;
    }

    public String mostrarEstados(){
        if (!hayEstados()) {
            return "Normal";
        }else {
            return EstadosAString();
        }
    }
}
