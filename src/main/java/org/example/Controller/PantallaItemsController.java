package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.example.Item.Item;
import org.example.Juego;
import org.example.Jugador;
import org.example.Pokemon.Pokemon;

import java.util.List;
import java.util.Optional;

public class PantallaItemsController {


    @FXML
    public Button aplicarItemBoton;
    @FXML
    public Button cancelarBoton;
    @FXML
    public Text descripcionItemText;
    public ListView<Pokemon> pokemonesListView = new ListView<Pokemon>();
    public ImageView mochi;
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
            this.mochi.setImage(new Image("/mochi.png"));
            // Configurar el StringConverter para la ListView
            itemsListView.setCellFactory(param -> new ItemListCell());

            itemsListView.getItems().addAll(this.jugador.getItems());
            aplicarItemBoton.setDisable(true);

            itemsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println("Item seleccionado: " + newValue);
                itemSeleccionado = newValue;
                if (itemSeleccionado != null) {
                    descripcionItemText.setText(itemSeleccionado.getDesc());
                    aplicarItemBoton.setDisable(false);
                } else {
                    aplicarItemBoton.setDisable(true);
                }
            });

            aplicarItemBoton.setOnAction(event -> aplicarItem());
            cancelarBoton.setOnAction(event -> cancelarAccion());
    }

    private void actualizarListaPokemones(List<Pokemon> pokemones) {
        if (itemSeleccionado != null) {
            pokemonesListView.setCellFactory(param -> new pokeListCell());
            pokemonesListView.getItems().addAll(pokemones);
        } else {
            pokemonesListView.getItems().clear();
        }
    }

    @FXML
    public void aplicarItem() {
        if (itemSeleccionado != null) {
            System.out.println("Aplicando item: " + itemSeleccionado.getNombre());
            actualizarListaPokemones(itemSeleccionado.posiblesPokemonesAAplicar(this.jugador.getPokemones()));
            Pokemon pokemon = eleccionPokemon();
            itemSeleccionado.aplicarItem(pokemon);
            if(itemSeleccionado.seAcabo())
                this.jugador.getItems().remove(itemSeleccionado);
            stage.close();
        }
        this.juego.ordenarEstados();
    }
    private Pokemon eleccionPokemon() {
        if (pokemonesListView.getItems().isEmpty()) {
            return null;
        }

        ComboBox<Pokemon> comboBox = new ComboBox<>();

        // Configura el StringConverter
        comboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Pokemon pokemon) {
                if (pokemon == null) {
                    return null;
                } else {
                    // Utiliza la lógica de la CellFactory para mostrar la información
                    return pokemon.getNombre() + " - Vida: " + pokemon.getVidaActual() + "/" + pokemon.getVidaMaxima();
                }
            }

            @Override
            public Pokemon fromString(String string) {
                // No es necesario implementar este método en este caso
                return null;
            }
        });

// Configura la CellFactory del ComboBox
        comboBox.setCellFactory(param -> new pokeListCell());

// Agrega los Pokémon al ComboBox
        comboBox.getItems().addAll(pokemonesListView.getItems());

// Configurar el diálogo de alerta
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Seleccionar Pokémon");
        alert.setHeaderText("Selecciona un Pokémon para aplicar el ítem:");
        alert.setGraphic(null);
        alert.getDialogPane().setContent(comboBox);

// Mostrar el diálogo y esperar la selección del usuario
        Optional<ButtonType> result = alert.showAndWait();

// Devolver el Pokémon seleccionado o null si el usuario cancela
        return result.map(buttonType -> comboBox.getSelectionModel().getSelectedItem()).orElse(null);
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

    private static class pokeListCell extends ListCell<Pokemon> {
        @Override
        protected void updateItem(Pokemon pokemon, boolean empty) {
            super.updateItem(pokemon, empty);
            if (empty || pokemon == null) {
                setText(null);
            } else {
                setText(pokemon.getNombre() + " - Vida: " + pokemon.getVidaActual() +"/" + pokemon.getVidaMaxima());
            }
        }
    }



}

