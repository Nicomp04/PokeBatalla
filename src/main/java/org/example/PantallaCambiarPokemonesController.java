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
    @FXML
    private Label jugadorNombre;
    @FXML
    private ImageView jugadorImagen;
    @FXML
    private Label pokemonNombre;
    @FXML
    private VBox listaPokemonsVBox = new VBox();
    private ImageView pokemonImage = new ImageView();
    private ProgressBar pokemosnSaludBar = new ProgressBar();
    private StackPane[] listaPokemones;
    private HBox informacionPokemon;
    private Jugador jugador;
    private int pos;
    private Juego juego;


    public void setStage(Stage stage, Juego juego ) {
        this.listaPokemones = new StackPane[3];
        this.stage = stage;
        this.pos = -1;
        this.juego = juego;
    }

    public void crearListaDePokemonesViewer(Jugador jugador, List<Pokemon> pokemones){
        this.jugador = jugador;
        this.jugadorNombre.setText(jugador.getNombre());
        Image imagen = new Image(jugador.getPokemonActual().getUrl());
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

    public void handleMouseClicked(MouseEvent mouseEvent) {

        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String identificador = stackPane.getId();
        if (identificador.equals("0")){this.pos = 0;}
        else if (identificador.equals("1")){this.pos = 1;}
        else if (identificador.equals("2")){this.pos = 2;}
        else if (identificador.equals("3")){this.pos = 3;}

        if (pos < jugador.getPokemones().size() || pos != -1){
            this.stage.close();
            jugador.elegirPokemon(pos);
            stage.close();
            juego.habilitarTurno();
        }
    }
}
