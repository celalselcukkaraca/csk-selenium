package base;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.PharmacyPage;
import steps.BaseContext;

public class BaseStep {

    ScenarioContext scenarioContext= BaseContext.getContext();

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public static int success;
    public static int fail;
    public static int total;











}
