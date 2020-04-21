package com.vytrack.pages.fleet;

import com.vytrack.pages.AbstractPageBase;
import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    @FindBy(css = "[id^='custom_entity_type_LicensePlate-uid']")
    private WebElement licensePlateInput;

    @FindBy(css = "[id^='custom_entity_type_Driver-uid']")
    private WebElement driverInput;

    @FindBy(css = "[id^='custom_entity_type_Location-uid']")
    private WebElement locationInput;

    @FindBy(css = "[id^='custom_entity_type_ModelYear-uid']")
    private WebElement modelYearInput;

    @FindBy(css = "[id^='custom_entity_type_Color-uid']")
    private WebElement colorInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement submit;

    public void clickToCreateACar(){
        WebDriverWait wait=new WebDriverWait((WebDriver) driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }


    public void setLicencePlateInput(String licencePlate) {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='custom_entity_type[LicensePlate]']")));
        wait.until(ExpectedConditions.visibilityOf(licensePlateInput));
        licensePlateInput.sendKeys(licencePlate);
    }

    public void setDriverInput(String driver) {
        driverInput.sendKeys(driver);
    }

    public void setLocationInput(String location) {
        locationInput.sendKeys(location);
    }

    public void setModelYear(String year) {
        modelYearInput.sendKeys(year);
    }

    public void setColor(String color) {
        this.colorInput.sendKeys(color);
    }

    public void submit() {
        submit.click();
    }

    public String getCarGeneralInfo(String parameter){
        String xpath = "//label[text()='" + parameter + "']/following-sibling::div/div";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }
}
