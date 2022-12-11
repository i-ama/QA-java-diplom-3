package models;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationForm {
    private final WebDriver driver;

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By nameField = By.xpath("//fieldset[1]/div/div/input");
    private static final By emailField = By.xpath("//fieldset[2]/div/div/input");
    private static final By passwordField = By.xpath("//*[name()='input' and @type='password']");
    private static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By loginLink = By.xpath(".//a[text()='Войти']");
    private static final By incorrectPasswordHint = By.xpath(".//p[text()='Некорректный пароль']");
    private static final By textRegistration = By.xpath(".//h2[text()='Регистрация']");


    @Step("Заполнить поле Имя")
    public void nameFieldInput(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнить поле email")
    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Password")
    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void registrationButtonClick() {
        driver.findElement(registrationButton).click();
    }

    @Step("Клик по кнопке Войти")
    public void loginLinkClick() {
        driver.findElement(loginLink).click();
    }

    @Step("Проверка, что отображается хинт Неверный пароль")
    public boolean isIncorrectPasswordHintDisplayed() {
        return driver.findElement(incorrectPasswordHint).isDisplayed();
    }

    @Step("Проверка, что отображается страница Регистрация")
    public boolean isRegistrationTextDisplayed() {
        return driver.findElement(textRegistration).isDisplayed();
    }
}
