package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageclasses.ExceptionPage;
import utils.ConfigReader;
import utils.DriverFactory;



public class NoSuchElementTest {
ExceptionPage page;

    @Given("the user to logged in practice page")
    public void the_user_to_logged_in_practice_page() {
      page=new ExceptionPage(DriverFactory.getDriver());
      DriverFactory.getDriver().get(ConfigReader.getInstance().getProperty("HomepageUrl"));
     page.verifyTitle();
    }
    @When("user enter perform the action")
    public void user_enter_perform_the_action() {

    }
    @Then("the server responds with nosuchelement exception")
    public void the_server_responds_with_nosuchelement_exception() {
    }

}
