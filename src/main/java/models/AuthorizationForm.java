package models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationForm {
    private final WebDriver driver;

    public AuthorizationForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By emailField = By.name("name");
    private static final By passwordField = By.name("Пароль");
    private static final By loginButton = By.xpath("/html/body/div/div/main/div/form/button");
    private static final By registrationLink = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private static final By resetPasswordLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");
    private static final By loginHeaderText = By.cssSelector("#root > div > main > div > h2");

    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password + Keys.RETURN);
    }

    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    public void registrationLinkClick() {
        driver.findElement(registrationLink).click();
    }

    public void resetPasswordLinkClick() {
        driver.findElement(resetPasswordLink).click();
    }

    public boolean isLoginHeaderTextDisplayed() {
        return driver.findElement(loginHeaderText).isDisplayed();
    }

}
