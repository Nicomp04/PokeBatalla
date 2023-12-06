package org.example;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import org.example.Habilidades.Habilidad;
import org.example.Pokemon.Pokemon;
import org.example.Vista.PantallaCambiarPokemones;
import org.example.Vista.PantallaItems;
import org.example.Vista.PantallaCambiarPokemones;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PantallaBatallaController {
    @FXML
    private Stage stage;

    private Image imagen1;

    private Image imagen2;

    private List<Habilidad> habilidades = new ArrayList<>();

    @FXML
    private Pokemon jugadorPokemon = new Pokemon();
    @FXML
    private Pokemon enemigoPokemon = new Pokemon();

    @FXML
    private ImageView jugadorPokemonImage;

    @FXML
    private ProgressBar jugadorSaludBar;

    @FXML
    private Text jugadorPokemonNombre;

    @FXML
    private ImageView enemigoPokemonImage;

    @FXML
    private ProgressBar enemigoSaludBar;

    @FXML
    private Text enemigoPokemonNombre;
    @FXML
    private ListView<String> habilidadesListView = new ListView<>();

    @FXML
    private VBox detallesHabilidadVBox;
    @FXML
    private Label usosLabel;
    @FXML
    private Label tipoLabel;

    @FXML
    private HBox parteInferiorHBox ;
    @FXML
    private VBox descripcionVBox = new VBox();

    @FXML
    private VBox botoneraVBox;

    @FXML
    private Button luchaButton;

    @FXML
    private Button mochilaButton;

    @FXML
    private Button pokemonButton;

    @FXML
    private Button huirButton;

    @FXML
    private VBox habilidadesVBox;

    private int selectedOptionIndex = 0;

    private Juego juego;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private void elegirHabilidades() {
        // Mostra habilidades en la interfaz
        this.habilidades = jugadorPokemon.getHabilidades();
        List<String> habilidadesNombres = this.habilidadesNombre(habilidades);
        habilidadesListView.getItems().setAll(habilidadesNombres);
        habilidadesListView.getSelectionModel().select(0);
        mostrarDetallesHabilidad(habilidades.get(0));

        // Cambio la visibilidad de las secciones
        descripcionVBox.setVisible(false);
        botoneraVBox.setVisible(false);
        habilidadesVBox.setVisible(true);
        detallesHabilidadVBox.setVisible(true);

        habilidadesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarDetallesHabilidad(obtenerHabilidadPorNombre(newValue, habilidades));
            }
        });
    }

    private List<String> habilidadesNombre(List<Habilidad> habilidades) {
        List<String> nombres = new ArrayList<>();
        for(int i = 0; i< habilidades.size(); i++){
            nombres.add(habilidades.get(i).getNombre());
        }
        return nombres;
    }

    private Habilidad obtenerHabilidadPorNombre(String nombre, List<Habilidad> habilidades) {
        for (Habilidad habilidad : habilidades) {
            if (habilidad.getNombre().equals(nombre)) {
                return habilidad;
            }
        }
        return null; // Manejar el caso en el que no se encuentra la habilidad
    }
    private void mostrarDetallesHabilidad(Habilidad habilidad) {
        usosLabel.setText("Usos restantes: " + habilidad.getUsosDisponibles());
        tipoLabel.setText("Tipo: " + habilidad.getTipo());

    }

    @FXML
    private void usarHabilidad(MouseEvent event) {
        Habilidad habilidadSeleccionada = obtenerHabilidadPorNombre(habilidadesListView.getSelectionModel().getSelectedItem(),habilidades);

        if (habilidadSeleccionada != null) {
            this.juego.getCampo().identificarAtacante(juego.getTurnoActivo().getId());
            this.juego.getCampo().usarHabilidad(habilidadSeleccionada);

            ordenarEstados();
        }
    }

    @FXML
    private void elegirItems() {
        Stage stage = new Stage();
        PantallaItems pantallaItems = new PantallaItems();
        pantallaItems.setStage(stage);
        pantallaItems.mostar(this.juego);

    }

    @FXML
    private void cambiarPokemones(){
        PantallaCambiarPokemones pantallaCambiarPokemones = new PantallaCambiarPokemones();
        pantallaCambiarPokemones.setStage(this.stage);
        pantallaCambiarPokemones.mostrar(this.juego.getTurnoActivo());
    }

    @FXML
    private void huir(){
        this.juego.getTurnoActivo().escapar();
        this.juego.habilitarTurno();
        this.stage.close();
    }
    public void initialize() {
        this.juego = new Juego(this);
        this.imagen1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/chari.gif")));
        this.imagen2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/oster.gif")));
        if ( Objects.equals(juego.getTurnoActivo(), juego.getJugador1())){
            actualizarInterfaz(juego.getJugador2());
        }else{
            actualizarInterfaz(juego.getJugador1());
        }
    }

    public void actualizarInterfaz(Jugador noActivo) {
        enemigoPokemon = noActivo.getPokemonActual();
        jugadorPokemon = juego.getTurnoActivo().getPokemonActual();

        this.jugadorPokemonImage.setImage(jugadorPokemon.getImage());
        this.jugadorSaludBar.setProgress((double) jugadorPokemon.getVidaActual() /jugadorPokemon.getVidaMaxima());
        this.jugadorPokemonNombre.setText(jugadorPokemon.getNombre());

        enemigoPokemonImage.setImage(enemigoPokemon.getImage());
        enemigoSaludBar.setProgress((double)enemigoPokemon.getVidaActual() / enemigoPokemon.getVidaMaxima());
        enemigoPokemonNombre.setText(enemigoPokemon.getNombre());

        descripcionVBox.setVisible(true);
        botoneraVBox.setVisible(true);
        habilidadesVBox.setVisible(false);
        detallesHabilidadVBox.setVisible(false);

        habilidadesListView.setItems(FXCollections.observableArrayList());
        descripcionVBox.requestFocus();
        }
        public void ordenarEstados(){
            this.juego.getCampo().validarEstadoEnvenenado(jugadorPokemon);
            this.jugadorPokemon.restarTurnoEstados();
            this.juego.habilitarTurno();
        }
    @FXML
    private void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            // Moverse a la derecha (incrementar el índice)
            selectedOptionIndex = (selectedOptionIndex + 1) % 4;
        } else if (event.getCode() == KeyCode.LEFT) {
            // Moverse a la izquierda (decrementar el índice)
            selectedOptionIndex = (selectedOptionIndex - 1 + 4) % 4;
        } else if (event.getCode() == KeyCode.ENTER) {
            // Realizar la acción correspondiente al botón seleccionado
            switch (selectedOptionIndex) {
                case 0:
                    elegirHabilidades();
                    break;
                case 1:
                    elegirItems();
                    break;
                case 2:
                    cambiarPokemones();
                    break;
                case 3:
                    huir();
                    break;
            }
        }

        // Actualizar el foco según el índice seleccionado
        updateFocus();
    }

    private void updateFocus() {
        switch (selectedOptionIndex) {
            case 0:
                luchaButton.requestFocus();
                break;
            case 1:
                mochilaButton.requestFocus();
                break;
            case 2:
                pokemonButton.requestFocus();
                break;
            case 3:
                huirButton.requestFocus();
                break;
        }
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void mostrarDerrota(Jugador perdedor) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaDerrota.fxml"));
            Parent root = loader.load();

            PantallaDerrotaController derrotaController = loader.getController();
            derrotaController.setDatosDerrota(perdedor);

            Scene scene = new Scene(root, 600, 400);
            Stage derrotaStage = new Stage();
            derrotaStage.setTitle("Pantalla de Derrota");
            derrotaStage.setScene(scene);
            derrotaStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }


   /* public void usaSuTurnoContra(Jugador jugadorNoActivo) {
        jugadorPokemon = juego.getTurnoActivo().getPokemonActual();
        enemigoPokemon = jugadorNoActivo.getPokemonActual();

        // Cargar la imagen desde el ClassLoader
        //this.jugadorPokemonImage.setImage(this.imagen2);
        this.jugadorSaludBar.setProgress((double) jugadorPokemon.getVidaActual() /jugadorPokemon.getVidaMaxima());
        this.jugadorPokemonNombre.setText(jugadorPokemon.getNombre());

        //enemigoPokemonImage.setImage(this.imagen1);
        enemigoSaludBar.setProgress((double)enemigoPokemon.getVidaActual() / enemigoPokemon.getVidaMaxima());
        enemigoPokemonNombre.setText(enemigoPokemon.getNombre());

        habilidadesListView.setItems(FXCollections.observableArrayList());
        descripcionVBox.requestFocus();
    }*/

    // Puedes agregar más métodos y lógica según sea necesario
}