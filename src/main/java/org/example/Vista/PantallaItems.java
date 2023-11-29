package org.example.Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Juego;
import org.example.PantallaBatallaController;
import org.example.PantallaItemsController;

import java.io.IOException;

public class PantallaItems {
    private Stage stage;

    private Juego juego;
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void mostar(Juego juego){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaItems.fxml"));
            Parent root = (Parent) loader.load();

            // Obtén el controlador de la pantalla de juego y establece el Stage y juego
            PantallaItemsController pantallaItemsController = loader.getController();

            pantallaItemsController.setStage(stage);
            pantallaItemsController.setJuego(juego);
            pantallaItemsController.mostar();

            Scene scene = new Scene(root,750,520);

            stage.setTitle("Pantalla Items");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
