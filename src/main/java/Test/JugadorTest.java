package Test;

import org.example.Item.Item;
import org.example.Item.Restaurador;
import org.example.Jugador;
import org.example.Pokemon.Pokemon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JugadorTest {
    @Test
    public void seCreaJugadorCorrectamente(){
        List<Pokemon> pokemones = new ArrayList<>();
        Pokemon pokemon = new Pokemon("charizard",3,"fuego",20,200,40,50,80);
        pokemones.add(pokemon);
        Item item = new Restaurador(1,"pocion",20);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Jugador jugador = new Jugador("Nico", pokemones,items,1);

        assertEquals("Nico", jugador.getNombre());
        assertEquals(pokemon,jugador.getPokemonActual());
        assertEquals(item,jugador.getItem(0));
    }

    @Test
    public void jugadorTienePokemonesVivos(){
        List<Pokemon> pokemones = new ArrayList<>();
        Pokemon pokemon = new Pokemon("charizard",3,"fuego",20,200,40,50,80);
        pokemones.add(pokemon);
        Item item = new Restaurador(1,"pocion",20);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Jugador jugador = new Jugador("Nico", pokemones,items,1);

        assertEquals(true,jugador.tienePokemones());
    }

    @Test
    public void jugadorNoTienePokemonesVivos(){
        List<Pokemon> pokemones = new ArrayList<>();
        Pokemon pokemon = new Pokemon("charizard",3,"fuego",20,0,40,50,80);
        pokemones.add(pokemon);
        Item item = new Restaurador(1,"pocion",20);
        List<Item> items = new ArrayList<>();
        items.add(item);

        Jugador jugador = new Jugador("Nico", pokemones,items,1);

        assertEquals(false,jugador.tienePokemones());
    }
}
