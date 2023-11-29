package org.example;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.StageStyle;
import org.example.Pokemon.Pokemon;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ItemSelectionUtil {

    public static Pokemon showItemSelectionDialog(List<Pokemon> pokemons) {
        if (pokemons.isEmpty()) {
            return null;
        }

        // Crear una lista de opciones personalizadas con nombre y vida del Pokémon
        List<PokemonOption> options = PokemonOption.createOptions(pokemons);

        // Crear un ChoiceBox con las opciones personalizadas
        ChoiceBox<PokemonOption> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(options);

        // Configurar el diálogo de alerta
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Seleccionar Pokémon");
        alert.setHeaderText("Selecciona un Pokémon para aplicar el ítem:");
        alert.initStyle(StageStyle.UTILITY);
        alert.setGraphic(null);
        alert.getDialogPane().setContent(choiceBox);

        // Mostrar el diálogo y esperar la selección del usuario
        Optional<ButtonType> result = alert.showAndWait();

        // Devolver el Pokémon seleccionado o null si el usuario cancela
        return result.map(buttonType -> Objects.requireNonNull(choiceBox.getSelectionModel().getSelectedItem()).getPokemon()).orElse(null);
    }

    public static class PokemonOption {
        private Pokemon pokemon;

        private PokemonOption(Pokemon pokemon) {
            this.pokemon = pokemon;
        }

        public Pokemon getPokemon() {
            return pokemon;
        }

        @Override
        public String toString() {
            // Personalizar cómo se muestra cada opción en el ChoiceBox
            return pokemon.getNombre() + " - Vida: " + pokemon.getVidaActual();
        }

        // Método para crear opciones personalizadas desde una lista de Pokémon
        public static List<PokemonOption> createOptions(List<Pokemon> pokemons) {
            return pokemons.stream().map(PokemonOption::new).toList();
        }
    }
}
