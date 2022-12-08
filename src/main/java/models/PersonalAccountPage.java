package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By youCanChangePersonalDataHint = By.xpath("//*[@id='root']/div/main/div/nav/p");
    private static final By exitButton = By.xpath("//*[@id='root']/div/main/div/nav/ul/li[3]/button");

    public boolean isYouCanChangePersonalDataHintDisplayed() {
        return driver.findElement(youCanChangePersonalDataHint).isDisplayed();
    }

    public void exitButtonClick() {
        driver.findElement(exitButton).click();
    }


}
