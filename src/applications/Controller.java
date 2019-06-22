package applications;

import applications.model.EvaluationResult;
import applications.model.PhoneInfo;
import applications.model.ResultDescription;
import applications.model.Results;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import jess.JessException;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static applications.Constants.*;
import static applications.Utils.*;

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
    protected void showResultView(Iterator iterator) throws IOException {
        //  Get current Window
        Stage resultStage = (Stage) startButton.getScene().getWindow();

        int finalScores = 1;
        StringBuilder metricsResult = new StringBuilder();

        Results results = parseResultDescriptionJSON(RESULT_DESCRIPTION);
        List<ResultDescription> descriptionList = results.getResultDescription();
        int id = 0;
        while (iterator.hasNext()) {
            EvaluationResult evaluationResult =
                    (EvaluationResult) iterator.next();
            finalScores += evaluationResult.getScore();
            ResultDescription resultDescription = findByMetric(descriptionList,
                    evaluationResult.getMetric());
            metricsResult.append(
                    START_ROW + id++ +
                            NEW_COL + resultDescription.getName() +
                            NEW_COL + evaluationResult.getScore() +
                            NEW_COL + resultDescription.getMaxScore() +
                            NEW_COL + resultDescription.getInfo() +
                            END_ROW);
        }
        int securityLabel = classifyDeviceSecurity(finalScores);

        //  Write to file
//        String content = generateHTMLFile(metricsResult.toString(), securityLabel);

        //  Create Web View
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
//        webEngine.loadContent(content, HTML_CONTENT);
        //  Display results on Window
        Scene scene = new Scene(new VBox(webView), SCREEN_WIDTH, SCREEN_HEIGHT);
        resultStage.setScene(scene);
        resultStage.show();
    }

}
