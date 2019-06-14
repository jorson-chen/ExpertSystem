package applications;

import applications.Beans.PhoneInfo;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;


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

}
