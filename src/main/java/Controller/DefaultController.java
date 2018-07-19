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

package Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class DefaultController {
    @FXML private Text actiontarget;

    @FXML
    protected void handlePrintButtonAction(ActionEvent event) {


        Scene scene = actiontarget.getScene();

        ImageView image = new ImageView(scene.getRoot().snapshot(null, null));


        Printer printer = Printer.getDefaultPrinter();

        if (printer != null) {
            PageLayout pageLayout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
            double scaleX = pageLayout.getPrintableWidth() / image.getBoundsInParent().getWidth();
            double scaleY = pageLayout.getPrintableHeight() / image.getBoundsInParent().getHeight();
            image.getTransforms().add(new Scale(scaleX, scaleY));

            PrinterJob printerJob = PrinterJob.createPrinterJob();
            if (printerJob != null && printerJob.showPrintDialog(scene.getWindow())) {

                boolean success = printerJob.printPage(image);
                if (success) {
                    printerJob.endJob();
                }

                actiontarget.setText("Print Complete.");
            } else {
                actiontarget.setText("Print Failed.");
            }
        }
        else {
            actiontarget.setText("No available printer.");
        }
    }

}
