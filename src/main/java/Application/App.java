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
