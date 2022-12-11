package models;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private final WebDriver driver;
    private static final By youCanChangePersonalDataHint = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private static final By exitButton = By.xpath(".//button[text()='Выход']");
    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что хинт Вы можете изменить личные данные отобразился")
    public boolean isYouCanChangePersonalDataHintDisplayed() {
        return driver.findElement(youCanChangePersonalDataHint).isDisplayed();
    }

    @Step("Клик по кнопке Выход")
    public void exitButtonClick() {
        driver.findElement(exitButton).click();
    }

    @Step("Клик по кнопке Конструктор")
    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }
}
