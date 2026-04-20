package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class ExceptionPage {
   By button=By.xpath("//button[@id='add_btn']");
  By row2= By.xpath("//label[contains(text(),'Row 2')]");
    WebDriver driver;
    WebDriverWait wait;
    public ExceptionPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void verifyExceptionPage(){
        String orgtTitle="Test Exceptions | Practice Test Automation";
       wait.until(ExpectedConditions.titleIs(orgtTitle));
      String actualTitle= driver.getTitle();
        if(orgtTitle.equals(actualTitle)){
            System.out.println("user on correct exception page");
        }
        else{
            System.out.println("title not match , not on correct url");
        }
    }

    public void addRow(){
        driver.findElement(button).click();
        //driver.findElement(row2);
       WebElement row2Element= wait.until(ExpectedConditions.visibilityOfElementLocated(row2));
       String row2Text=row2Element.getText();
       System.out.println("Row gets added is  :   "+row2Text);

    }

}
