import io.qameta.allure.junit4.DisplayName;
import models.AuthorizationForm;
import models.MainPage;
import models.PersonalAccountPage;
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
public class PersonalAccountTests {
    private WebDriver driver;
    private String propertyPath;
    private String optionPath;
    static private String email = RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.ru";
    static private String password = RandomStringUtils.randomAlphabetic(6);
    static private String name = RandomStringUtils.randomAlphabetic(7);

    public PersonalAccountTests(String propertyPath, String optionPath) {
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
    @DisplayName("Проверяет переход по клику на «Личный кабинет»")
    public void switchToPersonalAccountPage() {
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
        mainPage.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        boolean actualResult = personalAccountPage.isYouCanChangePersonalDataHintDisplayed();
        Assert.assertTrue("Personal account was not displayed", actualResult);
    }

    @Test
    @DisplayName("Проверяеи переход из личного кабинета по клику на логотип Stellar Burgers")
    public void switchToMainPageFromPersonalAccountViaLogo() {
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
        mainPage.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.logoButtonClick();
        boolean actualResult = mainPage.isCreateBurgerTextDisplayed();
        Assert.assertTrue("Main page was not displayed", actualResult);
    }

    @Test
    @DisplayName("Проверяеи переход из личного кабинета по клику на Конструктор")
    public void switchToMainPageFromPersonalAccountViaConstructor() {
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
        mainPage.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.constructorButtonClick();
        boolean actualResult = mainPage.isCreateBurgerTextDisplayed();
        Assert.assertTrue("Main page was not displayed", actualResult);
    }

    @Test
    @DisplayName("Проверяеи выход по кнопке «Выйти» в личном кабинете")
    public void logoutOnPersonalAccountPage() {
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
        mainPage.isCreateBurgerTextDisplayed();
        mainPage.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.exitButtonClick();
        boolean actualResult = authorizationForm.isLoginHeaderTextDisplayed();
        Assert.assertTrue("Authorization page was not displayed", actualResult);
    }
}
