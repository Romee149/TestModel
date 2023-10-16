package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ModifyCollateralDetailsScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By originalValueTextField = By.xpath("//input[contains(@class,'original-value')]");
	private By submitButton = By.xpath("//input[@value='Submit']");


	public ModifyCollateralDetailsScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of ModifyCollateralDetailsScreen class
	 */
	public ModifyCollateralDetailsScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set original Value
	 *
	 * @param originalValue in String format
	 * @return This will return the Object of ModifyCollateralDetailsScreen class
	 */
	public ModifyCollateralDetailsScreen enterOriginalValue(String originalValue) {
		eleUtil.waitForElementPresence(this.originalValueTextField, timeout);
		eleUtil.doSendKeys(this.originalValueTextField, originalValue);
		return this;
	}

	
	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnSubmitButton() {			
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
		return new AccountDetailTabScreen(driver);
	}
	
	
	
}
