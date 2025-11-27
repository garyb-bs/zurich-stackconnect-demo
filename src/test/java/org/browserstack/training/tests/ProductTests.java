package org.browserstack.training.tests;

import org.browserstack.training.pageobjects.Contact;
import org.browserstack.training.pageobjects.Home;
import org.browserstack.training.pageobjects.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTests {
    WebDriver driver;
    Home homePage;
    Products productsPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://training-site-2025.pages.dev/");
        driver.manage().window().maximize();
        homePage = new Home(driver);
        productsPage = new Products(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addProductsToCart() {
        try {
            homePage.goToProductsPage();

            productsPage.addProductsToCart();
            productsPage.getViewCartButton().click();

            Assert.assertEquals(productsPage.getCartItemCount().size(), 3, "Cart should contain 3 items");
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
