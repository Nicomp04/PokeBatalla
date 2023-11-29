package org.example;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    private Stage stage;

    private ImageView pokemonImage = new ImageView();

    private Label pokemonNombre = new Label();

    //private ProgressBar pokemosnSaludBar = new ProgressBar();

    @FXML
    private Label jugadorNombre;

    @FXML
    private ImageView jugadorImagen;

    private StackPane[] listaPokemones;

    private HBox[] informacionPokemon;

    @FXML
    private VBox listaPokemonsVBox;


    public void setStage(Stage stage) {
        this.listaPokemones = new StackPane[3];
        this.informacionPokemon = new HBox[2];
        this.stage = stage;
    }

    public void crearListaDePokemonesViewer(String nombreJugador, List<Pokemon> pokemones){
        this.jugadorNombre.setText(nombreJugador);
        Integer j = listaPokemonsVBox.getChildren().size();
        Integer tamanoVBox = j != null ? j : 0;
        for (int i = 0; i < tamanoVBox && i < pokemones.size(); i++){

            System.out.println(i);
            listaPokemones[i] = (StackPane) listaPokemonsVBox.getChildren().get(i);
            //listaPokemones[i].getChildren().add(pokemonImage);

            ProgressBar pokemosnSaludBar = new ProgressBar();
            pokemosnSaludBar.setProgress((double) pokemones.get(i).getVidaActual() /pokemones.get(i).getVidaMaxima());

            Label pokemonNombre = new Label();
            pokemonNombre.setText(pokemones.get(i).getNombre());

            this.listaPokemones[i].getChildren().add(pokemosnSaludBar);
            this.listaPokemones[i].getChildren().add(pokemonNombre);
        }
    }



    public void handleMouseClicked(MouseEvent mouseEvent) {
    }
}
