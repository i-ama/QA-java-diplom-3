import io.qameta.allure.junit4.DisplayName;
import models.AuthorizationForm;
import models.MainPage;
import models.RegistrationForm;
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
public class RegistrationTests {
    private WebDriver driver;
    private String propertyPath;
    private String optionPath;
    static String email;
    static String password = RandomStringUtils.randomAlphabetic(6);
    static String name = RandomStringUtils.randomAlphabetic(7);
    static private String passwordLessThenSixSymbols = RandomStringUtils.randomAlphabetic(5);

    public RegistrationTests(String propertyPath, String optionPath, String email) {
        this.propertyPath = propertyPath;
        this.optionPath = optionPath;
        this.email = email;
    }

    // Для propertyPath необходимо использовать актуальную версию WebDriver для браузеров на тестовой машине
    // Для optionPath необходимо указать актуальное расположение браузера на тестовой машине
    @Parameterized.Parameters
    public static Object[][]  getTestData() {
        return new Object[][] {
                {"src\\main\\resources\\YandexChromeDriver.exe", "C:\\Users\\igory\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe", RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.ru"},
                {"src\\main\\resources\\ChromeDriver.exe", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.su"},
        };
    }

    // Передаем в качестве параметров настройки браузеров для тестирования.
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", propertyPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(optionPath);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        mainPage.isMakeBurgerTextDisplayed();
        mainPage.personalAccountButtonClick();
        AuthorizationForm authorizationForm = new AuthorizationForm(driver);
        authorizationForm.isLoginTextDisplayed();
        authorizationForm.registrationLinkClick();
        RegistrationForm registrationForm = new RegistrationForm(driver);
        registrationForm.isRegistrationTextDisplayed();
        registrationForm.nameFieldInput(name);
        registrationForm.emailFieldInput(email + "1");
        registrationForm.passwordFieldInput(password);
        registrationForm.registrationButtonClick();
        boolean actualResult = authorizationForm.isLoginTextDisplayed();
        Assert.assertTrue("Registration was not successful", actualResult);
    }

    @Test
    @DisplayName("Регистрация с невалидным паролем")
    public void registrationWithWrongPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.isCreateBurgerTextDisplayed();
        mainPage.personalAccountButtonClick();
        AuthorizationForm authorizationForm = new AuthorizationForm(driver);
        authorizationForm.isLoginTextDisplayed();
        authorizationForm.registrationLinkClick();
        RegistrationForm registrationForm = new RegistrationForm(driver);
        registrationForm.isRegistrationTextDisplayed();
        registrationForm.nameFieldInput(name);
        registrationForm.emailFieldInput(email + "2");
        registrationForm.passwordFieldInput(passwordLessThenSixSymbols);
        registrationForm.registrationButtonClick();
        boolean actualResult = registrationForm.isIncorrectPasswordHintDisplayed();
        Assert.assertTrue("Registration was successful", actualResult);
    }
}
