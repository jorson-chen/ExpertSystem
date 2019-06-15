package applications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static applications.Constants.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Set Window
        Parent root = FXMLLoader.load(getClass().getResource(SCREEN_FXML));
        // Set title of window
        primaryStage.setTitle(WINDOW_TITLE);
        // Set Scene
        primaryStage.setScene(new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
