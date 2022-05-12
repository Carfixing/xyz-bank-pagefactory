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

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement clickOpenAccount;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameFound;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement selecttheCurrency;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement clickOnProcessBtn;

    //**********************************************************

    public void ClickOnOpenAccount(){
        clickOnElement(clickOpenAccount);
        CustomListeners.node.log(Status.PASS, "Click on ' Button OpenAccount'Button'");
        Reporter.log("Click on 'OpenAccount ' Button" + "<br>");
    }

    public void searchCustomerName(String name){
       selectByValueFromDropDown(customerNameFound,name);
        CustomListeners.node.log(Status.PASS, "Found in Dropdown CustomerName");
        Reporter.log("Found in Dropdown CustomerName" + "<br>");
    }

    public void selectCurrencyFromDropDown(String currency){
        selectByVisibleTextFromDropDown(selecttheCurrency,currency);
        CustomListeners.node.log(Status.PASS, " Currency found in dropdown");
        Reporter.log("Currency found in dropdown" + "<br>");
    }

    public void ClickOnProcessButton(){
        clickOnElement(clickOnProcessBtn);
    }

    public void verifyAccountCreatedSuccessfullyText(){
        Reporter.log("Clicking on Process button"+"\n</br>");
        String expected = "Account created successfully with account Number :1016";
        String actual = getTextFromAlert();
        Assert.assertEquals(expected.substring(0,20),actual.substring(0,20),"wrong message");
    }
    public void clickOnOkButtonPopup(){
        acceptAlert();
    }
}
