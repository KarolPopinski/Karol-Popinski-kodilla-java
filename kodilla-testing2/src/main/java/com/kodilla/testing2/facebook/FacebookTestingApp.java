package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//div[contains(@class, \"_al64\")]/button[2]";
    public static final String XPATH_NEW_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_SELECT_BIRTHDAY_DAY = "//*[@id=\"day\"]";
    public static final String XPATH_SELECT_BIRTHDAY_MONTH = "//*[@id=\"month\"]";
    public static final String XPATH_SELECT_BIRTHDAY_YEAR = "//*[@id=\"year\"]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).click();

        Thread.sleep(1000);

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_DAY));
        Select day = new Select(selectDay);
        day.selectByValue("22");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_MONTH));
        Select month = new Select(selectMonth);
        month.selectByValue("11");

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_YEAR));
        Select year = new Select(selectYear);
        year.selectByValue("1963");
    }
}