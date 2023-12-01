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

        //reproducirMusica("src/main/resources/BattleTheme.mp3");

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

    private void reproducirMusica(String url){
        // Crear un objeto Media con el archivo de audio
        Media sonido = new Media(new File(url).toURI().toString());

        // Crear un reproductor de medios (MediaPlayer)
        MediaPlayer mediaPlayer = new MediaPlayer(sonido);

        // Configurar el MediaPlayer para reproducir de manera continua (si se desea)
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer.play();
    }
}
