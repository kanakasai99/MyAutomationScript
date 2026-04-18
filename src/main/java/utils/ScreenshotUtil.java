package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {


    public static String captureScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = System.getProperty("user.dir") + "/screenshots/" + name + "_" + timestamp +".png";
            Files.createDirectories(Path.of(System.getProperty("user.dir") + "/screenshots"));
            Files.copy(src.toPath(), Path.of(path));
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

