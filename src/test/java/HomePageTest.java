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

import java.util.List;


public class HomePageTest {

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
    public void shouldReturnCorrectPage() {
        driver.get("http://automationpractice.com/index.php");

        Assertions.assertThat(driver.getTitle()).isEqualTo("My Store");
    }

    @Test
    public void shouldSeePopularItems() {
        driver.get("http://automationpractice.com/index.php");

        List<WebElement> popularList = driver.findElements(By.cssSelector("#homefeatured .product-name"));

        for (WebElement popular: popularList
             ) {
            System.out.println(popular.getText());
        }
        boolean anyProductHasEmptyName = popularList.stream()
                .anyMatch(el -> el.getText().isEmpty());

        Assertions.assertThat(anyProductHasEmptyName).isFalse();
    }

}
