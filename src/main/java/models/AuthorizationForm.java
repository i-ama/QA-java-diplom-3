package models;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationForm {
    private final WebDriver driver;
    private static final By emailField = By.xpath("//fieldset[1]/div/div/input");
    private static final By passwordField = By.xpath("//fieldset[2]/div/div/input");
    private static final By loginButton = By.xpath(".//button[text()='Войти']");
    private static final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private static final By resetPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");
    private static final By loginText = By.xpath(".//h2[text()='Вход']");

    public AuthorizationForm(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле email")
    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Password")
    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password + Keys.RETURN);
    }

    @Step("Клик по кнопке Войти")
    public void loginButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Клик по ссылке Регистрация")
    public void registrationLinkClick() {
        driver.findElement(registrationLink).click();
    }

    @Step("Клик по ссылке Сбросить пароль")
    public void resetPasswordLinkClick() {
        driver.findElement(resetPasswordLink).click();
    }

    @Step("Проверка наличия текста в хэдере")
    public boolean isLoginTextDisplayed() {
        return driver.findElement(loginText).isDisplayed();
    }
}
