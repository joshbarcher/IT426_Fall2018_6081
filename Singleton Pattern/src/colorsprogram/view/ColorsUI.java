package colorsprogram.view;

import colorsprogram.controller.Controller;
import colorsprogram.model.ColorPair;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class ColorsUI extends Application
{
    private Controller controller = new Controller();
    private FlowPane colorsPanel;

    @Override
    public void start(Stage stage)
    {
        stage.setScene(getScene());
        stage.setTitle("Working with MVC");
        stage.show();
    }

    private Scene getScene()
    {
        VBox mainPanel = new VBox();
        mainPanel.setPadding(new Insets(10));
        mainPanel.setSpacing(10);

        mainPanel.getChildren().addAll(entryForm(), colorsRegion());

        //add all saved colors
        addColors(controller.handleGetColors());

        return new Scene(mainPanel, 600, 500);
    }

    private HBox entryForm()
    {
        Label enterLabel = new Label("Enter a new color: ");
        TextField nameEntry = new TextField();
        ColorPicker colorEntry = new ColorPicker();
        Button add = new Button("Add!");

        add.setOnAction(event -> {
            controller.handleNewColor(nameEntry.getText(), colorEntry.getValue());
            addColor(new ColorPair(nameEntry.getText(), colorEntry.getValue()));
        });

        HBox controlsPanel = new HBox();
        controlsPanel.setSpacing(10);
        controlsPanel.getChildren().addAll(enterLabel, nameEntry, colorEntry, add);

        return controlsPanel;
    }

    private FlowPane colorsRegion()
    {
        colorsPanel = new FlowPane();
        colorsPanel.setHgap(10);
        colorsPanel.setVgap(10);
        return colorsPanel;
    }

    private void addColors(List<ColorPair> colors)
    {
        for (ColorPair pair : colors)
        {
            addColor(pair);
        }
    }

    private void addColor(ColorPair pair)
    {
        Rectangle square = new Rectangle();
        square.setWidth(40);
        square.setHeight(40);
        square.setFill(pair.getColor());

        //add a tooltip with the name
        Tooltip tip = new Tooltip(pair.getName());
        Tooltip.install(square, tip);

        colorsPanel.getChildren().add(square);
    }
}
