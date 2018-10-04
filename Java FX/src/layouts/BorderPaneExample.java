package layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Added an example of border pane in Java FX
 *
 * @author Josh Archer
 * @version 1.0
 */
public class BorderPaneExample extends Application
{
    public static final int WIN_SIZE = 500;

    @Override
    public void start(Stage stage)
    {
        stage.setScene(assembleScene());
        stage.setTitle("Working with Borders");
        stage.show();
    }

    private Scene assembleScene()
    {
        BorderPane panel = new BorderPane();

        //add nested panels to our border layout
        panel.setLeft(buildWestPanel());
        panel.setRight(buildEastPanel());
        panel.setTop(buildNorthPanel());
        panel.setBottom(buildSouthPanel());
        panel.setCenter(buildCenterPanel());

        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }

    private HBox buildNorthPanel()
    {
        HBox panel = new HBox();
        panel.setStyle("-fx-background-color: red");
        panel.setPrefHeight(100);
        return panel;
    }

    private HBox buildSouthPanel()
    {
        HBox panel = new HBox();
        panel.setStyle("-fx-background-color: blue");
        panel.setPrefHeight(100);
        return panel;
    }

    private VBox buildEastPanel()
    {
        VBox panel = new VBox();
        panel.setStyle("-fx-background-color: green");
        panel.setPrefWidth(100);
        return panel;
    }

    private VBox buildWestPanel()
    {
        VBox panel = new VBox();
        panel.setStyle("-fx-background-color: gray");
        panel.setPrefWidth(100);

        //add some nested controls
        for (int i = 1; i <= 4; i++)
        {
            panel.getChildren().add(new Button("Hello"));
        }

        return panel;
    }

    private ScrollPane buildCenterPanel()
    {
        ScrollPane panel = new ScrollPane();
        panel.setContent(new ImageView(new Image("bear.jpg")));
        return panel;
    }
}