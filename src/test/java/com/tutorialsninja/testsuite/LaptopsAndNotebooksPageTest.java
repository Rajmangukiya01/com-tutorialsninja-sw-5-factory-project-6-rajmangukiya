package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LaptopsAndNotebooksPageTest extends BaseTest {
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    DesktopPage desktopPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        desktopPage = new DesktopPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndDesktopTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.sortByPriceHighToLow();
        laptopsAndNotebooksPage.GetSortByHighToLowOrder();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        laptopsAndNotebooksPage.clickOnCurrencyLink();
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndDesktopTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.sortByPriceHighToLow();
        laptopsAndNotebooksPage.clickOnMacBookTab();
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        String expectedText = "Success: You have added MacBook to your shopping cart!\n"+"×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessTextFromLink(),expectedText,"Error Message not displayed");
        laptopsAndNotebooksPage.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooksPage.getShoppingCartMessage(),"Shopping Cart","Message not displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyProductMacbook(),"MacBook","Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");

        laptopsAndNotebooksPage.clickOnUpdateCart();
        String expectedMessage = "Success: You have modified your shopping cart!\n"+"×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessModifiedCartMessage(),expectedMessage,"Message not displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyTotal(),"£737.45","Price Not displayed");
        laptopsAndNotebooksPage.clickOnCheckoutButton();
        Assert.assertEquals(laptopsAndNotebooksPage.getCheckoutText(),"Checkout","Message not displayed");
        Thread.sleep(2000);
        String expectedNewCustomer = "New Customer";
        Assert.assertEquals(laptopsAndNotebooksPage.getNewCustomerText(),expectedNewCustomer,"Message not displayed");
        laptopsAndNotebooksPage.clickOnGuestCheckoutRadioButton();
        laptopsAndNotebooksPage.clickOnContinueTab();
        laptopsAndNotebooksPage.enterName("Xyz");
        laptopsAndNotebooksPage.enterLastName("zyx");
        laptopsAndNotebooksPage.enterEmail("test123@gmail.com");
        laptopsAndNotebooksPage.enterTelephone("07722567890");
        laptopsAndNotebooksPage.enterAddress("100,high road");
        laptopsAndNotebooksPage.enterCity("London");
        laptopsAndNotebooksPage.enterPostcode("E7 0NX");
        laptopsAndNotebooksPage.enterCountry("United Kingdom");
        laptopsAndNotebooksPage.enterZone("Greater London");
        laptopsAndNotebooksPage.clickOnContinueButton();
        laptopsAndNotebooksPage.enterTextToTextArea("Please confirm delivery date");
        laptopsAndNotebooksPage.clickOnTermsAndConditionsCheckbox();
        laptopsAndNotebooksPage.clickOnFinalContinueButton();
        String expectedPaymentText = "Warning: Payment method required!\n"+"×";
        Assert.assertEquals(laptopsAndNotebooksPage.getWarningPaymentMethodRequiredText(),expectedPaymentText,"Message not displayed");
    }
}
