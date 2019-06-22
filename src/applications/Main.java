package applications;

import applications.model.EvaluationResult;
import applications.model.PhoneInfo;
import applications.model.Row;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jess.JessException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import static applications.Constants.*;

public class Main {

    static int trainingDataSetSize = 1000;

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
        generateDataSet();
    }

    private static void generateDataSet() {
        PhoneInfo phoneInfo;
        SecurityEngine securityEngine;
        Row[] rows = new Row[trainingDataSetSize];
        try {
            for (int i = 0; i < trainingDataSetSize; i++) {
                phoneInfo = Utils.parseJSONAndCustomizeValues(ANDROID_SECURITY_LOG);
                securityEngine = new SecurityEngine(phoneInfo.getBasicInfo(),
                        phoneInfo.getSecurityInfo(),
                        phoneInfo.getSensorInfo(), phoneInfo.getAppInfo());
                Iterator iterator = securityEngine.run();


                Row row = new Row();

                row.setVersionRELEASE(phoneInfo.getBasicInfo().getVersionRELEASE());
                row.setBasicIntegrityTest(phoneInfo.getSecurityInfo().getBasicIntegrityTest());
                row.setBOOTLOADER(phoneInfo.getBasicInfo().getBOOTLOADER());
                row.setDeveloperMenu(phoneInfo.getSecurityInfo().getDeveloperMenu());
                row.setNoOfAppsWithUnsafePermission(phoneInfo.getSecurityInfo().getNoOfAppsWithUnsafePermission());
                row.setPotentiallyHarmfulApplications(phoneInfo.getSecurityInfo().getPotentiallyHarmfulApplications());
                row.setScreenLock(phoneInfo.getSecurityInfo().getScreenLock());
                row.setUnknownSources(phoneInfo.getSecurityInfo().getUnknownSources());


                int sum = 0;

                while (iterator.hasNext()) {
                    EvaluationResult evaluationResult =
                            (EvaluationResult) iterator.next();
                    sum += evaluationResult.getScore();
                }

                row.setSecurityScore(sum);

                rows[i] = row;

                System.out.println("Generating " + i);

            }
        } catch (JessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        convertToCSV(rows);
    }

    public static void convertToCSV(Row[] rows) {
        try (PrintWriter writer =
                     new PrintWriter(new File("dataset.csv"))) {

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < rows.length; i++) {
                stringBuilder.append(rows[i].getVersionRELEASE());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getScreenLock());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getDeveloperMenu());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getUnknownSources());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getPotentiallyHarmfulApplications());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getBOOTLOADER());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getBasicIntegrityTest());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getNoOfAppsWithUnsafePermission());
                stringBuilder.append(",");
                stringBuilder.append(rows[i].getSecurityScore());
                stringBuilder.append("\n");

                System.out.println(stringBuilder.toString());
            }


            writer.write(stringBuilder.toString());

            System.out.println("Write Successful!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
