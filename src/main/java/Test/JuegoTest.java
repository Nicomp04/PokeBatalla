package Test;

import org.example.Juego;
import org.example.Jugador;
import org.example.JugadorController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuegoTest {

    @Test
    public void queQuedenPokemones(){
        Jugador jugador1 = mock(Jugador.class);
        when(jugador1.tienePokemones()).thenReturn(false);
        Jugador jugador2 = mock(Jugador.class);
        when(jugador2.tienePokemones()).thenReturn(false);

        Juego juego = new Juego(jugador1, jugador2);

        assertEquals(false, juego.quedanPokemones());

    }

    @Test
    public void queUnoNoTengaPokemones(){
        Jugador jugador1 = mock(Jugador.class);
        when(jugador1.tienePokemones()).thenReturn(true);
        Jugador jugador2 = mock(Jugador.class);
        when(jugador2.tienePokemones()).thenReturn(false);

        Juego juego = new Juego(jugador1, jugador2);

        assertEquals(false, juego.quedanPokemones());

    }

    @Test
    public void determinaPerdedorCorrectamente(){

    }
}


