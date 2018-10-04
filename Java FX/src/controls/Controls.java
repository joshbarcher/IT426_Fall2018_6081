package controls;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This Java FX application shows several types of controls
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Controls extends Application
{
    public static final int REGION_SIZE = 50;
    public static final int WIN_WIDTH = 500;
    public static final int WIN_HEIGHT = 600;

    @Override
    public void start(Stage stage)
    {
        Scene scene = getScene();
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Working with Widgets");
        stage.setScene(scene);
        stage.show();
    }

    private Scene getScene()
    {
        //set up our main panels and scrollbars
        VBox mainPanel = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(mainPanel);

        //add content to the main panel...
        mainPanel.getChildren().addAll(checkBoxes(), radioButtons(),
                dropdowns(), textElements());

        //to set spacing/padding with a panel
        //mainPanel.setSpacing(10);
        //mainPanel.setPadding(new Insets(10));

        //with css
        //mainPanel.setStyle("-fx-spacing: 10px; -fx-padding: 10px");
        mainPanel.setId("main-panel");

        return new Scene(scrollPane, WIN_WIDTH, WIN_HEIGHT);
    }

    private HBox checkBoxes()
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

    private HBox radioButtons()
    {
        //create our buttons and group
        RadioButton[] buttons = new RadioButton[3];
        ToggleGroup group = new ToggleGroup();

        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new RadioButton("Choice #" + i);
        }
        group.getToggles().addAll(buttons);

        //assemble our panel and return it!
        HBox panel = new HBox();
        panel.setId("radio-panel");
        panel.getChildren().addAll(buttons);
        return panel;
    }

    private VBox dropdowns()
    {
        //string dropdown list
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Alaska", "Turkey", "Fred Meyer", "Montana", "Renton");

        //dates and colors
        DatePicker dates = new DatePicker();
        ColorPicker colors = new ColorPicker();

        //set a css class
        combo.getStyleClass().add("dropdown");
        dates.getStyleClass().add("dropdown");
        colors.getStyleClass().add("dropdown");

        //create a small region to show colors (using a primitive Node)
        Rectangle colorsRegion = new Rectangle();
        colorsRegion.setWidth(REGION_SIZE);
        colorsRegion.setHeight(REGION_SIZE);

        //use an event handler
        colors.setOnAction(event -> colorsRegion.setFill(colors.getValue()));

        VBox panel = new VBox();
        panel.setId("dropdown-panel");
        panel.getChildren().addAll(combo, dates, colors, colorsRegion);
        return panel;
    }

    private VBox textElements()
    {
        VBox userInfoForm = new VBox();
        userInfoForm.getChildren().addAll(
                createEntryFormRow("Name: ", new TextField()),
                createEntryFormRow("Bio: ", new TextArea()));

        return userInfoForm;
    }

    private HBox createEntryFormRow(String prompt, Node textInput)
    {
        HBox row = new HBox();
        Label display = new Label(prompt);
        row.getChildren().addAll(display, textInput);
        return row;
    }
}