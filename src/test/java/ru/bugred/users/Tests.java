package ru.bugred.users;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Tests {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @Test
    public void testLogin() {
        IndexPage indexPage = new IndexPage(driver);
        AuthPage authPage = indexPage.moveToAuthPage();
        HomePage homePage = authPage.login("ababa@gmail.com", "123123");

        WebElement tasksElement = homePage.getTasksElement();
        Assert.assertTrue(tasksElement.getText().equals("Задачи"));
    }

    @Test
    public void testRegister() {
        IndexPage indexPage = new IndexPage(driver);
        AuthPage authPage = indexPage.moveToAuthPage();
        HomePage homePage = authPage.register("Test User","ababa@gmail.com", "123123");

        WebElement tasksElement = homePage.getTasksElement();
        Assert.assertTrue(tasksElement.getText().equals("Задачи"));
    }

    @Test
    public void testFilter() {
        IndexPage indexPage = new IndexPage(driver);

        List<WebElement> users = indexPage.filterUsers("manager@mail.ru");
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void logOut() throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        AuthPage authPage = indexPage.moveToAuthPage();
        HomePage homePage = authPage.login("ababa@gmail.com", "123123");
        homePage.logOut();
    }

    @Test
    public void addTask() {
        IndexPage indexPage = new IndexPage(driver);
        AuthPage authPage = indexPage.moveToAuthPage();
        HomePage homePage = authPage.login("ababa@gmail.com", "123123");
        TaskPage taskPage = homePage.moveToTasks();

        String taskTitle = "Task 1";
        WebElement task =  taskPage.createTask(taskTitle);
        Assert.assertTrue(task.getText().equals(taskTitle));
    }

    @After
    public void teardown() {
        driver.close();
        System.out.println("Test stopped");
    }
}
