package org.example.Pokemon;
import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Tipo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


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
    private Estados estado;
    private List<Habilidad> habilidades = new ArrayList<>();
    public HashMap<String, Tipo> especie = new HashMap<>();

    final Logger logger = LoggerFactory.getLogger(Pokemon.class);

    public Pokemon(String nombre, int nivel, Tipo tipo,  int vidaMaxima, int velocidad, int defensa, int ataque,List<Habilidad> habilidades ){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidades = habilidades;

        especie.put("Charizard", new Fuego());
        especie.put("Bulbasaur", new Agua());
        especie.put("Pikachu", new Electrico());
        especie.put("Dragonite", new Dragon());
        especie.put("Shuppet", new Fantasma());
        especie.put("Caterpie", new Bicho());
        especie.put("Vulpix", new Hielo());
        especie.put("Machop", new Lucha());
        especie.put("Rattata", new Normal());
        especie.put("Chikorita", new Planta());
        especie.put("Abra", new Psiquio());
        especie.put("Nosepass", new Roca());
        especie.put("Diglett", new Tierra());
        especie.put("Ekans", new Veneno());
        especie.put("Tornadus", new Volador());
    }

    public Pokemon() {}

    public String getNombre(){
        return this.nombre;
    }

    public double getVidaActual (){
        return this.vidaActual;
    }
    public void cambiarEstado(Estados estado) { this.estado = estado; }

    public Estados getEstado(){
        return this.estado;
    }

    public void revivir() {
        this.vidaActual = vidaMaxima;
    }

    public void setDefensa(int valor) {this.defensa = valor;}

    public void setAtaque(int ataque) {this.ataque = ataque;}

    public void modificarAtaque(int porcentaje){this.ataque = this.ataque - ((this.ataque * (-porcentaje))/100);}

    public Tipo getTipo(){ return this.tipo;}

    public int getVelocidad() {
        return this.velocidad;
    }

    public int getDefensa(){ return this.defensa; }

    public void setVelocidad(int valor) { this.velocidad += valor; }

    public int getNivel() {return this.nivel;}

    public double getAtaque() { return this.ataque; }

    public Habilidad getHabilidad(int hablilidadElegida) {
        return habilidades.get(hablilidadElegida);
    }

    public boolean tieneUnEstado() {return (estado != null);}

    public String getEstadoString(){
        if (estado == Estados.PARALIZADO){
            return "Paralizado";
        }
        else if (estado == Estados.DORMIDO){
            return "Dormido";
        }
        else if (estado == Estados.ENVENENADO){
            return "Envenenado";
        }
        return "Normal";
    }

    public void serAtacado(double danio) {
        logger.info("El pokemon {} tiene {} de vida.",this.nombre,this.vidaActual);
        modificarHp(-danio);
    }

    public void aplicarVeneno(){
        double resto = ((vidaMaxima * 5) / 100);
        this.vidaActual = vidaActual - resto;
        logger.info("El pokemon {} esta Envenenado, pierde {} de vida", this.getNombre(), resto);
    }
    public void checkearEnvenenamiento() {
        if(estado == Estados.ENVENENADO){
            aplicarVeneno();
        }
    }

    public void modificarHp(double hp) {
        if (hp + vidaActual > vidaMaxima){
            vidaActual = vidaMaxima;
        }
        else if (hp + vidaActual < 0){
            vidaActual = 0;
            logger.info("El pokemon fue derrotado.");
        }
        else{
            this.vidaActual += hp;
        }
        logger.info("El pokemon {} tiene {} de vida.",this.nombre,this.vidaActual);
    }

    public Habilidad mostrarYElegirHabilidad(){
        int habilidadElegida = 0;
        Habilidad habilidad;
        Scanner scanner = new Scanner(System.in);

        logger.info("Es su turno ¿que Habilidad quiere realizar? \n");
        for(int i = 0; i < habilidades.size(); i++){
            logger.info("{}: {} \n",i + 1 , habilidades.get(i).getNombre());
        }
        logger.info("Habilidad ->  ");
        habilidadElegida = scanner.nextInt();

        switch (habilidadElegida){
            case 1:
                return this.habilidades.get(0);
            case 2:
                return this.habilidades.get(1);
            case 3:
                return this.habilidades.get(2);
            case 4:
                return this.habilidades.get(3);
        }
        logger.info("La hablilidad {} es invalida ingresela nuevamente \n", habilidadElegida);
        return mostrarYElegirHabilidad();
    }
    public boolean estaMuerto() {return this.vidaActual <= 0;}

    public void modificarDefensa(int porcentaje) {this.defensa = this.defensa - ((this.defensa * (-porcentaje))/100);}

    public void modificarVelocidad(int porcentaje) {this.velocidad = this.velocidad - ((this.velocidad * (-porcentaje))/100);}
}