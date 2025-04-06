package com.example.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GoogleAppTest {
    
    WebDriver webDriver();

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // adjust path
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("q")).submit();
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        assert title.contains("Selenium WebDriver");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
