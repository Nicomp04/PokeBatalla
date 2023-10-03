package org.example.Pokemon;
import org.example.Estado.Estado;
import org.example.Estado.Normal;
import org.example.Habilidades.Ataque;
import org.example.Habilidades.Habilidad;
import org.example.Tipo.Tipo;

import java.util.ArrayList;
import java.util.List;



public class Pokemon {
    private String nombre;
    private int nivel;
    private Tipo tipo;
    private String historia;
    private double vidaMaxima;
    private double vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;
    private Estado estado;

    private List<Habilidad> habilidades;


    public Pokemon(String nombre, int nivel,  int vidaMaxima, int velocidad, int defensa, int ataque){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estado = estado;
        habilidades = new ArrayList<>();
    }

    public Pokemon() {}

    public void cambiarEstado(Estado estado) { this.estado = estado; }

    public void modificarHp(double hp) {
        if (hp + vidaActual > vidaMaxima){
            vidaActual = vidaMaxima;
        }
        else if (hp + vidaActual < 0){
            vidaActual = 0;
        }
        else{
            this.vidaActual = vidaActual + vidaMaxima;
        }
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

    public Tipo getTipo(){ return this.tipo;}

    public int elegirHabilidad(){ //IMPUT
        //deberia elegir las habilidades
        return 0;
    }

    public  void usarHabilidad(int habilidadElegida, Pokemon pokemonAtacante){

    }
    public  void usarHabilidad(int habilidadElegida, Pokemon pokemonObjetivo, Pokemon pokemonAtacante){

    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public int getDefensa(){ return this.defensa; }

    public void modificarVelocidad(int valor) { this.velocidad += valor; }

    public int getNivel() {return this.nivel;}

    public double getAtaque() { return this.ataque; }

    public Habilidad getHabilidad(int hablilidadElegida) {
        return habilidades.get(hablilidadElegida);
    }
    public boolean tieneUnEstado() {
        return (!(estado == null));
    }
}