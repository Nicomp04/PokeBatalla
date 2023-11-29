package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.Item.Item;

public class PantallaItemsController {


    @FXML
    public Button aplicarItemBoton;
    @FXML
    public Button cancelarBoton;
    @FXML
    private ListView<Item> itemsListView = new ListView<>();

    @FXML
    private Label itemSeleccionadoLabel;
    @FXML
    private Label unidadesDisponiblesLabel;
    private Stage stage;
    private Juego juego;

    private Jugador jugador;

    private Item itemSeleccionado;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void mostar() {
        actualizar();
    }
    @FXML
    public void actualizar() {
            this.jugador = this.juego.getTurnoActivo();
            // Configurar el StringConverter para la ListView
            itemsListView.setCellFactory(param -> new ItemListCell());

            // Puedes agregar elementos directamente desde el código Java
            itemsListView.getItems().addAll(this.jugador.getItems());
            aplicarItemBoton.setDisable(true);

            itemsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println("Item seleccionado: " + newValue);
                itemSeleccionado = newValue;
                if (itemSeleccionado != null) {
                    aplicarItemBoton.setDisable(false);
                } else {
                    aplicarItemBoton.setDisable(true);
                }
            });

            aplicarItemBoton.setOnAction(event -> aplicarItem());
            cancelarBoton.setOnAction(event -> cancelarAccion());
    }
    @FXML
    public void aplicarItem() {
        if (itemSeleccionado != null) {
            System.out.println("Aplicando item: " + itemSeleccionado.getNombre());

            itemSeleccionado.aplicarItem(this.jugador.getPokemones());
            if(itemSeleccionado.seAcabo())
                this.jugador.getItems().remove(itemSeleccionado);
            stage.close();
        }
        this.juego.ordenarEstados();
    }

    @FXML
    private void cancelarAccion() {
        stage.close();//igualmente pierde el turno
    }

    @FXML
    private void itemSeleccionado() {
        itemSeleccionado = itemsListView.getSelectionModel().getSelectedItem();

        if(itemSeleccionado != null) {
            aplicarItemBoton.setDisable(false);
        } else {
            aplicarItemBoton.setDisable(true);
        }
    }

    private static class ItemListCell extends ListCell<Item> {
        @Override
        protected void updateItem(Item item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.getNombre() + " - Unidades: " + item.getUsos());
            }
        }
    }



}
