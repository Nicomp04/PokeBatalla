package org.example.Controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.util.Duration;
import org.example.Clima.Clima;
import org.example.Estado.EstadoPokemon;
import org.example.Habilidades.Habilidad;
import org.example.Juego;
import org.example.Jugador;
import org.example.Pokemon.Pokemon;
import org.example.Vista.PantallaCambiarPokemones;
import org.example.Vista.PantallaItems;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class PantallaBatallaController {
    @FXML
    private Stage stage;
    @FXML
    private Pokemon jugadorPokemon = new Pokemon();
    @FXML
    private Pokemon enemigoPokemon = new Pokemon();
    @FXML
    private ImageView jugadorPokemonImage;
    @FXML
    private Text textoDescripcion;
    @FXML
    private Clima climaActual;
    @FXML
    private ImageView ClimaActualImage;
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
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text vidaAtacante;
    private int selectedOptionIndex = 0;
    private Juego juego;
    private MediaPlayer mediaPlayer;
    private double vidaPreviaPokemonAtacado;
    private List<Habilidad> habilidades = new ArrayList<>();

    public HBox estadosAtacante;

    public HBox estadosAtacado;

    public void mostrarEstados(Pokemon pokemon, HBox barra){

        barra.getChildren().clear();
        Set<EstadoPokemon> estadosAgregados = new HashSet<>();

        for (EstadoPokemon estado : pokemon.getEstados()) {
            ImageView imageView = new ImageView(estado.getUrl());

            if (!estadosAgregados.contains(estado)){
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);
                barra.getChildren().add(imageView);
                estadosAgregados.add(estado);
            }
            else{
                estadosAgregados.remove(estado);
            }
        }
    }

    @FXML
    private void elegirHabilidades() {
        this.jugadorPokemon.limpiarHabilidades();
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
                mostrarDetallesHabilidad(Objects.requireNonNull(obtenerHabilidadPorNombre(newValue, habilidades)));
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
        return null;
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
            vidaPreviaPokemonAtacado = this.juego.getCampo().getPokemonAtacado().getVidaActual();
            Pokemon pokemonAtacante = juego.getCampo().getPokemonAtacante();
            this.juego.getCampo().usarHabilidad(habilidadSeleccionada);
            mostrarTextoTemporalmente(pokemonAtacante.getNombre() + " a usado " + habilidadSeleccionada.getNombre());
        }
    }

    public void mostrarTextoEstados(Pokemon pokemon, double duracion){
        Timeline timeline = new Timeline();

        for(EstadoPokemon estado: pokemon.getEstados()){
            actualizarTexto(estado.getMensaje());
            timeline.getKeyFrames().add(mostrarTexto(estado.getMensaje(), 2));
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
    public void cambiarPokemones(){
        Jugador jugadorActivo = this.juego.getTurnoActivo();
        PantallaCambiarPokemones pantallaCambiarPokemones = new PantallaCambiarPokemones();

        Stage stage2 = new Stage();
        pantallaCambiarPokemones.setStage(stage2, juego);
        pantallaCambiarPokemones.mostrar(jugadorActivo);
        actualizarTexto("Es el turno de " + jugadorActivo.getNombre());

    }

    @FXML
    private void huir(){
        this.juego.getTurnoActivo().escapar();
        this.juego.habilitarTurno();
        this.stage.close();
    }

    private void reproducirMusica(String url){

        Media sonido = new Media(new File(url).toURI().toString());

        this.mediaPlayer = new MediaPlayer(sonido);

        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        this.mediaPlayer.play();
    }

    private void pararMusica() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.stop();
        }
    }

    public void initialize() {
        this.juego = new Juego(this);
        this.textoDescripcion.setText(datosJugador());
        if ( Objects.equals(juego.getTurnoActivo(), juego.getJugador1())){
            jugadorPokemon = juego.getJugador2().getPokemonActual();
            actualizarInterfaz(juego.getJugador2());
        }else{
            actualizarInterfaz(juego.getJugador1());
        }
        reproducirMusica("src/main/resources/BattleTheme.mp3");
    }

    public void actualizarInterfaz(Jugador noActivo) {
        climaActual = juego.getCampo().getClima();
        enemigoPokemon = noActivo.getPokemonActual();
        jugadorPokemon = juego.getTurnoActivo().getPokemonActual();

        mostrarEstados(jugadorPokemon, estadosAtacante);
        mostrarEstados(enemigoPokemon, estadosAtacado);

        this.jugadorPokemonImage.setImage(jugadorPokemon.getImage());
        this.jugadorSaludBar.setProgress((double) jugadorPokemon.getVidaActual() /jugadorPokemon.getVidaMaxima());
        this.jugadorSaludBar.setStyle("-fx-accent: " + this.jugadorPokemon.getColorBarra() + ";");
        this.jugadorPokemonNombre.setText(jugadorPokemon.getNombre());
        this.vidaAtacante.setText(String.format("%.2f", jugadorPokemon.getVidaActual()) + "/" + String.format("%.2f", jugadorPokemon.getVidaMaxima()));

        ClimaActualImage.setImage(this.climaActual.getImage());
        System.out.println(this.climaActual.nombre);
        System.out.println(this.climaActual.getUrl());

        this.enemigoPokemonImage.setImage(this.enemigoPokemon.getImage());
        this.enemigoSaludBar.setProgress((double)enemigoPokemon.getVidaActual() / enemigoPokemon.getVidaMaxima());
        this.enemigoSaludBar.setStyle("-fx-accent: " + enemigoPokemon.getColorBarra() + ";");
        this.enemigoPokemonNombre.setText(enemigoPokemon.getNombre());

        descripcionVBox.setVisible(true);
        botoneraVBox.setVisible(true);
        habilidadesVBox.setVisible(false);
        detallesHabilidadVBox.setVisible(false);

        habilidadesListView.setItems(FXCollections.observableArrayList());
        descripcionVBox.requestFocus();
        actualizarTexto(datosJugador());
    }


    public void actualizarTexto(String nuevoTexto) {
        this.textoDescripcion.setText(nuevoTexto);
        descripcionVBox.setVisible(true);
    }

    public void mostrarTextoTemporalmente(String nuevoTexto) {
        double duracionEnSegundos = 2;
        actualizarTexto(nuevoTexto);
        Timeline timeline = new Timeline();

        timeline.getKeyFrames().add(mostrarTexto(nuevoTexto, 0));
        if (pokemonFueDañado()){
            int quitesDeVida = 30;
            for (int i = 0; i < quitesDeVida; i ++){
                timeline.getKeyFrames().add(bajarVidaPokemonAtacado(quitesDeVida, i, duracionEnSegundos));
            }
        }

        for(EstadoPokemon estado: this.jugadorPokemon.getEstados()){
            duracionEnSegundos = duracionEnSegundos + 2;
            timeline.getKeyFrames().add(mostrarTexto(estado.getMensaje(), duracionEnSegundos));
        }
        duracionEnSegundos = duracionEnSegundos + 2;

        timeline.getKeyFrames().add(resetearTurno(duracionEnSegundos));

        timeline.setCycleCount(1);
        timeline.play();
    }
    private KeyFrame mostrarTexto (String nuevoTexto, double duracion){
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duracion), event ->{
            textoDescripcion.setText(nuevoTexto);
            botoneraVBox.setVisible(false);
            habilidadesVBox.setVisible(false);
            detallesHabilidadVBox.setVisible(false);
        });
        return keyFrame;
    }
    private boolean pokemonFueDañado(){
        double vidaActualPokemonAtacado = juego.getCampo().getPokemonAtacado().getVidaActual();
        return (vidaActualPokemonAtacado < vidaPreviaPokemonAtacado);
    }
    private KeyFrame bajarVidaPokemonAtacado(int quitesDeVida, int i, double duracion) {
        double segundoActivacion = (duracion * i) / quitesDeVida;
        double vidaActualPokemonAtacado = juego.getCampo().getPokemonAtacado().getVidaActual();
        double vidaMaximaPokemonAtacado = juego.getCampo().getPokemonAtacado().getVidaMaxima();
        double parteDeVida = ((vidaPreviaPokemonAtacado - vidaActualPokemonAtacado) * i) / quitesDeVida;

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(segundoActivacion), event -> {
            double porcentajeVida = (vidaPreviaPokemonAtacado - parteDeVida) / vidaMaximaPokemonAtacado;
            cambiarColorSaludBar(enemigoSaludBar, enemigoPokemon, porcentajeVida);
            enemigoSaludBar.setProgress(porcentajeVida);
        });
        return keyFrame;
    }

    private void cambiarColorSaludBar(ProgressBar progressBar, Pokemon pokemon, double porcentajeVida) {
        pokemon.setColorBarra(calcularEstiloPorcentajeVida(porcentajeVida));

        progressBar.setStyle("-fx-accent: " + pokemon.getColorBarra() + ";");
    }

    private String calcularEstiloPorcentajeVida(double porcentajeVida) {

        double r = Math.min(1.0, 2.0 - 2.0 * porcentajeVida);
        double g = Math.min(1.0, 2.0 * porcentajeVida);
        double b = 0.0;

        String colorHex = String.format("#%02X%02X%02X",
                (int) (r * 255), (int) (g * 255), (int) (b * 255));

        return colorHex;
    }


    private KeyFrame resetearTurno(double duracionEnSegundos){
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duracionEnSegundos), event ->{
            botoneraVBox.setVisible(true);
            this.juego.habilitarTurno();
        });
        return keyFrame;
    }

    private String datosJugador(){return ("Es el turno de " + juego.getTurnoActivo().getNombre() + ", Vamos " + juego.getTurnoActivo().getPokemonActual().getNombre() + "!!!");}

    @FXML
    private void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            selectedOptionIndex = (selectedOptionIndex + 1) % 4;
        } else if (event.getCode() == KeyCode.LEFT) {
            selectedOptionIndex = (selectedOptionIndex - 1 + 4) % 4;
        } else if (event.getCode() == KeyCode.ENTER) {
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
        } else if (event.getCode() == KeyCode.ESCAPE) {
            // Cerrar la ventana y detener la música
            stage.close();
            pararMusica();
        }

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Styles/pantallaDerrota.fxml"));
            Parent root = loader.load();

            PantallaDerrotaController derrotaController = loader.getController();
            derrotaController.setDatosDerrota(perdedor);

            Scene scene = new Scene(root, 600, 400);
            Stage derrotaStage = new Stage();
            derrotaStage.setTitle("Pantalla de Derrota");
            derrotaStage.setScene(scene);
            derrotaStage.show();
            this.stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelarEleccionHabilidad(ActionEvent actionEvent) {
        descripcionVBox.setVisible(true);
        botoneraVBox.setVisible(true);
        habilidadesVBox.setVisible(false);
        detallesHabilidadVBox.setVisible(false);
    }
}