package ru.bugred.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage {
    private WebDriver driver;

    // Login selectors

    private final By loginEmailBy = By.xpath("//form[@action=\"/user/login/index.html\"]//input[@name=\"login\"]");
    private final By loginPasswordBy = By.xpath("//form[@action=\"/user/login/index.html\"]//input[@name=\"password\"]");
    private final By loginButtonBy = By.cssSelector("[value=\"Авторизоваться\"]");

    // Register selectors

    private final By registerNameBy = By.xpath("//form[@action=\"/user/register/index.html\"]//input[@name=\"name\"]");
    private final By registerEmailBy = By.xpath("//form[@action=\"/user/register/index.html\"]//input[@name=\"email\"]");
    private final By registerPasswordBy = By.xpath("//form[@action=\"/user/register/index.html\"]//input[@name=\"password\"]");
    private final By registerButtonBy = By.name("act_register_now");


    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String email, String password) {
        driver.findElement(loginEmailBy).sendKeys("ababa@gmail.com");
        driver.findElement(loginPasswordBy).sendKeys("123123");

        driver.findElement(loginButtonBy).click();
        return new HomePage(this.driver);
    }

    public HomePage register(String name, String email, String password) {
        driver.findElement(registerNameBy).sendKeys(name);
        driver.findElement(registerEmailBy).sendKeys(email);
        driver.findElement(registerPasswordBy).sendKeys(password);

        driver.findElement(registerButtonBy).click();
        return new HomePage(this.driver);
    }
}
