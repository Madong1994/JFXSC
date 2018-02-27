package jfxs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxs.controller.StageControlller;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static String controller = "controller";
    public static String cview = "/view/sample.fxml";

    private StageControlller stageControlller;
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stageControlller = new StageControlller();

        stageControlller.loadStage(controller,cview);
        stageControlller.showStage(controller);
    }
}
