package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaDerrotaController {

    Stage stage = new Stage();
    @FXML
    private Label datosDerrotaLabel;

    public void setDatosDerrota(Jugador perdedor) {
        datosDerrotaLabel.setText(perdedor.getNombre() + " te fuiste derrotado!");
    }

    @FXML
    private void volverAJugar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaJuego1.fxml"));
            Parent root = (Parent) loader.load();

            // Obtén el controlador de la pantalla de juego y establece el Stage y juego
            PantallaBatallaController pantallaBatallaController = loader.getController();
            pantallaBatallaController.setStage(stage);

            Scene scene = new Scene(root);

            stage.setTitle("Pantalla de Juego");
            stage.setFullScreen(true);
            stage.setMaxHeight(870);
            stage.setMaxWidth(1470);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
