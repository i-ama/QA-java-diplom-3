package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private static final By loginAccountButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private static final By personalAccountButton = By.xpath("//*[@id='root']/div/header/nav/a/p");
    private static final By constructorButton = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    private static final By logoButton = By.cssSelector("#root > div > header > nav > div > a > svg");
    private static final By bunSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private static final By sauceSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private static final By fillingSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");

    public void loginAccountButtonClick() {
        driver.findElement(loginAccountButton).click();
    }

    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }

    public void logoButtonClick() {
        driver.findElement(logoButton).click();
    }

    public void bunSectionClick() {
        driver.findElement(bunSection).click();
    }

    public void fillingSectionClick() {
        driver.findElement(fillingSection).click();
    }

    public boolean isBunSectionHighlighted() {
        return driver.findElement(bunSection).getCssValue("box-shadow").equals("inset 0 -1px 0 #2f2f37");
    }

    public boolean isSauceSectionHighlighted() {
        return driver.findElement(sauceSection).getCssValue("box-shadow").equals("inset 0 -1px 0 #2f2f37");
    }

    public boolean isFillingSectionHighlighted() {
        return driver.findElement(fillingSection).getCssValue("box-shadow").equals("inset 0 -1px 0 #2f2f37");
    }

    public void open() {
        driver.get(URL);
    }
}
