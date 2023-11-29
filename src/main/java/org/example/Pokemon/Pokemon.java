package org.example.Pokemon;
import org.example.Estado.Estados;
import org.example.Habilidades.Habilidad;
import org.example.Habilidades.RepositorioHabilidades;
import org.example.Tipo.*;
import org.example.Vista.PokemonVista;

import java.util.ArrayList;
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
    private List<Estados> estados = new ArrayList<>();

    private TipoFactory tipoFactory;
    private PokemonVista vista;

    public List<Habilidad> habilidades = new ArrayList<>();

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
    public double getVidaMaxima(){
        return this.vidaMaxima;
    }
    public List<Estados> getEstados(){return this.estados;}
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

    public Habilidad getHabilidad(int hablilidadElegida) {
        return habilidades.get(hablilidadElegida);
    }
    public List<Habilidad> getHabilidades(){return this.habilidades;}

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

    public void restarTurnoEstados() {
        for (int i = 0 ; i < estados.size() ; i++) {
            estados.get(i).restarTurno();
            System.out.println(estados.get(i).getNombre() + estados.get(i).getDuracion());
            if(estados.get(i).seAgoto())
                quitarEstado(estados.get(i));
        }
    }

    public void quitarEstado(Estados estado){this.estados.remove(estado);}

    public void agregarEstado(Estados estado) {
        if (!getEstados().contains(estado)){
            this.estados.add(estado);
        }
    }
}