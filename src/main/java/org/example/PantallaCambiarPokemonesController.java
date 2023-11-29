package org.example;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PantallaCambiarPokemonesController {
    @FXML
    public Label jugadorPokemonNombreLabel;
    @FXML
    public Label jugadorPokemonNivelLabel;
    @FXML
    public ProgressBar jugadorPokemonSaludBar;
    @FXML
    public Label jugadorPokemonVidaLabel;

    @FXML
    private Stage stage;

    @FXML
    private void initialize() {
        this.listaPokemonsVBox = new VBox();
    }

    @FXML
    private ImageView pokemonImage;

    @FXML
    private Label pokemonNombre;

    @FXML
    private ProgressBar pokemosnSaludBar;

    @FXML
    private Label jugadorNombre;

    @FXML
    private ImageView jugadorImagen;

    private StackPane[] listaPokemones;
    @FXML
    private VBox listaPokemonsVBox;


    public void setStage(Stage stage) {
        this.listaPokemones = new StackPane[3];
        this.stage = stage;
    }

    public void crearListaDePokemonesViewer(String nombreJugador, List<Pokemon> pokemones){
        //this.jugadorNombre.setText(nombreJugador);

        jugadorPokemonNivelLabel.setText(String.valueOf(pokemones.get(0).getNivel()));
        jugadorPokemonNombreLabel.setText(pokemones.get(0).getNombre());
        jugadorPokemonSaludBar.setProgress(pokemones.get(0).getVidaActual() / pokemones.get(0).getVidaMaxima());
        jugadorPokemonVidaLabel.setText(String.valueOf(pokemones.get(0).getVidaActual() / pokemones.get(0).getVidaMaxima()));

        Integer j = listaPokemonsVBox.getChildren().size();
        Integer tamanoVBox = j != null ? j : 0;

        for (int i = 0; i < tamanoVBox && i < pokemones.size(); i++){

            listaPokemones[i] = (StackPane) listaPokemonsVBox.getChildren().get(i);
            crearPokemonViewer(pokemones.get(i));
            listaPokemones[i].getChildren().add(pokemonImage);
            listaPokemones[i].getChildren().add(pokemosnSaludBar);
            listaPokemones[i].getChildren().add(pokemonNombre);
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
