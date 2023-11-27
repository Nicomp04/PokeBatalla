package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Pokemon.Pokemon;

public class PantallaBatallaController {
    @FXML
    private Stage stage;
    @FXML
    private ImageView jugadorPokemonImage;

    @FXML
    private ProgressBar jugadorSaludBar;

    @FXML
    private Text jugadorPokemonNombre;

    @FXML
    private ImageView enemigoPokemonImage;

    @FXML
    private ProgressBar enemigoSaludBar;

    @FXML
    private Text enemigoPokemonNombre;

    private Juego juego;

    @FXML
    private void ataque1(ActionEvent event) {
        // Lógica del primer ataque
    }

    @FXML
    private void ataque2(ActionEvent event) {
        // Lógica del segundo ataque
    }

    public void setJuego(Juego juego){
        this.juego = juego;
        inicializar();
    }

    public void inicializar() {
        //Pokemon jugadorPokemon = juego.getJugador1().getPokemonActual();
        //Pokemon enemigoPokemon = juego.getJugador2().getPokemonActual();

        // Ruta relativa al directorio de recursos
        String rutaImagen = "/chari.gif";
        //String rutaimagen2 = "/oster.gif";

        // Cargar la imagen desde el ClassLoader
        Image imagen = new Image(getClass().getResourceAsStream(rutaImagen));
        jugadorPokemonImage.setImage(imagen);
        jugadorSaludBar.setProgress(75);
        jugadorPokemonNombre.setText("juan");

        //Image imagen2 = new Image(getClass().getResourceAsStream(rutaimagen2));
        //enemigoPokemonImage.setImage(imagen2);
        //enemigoSaludBar.setProgress(enemigoPokemon.getVidaActual());
        //enemigoPokemonNombre.setText(enemigoPokemon.getNombre());

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Puedes agregar más métodos y lógica según sea necesario
}