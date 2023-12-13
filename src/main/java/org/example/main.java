package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.Vista.PantallaInicio;

import java.io.File;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        PantallaInicio pantallaInicio = new PantallaInicio();

        Scene scene = new Scene(pantallaInicio, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Pantalla de Inicio");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }

}
