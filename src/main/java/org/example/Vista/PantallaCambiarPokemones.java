package org.example.Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Jugador;
import org.example.Juego;
import org.example.Controller.PantallaCambiarPokemonesController;

import java.io.IOException;


public class PantallaCambiarPokemones {

    private Scene scene;

    private Juego juego;

    Stage stage;

    public PantallaCambiarPokemones() {
    }

    public void setStage(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }

    public void mostrar(Jugador j) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Styles/listaDePokemos.fxml"));
            Parent root = (Parent) loader.load();

            // Obtén el controlador de la pantalla de juego y establece el Stage
            PantallaCambiarPokemonesController pantallaCambiarPokemonesController = loader.getController();
            pantallaCambiarPokemonesController.setStage(stage, juego);
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
