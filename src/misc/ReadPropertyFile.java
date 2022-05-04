package misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

public class ReadPropertyFile {

    private Properties properties = new Properties();
    private static String path = "/Users/syalaburgi/IdeaProjects/practice/src/misc/ACDGroups.cfg";
    public static void main(String[] args) {
        ReadPropertyFile readPropertyFile = new ReadPropertyFile();
        readPropertyFile.loadPropertiesFile(path);
        // parser properties
        readPropertyFile.parse();
        readPropertyFile.setProperty("test1", "test1");
    }

    private void parse() {
        Set<String> name = properties.stringPropertyNames();
        print(name.toString());
    }

    private void print(String s) {
        System.out.println(s);
    }

    private void setProperty(String key, String value) {
        if(properties.getProperty(key) != null) {
            // log that key has a value which will be overriden.
        }

        properties.setProperty(key, value);

        writeToFile();
    }

    private void writeToFile() {
        try {
            OutputStream outputStream = new FileOutputStream(path);
            properties.store(outputStream, "updated");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            print("file is not found : " + path);
            print(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
            print("failed to store property file: " + path);
            print(e.getMessage());
        }
    }

    private void loadPropertiesFile(String path) {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(path);
            properties.load(inputStream);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            print("file is not found : " + path);
            print(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            print("failed to load property file: " + path);
            print(e.getMessage());
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                print("Failed to close input stream: ");
                print(e.getMessage());
            }
        }
    }

}
