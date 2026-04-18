package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;


public class PracticeLoginPage {

    WebDriver driver;
    Actions action;
    WebDriverWait wait;

    public PracticeLoginPage(WebDriver driver) {
        if (driver == null) {
            throw new RuntimeException("Driver is NULL - check initialization");
        }

        this.driver = driver;
        this.action = new Actions(driver);   // ✅ FIX
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ FIX
    }

  By username= By.xpath("//input[@id='username']");
    By password= By.xpath("//input[@id='password']");
  By submit= By.xpath("//button[text()='Submit']");
  By error= By.xpath("//div[@id='error']");
 By successmessage=By.xpath("//h1[contains(text(),'Logged In Successfully')]");
  public void enterUsername(){
      driver.findElement(username).sendKeys(ConfigReader.getInstance().getProperty("Username"));
  }

  public void enterPassword(){
      driver.findElement(password).sendKeys(ConfigReader.getInstance().getProperty("Password"));
  }
    public void enterUsername(String userName){
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(userName);
    }

    public void enterPassword(String passWord){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(passWord);
    }
    public void clickSubmit(){
        WebElement btn=driver.findElement(submit);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn);

        btn.click();
    }
 public void verifyTitlePage(){
      String orgTitle=driver.getTitle();
      if(orgTitle.contains("Test Login")){
          System.out.println("user on login page");
      }
      else{
          System.out.println("user on wrong page");
      }
 }
    public void loginWithExcelData(String userName, String passWord){

        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        driver.findElement(username).clear();
        driver.findElement(password).clear();

        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(passWord);

        WebElement btn = driver.findElement(submit);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn);

        btn.click();
    }


 public boolean getErrorSize(){

 return driver.findElements(error).size()>0;
 }
 public String getErrorMessage(){

      return driver.findElement(error).getText();
 }

    public boolean isSuccessDisplayed(){
        return driver.findElements(successmessage).size() > 0;
    }

    public String getSuccessMessage(){
        if(isSuccessDisplayed()){
            return driver.findElement(successmessage).getText();
        }
        return "";
    }

}
