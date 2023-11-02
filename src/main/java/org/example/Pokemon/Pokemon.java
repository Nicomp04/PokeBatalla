package org.example.Pokemon;
import org.example.Estado.Estado;
import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.RepositorioHabilidades;
import org.example.Tipo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Pokemon {
    private String nombre;
    private int id;
    private int nivel;
    private Tipo tipo;
    private String historia;
    private double vidaMaxima;
    private double vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;
    private Estado estado = new Estado();
    private TipoFactory tipoFactory;
    private PokemonVista vista;


    public List<Habilidad> habilidades = new ArrayList<>();

    public HashMap<String, Tipo> especie = new HashMap<>();

    public Pokemon(String nombre, int id, String tipo, int nivel,   int vidaMaxima, int velocidad, int defensa, int ataque,List<Integer> habilidadesId, RepositorioHabilidades repositorioHabilidades ){
        this.nombre = nombre;
        this.id = id;
        this.nivel = nivel;
        this.tipo = TipoFactory.getTipo(tipo);
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidades = repositorioHabilidades.cargarConjunto(habilidadesId);

        this.vista = new PokemonVista();

       /* especie.put("Charizard", new Fuego());
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
        especie.put("Tornadus", new Volador());*/
    }

    public Pokemon() {}

    public Pokemon(String nombre, int id, String tipo, int nivel, int vidaMaxima, int velocidad, int defensa, int ataque) {
        this.nombre = nombre;
        this.id = id;
        this.nivel = nivel;
        this.tipo = TipoFactory.getTipo(tipo);
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setVista(PokemonVista vista){this.vista = vista;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public int getNivel() {return this.nivel;}
    public Tipo getTipo(){ return this.tipo;}
    public double getVidaActual (){
        return this.vidaActual;
    }
    public Estado getEstado(){return this.estado;}
    public void setDefensa(int porcentaje) {this.defensa = this.defensa - ((this.defensa * (-porcentaje))/100);}
    public void setAtaque(int porcentaje) {
        this.ataque = this.ataque - ((this.ataque * (-porcentaje))/100);
    }
    public int getVelocidad() {
        return this.velocidad;
    }
    public int getDefensa(){ return this.defensa; }
    public void setVelocidad(int valor) { this.velocidad = valor; }
    public double getAtaque() { return this.ataque;}

    public Habilidad getHabilidades(int hablilidadElegida) {
        return habilidades.get(hablilidadElegida);
    }

    public void revivir() {
        this.vidaActual = vidaMaxima;
    }

    public void serAtacado(double danio) { //se puede sacar de pokemon
        vista.mostrarVida(this);
        modificarHp(-danio);
    }

    public void modificarHp(double hp) {
        if (hp + vidaActual > vidaMaxima){
            vidaActual = vidaMaxima;
        }
        else if (hp + vidaActual < 0){
            vidaActual = 0;
            vista.mostrarDerrotado();
        }
        else{
            this.vidaActual += hp;
        }
        vista.mostrarVida(this);
    }

    
    public void mostrarHabilidades(){
        vista.mostrarHabilidades(this.habilidades);
    }
    public boolean estaMuerto() {return this.vidaActual <= 0;}

    public int getNumeroDeHabilidades() {
        return this.habilidades.size();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}