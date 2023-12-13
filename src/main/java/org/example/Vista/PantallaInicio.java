package org.example.Vista;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.example.Controller.PantallaBatallaController;

import java.io.IOException;


public class PantallaInicio extends VBox {
    Stage stage;
    Button btnInicio;

    public PantallaInicio() {
        super();
        this.stage = new Stage();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Styles/pantallaJuego1.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage1 = new Stage();

            PantallaBatallaController pantallaBatallaController = loader.getController();
            pantallaBatallaController.setStage(stage1);

            Scene scene = new Scene(root);
            stage.close();
            stage1.setTitle("Pantalla de Juego");
            //stage1.setFullScreen(true);
            stage1.setMaxHeight(880);
            stage1.setMaxWidth(1470);
            stage1.setScene(scene);
            stage1.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
