package intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A hello world application for Java FX.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class HelloWorld extends Application
{

    public static final int WIN_SIZE = 300;
    public static final int FONT_SIZE = 30;

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Welcome to my first Java FX App!");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene()
    {
        //create my elements
        VBox column = new VBox();
        Text info = new Text("Hello World");

        //assemble my UI
        column.getChildren().add(info);

        //add a few styles programmatically
        column.setAlignment(Pos.CENTER);
        info.setFont(Font.font("Verdana", FontWeight.BOLD, FONT_SIZE));

        return new Scene(column, WIN_SIZE, WIN_SIZE);
    }
}
