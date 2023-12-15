package com.aktivo.pages;

import com.aktivo.framework.DriverManager;
import com.aktivo.framework.TestUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.aktivo.framework.PropertyManager.*;


public class BasePage {

    public static WebDriver driver;
    TestUtils utils = new TestUtils();

    public BasePage() {
        driver = new DriverManager().getDriver();
    }


    public void closeApp() {
        utils.log().info("close the driver");
        driver.quit();
    }

    public void waitForPageLoad(double s) {
        try {
            utils.log().info("waiting for seconds:"+s);
            Thread.sleep((long) (s*1000));
        } catch (InterruptedException e) {
            utils.log().info(e.getMessage());
        }
    }

    public void launchApp() {
        utils.log().info("navigate to url: "+getProps().get("cp_login_staging_url"));
        driver.navigate().to(getProps().get("cp_login_staging_url"));
        utils.log().info("Navigated to url");

    }
    public void setCookiesAndRefreshThePage() {
        utils.log().info("navigate to url and set the cookies");
        driver.navigate().to(getProps().get("cp_login_staging_url"));
        Cookie cookie = new Cookie("member_id", getProps().get("staging_user_member_id"));
        Cookie cname = new Cookie("accessToken", getProps().get("staging_user_access_token"));
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cname);
        utils.log().info("cookies are set and refresh the page");
        waitForPageLoad(5);
        driver.navigate().refresh();
        waitForPageLoad(10);
    }

    public void actionClick(WebElement ele){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",ele);
    }
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)",element);
    }
    public void scrollToElement(WebElement element,String argument){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView("+ argument +")",element);
    }
    public void scrollToTop(){
        new Actions(driver).keyDown(Keys.COMMAND).sendKeys(Keys.ARROW_UP).perform();
    }
    public void scrollToBottom(){
        new Actions(driver).keyDown(Keys.COMMAND).sendKeys(Keys.DOWN).perform();
    }

    public void scrollToAndClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        scrollToElement(element);
        actionClick(element);
    }


}
