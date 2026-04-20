package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
       this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }
By practiceLink=By.xpath("//li/a[contains(text(),'Practice')]");

    public void verifyHomePage(){
        String orgtTitle="Practice Test Automation | Learn Selenium WebDriver";
        String actualTitle=driver.getTitle();
        if(orgtTitle.equals(actualTitle)){
            System.out.println("user lands on correct home page");
        }
        else{
            System.out.println("title not match , not a correct home page");
        }
    }

    public void navigateExceptionPageLink(){
       WebElement practice= wait.until(ExpectedConditions.visibilityOfElementLocated(practiceLink));
        practice.click();
    }

}
