package org.example.Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.example.Juego;
import org.example.PantallaBatallaController;
import org.example.main;

import java.io.IOException;


public class PantallaInicio extends VBox {
    Stage stage;
    Button btnInicio;

    public PantallaInicio(Stage stage) {
        super();

        btnInicio = new Button("Iniciar Juego");
        btnInicio.setOnAction(e -> {
            System.out.println("¡Juego Iniciado!");
            try {
                this.cambiarAPantallaJuego();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        setAlignment(Pos.CENTER);
        // Add the button to the VBox
        getChildren().add(btnInicio);
    }

    private void cambiarAPantallaJuego() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaJuego1.fxml"));
            Parent root = loader.load();

            // Obtén el controlador de la pantalla de juego y establece el Stage y juego
            PantallaBatallaController pantallaBatallaController = loader.getController();
            pantallaBatallaController.setStage(stage);
            Juego juego = new Juego();
            pantallaBatallaController.setJuego(juego);

            Scene scene = new Scene(root, 320, 240);
            stage.setTitle("Pantalla de Juego");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
