package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.Dashboard.MIND_SCORE_LINK;
import static com.aktivo.locators.WebLocators.Dashboard.NUTRITION_AND_FIBER_SCORE_LINK;
import static com.aktivo.locators.WebLocators.Login.TRY_AGAIN_ERROR_MESSAGE;
import static com.aktivo.locators.WebLocators.Mind.MIND_SCREEN_TITLE;
import static com.aktivo.locators.WebLocators.NutritionAndFiber.*;
import static com.aktivo.locators.WebLocators.Play.WEEKLY_BONUS_POINT_TAB;


public class NutritionAndFiberPage extends BasePage{

    TestUtils utils = new TestUtils();
    public NutritionAndFiberPage(){
    }

    public boolean verifyUserOnNutritionAndFiberScreen() {
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
        if (driver.findElements(By.id(SMART_FIBER_CHECKER_BUTTON)).isEmpty()) {
            actionClick(driver.findElement(By.xpath(NUTRITION_AND_FIBER_SCORE_LINK)));
        }
        return !driver.findElements(By.id(SMART_FIBER_CHECKER_BUTTON)).isEmpty();
    }

    public String getScore() {
        return driver.findElement(By.id(NUTRITION_FIBER_SCORE)).getText();
    }

    public void clickOnSmartFibreChecker() {
        scrollToAndClickElement(By.id(SMART_FIBER_CHECKER_BUTTON));
        waitForPageLoad(2);
    }

    public boolean verifyQuestionsToCalculateTheFibreScore() {
        return !driver.findElements(By.xpath(QUESTION_LIST_TO_CALCULATE_FS)).isEmpty();
    }
    public boolean verifyFoodItemNameDisplayed() {
        return !driver.findElements(By.xpath(ONE_BOWL_RICE_FS)).isEmpty();
    }

    public boolean navigateToNutritionAndFiberScoredPage() {
        if (driver.findElements(By.id(SMART_FIBER_CHECKER_BUTTON)).isEmpty()) {
            actionClick(driver.findElement(By.xpath(NUTRITION_AND_FIBER_SCORE_LINK)));
        }
        return !driver.findElements(By.id(SMART_FIBER_CHECKER_BUTTON)).isEmpty();
    }
}
