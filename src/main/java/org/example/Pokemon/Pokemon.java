package org.example.Pokemon;
import javafx.scene.image.Image;
import org.example.Estado.EstadoPokemon;
import org.example.Habilidades.Habilidad;
import org.example.Habilidades.RepositorioHabilidades;
import org.example.Tipo.*;
import org.example.Vista.PokemonVista;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Pokemon implements Cloneable {
    private String colorBarra = "#00FF00";
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
    private List<EstadoPokemon> estados = new ArrayList<>();
    final Logger logger = LoggerFactory.getLogger(Pokemon.class);

    private TipoFactory tipoFactory;
    private PokemonVista vista;
    private String url;

    private List<Habilidad> habilidades = new ArrayList<>();
    private List<Integer> habilidadesIds = new ArrayList<>();

    public Pokemon(String nombre, int id, String tipo, int nivel,   int vidaMaxima, int velocidad, int defensa, int ataque,List<Integer> habilidadesId, RepositorioHabilidades repositorioHabilidades, String url ){
        this.nombre = nombre;
        this.id = id;
        this.nivel = nivel;
        this.tipo = TipoFactory.getTipo(tipo);
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidadesIds = habilidadesId;
        this.url = url;

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

    public int getId(){
        return this.id;
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
    public List<EstadoPokemon> getEstados(){return this.estados;}
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

    public void quitarEstado(EstadoPokemon estado){this.estados.remove(estado);}

    public void agregarEstado(EstadoPokemon estado) {
        if (!getEstados().contains(estado)){
            this.estados.add(estado);
        }else{
            logger.info("El pokemon ya tiene este estado alterado");
        }
    }
    public String getUrl(){return this.url;}

    public Image getImage() { return new Image(Objects.requireNonNull(getClass().getResourceAsStream(this.getUrl())));}

    public Pokemon clonar() {
            try {
                return (Pokemon) clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void cargarHabilidades(RepositorioHabilidades repositorio) {
        habilidades = repositorio.cargarConjunto(habilidadesIds);
    }

    public void limpiarHabilidades(){
        for (int i=0; i< habilidades.size();i++){
            if (habilidades.get(i).getUsosDisponibles() <= 0)
                habilidades.remove(i);
        }
    }

    public String getColorBarra() {
        return colorBarra;
    }

    public void setColorBarra(String colorBarra) {
        this.colorBarra = colorBarra;
    }

    public void setEstado(List<EstadoPokemon> estado) {
        this.estados = estado;
    }
}