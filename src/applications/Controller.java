package applications;

import applications.model.EvaluationResult;
import applications.model.PhoneInfo;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jess.JessException;

import java.io.IOException;
import java.util.Iterator;

import static applications.Constants.*;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    protected void evaluateSecurity() {
        PhoneInfo phoneInfo;
        SecurityEngine securityEngine;
        try {
            phoneInfo = Utils.parseJSON(ANDROID_SECURITY_LOG);
            securityEngine = new SecurityEngine(phoneInfo.getBasicInfo(),
                    phoneInfo.getSecurityInfo(),
                    phoneInfo.getSensorInfo(), phoneInfo.getAppInfo());
            Iterator evaluationResult = securityEngine.run();
            showResultView(evaluationResult);
        } catch (JessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void showResultView(Iterator iterator) {
        //  Get current Window
        Stage resultStage = (Stage) startButton.getScene().getWindow();
        //  Create StackPane
        StackPane stackPane = new StackPane();

        ListView listView = new ListView();

        final int[] finalScores = new int[1];
        iterator.forEachRemaining(it -> {
            EvaluationResult evaluationResult = (EvaluationResult) it;
            finalScores[0] = finalScores[0] + evaluationResult.getScore();
//            Label label = new Label();
            listView.getItems().add(evaluationResult.getMetric() + TABS + evaluationResult.getScore());

//            stackPane.getChildren().add(label);
        });


        String securityLabel = classifyDeviceSecurity(finalScores[0]);
        //  Display results to console
        System.out.println(RESULTS);
        System.out.println(OBTAINED_SCORE + finalScores[0]);
        System.out.println(MAXIMUM_SCORE);
        System.out.println(SECURITY_LABEL + securityLabel);

        //  Display results on Window
        VBox vBox = new VBox(listView);
        Scene scene = new Scene(vBox, 800, 500);
        resultStage.setScene(scene);
        resultStage.show();
    }

    private String classifyDeviceSecurity(int finalScore) {
        if (finalScore > 37) return SECURE_LEVEL_5;
        else if (finalScore > 34 && finalScore <= 37) return SECURE_LEVEL_4;
        else if (finalScore > 30 && finalScore <= 34) return SECURE_LEVEL_3;
        else if (finalScore > 23 && finalScore <= 30) return SECURE_LEVEL_2;
        else if (finalScore > 15 && finalScore <= 23) return SECURE_LEVEL_1;
        return SECURE_LEVEL_0;
    }

}
