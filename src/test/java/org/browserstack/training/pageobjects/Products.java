package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Products extends Base {
    By product1Button = By.id("addToCart1");
    By product2Button = By.id("addToCart2");
    By product3Button = By.id("addToCart3");
    By product4Button = By.id("addToCart4");
    By product5Button = By.id("addToCart5");
    By product6Button = By.id("addToCart6");
    By product7Button = By.id("addToCart7");
    By product8Button = By.id("addToCart8");

    By viewCartButton = By.id("view-cart-button");
    By cartItemCount = By.id("cartItem");

    public Products(WebDriver driver) {
        super(driver);
    }

    public void addProductsToCart() {
        waitForElementClickable(product1Button).click();
        waitForElementClickable(product2Button).click();
        waitForElementClickable(product3Button).click();
    }

    public void dynamicAddProduct(String productNumber) {
        By productButton = By.id("addToCart" + productNumber);
        waitForElementClickable(productButton).click();
    }

    public WebElement getProduct1Button() { return waitForElementClickable(product1Button); }
    public WebElement getProduct2Button() { return waitForElementClickable(product2Button); }
    public WebElement getProduct3Button() { return waitForElementClickable(product3Button); }
    public WebElement getProduct4Button() { return waitForElementClickable(product4Button); }
    public WebElement getProduct5Button() { return waitForElementClickable(product5Button); }
    public WebElement getProduct6Button() { return waitForElementClickable(product6Button); }
    public WebElement getProduct7Button() { return waitForElementClickable(product7Button); }
    public WebElement getProduct8Button() { return waitForElementClickable(product8Button); }
    public WebElement getViewCartButton() { return waitForElementClickable(viewCartButton); }
    public List<WebElement> getCartItemCount() { return waitForElementsClickable(cartItemCount); }

}