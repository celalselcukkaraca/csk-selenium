package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import configuration.Driver;
import utils.AllureUtils;

public class BaseStepsDefinition {

  private WebDriver driver;
  private static final Logger logger = LogManager.getLogger(BaseStepsDefinition.class);
  private AllureUtils allureUtils;

  @Before
  public void setUp() {
    logger.info("Test setup is starting...");
    driver = Driver.getDriver();
    logger.info("Driver is initialized.");
  }

  @After
  public void tearDownAndLogResults(Scenario scenario) {
    if (scenario.isFailed()) {
      logger.error("Scenario failed: " + scenario.getName());
      AllureUtils.takeScreenshot(driver);

    } else {
      logger.info("Scenario passed: " + scenario.getName());
    }

    Driver.closeDriver();
    logger.info("Driver is closed.");
  }
}
