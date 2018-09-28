package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controls extends Application
{
    @Override
    public void start(Stage stage)
    {
        Scene scene = getScene();
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Working with Widgets");
        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene()
    {
        //set up our main panels and scrollbars
        VBox mainPanel = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(mainPanel);

        //add content to the main panel...
        mainPanel.getChildren().addAll(checkBoxes());

        //to set spacing/padding with a panel
        //mainPanel.setSpacing(10);
        //mainPanel.setPadding(new Insets(10));

        //with css
        //mainPanel.setStyle("-fx-spacing: 10px; -fx-padding: 10px");
        mainPanel.setId("main-panel");

        return new Scene(scrollPane, 500, 600);
    }

    public HBox checkBoxes()
    {
        HBox panel = new HBox();
        panel.setId("checkbox-panel");

        String[] options = {"Green", "Blue", "Purple", "Maroon"};
        CheckBox[] boxes = new CheckBox[options.length];

        for (int i = 0; i < options.length; i++)
        {
            boxes[i] = new CheckBox(options[i]);
        }
        panel.getChildren().addAll(boxes);

        //assign event handlers
        for (CheckBox box : boxes)
        {
            //using a ChangeListener<Boolean> here
            box.selectedProperty().addListener(
                    (observable, oldValue, newValue) -> box.setText(newValue.toString()));

            //here is the anonymous class version
            /*box.selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
                {
                    box.setText(newValue.toString());
                }
            });*/
        }

        return panel;
    }

    public HBox radioButtons()
    {
        return null;
    }
}
