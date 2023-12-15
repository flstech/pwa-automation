package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.AccountSetting.*;
import static com.aktivo.locators.WebLocators.Dashboard.*;
import static com.aktivo.locators.WebLocators.Login.*;

public class AccountPage extends BasePage {

    TestUtils utils = new TestUtils();

    public AccountPage() {
    }

    public boolean verifyUserOnPlayScreen() {
        utils.log().info("navigate to url and set the cookies");
        driver.navigate().to(getProps().get("cp_login_staging_url"));
        waitForPageLoad(8);
        if (!driver.findElements(By.xpath(TRY_AGAIN_ERROR_MESSAGE)).isEmpty()) {
            Cookie cookie = new Cookie("member_id", getProps().get("staging_user_member_id"));
            Cookie cname = new Cookie("accessToken", getProps().get("staging_user_access_token"));
            driver.manage().addCookie(cookie);
            driver.manage().addCookie(cname);
            utils.log().info("cookies are set and refresh the page");
            waitForPageLoad(5);
            driver.navigate().refresh();
            waitForPageLoad(10);
        }
        if (driver.findElements(By.xpath(ACCOUNT_SCREEN_TITLE)).isEmpty()) {
            actionClick(driver.findElement(By.xpath(ACCOUNT_SCREEN_TAB)));
        }
        return !driver.findElements(By.xpath(ACCOUNT_SCREEN_TITLE)).isEmpty();
    }

    public void verifyAccountOptionsShouldBeDisplayed(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        // Check if each expected option is enabled on the screen
        for (String option : expectedOptions) {
            WebElement optionElement = driver.findElement(By.xpath(ACCOUNT_OPTION_LIST.replaceAll("AccountOptions", option)));
            System.out.println("optionElement: "+optionElement);
            Assert.assertTrue(optionElement.isDisplayed(),"Option is not displayed");
        }
    }

    public void verifyUserClicksOnCTAButtonsNavigateToThatPage(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        // Check if each expected option is enabled on the screen
        for (String option : expectedOptions) {
            switch (option) {
                case "ConnectedApps" -> {
                    driver.findElement(By.id(CONNECTED_APPS_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.id(CONNECTED_APPS_PAGE_TITLE)).getText(), "Connected Apps","Connected Apps page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                case "Reminders" -> {
                    driver.findElement(By.id(REMINDERS_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.id(REMINDERS_PAGE_TITLE)).getText(), "Reminders","Reminders page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                case "Badges" -> {
                    driver.findElement(By.id(BADGES_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.id(YOUR_BADGES_PAGE_TITLE)).getText(), "Your Badges","Your Badges page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                case "Help" -> {
                    driver.findElement(By.id(HELP_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.xpath(HELP_PAGE_TITLE)).getText(), "Frequently Asked Questions","Frequently Asked Questions page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                case "PrivacyPolicy" -> {
                    driver.findElement(By.id(PRIVACY_POLICY_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.xpath(PRIVACY_POLICY_PAGE_TITLE)).getText(), "Privacy Policy","Privacy Policy page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                case "TermsAndConditions" -> {
                    driver.findElement(By.id(TERMS_AND_CONDITIONS_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.xpath(TERMS_AND_CONDITION_PAGE_TITLE)).getText(), "Terms & Conditions","Terms & Conditions page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                case "EditProfile" -> {
                    driver.findElement(By.id(EDIT_PROFILE_BUTTON)).click();
                    waitForPageLoad(2);
                    Assert.assertEquals(driver.findElement(By.xpath(EDIT_PROFILE_PAGE_TITLE)).getText(), "Edit Profile","Edit Profile page is not displayed");
                    driver.navigate().back();
                    waitForPageLoad(4);
                }
                default -> {
                    System.out.println("Invalid option");
                    Assert.fail("Invalid option selected");
                }

            }
        }
    }

    public boolean clicksOnTheAccountOption(String option) {
        switch (option) {
            case "ConnectedApps" -> {
                driver.findElement(By.id(CONNECTED_APPS_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "Reminders" -> {
                driver.findElement(By.id(REMINDERS_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "Badges" -> {
                driver.findElement(By.id(BADGES_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "Help" -> {
                driver.findElement(By.id(HELP_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "PrivacyPolicy" -> {
                driver.findElement(By.id(PRIVACY_POLICY_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "TermsAndConditions" -> {
                driver.findElement(By.id(TERMS_AND_CONDITIONS_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "EditProfile" -> {
                driver.findElement(By.id(EDIT_PROFILE_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            case "LogOut" -> {
                driver.findElement(By.id(LOG_OUT_BUTTON)).click();
                waitForPageLoad(2);
                return true;
            }
            default -> {
                System.out.println("Invalid option");
                return false;
            }
        }
    }

    public boolean userOnTheAccountOptionPage(String page) {
        switch (page) {
            case "ConnectedApps" -> {
                Assert.assertEquals(driver.findElement(By.id(CONNECTED_APPS_PAGE_TITLE)).getText(), "Connected Apps","Connected Apps page is not displayed");
                return true;
            }
            case "Reminders" -> {
                Assert.assertEquals(driver.findElement(By.id(REMINDERS_PAGE_TITLE)).getText(), "Reminders","Reminders page is not displayed");
                return true;
            }
            case "Badges" -> {
                Assert.assertEquals(driver.findElement(By.id(YOUR_BADGES_PAGE_TITLE)).getText(), "Your Badges","Your Badges page is not displayed");
                return true;
            }
            case "Help" -> {
                Assert.assertEquals(driver.findElement(By.xpath(HELP_PAGE_TITLE)).getText(), "Frequently Asked Questions","Frequently Asked Questions page is not displayed");
                return true;
            }
            case "PrivacyPolicy" -> {
                Assert.assertEquals(driver.findElement(By.xpath(PRIVACY_POLICY_PAGE_TITLE)).getText(), "Privacy Policy","Privacy Policy page is not displayed");
                return true;
            }
            case "TermsAndConditions" -> {
                Assert.assertEquals(driver.findElement(By.xpath(TERMS_AND_CONDITION_PAGE_TITLE)).getText(), "Terms & Conditions","Terms & Conditions page is not displayed");
                return true;
            }
            case "EditProfile" -> {
                Assert.assertEquals(driver.findElement(By.xpath(EDIT_PROFILE_PAGE_TITLE)).getText(), "Edit Profile","Edit Profile page is not displayed");
                return true;
            }
            default -> {
                System.out.println("Invalid option");
                Assert.fail("Invalid option selected");
                return false;
            }
        }

    }

    public boolean confirmationPopUpAppearsWithOptionsLogoutNoAndYes() {
        boolean buttonStatus=false;
        boolean logOutNoButton= !driver.findElements(By.id(LOGOUT_NO_BUTTON)).isEmpty();
        boolean logOutYesButton= !driver.findElements(By.id(LOGOUT_YES_BUTTON)).isEmpty();
        if(logOutNoButton && logOutYesButton)
            buttonStatus = true;
        return buttonStatus;
    }
}
