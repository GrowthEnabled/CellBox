package cellbox;

import cellbox.controller.Controller;
import cellbox.model.arena.Arena;
import cellbox.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by luca on 29.08.17.
 */
public class CellBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Arena arena = new Arena(3);
        Controller controller = new Controller(arena);
        View view = new View(controller, arena);

        controller.init();

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.requestFocus();
        primaryStage.show();

    }
}
