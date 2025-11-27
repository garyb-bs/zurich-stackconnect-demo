package org.browserstack.training.tests;

import org.browserstack.training.pageobjects.Contact;
import org.browserstack.training.pageobjects.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTests {
    String name = "John Smith";
    String email = "john@smith.com";
    String message = "This is a message";

    String successMessage = "Thank you for your message! We'll get back to you soon.";
    String nameErrorMessage = "Name is required. Please enter your full name.";
    String emailErrorMessage = "Email is required. Please enter your email address.";
    String messageErrorMessage = "Message is required. Please enter your message.";
    String allFieldsErrorMessage = "All fields are required. Please fill in your name, email, and message.";
    String missingNameAndEmailErrorMessage = "Name and email are required. Please fill in both fields.";
    String missingNameAndMessageErrorMessage = "Name and message are required. Please fill in both fields.";
    String missingEmailAndMessageErrorMessage = "Email and message are required. Please fill in both fields.";


    WebDriver driver;
    Home homePage;
    Contact contactPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://training-site-2025.pages.dev/");
        driver.manage().window().maximize();
        homePage = new Home(driver);
        contactPage = new Contact(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sendContactRequestTest() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm(name, email, message);

            Assert.assertEquals(contactPage.getSuccessElement().getText(), successMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestName() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm("", email, message);

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestEmail() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm(name, "", message);

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestMessage() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm(name, email, "");

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestAllFields() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm("", "", "");

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestMissingNameAndEmail() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm("", "", message);

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestMissingNameAndMessage() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm("", email, "");

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedContactRequestTestMissingEmailAndMessage() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm(name, "", "");

            Assert.assertTrue(contactPage.getErrorElement().isDisplayed(), "Error message should be displayed");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
