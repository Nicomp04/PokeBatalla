package org.example.Clima;

import org.example.Pokemon.Pokemon;
import org.example.Tipo.*;

import java.util.*;

public class Clima {
    private String clima;
    private int turnos;
    private List<String> tipos = new ArrayList<>();
    private static final Map<String, List<String>> map = new HashMap<>();


    public Clima(String clima) {
        this.clima = clima;
        this.turnos = 5;

        List<String> tipos1 = new ArrayList<>();
        tipos1.add("Fuego");

        List<String> tipos2 = new ArrayList<>();
        tipos2.add("Agua");
        tipos2.add("Planta");

        List<String> tipos3 = new ArrayList<>();
        tipos3.add("Tierra");
        tipos3.add("Roca");

        List<String> tipos4 = new ArrayList<>();
        tipos4.add("Fantasma");
        tipos4.add("Psiquio");

        List<String> tipos5 = new ArrayList<>();
        tipos5.add("Electrico");

        List<String> tipos6 = new ArrayList<>();
        tipos6.add("Volador");

        List<String> tiposnull = new ArrayList<>();

        map.put("soleado", tipos1);
        map.put("lluvia", tipos2);
        map.put("arena", tipos3);
        map.put("niebla", tipos4);
        map.put("tormenta de rayos", tipos5 );
        map.put("huracan", tipos6);
        map.put("sin clima",tiposnull);

        this.tipos = map.get(clima);
    }

    public boolean compararTipos(Pokemon pokemon){
        this.tipos = map.get(clima);
        if (tipos == null) {

            return false;
        }
        return tipos.contains(pokemon.getTipo().getId());
    }

    public double mejoraPorTipo(Pokemon pokemon, double ataque){
        if(compararTipos(pokemon)){
            return (ataque * 10)/100;
        }
        return 0;
    }

    public void restarTurno(){
        if(turnos > 0) {
            this.turnos--;
        }
        if (turnos <= 0){
            sortearInicial();
        }
    }

    public void sortearInicial(){
        Random random = new Random();
        double probabilidad = random.nextDouble();

        if (probabilidad < 2.0 / 3.0) {
            this.clima = "sin clima";
            this.cambiar(clima);
        } else {
            String[] otrosClimas = {"soleado","lluvia", "arena", "niebla", "tormenta de rayos", "huracan"};
            int indiceClima = random.nextInt(otrosClimas.length);
             this.clima = otrosClimas[indiceClima];
             cambiar(clima);
        }
    }

    public void cambiar(String clima){
        this.clima = clima;
        this.turnos = 5;
    }

    public int getTurno() { return this.turnos;
    }

    public String getClima(){
        return this.clima;
    }

    public boolean climaPeligroso() {
        if (this.getClima() == "tormenta de rayos" || this.getClima() == "huracan")
            return true;
        return false;
    }
}
