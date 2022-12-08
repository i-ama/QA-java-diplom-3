package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationForm {
    private final WebDriver driver;

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By nameField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private static final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private static final By passwordField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    private static final By registrationButton = By.xpath("//*[@id='root']/div/main/div/form/button");
    private static final By incorrectPasswordHint = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");

    public void nameFieldInput(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void registrationButtonClick() {
        driver.findElement(registrationButton).click();
    }

    public boolean isIncorrectPasswordHintDisplayed() {
        return driver.findElement(incorrectPasswordHint).isDisplayed();
    }

}
