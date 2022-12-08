import io.qameta.allure.junit4.DisplayName;
import models.AuthorizationForm;
import models.MainPage;
import models.RegistrationForm;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    private WebDriver driver;
    static private String email = RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.ru";
    static private String password = RandomStringUtils.randomAlphabetic(6);
    static private String name = RandomStringUtils.randomAlphabetic(7);
    static private String passwordLessThenSixSymbols = RandomStringUtils.randomAlphabetic(5);


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.personalAccountButtonClick();
        AuthorizationForm authorizationForm = new AuthorizationForm(driver);
        authorizationForm.registrationLinkClick();
        RegistrationForm registrationForm = new RegistrationForm(driver);
        registrationForm.nameFieldInput(name);
        registrationForm.emailFieldInput(email);
        registrationForm.passwordFieldInput(password);
        registrationForm.registrationButtonClick();
        boolean actualResult = authorizationForm.isLoginHeaderTextDisplayed();
        Assert.assertTrue("Registration was not successful", actualResult);
    }

    @Test
    @DisplayName("Регистрация с невалидным паролем")
    public void registrationWithWrongPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.personalAccountButtonClick();
        AuthorizationForm authorizationForm = new AuthorizationForm(driver);
        authorizationForm.registrationLinkClick();
        RegistrationForm registrationForm = new RegistrationForm(driver);
        registrationForm.nameFieldInput(name);
        registrationForm.emailFieldInput(email);
        registrationForm.passwordFieldInput(passwordLessThenSixSymbols);
        registrationForm.registrationButtonClick();
        boolean actualResult = registrationForm.isIncorrectPasswordHintDisplayed();
        Assert.assertTrue("Registration was successful", actualResult);
    }
}
