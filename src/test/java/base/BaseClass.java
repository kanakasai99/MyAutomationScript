package base;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import utils.*;

import java.util.List;
import java.util.Map;

public class BaseClass {

    public static List<Map<String, String>> testData;

    @BeforeAll
    public static void setupReport() {
        ExtentSparkReporterManager.getInstance();
    }


    @Before
    public void initDriver(Scenario scenario) {
        ExtentSparkReporterManager.createTest(scenario.getName());
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            String path = ScreenshotUtil.captureScreenshot(
                    DriverFactory.getDriver(),
                    scenario.getName()
            );

            if (path != null && !path.isEmpty()) {
                ExtentSparkReporterManager.getTest()
                        .fail("Test Failed")
                        .addScreenCaptureFromPath(path);
            } else {
                ExtentSparkReporterManager.getTest().fail("Screenshot not captured");
            }
        }

        DriverFactory.quitDriver();
    }

    @AfterAll
    public static void flush() {
        ExtentSparkReporterManager.flushReport();
    }
}

