package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://karolpopinski.github.io";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }
    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }
    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"tasks\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"tasks\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"tasks\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }
    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->                                             // [4]
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }
    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;

        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);
        Thread.sleep(1000);

        driverTrello.findElement(By.id("user")).sendKeys("kpopinski@o2.pl");
        WebElement continue_button = driverTrello.findElement(By.id("login"));
        continue_button.submit();
        Thread.sleep(2000);

        driverTrello.findElement(By.id("password")).sendKeys("Kodilla@trello");
        WebElement login_button = driverTrello.findElement(By.id("login-submit"));
        login_button.submit();
        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Aplication\"]")).size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    private void deleteTestTaskFromCrud(String taskName) throws InterruptedException {
        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                        .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                        .forEach(theForm -> {
                            WebElement buttonDelete = theForm.findElement(By.xpath(".//div[contains(@class, \"datatable__row-section-wrapper\")]//button[4]"));
                            buttonDelete.click();
                        });
        Thread.sleep(4000);
    }
    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteTestTaskFromCrud(taskName);
    }
}