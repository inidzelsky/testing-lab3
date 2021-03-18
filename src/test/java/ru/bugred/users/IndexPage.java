package ru.bugred.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage {
    private final WebDriver driver;

    private final By filterInputBy = By.cssSelector("[placeholder=\"Введите email или имя\"]");
    private final By filterSubmitBy = By.cssSelector("[type=\"submit\"]");
    private final By usersBy = By.cssSelector(".ajax_load_row tr");

    private final By authButtonBy = By.linkText("Войти");

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://users.bugred.ru");
    }

    public AuthPage moveToAuthPage() {
        driver.findElement(authButtonBy).click();
        return new AuthPage(this.driver);
    }

    public final List<WebElement> filterUsers(String filterEmail) {
        WebElement filter = driver.findElement(filterInputBy);
        filter.sendKeys(filterEmail);
        driver.findElement(filterSubmitBy).click();

        List<WebElement> users = driver.findElements(usersBy);
        return users;
    }
}
