package com.aktivo.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driver2){
        driver.set(driver2);
    }

   /* public void executeShellScript(String path){

        try {
            // Create a ProcessBuilder for the shell script
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", path);

            // Redirect the standard output and error to the Java process
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Script executed successfully.");
            } else {
                System.out.println("Script execution failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
*/
    public void initializeDriver() throws Exception {
        WebDriver driver = null;
        GlobalParams params = new GlobalParams();

        try {
            utils.log().info("initializing WebDriver:"+params.getBrowserName());
            switch (params.getBrowserName()) {
                case "Chrome" -> {
          //          executeShellScript("cleanup.sh");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPhone 12 Pro");
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    utils.log().info("Chrome driver is launched");
                }
                case "IE" -> {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    utils.log().info("IE driver is launched");
                }
                case "Safari" -> {
                    WebDriverManager.safaridriver().setup();
                    SafariOptions options = new SafariOptions();
                    driver = new SafariDriver(options);
                    driver.manage().window().setSize(new Dimension(390, 844));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    utils.log().info("Safari driver is launched with iPhone 12 Pro view");

                }
                default -> utils.log().info("Path of Driver Executable is not Set for any Browser");
            }
            if (driver == null) {
                throw new Exception("driver is null. ABORT!!!");
            }
            utils.log().info("Driver is initialized");
            this.driver.set(driver);
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
            utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
            throw e;
        }

    }
}
