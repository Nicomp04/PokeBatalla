package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
    @FXML
    private Label textoInformativo;
    @FXML
    private HBox estadosImagen;
    @FXML
    private HBox estadoPokemonActualImagen;
    @FXML
    private Label porcentajeDeVidaPokemon;
    private ImageView pokemonImage = new ImageView();
    private ProgressBar pokemosnSaludBar = new ProgressBar();
    private StackPane[] listaPokemones;
    private HBox informacionPokemon;
    private Jugador jugador;
    private int pos;
    private Juego juego;
    boolean seSeleccionoPokemon;



    public void setStage(Stage stage, Juego juego ) {
        this.listaPokemones = new StackPane[3];
        this.stage = stage;
        this.pos = -1;
        this.juego = juego;
        this.seSeleccionoPokemon = false;
    }

    public void crearListaDePokemonesViewer(Jugador jugador, List<Pokemon> pokemones){
        this.jugador = jugador;
        Image imagen = new Image(jugador.getPokemonActual().getUrl());
        this.jugadorImagen.setImage(imagen);
        this.pokemonNombre.setText(pokemones.get(0).getNombre());
        double porcentajeVidaActual = (jugador.getPokemonActual().getVidaActual() / jugador.getPokemonActual().getVidaMaxima());
        String porcentajeVidaTexto = String.format("%.0f", porcentajeVidaActual * 100);
        this.vidaPokemon.setProgress(porcentajeVidaActual);
        this.porcentajeDeVidaPokemon.setText("  " + porcentajeVidaTexto + " %");
        estadoPokemonActualImagen.getChildren().clear();
        estadoPokemonActualImagen.getChildren().add(setImgaenEstados(jugador.getPokemonActual()));

        Integer j = listaPokemonsVBox.getChildren().size();
        Integer tamanoVBox = j != null ? j : 0;
        for (int i = 0; i < tamanoVBox && (i + 1) < pokemones.size(); i++){

            listaPokemones[i] = (StackPane) listaPokemonsVBox.getChildren().get(i);
            Pokemon pokemon = pokemones.get(i +1 );

            Label pokemonNombre = new Label();
            pokemonNombre.setText(pokemon.getNombre());
            pokemonNombre.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");

            Label espacio = new Label();
            espacio.setText("  ");

            ProgressBar pokemosnSaludBar = new ProgressBar();
            pokemosnSaludBar.setProgress((double) pokemon.getVidaActual() /pokemon.getVidaMaxima());

            Label porcentajeVida = new Label();
            double vida = (pokemon.getVidaActual() / pokemon.getVidaMaxima()) * 100;
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
            seSeleccionoPokemon = true;
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
                estadoPokemonActualImagen.getChildren().clear();
                estadoPokemonActualImagen.getChildren().add(setImgaenEstados(jugador.getPokemonActual()));
                this.textoAccion.setVisible(true);
                this.textoInformativo.setVisible(false);
                this.estadosImagen.setVisible(false);
            }),
            new KeyFrame(Duration.seconds(2), event -> {
                this.textoAccion.setVisible(false);
                this.stage.close();
            })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void mostrarTextoAccion(){
        if (pos < jugador.getPokemones().size() && pos != -1){

            Pokemon pokemon = jugador.getPokemones().get(pos);
            if (pokemon.estaMuerto()){
                textoAccion.setText("No puedes seleccionar a " + pokemon.getNombre() + "\nEsta Muerto =(");
            }
            else{
                textoAccion.setText("Estas por seleccionar a " + pokemon.getNombre());
            }
            textoAccion.setVisible(true);
        }
        else {
            textoAccion.setVisible(false);
        }
    }
    private void mostrarTextoInformativo(){
        if (pos < jugador.getPokemones().size() && pos != -1){
            Pokemon pokemon = jugador.getPokemones().get(pos);

            textoInformativo.setText("Ataque: " + pokemon.getAtaque() + "\n" +
                    "Defensa: " + pokemon.getDefensa() + "\n" +
                    "Nivel: " + pokemon.getNivel() + "\n");



            estadosImagen.getChildren().clear();
            estadosImagen.getChildren().add(setImgaenEstados(pokemon));
            textoInformativo.setVisible(true);
            estadosImagen.setVisible(true);
        }
        else {
            textoInformativo.setVisible(false);
            estadosImagen.setVisible(false);
        }
    }

    private HBox setImgaenEstados(Pokemon pokemon){
        HBox imagenesDeEstados = new HBox();
        for (int i = 0; i < pokemon.getEstados().size(); i++){
            ImageView imageView = new ImageView(pokemon.getEstados().get(i).getUrl());
            imageView.setFitHeight(30);
            imageView.setFitWidth(30);
            imagenesDeEstados.getChildren().add(imageView);
        }
        return imagenesDeEstados;
    }




    public void handleMouseEntered(MouseEvent mouseEvent){
        if (!seSeleccionoPokemon){
            StackPane stackPane = (StackPane) mouseEvent.getSource();
            String identificador = stackPane.getId();
            identificarPocision(identificador);
            mostrarTextoAccion();
            mostrarTextoInformativo();

            if (pos == 1) {colorRectangulo0.setFill(Color.LIGHTBLUE);}
            else if (pos == 2) {colorRectangulo1.setFill(Color.LIGHTBLUE);}
            else if (pos == 3) {colorRectangulo2.setFill(Color.LIGHTBLUE);}
            else if (pos == 4) {colorRectangulo3.setFill(Color.LIGHTBLUE);}
        }

    }

    public void handelMouseExited(MouseEvent mouseEvent) {
        if (!seSeleccionoPokemon){
            StackPane stackPane = (StackPane) mouseEvent.getSource();
            String identificador = stackPane.getId();
            identificarPocision(identificador);

            if (pos == 1) {colorRectangulo0.setFill(Color.GREY);}
            else if (pos == 2) {colorRectangulo1.setFill(Color.DIMGRAY);}
            else if (pos == 3) {colorRectangulo2.setFill(Color.GREY);}
            else if (pos == 4) {colorRectangulo3.setFill(Color.DIMGRAY);}
        }

    }

    private void identificarPocision(String identificador){
        if (identificador.equals("1")){this.pos = 1;}
        else if (identificador.equals("2")){this.pos = 2;}
        else if (identificador.equals("3")){this.pos = 3;}
        else if (identificador.equals("4")){this.pos = 4;}
        else{this.pos = -1;}
    }

    public void cancelarAccion(){
        stage.close();
    }

}
