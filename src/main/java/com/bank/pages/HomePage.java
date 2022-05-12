package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
//    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
//    WebElement clickBankMangerLogin;

    @FindBy (xpath ="//button[normalize-space()='Bank Manager Login']" )
    WebElement clickBankMangerLogin;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement clickCustomerLogin;


    //*************************************************************************************

    public void clickOnBankMangerLoginButton(){
        clickOnElement(clickBankMangerLogin);
        CustomListeners.node.log(Status.PASS, "Click on 'Bank Manager Login' ");
        Reporter.log("Click on 'Bank Manager Login' Button" + "<br>");
    }


    public void clickOnCustomerLoginButton(){
        clickOnElement(clickCustomerLogin);
        CustomListeners.node.log(Status.PASS, "Click on Customer Login Button");
        Reporter.log("Click on Customer Login Button" + "<br>");
    }



}
