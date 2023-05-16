package es.progcipfpbatoi;

import es.progcipfpbatoi.controlador.ChangeScene;
import es.progcipfpbatoi.controlador.PrincipalController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        PrincipalController principalController = new PrincipalController();
        // Muestra de la escena principal.
        ChangeScene.change(stage, principalController, "/vistas/principal.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}