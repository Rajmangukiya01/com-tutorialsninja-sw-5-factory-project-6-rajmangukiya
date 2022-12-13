package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {
    MyAccountPage myAccountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountPage.getRegisterAccountMessage(),"Register Account","Message not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountPage.getReturningCustomerMessage(),"Returning Customer","Message not displayed");
    }
    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName("Harry");
        myAccountPage.enterLastName("potter");
        myAccountPage.enterEmailId("harry115@gmail.com");
        myAccountPage.enterPhoneNumber("07734227890");
        myAccountPage.enterPassword("Harry123");
        myAccountPage.enterConfirmPassword("Harry123");
        myAccountPage.clickSubscribeOnYesRadioButton();
        myAccountPage.clickOnPrivacyPolicyCheckBox();
        myAccountPage.clickOnContinue1();
        Assert.assertEquals(myAccountPage.getAccountCreatedMessage(),"Your Account Has Been Created!","Message not displayed");
        myAccountPage.clickOnContinueButton2();
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Message not displayed");
        myAccountPage.clickOnContinueButton3();

    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailId("harry111@gmail.com");
        myAccountPage.enterPassword("Harry123");
        myAccountPage.clickOnLogin();
        // Assert.assertEquals(myAccountPage.getMyAccountText(),"My Account","My account text not displayed");
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Account Logout text not displayed");
        myAccountPage.clickOnContinueButton3();
    }
}
