package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AddHoldScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	
	private By startDateTextField = By.xpath("//div[contains(@id,'StartDate')]//input[contains(@id,'txtInputDate') and @aria-required]");
	private By endDateTextField = By.xpath("//div[contains(@id,'EndDate')]//input[contains(@class,'HoldEndDate')]");
	private By durationDropdown = By.xpath("//select[contains(@id,'holdDuration')]");
	private By holdAmountTextField = By.xpath("//input[contains(@id,'HoldAmount')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	private By holdTypeDropdown = By.xpath("//select[contains(@class, 'HoldType')]");
	private By cancelOrderSubmitBtn = By.xpath("//input[contains(@value,'Submit')]");
	
	public AddHoldScreen(WebDriver driver) {
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
	public AddHoldScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set start date
	 *
	 * @param amount in String format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen enterStartDate() {
		String startDate = new CommonUtil().getCurrentDateTime("MM/dd/yyyy hh:mm:ss a");
		eleUtil.doSendKeys(this.startDateTextField, startDate);
		return this;
	}

	/**
	 * This method is used to set start date
	 *
	 * @param startDate in String format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen enterStartDate(String startDate) {
		eleUtil.doSendKeys(this.startDateTextField, startDate);
		return this;
	}
	

	/**
	 * This method is used to set Duration
	 *
	 * @param value in String format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen selectDuration(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.durationDropdown, value);
		return this;
	}
	
	
	/**
	 * This method is used to set hold amount
	 *
	 * @param amount in String format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen enterHoldAmount(String amount) {
		eleUtil.scrollToElementByActionsClass(this.holdAmountTextField);
		eleUtil.doClear(this.holdAmountTextField);
		eleUtil.doSendKeys(this.holdAmountTextField, amount);
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
	 * This method is used to click on Submit Button of cancel order 
	 *
	 * @param nothing
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AccountDetailTabScreen clickOnCancelOrderSubmitBtn() {			
			eleUtil.scrollToElementByActionsClass(this.cancelOrderSubmitBtn);
			eleUtil.doClick(this.cancelOrderSubmitBtn);
			eleUtil.wait(5);
		return new AccountDetailTabScreen(driver);
	}
	
	/**
	 * This method is used to set start date
	 *
	 * @param startDate in String format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen enterEndDate(String startDate) {
		eleUtil.waitForElementPresence(this.endDateTextField, 20);
		eleUtil.scrollToElementByActionsClass(this.endDateTextField);
		eleUtil.doClear(this.endDateTextField);
		eleUtil.doSendKeys(this.endDateTextField, startDate);
		eleUtil.wait(2);
		return this;
	}

	/**
	 * This method is used to select Hold Type
	 *
	 * @param value in String format
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen selectHoldType(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.holdTypeDropdown, value);
		return this;
	}
	
	/**
	 * This method is used to scroll Page Down
	 * 
	 * 
	 * @return This will return the Object of AddHoldScreen class
	 */
	public AddHoldScreen scrollPageDown() {
		jsUtil.scrollPageDown();
		return this;
	}
	
}
