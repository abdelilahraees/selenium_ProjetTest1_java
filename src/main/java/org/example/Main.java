package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();
        profile.setPreference("javascript.enabled", "False");
        options.setProfile(profile);
        FirefoxDriver driver = new FirefoxDriver(options);
        try {
            driver.get("https://www.youtube.com");
            Thread.sleep(3000);
            WebElement searchBox = driver.findElement(By.name("search_query"));
            searchBox.sendKeys("tetouan");
            searchBox.submit();
            System.out.println("Page title: " + driver.getTitle());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement firstVideo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ytd-video-renderer:first-child #thumbnail")));
            firstVideo.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}