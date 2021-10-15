package tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class ContactUsTest extends BaseTest {

    @Test
    public void shouldNotAllowedToSendEmptyContactUsForm() {

        driver.findElement(By.xpath(".//a[contains(@href,'http://automationpractice.com/index.php?controller=contact')]")).click();
        driver.findElement(By.id("submitMessage")).click();
        WebElement alertBox = driver.findElement(By.className("alert-danger"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(alertBox));
        assertThat(alertBox.isDisplayed()).isTrue();

    }

    @Test
    public void shouldNotSendContactFormWithOnlyEmail() {

        driver.findElement(By.xpath(".//a[contains(@href,'http://automationpractice.com/index.php?controller=contact')]")).click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("iron@wp");
        driver.findElement(By.id("submitMessage")).click();
        WebElement alertBox = driver.findElement(By.className("alert-danger"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(alertBox));
        assertThat(alertBox.isDisplayed()).isTrue();

    }
}
