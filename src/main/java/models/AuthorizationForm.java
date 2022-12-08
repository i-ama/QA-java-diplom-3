package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationForm {
    private final WebDriver driver;

    public AuthorizationForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private static final By passwordField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/label");
    private static final By loginButton = By.xpath("//*[@id='root']/div/main/div/form/button");
    private static final By registrationLink = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private static final By resetPasswordLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");

    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
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

}
