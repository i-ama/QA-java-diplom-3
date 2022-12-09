import io.qameta.allure.junit4.DisplayName;
import models.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class AuthorizationTests {
    private WebDriver driver;
    private String propertyPath;
    private String optionPath;
    static private String email = RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.ru";
    static private String password = RandomStringUtils.randomAlphabetic(6);
    static private String name = RandomStringUtils.randomAlphabetic(7);

    public AuthorizationTests(String propertyPath, String optionPath) {
        this.propertyPath = propertyPath;
        this.optionPath = optionPath;
    }

    // Для propertyPath необходимо использовать актуальную версию WebDriver для браузеров на тестовой машине
    // Для optionPath необходимо указать актуальное расположение браузера на тестовой машине
    @Parameterized.Parameters
    public static Object[][]  getTestData() {
        return new Object[][] {
                {"src\\main\\resources\\YandexChromeDriver.exe", "C:\\Users\\igory\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"},
                {"src\\main\\resources\\ChromeDriver.exe", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"},
        };
    }

    // Передаем в качестве параметров настройки браузеров для тестирования.
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", propertyPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(optionPath);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главно")
    public void loginFromMainPage() {
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
        mainPage.logoButtonClick();
        mainPage.loginAccountButtonClick();
        authorizationForm.emailFieldInput(email);
        authorizationForm.passwordFieldInput(password);
        authorizationForm.loginButtonClick();
        boolean actualResult = mainPage.isCreateBurgerTextDisplayed();
        Assert.assertTrue("Login was not successful", actualResult);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromPersonalPage() {
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
        mainPage.logoButtonClick();
        mainPage.personalAccountButtonClick();
        authorizationForm.emailFieldInput(email);
        authorizationForm.passwordFieldInput(password);
        authorizationForm.loginButtonClick();
        boolean actualResult = mainPage.isCreateBurgerTextDisplayed();
        Assert.assertTrue("Login was not successful", actualResult);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPage() {
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
        mainPage.logoButtonClick();
        mainPage.personalAccountButtonClick();
        authorizationForm.registrationLinkClick();
        registrationForm.loginLinkClick();
        authorizationForm.emailFieldInput(email);
        authorizationForm.passwordFieldInput(password);
        authorizationForm.loginButtonClick();
        boolean actualResult = mainPage.isCreateBurgerTextDisplayed();
        Assert.assertTrue("Login was not successful", actualResult);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromResetPasswordPage() {
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
        mainPage.logoButtonClick();
        mainPage.personalAccountButtonClick();
        authorizationForm.resetPasswordLinkClick();
        ResetPasswordForm resetPasswordForm = new ResetPasswordForm(driver);
        resetPasswordForm.loginLinkClick();
        authorizationForm.emailFieldInput(email);
        authorizationForm.passwordFieldInput(password);
        authorizationForm.loginButtonClick();
        boolean actualResult = mainPage.isCreateBurgerTextDisplayed();
        Assert.assertTrue("Login was not successful", actualResult);
    }
}
