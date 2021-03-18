package ru.bugred.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskPage {
    private WebDriver driver;

    private final By createTaskButtonBy = By.name("name");
    private final By descriptionTextareaBy = By.xpath("//textarea");
    private final By submitButtonBy = By.className("btn-submit");

    public TaskPage(WebDriver driver) {
        this.driver = driver;
    }

    public final WebElement createTask(String title) {
        driver.findElement(By.linkText("Добавить задачу")).click();

        driver.findElement(createTaskButtonBy).sendKeys("Task 1");
        driver.findElement(descriptionTextareaBy).sendKeys("Lalala");
        driver.findElement(submitButtonBy).click();

        WebElement task = driver.findElement(By.linkText(title));
        return task;
    }
}
