package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;




public class ContactUsFormPage extends BasePage {


    public ContactUsFormPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "submitMessage")
    WebElement submitButton;

    @FindBy(className = "alert-danger")
    WebElement alert;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_contact")
    WebElement select;

    @FindBy(id = "id_order")
    WebElement orderInput;

    @FindBy(id = "message")
    WebElement messageInput;

    @FindBy(className = "alert alert-success")
    WebElement alertSuccess;



    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alert));
        boolean isDisplayed = false;
        try {
            isDisplayed = alert.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public boolean isGreenAlertBoxDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));
        boolean isDisplayed = false;
        try {
            isDisplayed = alertSuccess.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);

    }

    public void sendContactUsForm(Message message){
        wait.until(ExpectedConditions.visibilityOf(select));

        Select subject = new Select(select);
        subject.selectByVisibleText(message.getSubject().getValue());
        emailInput.sendKeys(message.getEmail());
        orderInput.sendKeys(message.getOrderReference());
        messageInput.sendKeys(message.getMessage());
        submitButton.click();

    }
}
