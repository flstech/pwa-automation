package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import org.openqa.selenium.By;

import static com.aktivo.locators.WebLocators.Login.*;
import static com.aktivo.locators.WebLocators.Dashboard.*;

public class LoginPage extends BasePage{

    TestUtils utils = new TestUtils();

    public LoginPage(){
    }


    public void enterUserName(String userName) {
        driver.findElement(By.cssSelector(LOGIN_USER_NAME_TEXT_BOX)).sendKeys(userName);
    }

    public void enterUserPsw(String password) {
        driver.findElement(By.cssSelector(LOGIN_USER_PASSWORD_TEXT_BOX)).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public boolean getHomePageDisplayed() {
        return !driver.findElements(By.xpath(HOME_SCREEN_TAB)).isEmpty();
    }

    public String getLoginUserNameErrorMessage() {
       return  driver.findElement(By.cssSelector(USER_NAME_ERROR_MESSAGE)).getText();
    }

    public String getTryAgainMessage() {
        launchApp();
        waitForPageLoad(10);
        utils.log().info("Message: "+driver.findElement(By.xpath(TRY_AGAIN_ERROR_MESSAGE)).getText());
        return driver.findElement(By.xpath(TRY_AGAIN_ERROR_MESSAGE)).getText();
    }
}
