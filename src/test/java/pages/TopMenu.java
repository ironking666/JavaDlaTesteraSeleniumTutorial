package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TopMenu extends BasePage {

    public TopMenu(WebDriver driver){
        super(driver);

    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    public void clickOnLink (){
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
        contactUsLink.click();
    }

}
