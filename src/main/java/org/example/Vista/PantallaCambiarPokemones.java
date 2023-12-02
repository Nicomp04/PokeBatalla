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
import org.example.Jugador;
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void mostrar(Jugador j) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/listaDePokemos.fxml"));
            Parent root = (Parent) loader.load();

            // Obtén el controlador de la pantalla de juego y establece el Stage
            PantallaCambiarPokemonesController pantallaCambiarPokemonesController = loader.getController();
            pantallaCambiarPokemonesController.setStage(stage);
            pantallaCambiarPokemonesController.crearListaDePokemonesViewer(j, j.getPokemones());

            Scene scene = new Scene(root);

            stage.setTitle("Lista de Pokemones");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
