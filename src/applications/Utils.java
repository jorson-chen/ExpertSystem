package applications;

import applications.model.PhoneInfo;
import applications.model.ResultDescription;
import applications.model.Results;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static applications.Constants.*;


/*
 * Utils.java
 *
 * Version: 1.0
 *
 * Revisions:
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
        System.out.println(resultDescription[0].getName());
        return resultDescription[0];
    }

}
