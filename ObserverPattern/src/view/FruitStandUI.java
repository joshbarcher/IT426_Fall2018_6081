package view;

import controller.FruitController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Fruit;
import observer.IObserver;
import observer.Observable;

import java.util.HashMap;
import java.util.Map;
import model.FruitData.Change;

public class FruitStandUI extends Application implements IObserver
{
    public static final int WIN_SIZE = 400;
    public static final int STANDARD_SPACING = 10;
    public static final int LABEL_WIDTH = 60;

    private Stage stage;
    private FruitController controller;
    private ListView fruitList;
    private Map<String, TextField> fieldMap;

    public FruitStandUI()
    {
        controller = new FruitController(this);
        fieldMap = new HashMap<>();

        //this list should only be created once
        fruitList = new ListView<>();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        this.stage = stage;

        //ready the application
        stage.setTitle("Fruit Stand!");
        stage.setScene(getMainScene());
        stage.show();
    }

    private Scene getMainScene()
    {
        //parent panel
        VBox panel = new VBox();

        //controls in panel
        Text header = new Text("Fruit Stand");
        Button addFruit = new Button("Add Fruit");

        //panel spacing
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(STANDARD_SPACING);
        panel.setPadding(new Insets(STANDARD_SPACING));

        //load a new scene on button press
        addFruit.setOnAction((ActionEvent event) -> {
            stage.setScene(getAddFruitScene());
        });

        //generate the panel and scene
        panel.getChildren().addAll(header, fruitList, addFruit);
        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }

    private Scene getAddFruitScene()
    {
        //parent panel
        VBox panel = new VBox();

        //controls
        Button saveFruit = new Button("Save Fruit");

        //load a new scene on button press
        saveFruit.setOnAction((ActionEvent event) -> {
            controller.addFruit(fieldMap.get("Fruit Type").getText(),
                    fieldMap.get("Fresh?").getText());

            stage.setScene(getMainScene());
        });

        //panel spacing
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(STANDARD_SPACING);
        panel.setPadding(new Insets(STANDARD_SPACING));

        //generate the panel and scene
        panel.getChildren().addAll(getLabelTextField("Fruit Type"),
                getLabelTextField("Fresh?"),
                saveFruit);
        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }

    private HBox getLabelTextField(String displayName)
    {
        //parent panel
        HBox panel = new HBox();

        //child controls
        Label label = new Label(displayName);
        TextField textField = new TextField();

        //save the text field for later
        fieldMap.put(displayName, textField);

        //element spacing
        panel.setSpacing(STANDARD_SPACING);
        panel.setAlignment(Pos.CENTER);
        label.setMinWidth(LABEL_WIDTH);

        panel.getChildren().addAll(label, textField);

        return panel;
    }

    @Override
    public void update(Observable observable, Object... args)
    {
        Change command = (Change)args[0];
        switch (command)
        {
            case ADD:
                Fruit fruit = (Fruit)args[1];
                fruitList.getItems().add(fruit.toString());
                break;
            case UPDATE:
                break;
            case REMOVE:
                break;
        }
    }
}