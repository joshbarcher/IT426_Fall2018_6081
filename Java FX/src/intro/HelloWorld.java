package intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Welcome to my first Java FX App!");
        stage.setScene(getScene());
        stage.show();
    }

    public Scene getScene()
    {
        //create my elements
        VBox column = new VBox();
        Text info = new Text("Hello World");

        //assemble my UI
        column.getChildren().add(info);

        //add a few styles programmatically
        column.setAlignment(Pos.CENTER);
        info.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        return new Scene(column, 300, 300);
    }
}
