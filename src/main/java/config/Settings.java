package config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private final static String PROP_PATH = "src/main/resources/application.properties";

    public static  String NASCAR_URL = null;
    public static  String YAHOO_URL = null;
    public static  String CHROME_DRIVER = null;
    public static  String CHROME_DRIVER_PATH = null;

    public  static Properties getProperties(){

        final String stage = "local";

        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream(PROP_PATH);
            properties.load(fis);

            NASCAR_URL = properties.getProperty("nascar.baseurl");
            YAHOO_URL = properties.getProperty("yahoo.baseurl");
            CHROME_DRIVER = properties.getProperty("chrome.driver");
            CHROME_DRIVER_PATH = properties.getProperty("chrome.driver.path");
        } catch (IOException e) {

            e.printStackTrace();
        }
        return properties;
    }




}
