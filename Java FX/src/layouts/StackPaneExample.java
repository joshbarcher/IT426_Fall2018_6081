package layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Added an example of the stack pane in Java FX.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class StackPaneExample extends Application
{

    public static final int CIRC1_RADIUS = 100;
    public static final int CIRC2_RADIUS = 75;
    public static final int CIRC3_RADIUS = 50;
    public static final int WIN_SIZE = 250;

    @Override
    public void start(Stage stage)
    {
        stage.setScene(assembleScene());
        stage.setTitle("Working with Borders");
        stage.show();
    }

    private Scene assembleScene()
    {
        StackPane panel = new StackPane();

        int[] radii = {CIRC1_RADIUS, CIRC2_RADIUS, CIRC3_RADIUS};
        Circle[] circles = new Circle[radii.length];

        Random random = new Random();
        for (int i = 0; i < circles.length; i++)
        {
            circles[i] = new Circle(radii[i]);
            circles[i].setFill(Color.color(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble()
            ));
        }
        panel.getChildren().addAll(circles);

        //place elements in different positions in the parent panel
        Pos[] positions = {Pos.BOTTOM_RIGHT, Pos.TOP_LEFT, Pos.CENTER_LEFT};
        for (int i = 0; i < circles.length; i++)
        {
            StackPane.setAlignment(circles[i], positions[i]);
        }

        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }
}