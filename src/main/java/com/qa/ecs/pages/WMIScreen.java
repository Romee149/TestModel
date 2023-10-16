package com.qa.ecs.pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class WMIScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	private By workFlowActions = By.xpath("//span[@class='ui-button-text' and text()='Workflow Actions']");
	private By firstApprovalCompleteOption = By.xpath("//*[contains(text(),'First Approval Complete')]");
	private Function<String, By> workFlowActionsOption = (workFlowActionsOption) -> 
	By.xpath("//*[contains(text(),'"+workFlowActionsOption+"')]");
	private By generalCaseInformationValue = By.xpath("//*[@class='FieldValLabel' and contains(text(),'Case Number')]");
	private By frame = By.xpath("//*[@class='iframeContainerHeight']");
	private Function<String, By> selectFromDropDown = (selectType) -> By
			.xpath("//td//span[text()='" + selectType + "']/parent::td//select");
	private By addressTypeDropdown = By.xpath("//select[contains(@id,'AddressType')]");
	private By caseType = By.xpath("//span[text()='Case Type']/following-sibling::span");
	private By closeWindowLink = By.xpath("//a//span[text()=' Close Window']");
	private By caseClassValue = By.xpath("//span[text()='Case Class']//following-sibling::span");
	private Function<String, By> tabLink = (tabLinkName) -> By
			.xpath("//a[@role='menuitem']/span[contains(text(),'"+tabLinkName+"')]");
	
	public WMIScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		eleUtil.switchToFrame(this.frame);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of FundsTransferInternal class
	 */
	public WMIScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to MouseHover to WorkFlowActions and then click on First Approval Complete option
	 * 
	 * @param nothing
	 * @return This will return the Object of FundsTransferInternal class
	 */
	public WorkflowPage selectFirstApprovalCompleteOption() {
		try {
			eleUtil.waitForElementPresence(this.workFlowActions, 20);
			eleUtil.moveToElementAndClick(this.workFlowActions, this.firstApprovalCompleteOption);
			wait(5);
			eleUtil.switchToDefaultContent();
			eleUtil.switchToWindow(0);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"MouseHover to WorkFlowActions and then click on First Approval Complete option is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting First Approval Complete option");
			Assert.fail(e.getMessage());
		}
		return new WorkflowPage(driver);
	}
	
	
	
	/**
	 * This method is used to MouseHover to WorkFlowActions and then click on First Approval Complete option
	 * 
	 * @param nothing
	 * @return This will return the Object of FundsTransferInternal class
	 */
	public WorkflowPage selectWorkFlowActionsOption(String workFlowActionOption) {
		try {
			eleUtil.waitForElementPresence(this.workFlowActions, 20);
			eleUtil.waitForElementVisibility(this.workFlowActions, 20);
			wait(5);
			eleUtil.moveToElementAndClick(this.workFlowActions, this.workFlowActionsOption.apply(workFlowActionOption));
			wait(5);
			eleUtil.switchToDefaultContent();
			eleUtil.switchToWindow(0);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"MouseHover to WorkFlowActions and then click on First Approval Complete option is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting First Approval Complete option");
			Assert.fail(e.getMessage());
		}
		return new WorkflowPage(driver);
	}
	
	/**
	 * This method is used to MouseHover to WorkFlowActions and then click on First Approval Complete option
	 * 
	 * @param nothing
	 * @return This will return the Object of FundsTransferInternal class
	 */
	public String getGeneralCaseInformationValue() {
		String generalCaseInformationValue=null;
		try {
			eleUtil.waitForElementPresence(this.generalCaseInformationValue, 20);
			generalCaseInformationValue = eleUtil.doGetText(this.generalCaseInformationValue);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch General Case Information value is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging General Case Information value");
			Assert.fail(e.getMessage());
		}
		return generalCaseInformationValue;
	}
	
	
	
	/**
	 * This method is used to get Case Class value
	 * 
	 * @param nothing
	 * @return This will return the String
	 */
	public String getCaseClassValue() {
		String caseClassValue=null;
		try {
			eleUtil.waitForElementPresence(this.caseClassValue, 20);
			caseClassValue = eleUtil.doGetText(this.caseClassValue);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch Case Class value is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging Case Class value");
			Assert.fail(e.getMessage());
		}
		return caseClassValue;
	}
	
	
	
	
	/**
	 * This method is used to fetch Case Number available under General Case Information
	 * 
	 * @param nothing
	 * @return This will return the Case Number in String format
	 */
	public String getCaseNumberUnderGeneralCaseInformationValue() {
		String caseNumber=null;
		try {
			eleUtil.waitForElementPresence(this.generalCaseInformationValue, 20);
			caseNumber = eleUtil.doGetText(this.generalCaseInformationValue).split("\\n")[0].split(":")[1].trim();
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch Case Number available under General Case Information is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging Case Number available under General Case Information");
			Assert.fail(e.getMessage());
		}
		return caseNumber;
	}
	
	
	/**
	 * This method is used to fetch Case Status available under General Case Information
	 * 
	 * @param nothing
	 * @return This will return the Case Number in String format
	 */
	public String getCaseStatusUnderGeneralCaseInformationValue() {
		String caseStatus=null;
		try {
			eleUtil.waitForElementPresence(this.generalCaseInformationValue, 20);
			caseStatus = eleUtil.doGetText(this.generalCaseInformationValue).split("\\n")[5].split(":")[1].trim();
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch Case Status available under General Case Information is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging Case Status available under General Case Information");
			Assert.fail(e.getMessage());
		}
		return caseStatus;
	}
	
	
	/**
	 * This method is used to fetch Current Queue available under General Case Information
	 * 
	 * @param nothing
	 * @return This will return the Current Queue in String format
	 */
	public String getCurrentQueueUnderGeneralCaseInformationValue() {
		String currentQueue=null;
		try {
			eleUtil.waitForElementPresence(this.generalCaseInformationValue, 20);
			currentQueue = eleUtil.doGetText(this.generalCaseInformationValue).split("\\n")[8].split(":")[1].trim();
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch Current Queue available under General Case Information is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging Current Queue available under General Case Information");
			Assert.fail(e.getMessage());
		}
		return currentQueue;
	}
	
	
	/**
	 * This method is used to fetch Created Date available under General Case Information
	 * 
	 * @param nothing
	 * @return This will return the Created Date in String format
	 */
	public String getCreatedDateUnderGeneralCaseInformationValue() {
		String createdDate=null;
		try {
			eleUtil.waitForElementPresence(this.generalCaseInformationValue, 20);
			createdDate = eleUtil.doGetText(this.generalCaseInformationValue).split("\\n")[2].split(":")[1].trim();
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch Created Date available under General Case Information is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging Created Date available under General Case Information");
			Assert.fail(e.getMessage());
		}
		return createdDate;
	}
	
	/**
	 * This method is used to fetch line info available under General Case Information
	 * 
	 * @param lineNo in integer format
	 * @return This will return the lineText in String format
	 */
	public String getSpecificLineTextUnderGeneralCaseInformationValue(int lineNo) {
		String lineText=null;
		eleUtil.waitForElementPresence(this.generalCaseInformationValue, 20);
		lineText = eleUtil.doGetText(this.generalCaseInformationValue).split("\\n")[lineNo-1];
		return lineText;
	}
	
	/**
	 * This method is used to get displayed text from Select option
	 * 
	 * @param selectType is in String format
	 * @return This will return value in String format
	 */
	public String getTextFromSelectDisplayedOption(String selectType) {
		String value = null;
		try {
			eleUtil.waitForElementPresence(this.selectFromDropDown.apply(selectType), 20);
			value = eleUtil.doGetText(this.selectFromDropDown.apply(selectType));
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch select option: " + selectType + " and " + value + " is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging select option: " + selectType + " and " + value +"");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get displayed text from Select drop down option
	 * 
	 * @param selectType in String format
	 * @return This will return displayed selectOption from drop down in String format
	 */
	public String getSelectedOptionDisplayedFromDropDown(String selectType) {
		eleUtil.waitForElementPresence(this.selectFromDropDown.apply(selectType), 20);
		String selectedOption = eleUtil.getDefaultSelectedValueForDropdown(this.selectFromDropDown.apply(selectType));
		return selectedOption;
	}
	
	
	
	/**
	 * This method is used to select value from Address Type drop down
	 * 
	 * @param selectType in String format
	 * @return This will return displayed selectOption from drop down in String format
	 */
	public WMIScreen selectAddressType(String addressType) {
		eleUtil.waitForElementPresence(this.addressTypeDropdown, 20);
		eleUtil.doDropDownSelectByVisibleText(this.addressTypeDropdown,addressType);
		return this;
	}


	/**
	 * This method is used to get Case Type text under case type label 
	 * 
	 * @return This will return value in String format
	 */
	public String getCaseTypeText() {
		String value = null;
		try {
			eleUtil.waitForElementPresence(this.caseType, 20);
			value = eleUtil.doGetText(this.caseType);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetch Case Type: "+value + " is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetchinging case type " + value + "");
			Assert.fail(e.getMessage());
		}
		return value;
	}
	
	/**
	 * This method is used to click on Close Window Link
	 *
	 * @return This will return the Object of WMIScreen class
	 */
	public WMIScreen clickOnCloseWindowLink() {
		eleUtil.switchToDefaultContent();
		eleUtil.doClick(this.closeWindowLink);
		eleUtil.switchToWindow(0);
		return this;
	}
	
	public CommonWidget getCommonWidgetPage() {
		return new CommonWidget(driver);
	}
	
	
	public WMIResolutionScreen getWMIResolutionScreen() {
		return new WMIResolutionScreen(driver);
	}
	
	
	/**
	 * This method is used to click on tab link
	 *
	 * @return This will return the Object of WMIScreen class
	 */
	public WMIScreen clickOnTabLink(String tabLinkName) {
		eleUtil.switchToDefaultContent();
		eleUtil.doClick(this.tabLink.apply(tabLinkName));		
		return this;
	}
	
	
	
}
	

