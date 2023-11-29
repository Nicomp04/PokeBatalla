package org.example;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
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

    private ProgressBar pokemosnSaludBar = new ProgressBar();

    @FXML
    private Label jugadorNombre;

    @FXML
    private ImageView jugadorImagen;

    @FXML
    private Label pokemonNombre;

    private StackPane[] listaPokemones;

    private HBox informacionPokemon;

    @FXML
    private VBox listaPokemonsVBox = new VBox();


    public void setStage(Stage stage) {
        this.listaPokemones = new StackPane[3];
        this.stage = stage;
    }

    public void crearListaDePokemonesViewer(String nombreJugador, List<Pokemon> pokemones){
        this.jugadorNombre.setText(nombreJugador);
        Image imagen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/chari.gif")));
        this.jugadorImagen.setImage(imagen);
        this.pokemonNombre.setText(pokemones.get(0).getNombre());

        Integer j = listaPokemonsVBox.getChildren().size();
        Integer tamanoVBox = j != null ? j : 0;
        for (int i = 0; i < tamanoVBox && i < pokemones.size(); i++){

            listaPokemones[i] = (StackPane) listaPokemonsVBox.getChildren().get(i);

            Label pokemonNombre = new Label();
            pokemonNombre.setText(pokemones.get(i).getNombre());

            ProgressBar pokemosnSaludBar = new ProgressBar();
            pokemosnSaludBar.setProgress((double) pokemones.get(i).getVidaActual() /pokemones.get(i).getVidaMaxima());

            this.informacionPokemon = new HBox();

            informacionPokemon.setAlignment(Pos.CENTER);
            informacionPokemon.getChildren().add(pokemonNombre);
            informacionPokemon.getChildren().add(pokemosnSaludBar);
            this.listaPokemones[i].getChildren().add(informacionPokemon);

        }
    }



    public int handleMouseClicked(MouseEvent mouseEvent) {
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String identificador = stackPane.getId();
        if (identificador.equals("0")){return 0;}
        else if (identificador.equals("1")){return 1;}
        else if (identificador.equals("2")){return 2;}
        else if (identificador.equals("3")){return 3;}

        return -1;
    }
}
