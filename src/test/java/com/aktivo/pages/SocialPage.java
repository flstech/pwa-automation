package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.Dashboard.*;
import static com.aktivo.locators.WebLocators.Login.TRY_AGAIN_ERROR_MESSAGE;
import static com.aktivo.locators.WebLocators.Social.*;

public class SocialPage extends BasePage{

    TestUtils utils = new TestUtils();
    public SocialPage(){
    }

    public boolean verifyUserOnSocialScreen() {
        utils.log().info("navigate to url and set the cookies");
        driver.navigate().to(getProps().get("cp_login_staging_url"));
        waitForPageLoad(8);
        if(!driver.findElements(By.xpath(TRY_AGAIN_ERROR_MESSAGE)).isEmpty())
        {
            Cookie cookie = new Cookie("member_id", getProps().get("staging_user_member_id"));
            Cookie cname = new Cookie("accessToken", getProps().get("staging_user_access_token"));
            driver.manage().addCookie(cookie);
            driver.manage().addCookie(cname);
            utils.log().info("cookies are set and refresh the page");
            waitForPageLoad(5);
            driver.navigate().refresh();
            waitForPageLoad(10);
        }
        if (driver.findElements(By.id(SOCIAL_SCREEN_TITLE)).isEmpty()) {
            actionClick(driver.findElement(By.xpath(SOCIAL_SCREEN_TAB)));
        }
        return !driver.findElements(By.id(SOCIAL_SCREEN_TITLE)).isEmpty();
    }

    public boolean verifySocialWallDisplayedWithItsComponent() {
        boolean buttonStatus=false;
        boolean createPostTextBox= !driver.findElements(By.id(SHARE_YOUR_THOUGHTS_TEXT_BOX)).isEmpty();
        boolean socialPostTextBox= !driver.findElements(By.xpath(SOCIAL_POST_LIST)).isEmpty();
        boolean cameraIconImage= !driver.findElements(By.id(CAMERA_ICON_IMAGE)).isEmpty();
        System.out.println("status"+cameraIconImage+","+socialPostTextBox+","+createPostTextBox);
        if(createPostTextBox && socialPostTextBox && cameraIconImage)
            buttonStatus = true;
        return buttonStatus;
    }

    public boolean verifyTheHeaderContainsTheTextSocialInTheMiddle() {
        return !driver.findElements(By.id(SOCIAL_SCREEN_TITLE)).isEmpty();
    }

    public int getListOfPostCount() {
        return driver.findElements(By.xpath(SOCIAL_POST_LIST)).size();
    }

    public int getThreeDotsMenuIconCount() {
        return driver.findElements(By.id(THREE_DOTS_POST_MENU_BUTTON)).size();
    }
}
