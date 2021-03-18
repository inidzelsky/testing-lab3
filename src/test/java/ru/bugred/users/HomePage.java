package ru.bugred.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final WebDriver driver;

    private final By tasksButtonBy = By.xpath("//a[@href=\"/tasks/index.html\"]/span");

    private final By menuBy = By.id("fat-menu");
    private final By dropdownBy = By.className("dropdown-toggle");
    private final By exitButtonBy = By.linkText("Выход");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public final TaskPage moveToTasks() {
        driver.findElement(tasksButtonBy).click();
        return new TaskPage(this.driver);
    }

    public final WebElement getTasksElement() {
        WebElement tasksElement = driver.findElement(By.xpath("//a[@href=\"/tasks/index.html\"]"));
        return tasksElement;
    }

    public final void logOut() {
        WebElement menu = this.driver.findElement(menuBy);
        menu.findElement(dropdownBy).click();
        this.driver.findElement(exitButtonBy).click();
    }
}
