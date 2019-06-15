package applications;

import applications.model.PhoneInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Iterator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PhoneInfo phoneInfo = Utils.parseJSON("log.json");
        SecurityEngine securityEngine =
                new SecurityEngine(phoneInfo.getBasicInfo(),
                        phoneInfo.getSecurityInfo(),
                        phoneInfo.getSensorInfo(), phoneInfo.getAppInfo());

        Iterator evaluationResult = securityEngine.run();
//        System.out.println(securityEngine.run(phoneInfo));

//        securityEngine.run(phoneInfo);

        int p = 0;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
