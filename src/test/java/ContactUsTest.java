import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;

public class ContactUsTest {

    private WebDriver driver;


    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldNotAllowedToSendEmptyContactUsForm(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath(".//a[contains(@href,'http://automationpractice.com/index.php?controller=contact')]")).click();
        driver.findElement(By.id("submitMessage")).click();
        WebElement alertBox = driver.findElement(By.className("alert-danger"));
        assertThat(alertBox.isDisplayed()).isTrue();

    }
}
