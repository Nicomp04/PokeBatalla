package Test;
import org.example.Item.Item;
import org.example.Item.*;
import org.example.Pokemon.Pokemon;
import org.example.Vista.PokemonVista;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ItemTest {
    @Test
    public void Test01(){
        //Arrange

        PokemonVista vista = mock(PokemonVista.class);

        Item pocion = new Restaurador(1,"Pocion", 10);

        Pokemon pokemon1 = new Pokemon("Blastoise",2,"Agua",20,200,40,50,80);

        pokemon1.setVista(vista);

        Pokemon pokemon2 = new Pokemon("charizard",3,"fuego",20,200,40,50,80);

        pokemon1.modificarHp(-50);

        List<Pokemon> pokemones = new ArrayList<>();

        pokemones.add(pokemon1);
        pokemones.add(pokemon2);

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //Act

        pocion.aplicarItem(pokemones.get(0));

        //Assert

        assertEquals(160.0, pokemon1.getVidaActual());

    }

    @Test
    public void test02(){

        PokemonVista vista = mock(PokemonVista.class);

        Item revivir = new Revivir(1);

        Pokemon pokemon1 = new Pokemon("Blastoise",2,"Agua",20,200,40,50,80);

        pokemon1.setVista(vista);

        Pokemon pokemon2 = new Pokemon("charizard",3,"fuego",20,200,40,50,80);

    }
}
