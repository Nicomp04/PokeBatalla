package org.example.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.Juego;


public class JuegoInicio extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Juego con Interfaz");

        Button btnInicio = new Button("Iniciar Juego");
        btnInicio.setOnAction(e -> {
            System.out.println("¡Juego Iniciado!");
            Juego juego = new Juego();
        });

        StackPane root = new StackPane();
        root.getChildren().add(btnInicio);
        primaryStage.setScene(new Scene(root, 300, 200));

        primaryStage.show();
    }
}
