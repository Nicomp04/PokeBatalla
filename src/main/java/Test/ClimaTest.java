package Test;
import org.example.Clima.Clima;
import org.example.Clima.TipoClima;
import org.example.Parsers.ParserClima;
import org.example.Pokemon.Pokemon;
import org.example.Tipo.Fuego;
import org.example.Tipo.Tipo;
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
        Clima clima = new Clima("Normal", TipoClima.NORMAL, null);

        clima.cambiar("Soleado");

        assertEquals("Soleado", clima.getNombre());
    }
    @Test
    public void climaGastaTurnos(){
        Clima clima = new Clima("Normal", TipoClima.NORMAL, null);

        clima.restarTurno();

        assertEquals(4,clima.getTurno());
    }

    @Test
    public void climaEsPeligroso(){
        Clima clima = new Clima("Huracan", TipoClima.PELIGROSO, null);

        assertTrue(clima.esClimaPeligroso());
    }

    @Test
    public void climaComparaYMejoraAtaque(){
        Tipo tipo = new Fuego();
        List<Tipo> list = new ArrayList<>();
        list.add(tipo);

        Clima clima = new Clima("Soleado", TipoClima.NORMAL, list);

        Pokemon pokemon = new Pokemon("charizard",1,"fuego",10,10,10,10,10);
        double esperado = 100 + clima.mejoraPorTipo(pokemon,100);

        assertEquals(110.0,esperado);
    }
}
