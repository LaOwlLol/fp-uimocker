# fp-uimocker

A simple JavaFX Application with FXMLLoader for mock-up or prototype GUIs in FXML. 

## How To Use...

See [Oracle Documentation]( https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm) for an introduction to Java FXML.  Do not worry about writing a Java class to load the fxml file; That's what this application does! 

Create an FXML file named 'GuiPrototype.fxml' and place it in your home directory and run this application for GUI mock-ups or prototypes.

## Running...

Double click the jar provided.  Or run from the command line with 'java -jar fp-uimocker.jar'

If you have cloned the repo, you will need to build with './gralde build' before running. (The jar should be located in /build/libs.)

## Controller (with printing!)

A simple controller is provided.

```
fx:controller="Controller.DefualtController"
```
At this time it has just one member and one method.

```
public class DefaultController {
    @FXML private Text actiontarget;

    @FXML
    protected void handlePrintButtonAction(ActionEvent event) {
        ...
    }
}
```

If you want to use the DefaultController (and expect to use it's test printing functionality) you must add an actionTarget Text element to your layout.

With an actionTarget Text and a Print Button which calls handlePrintButtonAction you can use the default controller to print your layout in (scaled in landscape orientation) to a printing device of you choice.
