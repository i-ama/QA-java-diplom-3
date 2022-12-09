import io.qameta.allure.junit4.DisplayName;
import models.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PersonalAccountTests {

    private WebDriver driver;
    static private String email = RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.ru";
    static private String password = RandomStringUtils.randomAlphabetic(6);
    static private String name = RandomStringUtils.randomAlphabetic(7);

    //Создаем пользователя
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
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
