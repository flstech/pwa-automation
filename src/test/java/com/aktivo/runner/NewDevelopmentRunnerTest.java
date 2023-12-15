package com.aktivo.runner;


import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,features = {"src/test/resources/sanityTestSuite"}
        ,glue = {"com.aktivo.stepDef"}
        ,tags = "@New"
)
public class NewDevelopmentRunnerTest extends RunnerBase {

}
