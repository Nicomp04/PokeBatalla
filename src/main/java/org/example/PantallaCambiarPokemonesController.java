package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PantallaCambiarPokemonesController {

    @FXML
    private Stage stage;

    @FXML
    private ImageView pokemonImage;

    @FXML
    private Text pokemonNombre;

    @FXML
    private ProgressBar pokemosnSaludBar;

    @FXML
    private Text nombreJugador;

    public PantallaCambiarPokemonesController(){
    }
    public void setStage(Stage stage) {
    }

    public void crearListaDePokemonesViewer(String nombreJugador, List<Pokemon> pokemones){
        this.nombreJugador.setText(nombreJugador);
        for (int i = 0; i < pokemones.size(); i ++){
            crearPokemonViewer(pokemones.get(i));
        }
    }

    public void crearPokemonViewer(Pokemon pokemon) {

        this.pokemonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/chari.gif"))));
        this.pokemosnSaludBar.setProgress((double) pokemon.getVidaActual() /pokemon.getVidaMaxima());
        this.pokemonNombre.setText(pokemon.getNombre());
    }


    public void handleMouseClicked(MouseEvent mouseEvent) {
    }
}
