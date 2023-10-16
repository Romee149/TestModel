package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AccountDetails {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private JavaScriptUtil jsUtil;

	// ****************** Locators ****************** //
	private By accountTitleTextField = By.xpath("//label[text() ='Account Title']/following-sibling::div//input");
	private By accountNickNameTextField = By.xpath("//label[text() ='Account Nickname']/following-sibling::div//input");
	private By accountOpenDateTextField = By.xpath("//input[contains(@class, 'AcctOpenDateCal')]");
	private By accountReferenceIDTextField = By.xpath("");
	private By selectAccountCurrencyDropdown = By
			.xpath("//label[text()='Account Currency']/following-sibling::div//select");
	private By selectTimeZoneDropdown = By.xpath("//select[contains(@class, 'time-zone')]]");
	private By nextButton = By.xpath("//input[contains(@class,'next-button')]");
	private By cancelButton = By.xpath("//input[contains(@class,'CancelButton')]");
	

	public AccountDetails(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of AccountDetails class
	 */
	public AccountDetails wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
		
	/**
	 * This method is used to click on cancel button
	 *
	 * @param nothing
	 * @return This will return the Object of AccountDetails class
	 */
	public AccountDetails clickOnCancelButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.cancelButton, 5);
			eleUtil.doClick(this.cancelButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on cancel button on AccountDetails page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on cancel button on AccountDetails page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter account title in text field in Account Details
	 * Page
	 *
	 * @param accountTitle in String format
	 * @return This will return the Object of AccountDetails class
	 */
	public AccountDetails enterAccountTitle(String accountTitle) {
		try {
			eleUtil.waitForElementPresence(this.accountTitleTextField, 10);
			eleUtil.doSendKeys(this.accountTitleTextField, accountTitle);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter " + accountTitle + " in Account Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering " + accountTitle + " in Account Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select account currency from drop down menu in Account Details Page
	 *
	 * @param currency is in String format
	 * @return This will return the Object of AccountDetails class
	 */
	public AccountDetails selectAccountCurrency(String currency) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectAccountCurrencyDropdown, currency);
			ExtentReportListener.test.get().log(Status.INFO, "Selected account currency " + currency + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting account currency from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 20);
			eleUtil.doClick(this.nextButton);
			wait(6);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on AccountDetails page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on AccountDetails page");
			Assert.fail(e.getMessage());
		}
		return new RelatedParties(driver);
	}
}
