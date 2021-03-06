package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgatPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    public void login(String usernameValue, String passwordValue) {
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);

    }
    public void login(){
        this.username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    public void login(String role){
        String userName="";

        if (role.equalsIgnoreCase("driver")){
            userName="user15";
        } else if (role.equalsIgnoreCase("sales manager")){
            userName="salesmanager110";
        } else if (role.equalsIgnoreCase("store manager")){
            userName="storemanager85";
        } else {
            throw new RuntimeException("Invalid role!");
        }

        System.out.println("Login as: "+ role);
        login(userName,"UserUser123");
    }
}
