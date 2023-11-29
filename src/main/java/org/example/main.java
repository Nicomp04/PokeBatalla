package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Vista.PantallaInicio;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        PantallaInicio pantallaInicio = new PantallaInicio(primaryStage);

        // Create a scene and set it to the stage
        Scene scene = new Scene(pantallaInicio, 400, 300);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle("Pantalla de Inicio");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
