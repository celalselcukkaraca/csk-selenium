package steps;

import base.ScenarioContext;

public class BaseContext {

    public static ScenarioContext scenarioContext;

    public BaseContext(){}

    public static ScenarioContext getContext(){
        if(scenarioContext==null){
            scenarioContext=new ScenarioContext();
        }
         return scenarioContext;
    }
}
