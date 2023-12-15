package com.aktivo.stepDef;

import com.aktivo.framework.DriverManager;
import com.aktivo.framework.QaTouchApiClient;
import com.aktivo.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;

public class Hooks{
    public String projectKey="Z7Jk";
    public String testRunId = "MeekK";
    public String newStatus = "1";// means Passed
    public String failStatus = "5";//means Failed
    public String newComments ="Updated through Automation";
    BasePage basePage = new BasePage();

        @Before
        public void initialize() throws Exception {
            basePage.launchApp();
           // basePage.setCookiesAndRefreshThePage();

            //  new VideoManager().startRecording();
        }

        @After
        public void quit(Scenario scenario) throws IOException {
            if(scenario.isFailed()){
                try {
                    // To create reference of TakesScreenshot
                    TakesScreenshot screenshot = (TakesScreenshot) new DriverManager().getDriver();
                    // Call method to capture screenshot
                    byte[] src = screenshot.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(src, "image/png", scenario.getName());
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
                }
            }else
            {
                try {
                    // To create reference of TakesScreenshot
                    TakesScreenshot screenshot = (TakesScreenshot) new DriverManager().getDriver();
                    // Call method to capture screenshot
                    byte[] src = screenshot.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(src, "image/png", scenario.getName());
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
                }
            }
            String[] s= scenario.getName().split("_");
            String run_result_tc_id= s[0].replaceAll("TC","");
            System.out.println("run_result_tc_id: "+run_result_tc_id+ "Test Case Status:"+scenario.getStatus());
            if (scenario.isFailed()) {
                QaTouchApiClient.addTestRunStatus(testRunId,projectKey,run_result_tc_id, failStatus, newComments);
            }
            else  {
                System.out.println("Success");
                QaTouchApiClient.addTestRunStatus(testRunId,projectKey,run_result_tc_id, newStatus, newComments);
            }


          /*    new VideoManager().stopRecording(scenario.getName());
             basePage.closeApp(); // Uncomment this line if you want close browser after each scenario*/

        }
}
