package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BarraVida extends Application {

    private double vidaActual = 1.0; // Vida inicial al 100%
    private ProgressBar barraVida;

    @Override
    public void start(Stage primaryStage) {
        // Crear una ProgressBar para representar la barra de vida
        barraVida = new ProgressBar();
        barraVida.setPrefWidth(200); // Ancho de la barra
        actualizarVida();

        // Crear un contenedor VBox para la escena
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().add(barraVida);

        // Crear la escena y mostrarla en el escenario
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Barra de Vida Animada");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Reducir gradualmente la vida usando una animación
        reducirVidaAnimada(0.3); // Reducir la vida en un 30% (ejemplo)
    }

    // Método para actualizar la barra de vida con el valor actual
    private void actualizarVida() {
        barraVida.setProgress(vidaActual);
    }

    // Método para reducir gradualmente la vida usando una animación
    private void reducirVidaAnimada(double reduccion) {
        double vidaReducida = vidaActual - reduccion;

        if (vidaReducida < 0) {
            vidaReducida = 0; // Evitar valores negativos
        }

        final double vidaredox = vidaReducida;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), // Duración de la animación (2 segundos en este caso)
                        e -> {
                            vidaActual = vidaredox; // Actualizar el valor de vida
                            actualizarVida(); // Actualizar la barra de vida
                        })
        );
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

