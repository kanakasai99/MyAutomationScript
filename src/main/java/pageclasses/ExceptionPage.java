package pageclasses;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class ExceptionPage {

    WebDriver driver;

    public ExceptionPage(WebDriver driver){
        this.driver=driver;
    }


    public void verifyTitle(){
        String orgtTitle="Practice Test Automation | Learn Selenium WebDriver";
        String actualTitle=driver.getTitle();
        if(orgtTitle.equals(actualTitle)){
            System.out.println("user on correct home page");
        }
        else{
            System.out.println("title not match , not on correct url");
        }
    }

}
