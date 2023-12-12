package Test;

import org.example.Estado.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstadosTest {

    @Test
    public void restarTurno_Dormido() {
        Dormido dormido = new Dormido();
        assertEquals(0, dormido.getDuracion());

        dormido.restarTurno();
        assertEquals(1, dormido.getDuracion());
    }

    @Test
    public void restarTurno_Confundido() {
        Confundido confundido = new Confundido();
        assertEquals(3, confundido.getDuracion());

        confundido.restarTurno();
        assertEquals(2, confundido.getDuracion());
    }

}
