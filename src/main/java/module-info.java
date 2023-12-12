module PokeBatalla {
    opens org.example;
    requires org.json;
    requires javafx.graphics;
    requires javafx.fxml;
    requires json.simple;
    requires org.slf4j;
    requires javafx.controls;
    requires junit;
    requires org.mockito;
    requires javafx.media;
    requires java.desktop;

    exports org.example;
    exports Test;
    exports org.example.Controller;
    opens org.example.Controller;
}