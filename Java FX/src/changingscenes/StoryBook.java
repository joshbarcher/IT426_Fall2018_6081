package changingscenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;

/**
 * This Java FX application shows how to changes
 * scenes in Java FX.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class StoryBook extends Application
{
    public static final int WIN_SIZE = 300;
    public static final int DELAY = 3000;

    private Stage stage;
    private String[] headers = {"Part #1", "Part #2", "Part #3", "Part 4"};
    private String[] bodies = {
            "I saw a shark when I went whale watching",
            "A friend of mine fell into the water",
            "I went to get a smoothie",
            "The end..."
    };

    @Override
    public void start(Stage stage)
    {
        this.stage = stage;

        stage.setTitle("Here is my story");
        stage.setScene(getLoadingScreen());
        stage.show();

        KeyFrame frame = new KeyFrame(Duration.millis(DELAY),
                event -> stage.setScene(nextScene(0)));

        Timeline animation = new Timeline(frame);
        animation.play();
    }

    private Scene getLoadingScreen()
    {
        //add a few controls
        ProgressIndicator spinner = new ProgressIndicator();
        Text loadingMessage = new Text("Loading...");

        return createScene(spinner, loadingMessage);
    }

    private Scene nextScene(int index)
    {
        //add controls for the story
        Text header = new Text(headers[index]);
        Text body = new Text(bodies[index]);

        if (index != headers.length - 1)
        {
            Button next = new Button("Next");
            next.setOnAction(event -> stage.setScene(nextScene(index + 1)));

            return createScene(header, body, next);
        }

        //we don't have a next button here
        return createScene(header, body);
    }

    private Scene createScene(Node... nodes)
    {
        VBox panel = new VBox();
        panel.getChildren().addAll(nodes);
        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }

    @Override
    public String toString()
    {
        return "StoryBook{" +
                "stage=" + stage +
                ", headers=" + Arrays.toString(headers) +
                ", bodies=" + Arrays.toString(bodies) +
                '}';
    }
}
