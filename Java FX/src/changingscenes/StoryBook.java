package changingscenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StoryBook extends Application
{
    public static final int WIN_SIZE = 300;

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

        sleep(3000);
    }

    public void sleep(double millis)
    {
        KeyFrame frame = new KeyFrame(Duration.millis(millis),
                event -> stage.setScene(nextScene(0)));

        Timeline animation = new Timeline(frame);
        animation.play();
    }

    public Scene getLoadingScreen()
    {
        //add a few controls
        ProgressIndicator spinner = new ProgressIndicator();
        Text loadingMessage = new Text("Loading...");

        return createScene(spinner, loadingMessage);
    }

    public Scene nextScene(int index)
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

    public Scene createScene(Node... nodes)
    {
        VBox panel = new VBox();
        panel.getChildren().addAll(nodes);
        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }
}
