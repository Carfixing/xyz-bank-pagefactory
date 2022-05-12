package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }
}
