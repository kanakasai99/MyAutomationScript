package pageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeHomePage {

    WebDriver driver;
    WebDriverWait wait;
    public PracticeHomePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By exceptionLink= By.xpath("//a[contains(text(),'Test Exceptions')]");
    public void clickLinks(){
      wait.until(ExpectedConditions.visibilityOfElementLocated(exceptionLink)).click();
    }
}
