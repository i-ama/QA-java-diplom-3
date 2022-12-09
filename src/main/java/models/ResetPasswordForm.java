package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordForm {
    private final WebDriver driver;

    public ResetPasswordForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset/div/div/input");
    private static final By resetButton = By.xpath("//*[@id='root']/div/main/div/form/button");
    private static final By loginLink = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void resetButtonClick() {
        driver.findElement(resetButton).click();
    }
    public void loginLinkClick() {
        driver.findElement(loginLink).click();
    }

}
