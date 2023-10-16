package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AddAddressScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By addressLine1Textfield = By.xpath("(//input[contains(@id,'AddressStreet')])[1]");
	private By cityTextfield = By.xpath("//input[contains(@id,'AddressCity')]");
	private By stateRegionDropdown = By.xpath("//select[contains(@id,'AddressRegion')]");
	private By zipPostalCodeTextfield = By.xpath("//input[contains(@id,'AddressPostalCode')]");
	private By countryDropdown = By.xpath("//select[contains(@id,'CountryInput')]");
	private By submitButton = By.xpath("//input[contains(@id,'Submit')]");

	public AddAddressScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddAddressScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set address line 1
	 *
	 * @param addressLine1 in String format
	 * @return This will return the Object of AddAddressScreen class
	 */
	public AddAddressScreen enterAddressLine1(String addressLine1) {
		eleUtil.waitForElementPresence(this.addressLine1Textfield, timeout);
		eleUtil.doSendKeys(this.addressLine1Textfield, addressLine1);
		return this;
	}

	
	
	/**
	 * This method is used to set city
	 *
	 * @param city in String format
	 * @return This will return the Object of AddAddressScreen class
	 */
	public AddAddressScreen enterCity(String city) {
		eleUtil.waitForElementPresence(this.cityTextfield, timeout);
		eleUtil.doSendKeys(this.cityTextfield, city);
		return this;
	}
	
	
	
	/**
	 * This method is used to select State/Region
	 *
	 * @param stateRegion in String format
	 * @return This will return the Object of AddAddressScreen class
	 */
	public AddAddressScreen selectState(String state) {
		eleUtil.waitForElementPresence(this.stateRegionDropdown, timeout);
		eleUtil.doDropDownSelectByVisibleText(this.stateRegionDropdown, state);
		return this;
	}
	
	
	
	/**
	 * This method is used to set zip/PostalCode
	 *
	 * @param zipPostalCode in String format
	 * @return This will return the Object of AddAddressScreen class
	 */
	public AddAddressScreen enterZipCode(String zipCode) {
		eleUtil.waitForElementPresence(this.zipPostalCodeTextfield, timeout);
		eleUtil.doSendKeys(this.zipPostalCodeTextfield, zipCode);
		return this;
	}
	
	
	/**
	 * This method is used to select Country
	 *
	 * @param country in String format
	 * @return This will return the Object of AddAddressScreen class
	 */
	public AddAddressScreen selectCountry(String country) {
		eleUtil.waitForElementPresence(this.countryDropdown, timeout);
		eleUtil.doDropDownSelectByVisibleText(this.countryDropdown, country);
		return this;
	}
	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnSubmitButton() {			
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.scrollToElementByActionsClass(this.submitButton);
				eleUtil.doClick(this.submitButton);								
				counter = 10;
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.submitButton);
			}
		}
		return new CustomerDetail(driver);
	}
	
	
	
}
