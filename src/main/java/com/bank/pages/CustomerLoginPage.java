package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement serchcustThatcreatedByCust;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickLoginBtn;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement verifyLogOutTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement clickLogOut;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Ron Weasly')]")
    WebElement yourNameDisplay;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement clickDeposit;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterAmount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOndeposit;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyDepositSuccess;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement clickWithdrawl;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterWithdrwalAmt;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement clickWithdrawlafterAmt;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyWithDrawSuccess;

    //*********************************************************

    public void searchCustomerCreatedByCustomer(String name1){
      selectByValueFromDropDown(serchcustThatcreatedByCust,name1);
        CustomListeners.node.log(Status.PASS, "Click On Customer Login Page");
        Reporter.log("Click On Customer Login Page" + "<br>");
    }

    public void ClickOnLoginButton(){
        clickOnElement(clickLoginBtn);
        CustomListeners.node.log(Status.PASS, "Click On  Login Button");
        Reporter.log("Click On Login Button" + "<br>");
    }

    public String verifyLogoutButton(){
        String logoutMessage = verifyLogOutTab.getAttribute("ng-show");
        CustomListeners.node.log(Status.PASS, "Find Logout Button : " + logoutMessage);
        Reporter.log("Find Logout Button : " + logoutMessage + "<br>");
        return logoutMessage;
    }

    public void clickOnLogOutButton(){
        clickOnElement(clickLogOut);
        CustomListeners.node.log(Status.PASS,"click On LogOut Button");
        Reporter.log("Click On LogOut Button");
    }

    public String verifyYourNameIsDisplay() {
            String getYourNameText = getTextFromElement(yourNameDisplay);
            String actualYourNameText= getYourNameText.substring(0,9);
            CustomListeners.node.log(Status.PASS, "Get Your Name text : " + actualYourNameText);
            Reporter.log("Get Your Name text : " + actualYourNameText + "<br>");
            return actualYourNameText;
        }


    public void clickOnDepositTab(){
        clickOnElement(clickDeposit);
        CustomListeners.node.log(Status.PASS, "Click On  Deposit Tab");
        Reporter.log("Click On  Deposit Tab" + "<br>");
    }
    public void enterAmountInDeposit(String value){
        sendTextToElement(enterAmount,value);
        CustomListeners.node.log(Status.PASS, "enter amount");
        Reporter.log("enter amount" + "<br>");
    }

    public void clickOnDepositTabafterenteringAmount(){
        clickOnElement(clickOndeposit);
        CustomListeners.node.log(Status.PASS, "Click On  Deposit Tab");
        Reporter.log("Click On  Deposit Tab" + "<br>");
    }
    public String verifyDepositSuccessfullyIsDisplay() {
        String depositAount = verifyDepositSuccess.getAttribute("Deposit Successful");
        CustomListeners.node.log(Status.PASS, "verify Deposit Msg : " + depositAount);
        Reporter.log("verify Deposit Msg : " + depositAount + "<br>");
        return depositAount ;
    }
    public void clickOnWithdrawlTab(){
        clickOnElement(clickWithdrawl);
        CustomListeners.node.log(Status.PASS, "Click On  Deposit Tab");
        Reporter.log("Click On  Deposit Tab" + "<br>");
    }
    public void enterAmountInWithDrawl(String value){
        sendTextToElement(enterWithdrwalAmt,value);
        CustomListeners.node.log(Status.PASS, "enter amount");
        Reporter.log("enter amount" + "<br>");
    }
    public void clickOnWithDrawTabafterenteringAmount(){
        clickOnElement(clickWithdrawlafterAmt);
        CustomListeners.node.log(Status.PASS, "Click On  Deposit Tab");
        Reporter.log("Click On  Deposit Tab" + "<br>");
    }
    public String verifyAfterWithdrawtlTransationSuccessfull() {
        String depositAount = verifyWithDrawSuccess.getAttribute("Transaction successful");
        CustomListeners.node.log(Status.PASS, "verify Withdrawl Msg : " + depositAount);
        Reporter.log("verify Withdrawl Msg : " + depositAount + "<br>");
        return depositAount ;
    }
}

