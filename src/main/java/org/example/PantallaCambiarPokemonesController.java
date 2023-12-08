package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.Pokemon.Pokemon;

import java.util.List;

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
    @FXML
    private ProgressBar vidaPokemon;
    @FXML
    private Rectangle colorRectangulo0;
    @FXML
    private Rectangle colorRectangulo1;
    @FXML
    private Rectangle colorRectangulo2;
    @FXML
    private Rectangle colorRectangulo3;
    @FXML
    private Label textoAccion;
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
        double porcentajeVidaActual = (jugador.getPokemonActual().getVidaActual() / jugador.getPokemonActual().getVidaMaxima());
        this.vidaPokemon.setProgress(porcentajeVidaActual);

        Integer j = listaPokemonsVBox.getChildren().size();
        Integer tamanoVBox = j != null ? j : 0;
        for (int i = 0; i < tamanoVBox && i < pokemones.size(); i++){

            listaPokemones[i] = (StackPane) listaPokemonsVBox.getChildren().get(i);

            Label pokemonNombre = new Label();
            pokemonNombre.setText(pokemones.get(i).getNombre());
            pokemonNombre.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");

            Label espacio = new Label();
            espacio.setText("  ");

            ProgressBar pokemosnSaludBar = new ProgressBar();
            pokemosnSaludBar.setProgress((double) pokemones.get(i).getVidaActual() /pokemones.get(i).getVidaMaxima());

            Label porcentajeVida = new Label();
            double vida = (pokemones.get(i).getVidaActual() / pokemones.get(i).getVidaMaxima()) * 100;
            String porcentaje = String.format("%.0f", vida);
            porcentajeVida.setText("  " + porcentaje + " %");
            porcentajeVida.setStyle("-fx-font-size: 10px; -fx-font-weight: bold;");

            this.informacionPokemon = new HBox();

            informacionPokemon.setAlignment(Pos.CENTER);
            informacionPokemon.getChildren().add(pokemonNombre);
            informacionPokemon.getChildren().add(espacio);
            informacionPokemon.getChildren().add(pokemosnSaludBar);
            informacionPokemon.getChildren().add(porcentajeVida);
            this.listaPokemones[i].getChildren().add(informacionPokemon);
        }
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {

        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String identificador = stackPane.getId();
        identificarPocision(identificador);

        boolean posicionValida = pos < jugador.getPokemones().size() && pos != -1;

        if ( posicionValida && !jugador.getPokemones().get(pos).estaMuerto()){
            jugador.elegirPokemon(pos);
            mostrarTextoSeleccionado(jugador.getPokemonActual());
            juego.habilitarTurno();
        }
    }

    private void mostrarTextoSeleccionado(Pokemon pokemonActual) {

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, event -> {
                this.textoAccion.setText("Seleccionaste a " + pokemonActual.getNombre() + "\nA LUCHAR !");
                Image imagen = new Image(jugador.getPokemonActual().getUrl());
                this.jugadorImagen.setImage(imagen);
                this.pokemonNombre.setText(pokemonActual.getNombre());
                double porcentajeVidaActual = (jugador.getPokemonActual().getVidaActual() / jugador.getPokemonActual().getVidaMaxima());
                this.vidaPokemon.setProgress(porcentajeVidaActual);
                this.textoAccion.setVisible(true);
            }),
            new KeyFrame(Duration.seconds(2), event -> {
                this.textoAccion.setVisible(false);
                this.stage.close();
            })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void mostrarTextoInformativo(){
        if (pos < jugador.getPokemones().size() && pos != -1){

            Pokemon pokemon = jugador.getPokemones().get(pos);
            if (pokemon.estaMuerto()){
                textoAccion.setText("No puedes seleccionar a " + pokemon.getNombre() + "\nEsta Muerto =(");
            }
            //if esta envenenado
            else{
                textoAccion.setText("Estas por seleccionar a " + pokemon.getNombre());
            }
            textoAccion.setVisible(true);
        }
        else {
            textoAccion.setVisible(false);
        }
    }


    public void handleMouseEntered(MouseEvent mouseEvent){
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String identificador = stackPane.getId();
        identificarPocision(identificador);
        mostrarTextoInformativo();

        if (pos == 0) {colorRectangulo0.setFill(Color.LIGHTBLUE);}
        else if (pos == 1) {colorRectangulo1.setFill(Color.LIGHTBLUE);}
        else if (pos == 2) {colorRectangulo2.setFill(Color.LIGHTBLUE);}
        else if (pos == 3) {colorRectangulo3.setFill(Color.LIGHTBLUE);}

    }

    public void handelMouseExited(MouseEvent mouseEvent) {
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String identificador = stackPane.getId();
        identificarPocision(identificador);

        if (pos == 0) {colorRectangulo0.setFill(Color.GREY);}
        else if (pos == 1) {colorRectangulo1.setFill(Color.DIMGRAY);}
        else if (pos == 2) {colorRectangulo2.setFill(Color.GREY);}
        else if (pos == 3) {colorRectangulo3.setFill(Color.DIMGRAY);}
    }

    private void identificarPocision(String identificador){
        if (identificador.equals("0")){this.pos = 0;}
        else if (identificador.equals("1")){this.pos = 1;}
        else if (identificador.equals("2")){this.pos = 2;}
        else if (identificador.equals("3")){this.pos = 3;}
        else{this.pos = -1;}
    }


}
