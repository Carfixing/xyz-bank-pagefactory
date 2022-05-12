package com.bank.testsuite;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import javafx.scene.control.Tab;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;


    @BeforeMethod(alwaysRun = true)

    public void inIT(){
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
    }

    @Test(groups = {"sanity","regression"},priority = 2)
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankMangerLoginButton();
        //click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //enter FirstName
        addCustomerPage.enterFirstNameinAddcustomerPage("John");
        //enter LastName
        addCustomerPage.enterLastNameinAddcustomerPage("Patel");
        //enter PostCode
        addCustomerPage.enterPostCodeinAddCustomerPage("Ub8 7ld");
        //click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButtonForNewCustomer();
        //popup display
        //verify message "Customer added successfully"
        String expectedMessage = "Customer added successfully";
        String actualMessage = addCustomerPage.textFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual text does not match expected text");
        //	click on "ok" button on popup.
        addCustomerPage.clickOkOnAlert();

    }

    @Test(groups = {"sanity","smoke","regression"},priority = 1)
    public void bankManagerShouldOpenAccountSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankMangerLoginButton();
        //	click On "Open Account" Tab
        openAccountPage.ClickOnOpenAccount();
        //	Search customer that created in first test
       openAccountPage.searchCustomerName("3");
        //	Select currency "Pound"
       openAccountPage.selectCurrencyFromDropDown("Dollar");
        //	click on "process" button
        openAccountPage.ClickOnProcessButton();
        //	popup displayed
        //	verify message "Account created successfully"
        openAccountPage.verifyAccountCreatedSuccessfullyText();
        //	click on "ok" button on popup.
        openAccountPage.clickOnOkButtonPopup();
    }

    @Test(groups = {"smoke","regression"},priority = 3)
    public void customerShouldLoginAndLogoutSuceessfully(){
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //search customer that you created.
        customerLoginPage.searchCustomerCreatedByCustomer("3");
        //click on "Login" Button
        customerLoginPage.ClickOnLoginButton();
        //verify "Logout" Tab displayed.
        String expectedMessage = "logout";
        String actualMessage =customerLoginPage.verifyLogoutButton();
        Assert.assertEquals(expectedMessage, actualMessage, "LogOut text not displayed");
        //click on "Logout"
        customerLoginPage.clickOnLogOutButton();
        //verify "Your Name" text displayed.
        //verify "Your Name" text displayed
        String expectedMessage1 = "Your Name";
        String actualMessage1 = customerLoginPage.verifyYourNameIsDisplay();
        Assert.assertEquals(expectedMessage1, actualMessage1, "Your Name text not displayed");

    }

    @Test(groups = {"smoke","regression"},priority = 4)
    public void customerShouldDepositMoneySuccessfully(){
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customerLoginPage.searchCustomerCreatedByCustomer("3");
        //	click on "Login" Button
        customerLoginPage.ClickOnLoginButton();
        //	click on "Deposit" Tab
       customerLoginPage.clickOnDepositTab();
        //	Enter amount 100
        customerLoginPage.enterAmountInDeposit("100");
        //	click on "Deposit" Button
        customerLoginPage.clickOnDepositTabafterenteringAmount();
        //	verify message "Deposit Successful"
        customerLoginPage.verifyDepositSuccessfullyIsDisplay();
    }

    @Test(groups = {"regression"},priority = 5)
    public void  customerShouldWithdrawMoneySuccessfully(){
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //search customer that you created.
        customerLoginPage.searchCustomerCreatedByCustomer("3");
        //click on "Login" Button
        customerLoginPage.ClickOnLoginButton();
        //click on "Withdrawl" Tab
        customerLoginPage.clickOnWithdrawlTab();
        //Enter amount 50
        customerLoginPage.enterAmountInWithDrawl("50");
        //click on "Withdraw" Button
       customerLoginPage.clickOnWithDrawTabafterenteringAmount();
        //verify message "Transaction Successful"
        customerLoginPage.verifyAfterWithdrawtlTransationSuccessfull();
    }
}
