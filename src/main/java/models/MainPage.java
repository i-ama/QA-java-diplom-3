package models;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private static final By createBurgerText = By.cssSelector("h1");
    private static final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By logoButton = By.xpath("//*[name()='svg' and @fill='none']");
    private static final By bunSection = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    private static final By sauceSection = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]");
    private static final By fillingSection = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]");
    private static final By textMakeBurger = By.xpath(".//h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка отображения текста")
    public boolean isCreateBurgerTextDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(createBurgerText));
        return driver.findElement(createBurgerText).isDisplayed();
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void loginAccountButtonClick() {
        driver.findElement(loginAccountButton).click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик по лого")
    public void logoButtonClick() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик по секции Булочки")
    public void bunSectionClick() {
        driver.findElement(bunSection).click();
    }

    @Step("Клик по секции Соусы")
    public void sauceSectionClick() {
        driver.findElement(sauceSection).click();
    }

    @Step("Клик по секции Ингредиенты")
    public void fillingSectionClick() {
        driver.findElement(fillingSection).click();
    }

    @Step("Проверка, что секция Булочки выделена цветом")
    public boolean isBunSectionHighlighted() {
        return driver.findElement(bunSection).getCssValue("pointer-events").equals("none");
    }

    @Step("Проверка, что секция Соусы выделена цветом")
    public boolean isSauceSectionHighlighted() {
        return driver.findElement(sauceSection).getCssValue("pointer-events").equals("none");
    }

    @Step("Проверка, что секция Ингредиенты выделена цветом")
    public boolean isFillingSectionHighlighted() {
        return driver.findElement(fillingSection).getCssValue("pointer-events").equals("none");
    }

    @Step("Проверка, что отображается текст Соберите бургер")
    public boolean isMakeBurgerTextDisplayed() {
        return driver.findElement(textMakeBurger).isDisplayed();
    }

    @Step("Открыть домашнюю страницу")
    public void open() {
        driver.get(URL);
    }
}
