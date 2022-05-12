package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement enterFirstName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement enterLastName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement enterPostCode;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnAddCustomer;


    //****************************************************************


    public void enterFirstNameinAddcustomerPage(String firstName){
        sendTextToElement(enterFirstName,firstName);
        CustomListeners.node.log(Status.PASS, "Enter FirstName in Addcustomer Page ");
        Reporter.log("Enter FirstName in Addcustomer Page" + "<br>");
    }
    public void enterLastNameinAddcustomerPage(String lastName){
        sendTextToElement(enterLastName,lastName);
        CustomListeners.node.log(Status.PASS, "Enter LastName in Addcustomer Page ");
        Reporter.log("Enter LastName in Addcustomer Page" + "<br>");
    }
    public void enterPostCodeinAddCustomerPage(String postCode){
        sendTextToElement(enterPostCode,postCode);
        CustomListeners.node.log(Status.PASS, "Enter PostCode in AddCustomer Page ");
        Reporter.log("\"Enter PostCode in AddCustomer Page" + "<br>");
    }
    public void clickOnAddCustomerButtonForNewCustomer(){
        clickOnElement(clickOnAddCustomer);
        CustomListeners.node.log(Status.PASS, "Click On Add Customer ");
        Reporter.log("CustomListeners.node.log(Status.PASS, " + "<br>");

    }
    public String textFromAlert() {
        String successfullyAddedMessage = getTextFromAlert();
        String actualSuccessfullyAddedMessage = successfullyAddedMessage.substring(0, 27);
        CustomListeners.node.log(Status.PASS, "Get Customer added successfully text : " + actualSuccessfullyAddedMessage);
        Reporter.log("Get Customer added successfully text : " + actualSuccessfullyAddedMessage + "<br>");
        return actualSuccessfullyAddedMessage;
    }

    public void clickOkOnAlert() {
        acceptAlert();
    }

}


