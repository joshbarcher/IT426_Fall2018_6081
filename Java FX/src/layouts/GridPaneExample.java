package layouts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Added an example of using the GridPane layout.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class GridPaneExample extends Application
{
    public static final int NUM_COLS = 3;
    public static final int NUM_BOXES = 3;
    public static final int COL_WIDTH = 80;
    public static final int WIN_WIDTH = 400;
    public static final int WIN_HEIGHT = 500;

    @Override
    public void start(Stage stage)
    {
        stage.setScene(getScene());
        stage.setTitle("Working in a grid");
        stage.show();
    }

    private Scene getScene()
    {
        GridPane grid = new GridPane();

        //set some spacing
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10));

        //we can define the size of columns or rows
        ObservableList<ColumnConstraints> cols = grid.getColumnConstraints();
        for (int i = 1; i <= NUM_COLS; i++)
        {
            cols.add(new ColumnConstraints(COL_WIDTH));
        }

        //add a row of checkboxs
        for (int i = 0; i < NUM_BOXES; i++)
        {
            grid.add(new CheckBox("Option #" + i), i,0);
        }

        //then add a button that spans columns
        Button button = new Button("Please Click Me!");
        button.setPrefWidth(Double.MAX_VALUE);
        grid.add(button, 0,1,3,1);

        //then add a text area with row and col span
        TextArea area = new TextArea();
        grid.add(area, 0, 2, 2, 2);

        //double check that our row span is working
        grid.add(new Button("Click me too!"), 2, 2);

        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);
    }
}







