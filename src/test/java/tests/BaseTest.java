package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    private static final String  BASE_URL = "http://automationpractice.com/index.php";

    protected WebDriver driver;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
