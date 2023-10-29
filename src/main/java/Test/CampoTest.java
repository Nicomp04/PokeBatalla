package Test;

import org.example.Campo;
import org.example.Jugador;
import org.example.Pokemon.Pokemon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CampoTest {

    @Test
    public void campoCargadoCorrectamente(){
        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        Campo campo = new Campo(pokemon1,pokemon2);

        assertEquals(pokemon1,campo.getPokemonesActivos(0));
        assertEquals(pokemon2,campo.getPokemonesActivos(1));
    }
}
