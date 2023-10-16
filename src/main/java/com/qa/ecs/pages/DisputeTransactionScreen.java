package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class DisputeTransactionScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	
	private By originDropdown = By.xpath("//select[contains(@id,'Origin')]");
	private By disputeTypeDropdown = By.xpath("//select[contains(@id,'DisputeType')]");
	private By disputeReasonDropdown = By.xpath("//select[contains(@id,'DisputeReason')]");
	private By disputedAmountTextfield = By.xpath("//input[contains(@id,'disputedAmount')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	
	private By cancelOrderSubmitBtn = By.xpath("//input[contains(@value,'Submit')]");
	
	public DisputeTransactionScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of DisputeTransactionScreen class
	 */
	public DisputeTransactionScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	

	/**
	 * This method is used to set Origin
	 *
	 * @param value in String format
	 * @return This will return the Object of DisputeTransactionScreen class
	 */
	public DisputeTransactionScreen selectOrigin(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.originDropdown, value);
		return this;
	}
	
	
	
	/**
	 * This method is used to set Dispute Type
	 *
	 * @param value in String format
	 * @return This will return the Object of DisputeTransactionScreen class
	 */
	public DisputeTransactionScreen selectDisputeType(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.disputeTypeDropdown, value);
		return this;
	}
	
	
	/**
	 * This method is used to set Dispute Reason
	 *
	 * @param value in String format
	 * @return This will return the Object of DisputeTransactionScreen class
	 */
	public DisputeTransactionScreen selectDisputeReason(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.disputeReasonDropdown, value);
		return this;
	}
	
	
	/**
	 * This method is used to set Disputed Amount
	 *
	 * @param amount in String format
	 * @return This will return the Object of DisputeTransactionScreen class
	 */
	public DisputeTransactionScreen enterDisputedAmount(String amount) {
		eleUtil.scrollToElementByActionsClass(this.disputedAmountTextfield);
		eleUtil.doClear(this.disputedAmountTextfield);
		eleUtil.doSendKeys(this.disputedAmountTextfield, amount);
		eleUtil.wait(2);
		return this;
	}
	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AccountDetailTabScreen clickOnSubmitButton() {			
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.scrollToElementByActionsClass(this.submitButton);
				eleUtil.doClick(this.submitButton);
				//jsUtil.clickElementByJS(this.submitButton);				
				counter = 10;
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.submitButton);
			}
		}
		return new AccountDetailTabScreen(driver);
	}
	
	
	/**
	 * This method is used to scroll Page Down
	 * 
	 * 
	 * @return This will return the Object of AddHoldScreen class
	 */
	public DisputeTransactionScreen scrollPageDown() {
		jsUtil.scrollPageDown();
		return this;
	}
	
}
