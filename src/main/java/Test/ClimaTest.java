package Test;
import org.example.Clima.Clima;
import org.example.Pokemon.Pokemon;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClimaTest {
    @Test
    public void cambiarClima(){
        Clima clima = new Clima("sin clima");

        clima.cambiar("soleado");

        assertEquals("soleado", clima.getClima());
    }
    @Test
    public void climaGastaTurnos(){
        Clima clima = new Clima("sin clima");

        clima.restarTurno();

        assertEquals(4,clima.getTurno());
    }

    @Test
    public void climaEsPeligroso(){
        Clima clima = new Clima("huracan");

        assertEquals(true,clima.climaPeligroso());
    }

    @Test
    public void climaComparaYMejoraAtaque(){
        Clima clima = new Clima("soleado");
        List<Integer> list = new ArrayList<>();

        Pokemon pokemon = new Pokemon("charizard",1,"fuego",10,10,10,10,10);
        double esperado = 100 + clima.mejoraPorTipo(pokemon,100);

        assertEquals(110.0,esperado);
    }
}
