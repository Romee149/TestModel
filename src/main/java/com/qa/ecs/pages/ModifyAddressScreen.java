package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ModifyAddressScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By zipCodeTextField = By.xpath("//input[contains(@id,'AddressPostalCode')]");
	private By submitButton = By.xpath("//input[@value='Submit']");


	public ModifyAddressScreen(WebDriver driver) {
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
	public ModifyAddressScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set zip code
	 *
	 * @param zipCode in String format
	 * @return This will return the Object of ModifyAddressScreen class
	 */
	public ModifyAddressScreen enterZipCode(String zipCode) {
		try { 
			eleUtil.waitForElementPresence(this.zipCodeTextField, timeout); 
		}catch(Exception e) {
		}
		jsUtil.scrollIntoView(this.zipCodeTextField);
		eleUtil.doSendKeys(this.zipCodeTextField, zipCode);
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
