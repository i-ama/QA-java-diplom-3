import io.qameta.allure.junit4.DisplayName;
import models.MainPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class ConstructorTests {

    private WebDriver driver;
    static private String email = RandomStringUtils.randomAlphabetic(5).toLowerCase(Locale.ROOT) + "@ru.ru";
    static private String password = RandomStringUtils.randomAlphabetic(6);
    static private String name = RandomStringUtils.randomAlphabetic(7);

    //Создаем пользователя
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Соусы»")
    public void switchToSauceSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.logoButtonClick();
        mainPage.isCreateBurgerTextDisplayed();
        mainPage.sauceSectionClick();
        boolean actualResult = mainPage.isSauceSectionHighlighted();
        Assert.assertTrue("Sauce section was not Highlighted", actualResult);
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Начинки»")
    public void switchToFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.logoButtonClick();
        mainPage.isCreateBurgerTextDisplayed();
        mainPage.fillingSectionClick();
        boolean actualResult = mainPage.isFillingSectionHighlighted();
        Assert.assertTrue("Filling section was not Highlighted", actualResult);
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Булки»")
    public void switchToBunSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.logoButtonClick();
        mainPage.isCreateBurgerTextDisplayed();
        mainPage.fillingSectionClick();
        mainPage.bunSectionClick();
        boolean actualResult = mainPage.isBunSectionHighlighted();
        Assert.assertTrue("Filling section was not Highlighted", actualResult);
    }
}
