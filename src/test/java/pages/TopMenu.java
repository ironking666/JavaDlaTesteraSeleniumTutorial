package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenu {

    private WebDriverWait wait;

    public TopMenu(WebDriver driver){

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    public void clickOnLink (){
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
        contactUsLink.click();
    }

}
