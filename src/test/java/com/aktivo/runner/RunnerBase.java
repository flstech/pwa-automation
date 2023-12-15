package com.aktivo.runner;

import com.aktivo.framework.DriverManager;
import com.aktivo.framework.GlobalParams;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;

public class RunnerBase {
    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner(){
        return testNGCucumberRunner.get();
    }

    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }

    @Parameters({"browserName", "systemPort"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String browserName, String systemPort) throws Exception {
        ThreadContext.put("ROUTINGKEY", browserName + "_" + browserName);
        GlobalParams params = new GlobalParams();
      //  params.setPlatformName(platformName);
        params.setBrowserName(browserName);
        // new ServerManager().startServer();
         new DriverManager().initializeDriver();
        setRunner(new TestNGCucumberRunner(this.getClass()));
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        DriverManager driverManager= new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        getRunner().finish();
    }



}
