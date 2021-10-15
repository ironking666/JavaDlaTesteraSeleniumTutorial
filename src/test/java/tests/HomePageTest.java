package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;


public class HomePageTest extends BaseTest{

    @Test
    public void shouldSeePopularItems() {

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
