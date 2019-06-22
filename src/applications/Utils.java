package applications;

import applications.model.*;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static applications.Constants.*;

/*
 * Utils.java
 *
 * Version: 1.0
 *
 * Revisions:
 *      Added Documentation
 */
public class Utils {

    public static PhoneInfo parseJSON(String fileName) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(fileName),
                PhoneInfo.class);
    }

    public static Results parseResultDescriptionJSON(String fileName) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(fileName),
                Results.class);
    }

    public static String generateHTMLFile(String contents, String securityLabel) {
        StringBuffer fileContents = new StringBuffer();
        try (Stream<String> stream = Files.lines(Paths.get(HTML_FILE))) {
            stream.forEach(it -> fileContents.append(it));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileContent = fileContents.toString();
        fileContent = fileContent.replace(METRICS_STUB, contents);
        fileContent = fileContent.replace(SCORE_STUB, securityLabel);

        return fileContent;
    }

    public static String classifyDeviceSecurity(int finalScore) {
        if (finalScore > 37) return SECURE_LEVEL_5;
        else if (finalScore > 34 && finalScore <= 37) return SECURE_LEVEL_4;
        else if (finalScore > 30 && finalScore <= 34) return SECURE_LEVEL_3;
        else if (finalScore > 23 && finalScore <= 30) return SECURE_LEVEL_2;
        else if (finalScore > 15 && finalScore <= 23) return SECURE_LEVEL_1;
        return SECURE_LEVEL_0;
    }

    public static ResultDescription findByMetric(List<ResultDescription> resultDescriptionList, String metric) {
        final ResultDescription[] resultDescription = new ResultDescription[1];
        resultDescriptionList.forEach(x -> {
            if (x.getMetric().equals(metric))
                resultDescription[0] = x;
        });
        return resultDescription[0];
    }

    public static PhoneInfo parseJSONAndCustomizeValues(String fileName) throws IOException {

        Gson gson = new Gson();
        PhoneInfo phoneInfo = gson.fromJson(new FileReader(fileName),
                PhoneInfo.class);

        Results results = gson.fromJson(new FileReader("resultDescription" +
                        ".json"),
                Results.class);

        BasicInfo basicInfo = phoneInfo.getBasicInfo();
        int[] versionPossibleInputs = new int[9];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("version")) {
                versionPossibleInputs = rs.getPossibleInputs();
            }
        }
        basicInfo.setVersionRELEASE(versionPossibleInputs[getRandomNumberInRange(0, 8)]);

        int[] bootloaderPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("BOOTLOADER")) {
                bootloaderPossibleInputs = rs.getPossibleInputs();
            }
        }
        basicInfo.setBOOTLOADER(bootloaderPossibleInputs[getRandomNumberInRange(0, 1)]);

        phoneInfo.setBasicInfo(basicInfo);

        SecurityInfo securityInfo = phoneInfo.getSecurityInfo();

        int[] screenLockPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("screenLock")) {
                screenLockPossibleInputs = rs.getPossibleInputs();
            }
        }
        securityInfo.setScreenLock(screenLockPossibleInputs[getRandomNumberInRange(0, 1)]);

        int[] unknownSourcesPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("unknownSources")) {
                unknownSourcesPossibleInputs = rs.getPossibleInputs();
            }
        }
        securityInfo.setUnknownSources(unknownSourcesPossibleInputs[getRandomNumberInRange(0, 1)]);

        int[] developerMenuPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("developerMenu")) {
                developerMenuPossibleInputs = rs.getPossibleInputs();
            }
        }
        securityInfo.setDeveloperMenu(developerMenuPossibleInputs[getRandomNumberInRange(0, 1)]);

        int[] basicIntegrityTestPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("basicIntegrityTest")) {
                basicIntegrityTestPossibleInputs = rs.getPossibleInputs();
            }
        }
        securityInfo.setBasicIntegrityTest(basicIntegrityTestPossibleInputs[getRandomNumberInRange(0, 1)]);

        int[] potentiallyHarmfulApplicationsPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("potentiallyHarmfulApplications")) {
                potentiallyHarmfulApplicationsPossibleInputs = rs.getPossibleInputs();
            }
        }
        securityInfo.setPotentiallyHarmfulApplications(potentiallyHarmfulApplicationsPossibleInputs[getRandomNumberInRange(0, 1)]);

        int[] noOfAppsWithUnsafePermissionPossibleInputs = new int[2];
        for (ResultDescription rs :
                results.getResultDescription()) {
            if (rs.getMetric().equals("noOfAppsWithUnsafePermission")) {
                noOfAppsWithUnsafePermissionPossibleInputs = rs.getPossibleInputs();
            }
        }
        securityInfo.setNoOfAppsWithUnsafePermission(noOfAppsWithUnsafePermissionPossibleInputs[getRandomNumberInRange(0, 8)]);

        phoneInfo.setSecurityInfo(securityInfo);


        return phoneInfo;
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
