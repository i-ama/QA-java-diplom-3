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

    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void resetButtonClick() {
        driver.findElement(resetButton).click();
    }

}
