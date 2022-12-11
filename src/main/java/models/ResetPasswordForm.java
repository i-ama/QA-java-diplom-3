package models;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordForm {
    private final WebDriver driver;
    private static final By loginLink = By.xpath(".//a[text()='Войти']");
    private static final By textResetPassword = By.xpath(".//h2[text()='Восстановление пароля']");

    public ResetPasswordForm(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Войти")
    public void loginLinkClick() {
        driver.findElement(loginLink).click();
    }

    @Step("Проверка, что отображается страница Восстановление пароля")
    public boolean isResetPasswordTextDisplayed() {
        return driver.findElement(textResetPassword).isDisplayed();
    }

}
