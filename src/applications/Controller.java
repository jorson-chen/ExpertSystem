package applications;

import applications.model.PhoneInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jess.JessException;

import java.io.IOException;
import java.util.Iterator;

import static applications.Constants.ANDROID_SECURITY_LOG;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    protected void evaluateSecurity(ActionEvent event) {
        PhoneInfo phoneInfo;
        SecurityEngine securityEngine;
        try {
            phoneInfo = Utils.parseJSON(ANDROID_SECURITY_LOG);
            securityEngine = new SecurityEngine(phoneInfo.getBasicInfo(),
                    phoneInfo.getSecurityInfo(),
                    phoneInfo.getSensorInfo(), phoneInfo.getAppInfo());
            Iterator evaluationResult = securityEngine.run();
            evaluationResult.forEachRemaining(x -> System.out.println(x));
            Stage resultStage =
                    (Stage) ((Node) event.getSource()).getScene().getWindow();

            showResultView(evaluationResult, resultStage);
        } catch (JessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void showResultView(Iterator iterator, Stage resultStage) {
        resultStage.setScene(new Scene(new Pane()));
    }

}
