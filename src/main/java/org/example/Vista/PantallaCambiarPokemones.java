package org.example.Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.PantallaBatallaController;
import org.example.PantallaCambiarPokemonesController;
import org.example.Pokemon.Pokemon;

import java.io.IOException;
import java.util.List;


public class PantallaCambiarPokemones {

    private Scene scene;

    Stage stage;

    public PantallaCambiarPokemones() {
    }

    public Scene getScene() {
        return scene;
    }

    public void mostrar(List<Pokemon> pokemones) {
        /*
        // Crear un VBox principal para organizar los elementos
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Supongamos que tienes una lista de Pokémon en tu modelo
        // Aquí se utiliza una lista de imágenes y datos de ejemplo
        String[] pokemonImages = {
                "bulbasaur.png", "charmander.png", "squirtle.png", "pikachu.png"
        };
        String[] nombres = {"Bulbasaur", "Charmander", "Squirtle", "Pikachu"};
        int[] niveles = {10, 12, 8, 15};
        int[] vida = {80, 75, 90, 100};

        // Mostrar los Pokémon en el VBox
        for (int i = 0; i < 4; i++) {
            // Crear un HBox para cada Pokémon
            HBox hbox = new HBox();
            hbox.setSpacing(10);

            // Añadir la imagen a la izquierda
            //ImageView imageView = new ImageView(new Image(pokemonImages[i]));
            //imageView.setFitWidth(100);
            //imageView.setPreserveRatio(true);
            //hbox.getChildren().add(imageView);

            // Añadir la información (nombre, nivel, vida) a la derecha
            VBox infoBox = new VBox();
            infoBox.setAlignment(Pos.CENTER_LEFT);

            Text nombreText = new Text("Nombre: " + nombres[i]);
            Text nivelText = new Text("Nivel: " + niveles[i]);
            Text vidaText = new Text("Vida: " + vida[i]);

            infoBox.getChildren().addAll(nombreText, nivelText, vidaText);
            hbox.getChildren().add(infoBox);

            // Añadir el HBox al VBox principal
            vbox.getChildren().add(hbox);
        }

        this.scene = new Scene(vbox, 600, 400);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

         */
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/listaDePokemons.fxml"));
            Parent root = (Parent) loader.load();

            // Obtén el controlador de la pantalla de juego y establece el Stage y juego
            PantallaBatallaController pantallaBatallaController = loader.getController();


            PantallaCambiarPokemonesController pantallaCambiarPokemonesController = loader.getController();
            pantallaCambiarPokemonesController.setStage(stage);

            Scene scene = new Scene(root);

            stage.setTitle("Lista de Pokemones");
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
