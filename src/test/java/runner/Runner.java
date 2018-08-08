package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"src/test/java"}, glue= {"definition"})
public class Runner extends AbstractTestNGCucumberTests{

}
