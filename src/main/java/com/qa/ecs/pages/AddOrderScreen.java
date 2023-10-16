package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AddOrderScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 20;
	
	private By orderTypeDropdown = By.xpath("//select[contains(@id,'OrderTypeInput')]");
	private By transferToCustomerPositionCheckbox = By.xpath("//input[@type='checkbox' and @class='TransferToCustAcct']");
	private By accountNumberDropdown = By.xpath("//select[contains(@class,'custAcctNbrWithGrp')]");
	private By positionAccountNumberDropdown = By.xpath("//select[contains(@id,'customerPositionAccountNumber')]");
	private By transferDateSendNowCheckbox = By.xpath("//input[contains(@id,'IsSendNowValue') and @class='IsSendNowValue']");
	private By transferAmountTextfield = By.xpath("//input[contains(@id,'OrderAmt')]");
	//private By submitButton = By.xpath("//input[contains(@id,'ButtonSubmit')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	private By confirmButton = By.xpath("//input[contains(@id,'ButtonConfirm')]");
	private By startDateTextField = By.xpath("//div[contains(@id,'StartDate')]//input[contains(@id,'txtInputDate') and @aria-required]");
	private By routingNumberTextField = By.xpath("//input[contains(@class, 'RoutingNumber')]");
	private By accountTitleTextField = By.xpath("//input[contains(@class, 'AcctTitle')]");
	private By accountTypeDropdown = By.xpath("//select[contains(@class, 'AcctType')]");
	private By accountNumberTextField = By.xpath("//input[contains(@class, 'accountNumber')]");
	private By transferDateTextField = By.xpath("//input[contains(@class,'OrderDateInput')]");
	
	public AddOrderScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to select Order Type from Order Type drop down
	 * 
	 * @param orderType in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen selectOrderType(String orderType) {
		try {
			eleUtil.waitForElementVisibility(this.orderTypeDropdown, 40);
			eleUtil.doDropDownSelectByVisibleText(this.orderTypeDropdown, orderType);
			eleUtil.wait(2);
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected Order Type " + orderType + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Order Type from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Transfer To Customer Position Checkbox
	 * 
	 * @param nothing
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen clickOnTransferToCustomerPositionCheckbox() {
		try {
			eleUtil.waitForElementPresence(this.transferToCustomerPositionCheckbox, timeout);
			eleUtil.doClick(this.transferToCustomerPositionCheckbox);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Transfer To Customer Position Checkbox successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Transfer To Customer Position Checkbox");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	/**
	 * This method is used to select Account Number from Account Number drop down
	 * 
	 * @param accountNumber in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen selectAccountNumber(String accountNumber) {
		try {
			eleUtil.waitForElementPresence(this.accountNumberDropdown, timeout);
			eleUtil.doDropDownSelectByVisibleText(this.accountNumberDropdown, accountNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected Account Number " + accountNumber + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Account Number from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	
	/**
	 * This method is used to select Account Number from Position Account Number drop down
	 * 
	 * @param accountNumber in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen selectPositionAccountNumber(String positionAccountNumber) {
		try {
			try {
				eleUtil.waitForElementPresence(this.positionAccountNumberDropdown, timeout);
				eleUtil.doDropDownSelectByVisibleText(this.positionAccountNumberDropdown, positionAccountNumber);
				ExtentReportListener.test.get().log(Status.INFO,
					"Selected Position Account Number " + positionAccountNumber + "from Dropdown is successfully");
			}catch (StaleElementReferenceException se) {
				eleUtil.wait(10);
				eleUtil.doDropDownSelectByVisibleText(this.positionAccountNumberDropdown, positionAccountNumber);
				ExtentReportListener.test.get().log(Status.INFO,
					"Selected Position Account Number " + positionAccountNumber + "from Dropdown is successfully");
			}
		}
		catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Position Account Number from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	/**
	 * This method is used to click on Transfer Date Send Now Checkbox
	 * 
	 * @param nothing
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen clickOnTransferDateSendNowCheckbox() {
		try {
			eleUtil.waitForElementPresence(this.transferDateSendNowCheckbox, timeout);
			eleUtil.doClick(this.transferDateSendNowCheckbox);
			eleUtil.wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Send Now Checkbox under Transfer Date successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Send Now Checkbox under Transfer Date");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to set Transfer Amount
	 *
	 * @param transferAmount in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen enterTransferAmount(String transferAmount) {
		eleUtil.waitForElementPresence(this.transferAmountTextfield, timeout);
		eleUtil.scrollToElementByActionsClass(this.transferAmountTextfield);
		eleUtil.doSendKeys(this.transferAmountTextfield, transferAmount);
		eleUtil.pressEnterKey(this.transferAmountTextfield);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to set Transfer Amount
	 *
	 * @param transferAmount in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen enterTransferAmount(String transferAmount, boolean doClear) {
		eleUtil.waitForElementPresence(this.transferAmountTextfield, timeout);
		eleUtil.scrollToElementByActionsClass(this.transferAmountTextfield);
		if(doClear)
			eleUtil.doClear(this.transferAmountTextfield);
		eleUtil.doSendKeys(this.transferAmountTextfield, transferAmount);
		eleUtil.pressEnterKey(this.transferAmountTextfield);
		eleUtil.wait(2);
		return this;
	}
	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen clickOnSubmitButton() {			
		int counter = 0;
		while (counter < 10) {
			try {
				eleUtil.waitForElementPresence(this.submitButton, timeout);
				eleUtil.scrollToElementByActionsClass(this.submitButton);
				if(eleUtil.isEnabled(this.submitButton)) {
					eleUtil.doClick(this.submitButton);
					eleUtil.wait(4);
					counter = 10;
				}else {
					counter++;
					wait(2);
				}
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.submitButton);
			}
		}
		return this;
	}
	
	/**
	 * This method is used to click on Confirm Button
	 *
	 * @param nothing
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AccountDetailTabScreen clickOnConfirmButton() {			
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.waitForElementPresence(this.confirmButton, timeout);				
				if(eleUtil.isEnabled(this.confirmButton)) {
					eleUtil.doClick(this.confirmButton);				
					counter = 10;
				}else {
					counter++;
					wait(1);
				}
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.confirmButton);
			}
		}
		return new AccountDetailTabScreen(driver);
	}
	
	/**
	 * This method is used to enter Routing Number
	 *
	 * @param number in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen enterRoutingNumber(String number) {
		eleUtil.waitForElementPresence(this.routingNumberTextField, 20);
		eleUtil.scrollToElementByActionsClass(this.routingNumberTextField);
		eleUtil.doSendKeys(this.routingNumberTextField, number);
		return this;
	}
	
	/**
	 * This method is used to enter account Title 
	 *
	 * @param text in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen enterAccountTitle(String text) {
		eleUtil.waitForElementPresence(this.accountTitleTextField, 20);
		eleUtil.scrollToElementByActionsClass(this.accountTitleTextField);
		eleUtil.doSendKeys(this.accountTitleTextField, text);
		return this;
	}
	
	/**
	 * This method is used to enter account Title 
	 *
	 * @param text in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen enterAccountNumber(String accountNumber) {
		eleUtil.scrollToElementByActionsClass(this.accountNumberTextField);
		eleUtil.doSendKeys(this.accountNumberTextField, accountNumber);
		return this;
	}
	
	/**
	 * This method is used to select account Type from drop down menu in Account
	 * Details Page
	 *
	 * @param account type in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen selectAccountType(String accountType) {
		try {
			eleUtil.scrollToElementByActionsClass(this.accountTypeDropdown);
			eleUtil.doDropDownSelectByVisibleText(this.accountTypeDropdown, accountType);
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected account Type " + accountType + " from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting account Type " + accountType + " from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to set Transfer Amount
	 *
	 * @param transferDate in String format
	 * @return This will return the Object of AddOrderScreen class
	 */
	public AddOrderScreen enterTransferDate(String transferDate) {
		eleUtil.waitForElementPresence(this.transferDateTextField, 20);
		eleUtil.scrollToElementByActionsClass(this.transferDateTextField);
		eleUtil.doSendKeys(this.transferDateTextField, transferDate);
		eleUtil.pressEnterKey(this.transferDateTextField);
		eleUtil.wait(2);
		return this;
	}
}
