package Test;

import org.example.Clima.Clima;
import org.example.Estado.Estados;
import org.example.Habilidades.*;
import org.example.Parsers.ParserClima;
import org.example.Pokemon.Pokemon;
import org.example.Vista.PokemonVista;
import org.example.Tipo.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class HabilidadesTest {

    @Test
    public void testAtaquePokemonDañaAPokemonRival(){
        // Arrange:

        Habilidad habilidadTest = new Ataque(17, "Surf", 5, "agua", 40);

        Pokemon pokemonAtacante = new Pokemon("Blastoise",2,"agua",20,200,40,50,80);

        Pokemon pokemonAtacado = new Pokemon("charizard",3,"fuego",20,200,40,50,80);

        Clima clima = new ParserClima("src/main/resources/Climas.json").getClima("Normal");

        PokemonVista vista = new PokemonVista();

        pokemonAtacado.setVista(vista);

        // Act:
        double vidaOriginal = pokemonAtacado.getVidaActual();

        habilidadTest.usarEnPokemon(pokemonAtacante, pokemonAtacado, clima);

        double vidaModificada = pokemonAtacado.getVidaActual();

        boolean esMayor = vidaOriginal > vidaModificada;

        // Assert:
        assertTrue(esMayor);
    }

    @Test
    public void testCambioDeEstadoDeUnPokemonPorHabilidad(){

        Habilidad habilidadTest = new Efecto(17, "Hidropulso", 5, Estados.CONFUNDIDO, true, "Agua");

        Pokemon pokemonAtacante = new Pokemon("Blastoise",2,"Agua",20,200,40,50,80);

        Pokemon pokemonAtacado = new Pokemon("charizard",3,"fuego",20,200,40,50,80);

        Clima clima = new ParserClima("src/main/resources/Climas.json").getClima("Normal");

        habilidadTest.usarEnPokemon(pokemonAtacante, pokemonAtacado, clima);
        boolean estadoEsperado = pokemonAtacado.getEstados().contains(Estados.CONFUNDIDO);

        assertTrue(estadoEsperado);

    }

    @Test
    public void testCambioDeDefenzaDeUnPokemonPorHabilidad(){
        // Arrange:
        Modificacion habilidadTest = new ModificarDefensa(17, "Surf", 5, 3, 10,"fuego");

        Pokemon pokemonAtacante = new Pokemon("Blastoise",2,"Agua",20,200,40,50,80);

        Pokemon pokemonAtacado = new Pokemon("charizard",3,"fuego",20,200,40,50,80);

        Clima clima = new ParserClima("src/main/resources/Climas.json").getClima("Normal");

        // Act:
        int EstadisticaOriginal = pokemonAtacado.getDefensa();
        habilidadTest.usarEnPokemon(pokemonAtacante, pokemonAtacado, clima);
        int EstadisticaReducida = pokemonAtacado.getDefensa();

        // Assert:
        assertEquals(EstadisticaOriginal - 5, EstadisticaReducida);
    }


    @Test
    public void testMismoTipo() {
        // Arrange:
        Ataque habilidadTest = new Ataque(17, "Surf", 5, "Agua", 40);

        Tipo tipoDelPokemon = TipoFactory.getTipo("Agua");

        // Act:
        double efectividad = habilidadTest.mismoTipo(tipoDelPokemon);

        // Assert:
        assertEquals(1.5, efectividad);
    }

}
