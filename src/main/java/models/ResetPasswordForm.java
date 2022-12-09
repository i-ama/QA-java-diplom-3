package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordForm {
    private final WebDriver driver;

    public ResetPasswordForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By loginLink = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    public void loginLinkClick() {
        driver.findElement(loginLink).click();
    }

}
