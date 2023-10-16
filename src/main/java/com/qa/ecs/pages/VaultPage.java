package com.qa.ecs.pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.commonelements.Tables;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class VaultPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 40;
	private CommonWidget commonWidget; 
	private Tables tables;

	// ****************** Locators ****************** //
	private Function<String, By> selectDropdown = (text) ->By.xpath("//span[contains(text(), '"+text+"')]");
	private Function<String, By> dropdownOption = (optionName) -> By.xpath("//div[text()='"+optionName+"']");
	private By filterIcon = By.xpath("//a[@title='Apply filters']");
	private By enterSearchCriteriaCaseNumber = By.xpath("//input[@srcfieldname='Case Number']");
	private By searchButton = By.xpath("//input[@value='Search']");
	private Function<String, By> pageNumber = (pageNumber) -> By.xpath("//*[contains(@id,'PageNavigator')]//span[text()='"+pageNumber+"']");
	private By caseNumberColumnHeader = By.xpath("//*[@headername='caseNumber']//a");
	private Function<String, By> caseNumberColumnValue = (caseNumber) -> By.xpath("//*[@key='caseNumber' and text()='"+caseNumber+"']");
	private By enterSearchCriteriaPopUpLabel = By.xpath("//table[contains(@id,'FieldsTable')]//label[@srcfieldname]");
	private By enterSearchCriteriaPopUpCaseNumberTextfield = By.xpath("//input[@srcfieldname='Case Number']");
	private By enterSearchCriteriaPopUpSearchButton = By.xpath("//input[contains(@id,'wtsearch')]");
	private Function<Integer, By> caseNumberColumnValueByRow = (rowIndex) -> By.xpath("(//span[@key='caseNumber'])["+rowIndex+"]");

	public VaultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		commonWidget =  new CommonWidget(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to click on Select Dropdown for search
	 * 
	 * @param nothing
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage clickOnSelectDropdown(String text) {
		try {
			eleUtil.waitForElementPresence(this.selectDropdown.apply(text), timeout);
			eleUtil.doClick(this.selectDropdown.apply(text));
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Select search Dropdown successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Select search Dropdown");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Select Dropdown Options for search
	 * 
	 * @param nothing
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage clickOnDropdownOption(String text) {
		try {
			eleUtil.waitForElementPresence(this.dropdownOption.apply(text), timeout);
			eleUtil.doClick(this.dropdownOption.apply(text));
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Select search option from Dropdown successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Select search option of Dropdown");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Filter Icon
	 * 
	 * @param nothing
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage clickOnFilterIcon() {
		try {
			eleUtil.waitForElementPresence(this.filterIcon, timeout);
			eleUtil.doClick(this.filterIcon);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Filter Icon successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Filter Icon");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to set Case Number
	 *
	 * @param caseNumber in String format
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage enterCaseNumber(String caseNumber) {
		try {
		eleUtil.waitForElementVisibility(this.enterSearchCriteriaCaseNumber, timeout);
		eleUtil.doSendKeys(this.enterSearchCriteriaCaseNumber, caseNumber);
		}catch(Exception e) {
			jsUtil.scrollIntoView(this.enterSearchCriteriaCaseNumber);
			eleUtil.doSendKeys(this.enterSearchCriteriaCaseNumber, caseNumber);
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Search Button
	 * 
	 * @param nothing
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage clickOnSearchButton() {
		try {
			eleUtil.waitForElementPresence(this.searchButton, timeout);
			eleUtil.doClick(this.searchButton);
			eleUtil.wait(4);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Search Button successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Search Button");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Page Number in Page Navigation
	 * 
	 * @param nothing
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage clickOnPageNumber(String pageNumber) {
		try {
			eleUtil.waitForElementPresence(this.pageNumber.apply(pageNumber), timeout);
			eleUtil.doClick(this.pageNumber.apply(pageNumber));
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Page Number successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Page Number");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Page Number in Page Navigation
	 * 
	 * @param nothing
	 * @return This will return the Object of VaultPage class
	 */
	public VaultPage clickOnCaseNumberColumnHeader() {
		try {
			eleUtil.waitForElementPresence(this.caseNumberColumnHeader, timeout);
			eleUtil.doClick(this.caseNumberColumnHeader);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Case Number Column Header successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Case Number Column Header");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Page Number in Page Navigation
	 * 
	 * @param nothing
	 * @return This will return the Object of FundsTransferInternalPage class
	 */
	public WMIScreen clickOnCaseNumber(String caseNumber) {
		try {
			eleUtil.waitForElementVisibility(this.caseNumberColumnValue.apply(caseNumber), timeout);
			wait(10);
			eleUtil.doClick(this.caseNumberColumnValue.apply(caseNumber));
			wait(10);
			eleUtil.switchToWindow(1);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Case Number successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Case Number");
			Assert.fail(e.getMessage());
		}
		return new WMIScreen(driver);
	}
	
	
	public CommonWidget getCommonWidget() {
		return this.commonWidget;
	}
	
	public String getCaseNumber(int rowNumber) {
		String value=null;
		try {
			eleUtil.waitForElementVisibility(this.caseNumberColumnValueByRow.apply(rowNumber), timeout);
			value = eleUtil.doGetText(this.caseNumberColumnValueByRow.apply(rowNumber));
			ExtentReportListener.test.get().log(Status.INFO,
					"Get CaseNumber successfuly");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while getting CaseNumber");
			Assert.fail(e.getMessage());
		}
		return value;
	}
	
}
