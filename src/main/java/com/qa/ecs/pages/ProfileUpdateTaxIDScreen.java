package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ProfileUpdateTaxIDScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By taxIDTypeDropdown = By.xpath("//select[contains(@id,'TinType')]");
	private By taxIDTextfield = By.xpath("//input[contains(@id,'TaxId')]");
	private By updateReasonDropdown = By.xpath("//select[contains(@id,'TaxUpdReason')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	

	public ProfileUpdateTaxIDScreen(WebDriver driver) {
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
	public ProfileUpdateTaxIDScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set taxID
	 *
	 * @param taxID in String format
	 * @return This will return the Object of ProfileUpdateTaxIDScreen class
	 */
	public ProfileUpdateTaxIDScreen enterTaxID(String taxID) {
		eleUtil.waitForElementPresence(this.taxIDTextfield, timeout);
		eleUtil.doSendKeys(this.taxIDTextfield, taxID);
		return this;
	}

	
	
	
	/**
	 * This method is used to select taxType
	 *
	 * @param taxType in String format
	 * @return This will return the Object of ProfileUpdateTaxIDScreen class
	 */
	public ProfileUpdateTaxIDScreen selectTaxType(String taxType) {
		eleUtil.waitForElementPresence(this.taxIDTypeDropdown, timeout);
		eleUtil.doDropDownSelectByVisibleText(this.taxIDTypeDropdown, taxType);
		return this;
	}
	
	
	/**
	 * This method is used to select updateReason
	 *
	 * @param updateReason in String format
	 * @return This will return the Object of ProfileUpdateTaxIDScreen class
	 */
	public ProfileUpdateTaxIDScreen selectUpdateReason(String updateReason) {
		eleUtil.waitForElementPresence(this.updateReasonDropdown, timeout);
		eleUtil.doDropDownSelectByVisibleText(this.updateReasonDropdown, updateReason);
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
