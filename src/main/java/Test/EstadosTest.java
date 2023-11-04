package Test;
import org.example.Estado.Estados;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EstadosTest {
    @Test
    public void testSetDuracion() {
        Estados.DORMIDO.setDuracion(3);
        assertEquals(3, Estados.DORMIDO.getDuracion());
    }

    @Test
    public void testGetNombre() {
        assertEquals("DORMIDO", Estados.DORMIDO.getNombre());
        assertEquals("PARALIZADO", Estados.PARALIZADO.getNombre());
        assertEquals("ENVENENADO", Estados.ENVENENADO.getNombre());
        assertEquals("CONFUNDIDO", Estados.CONFUNDIDO.getNombre());
    }

    @Test
    public void testRestarTurno(){
        Estados estado = Estados.CONFUNDIDO;
        estado.setDuracion(5);
        assertEquals(5, estado.getDuracion());
        estado.restarTurno();
        assertEquals(4, estado.getDuracion());
    }
}
