package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Pokemon.Pokemon;

import java.util.Objects;

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


    public void initialize() {
        this.juego = new Juego();
        Pokemon jugadorPokemon = juego.getJugador1().getPokemonActual();
        Pokemon enemigoPokemon = juego.getJugador2().getPokemonActual();

        // Ruta relativa al directorio de recursos
        String rutaImagen = "/resources/chari.gif";
        String rutaimagen2 = "/resources/oster.gif";

        // Cargar la imagen desde el ClassLoader
        this.jugadorPokemonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/chari.gif"))));
        this.jugadorSaludBar.setProgress((double) jugadorPokemon.getVidaActual() /jugadorPokemon.getVidaMaxima());
        this.jugadorPokemonNombre.setText(jugadorPokemon.getNombre());

        enemigoPokemonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/oster.gif"))));
        enemigoSaludBar.setProgress((double)enemigoPokemon.getVidaActual() / enemigoPokemon.getVidaMaxima());
        enemigoPokemonNombre.setText(enemigoPokemon.getNombre());

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Puedes agregar más métodos y lógica según sea necesario
}