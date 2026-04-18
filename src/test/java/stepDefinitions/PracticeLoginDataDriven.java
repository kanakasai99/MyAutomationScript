package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageclasses.PracticeLoginPage;

import utils.ConfigReader;
import utils.DriverFactory;

public class PracticeLoginDataDriven {


    PracticeLoginPage login;

    @Given("the page is login page")
    public void the_page_is_login_page() {

        login = new PracticeLoginPage(DriverFactory.getDriver());// ✅ create AFTER driver init

        DriverFactory.getDriver().get(ConfigReader.getInstance().getProperty("LoginPageUrl"));
        login.verifyTitlePage();
    }

    @When("I login with different {string} and {string}")
    public void i_login_with_different(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickSubmit();
    }

    @Then("the outcome should be {string}")
    public void the_outcome_should_be(String expected)
        {

            if (expected.equalsIgnoreCase("error")) {

                // ✅ Only check error
                Assert.assertTrue(login.getErrorSize(),
                        "Expected error but login succeeded");

            } else {

                // ✅ First check if success exists
                Assert.assertTrue(login.isSuccessDisplayed(),
                        "Expected success but not displayed");

                // ✅ Then get text
                Assert.assertTrue(
                        login.getSuccessMessage().contains("Logged In Successfully")
                );
            }
        }
}
