/*
 *
 * fp-uimocker - A simple JavaFX Application with FXMLLoader for mock-up or prototype GUIs in FXML
 *     Copyright (C) <2018>  <Nathaniel Gillard>
 *
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package Application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    Stage appStage;
    BorderPane rootPane;
    Button fileSelectBtn;

    @Override
    public void start(Stage stage) throws Exception {
        Parent customLayout;
        final FileChooser fileChooser = new FileChooser();

        rootPane = new BorderPane();
        appStage = stage;
        fileSelectBtn = new Button("Select Layout");
        fileSelectBtn.setOnAction( (event) -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                setLayout(file.toPath());
            }
        } );

        rootPane.setBottom(fileSelectBtn);

        if (Files.exists(Paths.get(System.getProperty("user.home"), "GuiPrototype.fxml"))) {
            setLayout(Paths.get(System.getProperty("user.home"), "GuiPrototype.fxml"));
        }

        else {
            customLayout = FXMLLoader.load(getClass().getClassLoader().getResource("defaultLayout.fxml"));
            rootPane.setCenter(customLayout);
        }

        Scene scene = new Scene(rootPane);
        stage.setTitle("GUI Prototype");
        stage.setScene(scene);
        stage.show();
    }



    private void setLayout(Path path) {
        Parent customLayout = null;

        try {
            customLayout = FXMLLoader.load(path.toUri().toURL());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (customLayout != null) {
            rootPane.setCenter(customLayout);
        }
    }
}
