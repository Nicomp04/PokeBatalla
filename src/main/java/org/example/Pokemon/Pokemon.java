package org.example.Pokemon;

import org.example.Estado.Estado;
import org.example.Habilidad.Habilidad;
import org.example.Tipo.Tipo;

import java.util.List;

public class Pokemon {
    private String nombre;
    private int nivel;
    private Tipo tipo;
    private String historia;
    private int vidaMaxima;
    private int vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;
    private List<Habilidad> habilidades;
    private Estado estado;


    public Pokemon(String nombre, int nivel, Tipo tipo, String historia, int vidaMaxima, int velocidad, int defensa, int ataque, List<Habilidad> habilidades, Estado estado){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.historia = historia;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidades =habilidades;
        this.estado = estado;
    }


    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public void modificarHp(int hp) {
        this.vidaMaxima = hp;
    }

    public void revivir() {
        this.vidaActual = vidaMaxima;
    }

    public void modificarDefensa(int porcentaje) {
        this.defensa = porcentaje;
    }

    public void modificarAtaque(int porcentaje) {
        this.ataque = porcentaje;
    }

    public int getVelocidad() {
        return this.velocidad;
    }






}