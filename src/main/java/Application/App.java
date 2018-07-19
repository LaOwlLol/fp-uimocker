package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;

        if (Files.exists(Paths.get(System.getProperty("user.home"), "GuiPrototype.fxml"))) {
            root = FXMLLoader.load(Paths.get(System.getProperty("user.home"), "GuiPrototype.fxml").toUri().toURL());
        }
        else {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("defaultLayout.fxml"));
        }

        if (root != null) {
            Scene scene = new Scene(root);
            stage.setTitle("GUI Prototype");
            stage.setScene(scene);
            stage.show();
        }
    }
}
