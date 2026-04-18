package utils;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigReader {
    private Properties prop;
    private static ConfigReader config;
    private ConfigReader() {
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\Sai\\AutpmationForEverything\\src\\test\\resources\\Config.properties");
            prop.load(file);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static ConfigReader getInstance(){
        if(config==null){
            config=new ConfigReader();
        }
        return config;
    }
    public String getProperty(String key){
        return prop.getProperty(key);
    }
}
