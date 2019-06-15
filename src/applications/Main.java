package applications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static applications.Constants.SCREEN_FXML;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Set Window
        Parent root = FXMLLoader.load(getClass().getResource(SCREEN_FXML));
        // Set title of window
        primaryStage.setTitle("Expert System");
        // Set Scene
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
