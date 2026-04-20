package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/*
 * Runner Class:
 * - Entry point to run Cucumber tests
 * - Connects feature files with step definitions
 */

@CucumberOptions(
        features = "C:\\Users\\Sai\\AutpmationForEverything\\src\\test\\resources\\features",
        glue = {"stepDefinitions", "base"},           // packages for steps + hooks
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
        },
        monochrome = true
)
public class LoginRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true) // 🔥 parallel execution
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
