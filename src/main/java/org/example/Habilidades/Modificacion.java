package org.example.Habilidades;
import org.example.Pokemon.Pokemon;

public class Modificacion extends Habilidad{

    private int estadistica;// 1-HP 2-ATAQUE 3-DEFENSA 4-VELOCIDAD
    private int valor;

    public Modificacion(String nombre, int usosDisponibles, int estadistica, int valor, boolean afectaAEnemigo) {
        this.valor = -valor;
        this.nombre = nombre;
        this.usosDisponibles = usosDisponibles;
        this.estadistica = estadistica;
        this.atacaAEnemigo = false;
        this.afectaAEnemigo = afectaAEnemigo;
    }

    @Override
    public void usarEnPokemon(Pokemon pokemon, Pokemon objetivo) {
        if (afectaAEnemigo){
            switch (this.estadistica){
                case 1:
                    objetivo.modificarHp(this.valor);
                    break;
                case 2:
                    objetivo.setAtaque(this.valor);
                    break;
                case 3:
                    objetivo.setDefensa(this.valor);
                    break;
                case 4:
                    objetivo.setVelocidad(this.valor);
                    break;
            }
        }else{
            switch (this.estadistica){
                case 1:
                    pokemon.modificarHp(this.valor);
                    break;
                case 2:
                    pokemon.setAtaque(this.valor);
                    break;
                case 3:
                    pokemon.setDefensa(this.valor);
                    break;
                case 4:
                    pokemon.setVelocidad(this.valor);
                    break;
            }
        }

    }

}
