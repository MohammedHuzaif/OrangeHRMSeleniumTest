package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static void sleepSeconds(int seconds) throws InterruptedException {
        try{
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPropertyValue(String fileName, String key){
        String returnValue = "No returnValue";
        String rootPath = "src/test/java/orangeHRM/testData/"+fileName;

        try (FileInputStream input = new FileInputStream(rootPath)) {
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            returnValue = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return returnValue;
    }
}
