package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageclasses.PracticeLoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class PracticeBlogLoginTest {
    PracticeLoginPage login;
    @Given("the page is practice blogpage")
    public void enterPage(){
        login = new PracticeLoginPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get(ConfigReader.getInstance().getProperty("LoginPageUrl"));
        login.verifyTitlePage();
    }

     @When("I enter the username and password with different sets")
public void enterCredentials(){
        login.enterUsername();
        login.enterPassword();
        login.clickSubmit();
     }

    @Then("the outcome should come with data match")
    public void loginStatus(){

       if(login.getErrorSize()) {
           login.getErrorMessage();
       Assert.fail("Login failed due to invalid username or password");
}
        else{
            login.getSuccessMessage();
            }
    }
}
