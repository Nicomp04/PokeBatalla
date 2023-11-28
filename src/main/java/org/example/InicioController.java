package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController {
    @FXML
    private Label welcomeText;
    @FXML
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //@FXML
   // private void onHelloButtonClick() throws IOException {
      //  welcomeText.setText("¡Iniciando Juego2!");
        //cambiarAPantallaJuego();
    //}

   /* private void cambiarAPantallaJuego() throws IOException {
        FXMLLoader loader = new FXMLLoader(PokemonApp.class.getResource("/org/example/pantallaJuego.fxml"));
        Parent root =(Parent) loader.load();

        // Obtén el controlador de la pantalla de juego y establece el Stage y juego
        PantallaBatallaController pantallaBatallaController = loader.getController();
        pantallaBatallaController.setStage(stage);
        Juego juego = new Juego();
        pantallaBatallaController.setJuego(juego);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Pantalla de Juego");
        stage.setScene(scene);
        stage.show();
    }*/
}