# fp-uimocker

A simple JavaFX Application with FXMLLoader for mock-up or prototype GUIs in FXML. 

## How To...

By creating a FXML file named 'GuiPrototype.fxml' and placing it in your home directory you can mock up or prototype a GUI.

See https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm for an introduction to java fxml 

## Controller

A simple controller is provided.
fx:controller="Controller.DefualtController"

As this time it has just one memberand one method. 

public class DefaultController {
    @FXML private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Submit pressed");
    }
}

For now this provides a simple test button, assuming a Text control names actionTarget is included in the mock-up)
