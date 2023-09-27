package org.example.Habilidades;
import org.example.Pokemon.Pokemon;

public class Modificacion extends Habilidad{

    private int estadistica;// 1-HP 2-ATAQUE 3-DEFENSA 4-VELOCIDAD
    private int valor;

    public Modificacion(String nombre, int usosDisponibles, int estadistica, int valor) {
        this.valor = valor;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estadistica = estadistica;
    }

    public void usarHabilidad(Pokemon pokemon){
        switch (this.estadistica){
            case 1:
                pokemon.modificarHp(this.valor);
                break;
            case 2:
                pokemon.modificarAtaque(this.valor);
                break;
            case 3:
                pokemon.modificarDefensa(this.valor);
                break;
            case 4:
                pokemon.modificarVelocidad(this.valor);
                break;
        }
    }
}
