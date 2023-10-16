package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ModifyInsuranceDetailsScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By coverageAmountTextField = By.xpath("//input[contains(@class,'coverage-amount')]");
	private By submitButton = By.xpath("//input[@value='Submit']");


	public ModifyInsuranceDetailsScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of ModifyInsuranceDetailsScreen class
	 */
	public ModifyInsuranceDetailsScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set Coverage Amount
	 *
	 * @param coverageAmount in String format
	 * @return This will return the Object of ModifyInsuranceDetailsScreen class
	 */
	public ModifyInsuranceDetailsScreen enterCoverageAmount(String coverageAmount) {
		eleUtil.waitForElementPresence(this.coverageAmountTextField, timeout);
		eleUtil.doSendKeys(this.coverageAmountTextField, coverageAmount);
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
