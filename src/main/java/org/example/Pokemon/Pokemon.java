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

    public void cambiarEstado(Estados estado) { this.estado = estado; }

    public Estados getEstado(){
        return this.estado;
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
            this.vidaActual = vidaActual + vidaMaxima;
        }
        logger.info("El pokemon {} tiene {} de vida.",this.nombre,this.vidaActual);
    }

    public void revivir() {
        this.vidaActual = vidaMaxima;
    }

    public void setDefensa(int porcentaje) {
        this.defensa = porcentaje;
    }

    public void setAtaque(int porcentaje) {
        this.ataque = porcentaje;
    }

    public Tipo getTipo(){ return this.tipo;}

    public Habilidad mostrarYElegirHabilidad(){
        int habilidadElegida = 0;
        Habilidad habilidad;
        Scanner scanner = new Scanner(System.in);

        logger.info("Es su turno ¿que Habilidad quiere realizar? \n");
        logger.info(
                "1: {} \n", habilidades.get(0).getNombre() +
                "2: {} \n", habilidades.get(1).getNombre() +
                "3: {} \n", habilidades.get(2).getNombre() +
                "4: {} \n", habilidades.get(3).getNombre());
        logger.info("Habilidad ->  ");
        habilidadElegida = scanner.nextInt();
        logger.info("\n");
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

    public void serAtacado(double danio) {
        this.vidaActual = vidaActual - danio;
        logger.info("El pokemon {} tiene {} de vida.",this.nombre,this.vidaActual);
    }

    public void aplicarVeneno(){
        int resto = (int) ((vidaMaxima * 5) / 100);
        this.vidaActual = vidaActual - ((vidaMaxima * 5) / 100);
        logger.info("El pokemon esta Envenenado, pierde {} de vida", resto);
    }
}