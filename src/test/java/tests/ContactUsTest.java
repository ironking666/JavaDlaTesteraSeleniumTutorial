package tests;


import enums.MessageSubject;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenu;
import utils.PageTitleUtils;


import static org.assertj.core.api.Assertions.*;

public class ContactUsTest extends BaseTest {

    private TopMenu topMenu;  // - utworzony object
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenu = new TopMenu(driver);  // - zainicjalizowany object
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    public void shouldNotAllowedToSendEmptyContactUsForm() {

        topMenu.clickOnLink();
        contactUsFormPage.clickOnSubmitButton();

        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();

    }

    @Test
    public void shouldNotSendContactFormWithOnlyEmail() {

        topMenu.clickOnLink();
        contactUsFormPage.enterEmail("iron@wp.pl");
        contactUsFormPage.clickOnSubmitButton();
        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();

    }

    @ Test
    public void shouldSendContactUsFormWithValidData(){
        topMenu.clickOnLink();

        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("iron@w.pl");
        message.setOrderReference("SomeText");
        message.setMessage("Some message");


        contactUsFormPage.sendContactUsForm(message);
        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}
