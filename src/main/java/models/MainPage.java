package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private static final By createBurgerText = By.cssSelector("h1");
    private static final By loginAccountButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private static final By personalAccountButton = By.xpath("//*[@id='root']/div/header/nav/a/p");
    private static final By logoButton = By.cssSelector("#root > div > header > nav > div > a > svg");
    private static final By bunSection = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    private static final By sauceSection = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]");
    private static final By fillingSection = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]");

    public boolean isCreateBurgerTextDisplayed() {
        return driver.findElement(createBurgerText).isDisplayed();
    }
    public void loginAccountButtonClick() {
        driver.findElement(loginAccountButton).click();
    }

    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    public void logoButtonClick() {
        driver.findElement(logoButton).click();
    }

    public void bunSectionClick() {
        driver.findElement(bunSection).click();
    }

    public void sauceSectionClick() {
        driver.findElement(sauceSection).click();
    }

    public void fillingSectionClick() {
        driver.findElement(fillingSection).click();
    }

    public boolean isBunSectionHighlighted() {
        return driver.findElement(bunSection).getCssValue("pointer-events").equals("none");
    }

    public boolean isSauceSectionHighlighted() {
        return driver.findElement(sauceSection).getCssValue("pointer-events").equals("none");
    }

    public boolean isFillingSectionHighlighted() {
        return driver.findElement(fillingSection).getCssValue("pointer-events").equals("none");
    }

    public void open() {
        driver.get(URL);
    }
}
