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

public class WorkflowPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 40;
	private CommonWidget commonWidget; 
	private Tables tables;

	// ****************** Locators ****************** //
	private By selectProcessDropdown = By.xpath("//a[@class='select2-choice']");
	private Function<String, By> selectProcessDropdownValue = (process) -> By.xpath("//ul[@id='select2-results-1']//*[text()='"+process+"']");
	//Account Servicing
	private Function<String, By> selectActivities = (activityName) -> By.xpath("//*[@class='ActivityListItemText' and text()='"+activityName+"']");
	//Approval
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
	
	
	public WorkflowPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		commonWidget =  new CommonWidget(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to click on Select Process Dropdown
	 * 
	 * @param nothing
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnSelectProcessDropdown() {
		try {
			eleUtil.waitForElementPresence(this.selectProcessDropdown, timeout);
			eleUtil.doClick(this.selectProcessDropdown);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Select Process Dropdown successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Select Process Dropdown");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Select Process value
	 * 
	 * @param processName in String format
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnSelectProcessValue(String processName) {
		try {
			eleUtil.waitForElementPresence(this.selectProcessDropdownValue.apply(processName), timeout);
			eleUtil.doClick(this.selectProcessDropdownValue.apply(processName));
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Select Process Value successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Select Process Value");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	/**
	 * This method is used to click on Activities
	 * 
	 * @param activities in String format
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnActivity(String activities) {
		try {
			eleUtil.waitForElementPresence(this.selectActivities.apply(activities), timeout);
			eleUtil.doClick(this.selectActivities.apply(activities));
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Activity successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Activity");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Filter Icon
	 * 
	 * @param nothing
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnFilterIcon() {
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
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage enterCaseNumber(String caseNumber) {
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
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnSearchButton() {
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
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnPageNumber(String pageNumber) {
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
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnCaseNumberColumnHeader() {
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
	
	/**
	 * This method is used to verify label in Enter Search Criteria PopUp 
	 * 
	 * @param labelName
	 * @return This will return the Object of WorkflowPage class
	 */
	public boolean isLabelOfEnterSearchCriteriaPopupExist(String labelName) {
		boolean status=false;
		try {		
			List<String> list = eleUtil.getAllOptionsOfElement(this.enterSearchCriteriaPopUpLabel);
			status = list.contains(labelName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Search Button in Enter Search Criteria PopUp successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Search Button in Enter Search Criteria PopUp");
			Assert.fail(e.getMessage());
		}
		return status;
	}
	
	/**
	 * This method is used to click on Search button in Enter Search Criteria PopUp 
	 * 
	 * @param nothing
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage enterCaseNumberInEnterSearchCriteriaPopup(String caseNumber) {
		try {
			eleUtil.waitForElementVisibility(this.enterSearchCriteriaPopUpCaseNumberTextfield, timeout);
			eleUtil.doSendKeys(this.enterSearchCriteriaPopUpCaseNumberTextfield, caseNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Case Number in Case Number textfield in Enter Search Criteria PopUp successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Case Number in Case Number textfield in Enter Search Criteria PopUp");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Search button in Enter Search Criteria PopUp 
	 * 
	 * @param nothing
	 * @return This will return the Object of WorkflowPage class
	 */
	public WorkflowPage clickOnSearchButtonInEnterSearchCriteriaPopup() {
		try {
			eleUtil.waitForElementVisibility(this.enterSearchCriteriaPopUpSearchButton, timeout);
			eleUtil.doClick(this.enterSearchCriteriaPopUpSearchButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Search Button in Enter Search Criteria PopUp successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Search Button in Enter Search Criteria PopUp");
			Assert.fail(e.getMessage());
		}
		return this;
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