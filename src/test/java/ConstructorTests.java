import io.qameta.allure.junit4.DisplayName;
import models.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class ConstructorTests {
    private WebDriver driver;
    private String propertyPath;
    private String optionPath;

    public ConstructorTests(String propertyPath, String optionPath) {
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
