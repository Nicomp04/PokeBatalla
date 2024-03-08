package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.Vista.PantallaInicio;

import java.io.File;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        PantallaInicio pantallaInicio = new PantallaInicio();

        // Cargar la imagen de fondo
        Image backgroundImage = new Image("inicio.png");

        // Crear un fondo de imagen con la imagen de fondo
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage, null, null, null, null);

        // Crear un fondo con la imagen de fondo
        Background background = new Background(backgroundImg);

        pantallaInicio.setBackground(background);

        Scene scene = new Scene(pantallaInicio, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Pantalla de Inicio");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }

}
