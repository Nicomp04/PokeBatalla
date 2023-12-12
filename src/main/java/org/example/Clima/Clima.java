package org.example.Clima;

import javafx.scene.image.Image;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clima {

    public String nombre;
    public List<Tipo> tipos = new ArrayList<>();
    private TipoClima tipoClima;
    private int turnos;
    private int id;
    private String url;


    public Clima(String nombre, TipoClima tipoClima, List<Tipo> tipos,String url) {
        this.nombre = nombre;
        this.tipos = tipos;
        this.tipoClima = tipoClima;
        this.turnos = 5;
        this.url = url;
    }

    public Clima() {
        this.url = "src/main/resources/nada.png";
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


    public void cambiar(Clima nuevoClima){
        this.nombre = nuevoClima.getNombre();
        this.tipos = nuevoClima.getTipos();
        this.tipoClima = nuevoClima.getTipoClima();
        this.turnos = 5;
        this.url = nuevoClima.getUrl();
        this.id = nuevoClima.getId();
    }

    private int getId() {
        return id;
    }

    private List<Tipo> getTipos() {
        return this.tipos;
    }

    public void restarTurno(){
        if(turnos > 0 && (!Objects.equals(this.nombre, "Normal"))) {
            this.turnos--;
        }else{
            Clima normal = new Clima("Normal",TipoClima.NORMAL, new ArrayList<>(), "/nada.png");
            cambiar(normal);
        }
    }

    public boolean compararTipos(Pokemon pokemon){
        for(int i  = 0 ; i< tipos.size(); i++ ){
            if(Objects.equals(tipos.get(i).getId(), pokemon.getTipo().getId())){
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

    public String getUrl(){
        return this.url;
    }

    public Image getImage() { return new Image(this.url);}

}

