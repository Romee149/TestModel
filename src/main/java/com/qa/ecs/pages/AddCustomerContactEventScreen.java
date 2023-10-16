package com.qa.ecs.pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AddCustomerContactEventScreen {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 40;

	private By originLabel = By.xpath("//div[contains(@id,'Origin')]/label");
	private By originDropdown = By.xpath("//div[contains(@id,'Origin')]/select");
	private By topicLabel = By.xpath("//div[contains(@id,'Topic')]/label");
	private By topicDropdown = By.xpath("//div[contains(@id,'Topic')]/select");
	private By subtopicLabel = By.xpath("//div[contains(@id,'Subject')]/label");
	private By subtopicDropdown = By.xpath("//div[contains(@id,'Subject')]/select");
	private By customerIDLabel = By
			.xpath("//div[contains(@id,'Customer_CN')]/span[not(contains(@style,'display: none'))]");
	private By partyIDLabel = By.xpath("//div[contains(@id,'Party_CN')]/span[not(contains(@style,'display: none'))]");
	private By partyGroupIDLabel = By
			.xpath("//div[contains(@id,'PartyGroup_CN')]/span[not(contains(@style,'display: none'))]");
	private By accountNumberLabel = By.xpath(
			"//div[contains(@id,'AccountNumber_CN') and not(contains(@id,'Position'))]/span[not(contains(@style,'display: none'))]");
	private By accountNumberDropdown = By
			.xpath("//div[contains(@id,'AccountNumber_CN') and not(contains(@id,'Position'))]/select");
	private By positionAccountNumberLabel = By
			.xpath("//div[contains(@id,'PositionAccountNumber_CN')]/span[not(contains(@style,'display: none'))]");
	private By positionAccountNumberDropdown = By.xpath("//div[contains(@id,'PositionAccountNumber_CN')]/select");
	private By platformLabel = By.xpath("//div[contains(@id,'Platform')]/span[not(contains(@style,'display: none'))]");
	private By platformDropdown = By.xpath("//div[contains(@id,'Platform')]/select");
	private By messageLabel = By.xpath("//div[contains(@id,'Message_CN')]/label");
	private Function<String, By> messageTextArea = (text) ->By.xpath("//textarea[contains(@id,'"+text+"')]");
	private By cancelButton = By.xpath("//input[@value='Cancel']");
	private By submitButton = By.xpath("//input[@value='Submit']");

	public AddCustomerContactEventScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of AddComplaintScreen class
	 */
	public AddCustomerContactEventScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to get label of Origin Dropdown
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getOriginDropdownLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.originLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Origin dropdown label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Origin dropdown label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of Topic Dropdown
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getTopicDropdownLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.topicLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Topic dropdown label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Topic dropdown label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of Sub Topic Dropdown
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getSubTopicDropdownLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.subtopicLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Sub Topic dropdown label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Sub Topic dropdown label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of CustomerID Textfield
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getCustomerIDTextfieldLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.customerIDLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting CustomerID textfield label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting CustomerID textfield label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of PartyID Textfield
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getPartyIDTextfieldLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.partyIDLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting PartyID textfield label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting PartyID textfield label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of PartyGroupID Textfield
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getPartyGroupIDTextfieldLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.partyGroupIDLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting PartyGroupID textfield label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting PartyGroupID textfield label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of AccountNumber dropdown
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getAccountNumberDropdownLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.accountNumberLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting AccountNumber dropdown label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting AccountNumber dropdown label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of PositionAccountNumber dropdown
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getPositionAccountNumberDropdownLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.positionAccountNumberLabel);
			ExtentReportListener.test.get().log(Status.INFO,
					"Getting PositionAccountNumber dropdown label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while getting PositionAccountNumber dropdown label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of Platform dropdown
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getPlatformDropdownLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.platformLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Platform dropdown label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Platform dropdown label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get label of Message Textfield
	 *
	 * @param nothing
	 * @return This will return the label in string format
	 */
	public String getMessageTextfieldLabel() {
		String value = null;
		try {
			value = eleUtil.doGetText(this.messageLabel);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Message Textfield label successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Message Textfieldn label");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get Cancel button existing user
	 *
	 * @param nothing
	 * @return This will return the existence status in boolean
	 */
	public boolean isCancelButtonExists() {
		boolean value = false;
		try {
			value = eleUtil.isElementExist(this.cancelButton);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Cancel Button existence status successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Cancel Button existence status");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to get Submit button existing user
	 *
	 * @param nothing
	 * @return This will return the existence status in boolean
	 */
	public boolean isSubmitButtonExists() {
		boolean value = false;
		try {
			value = eleUtil.isElementExist(this.submitButton);
			ExtentReportListener.test.get().log(Status.INFO, "Getting Submit Button existence status successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while getting Submit Button existence status");
			Assert.fail(e.getMessage());
		}
		return value;
	}
	
	
	
	/**
	 * This method is used to select value from Origin Dropdown
	 *
	 * @param origin in String format
	 * @return This will return the object of AddCustomerContactEventScreen class
	 */
	public AddCustomerContactEventScreen selectOrigin(String origin) {		
		try {
			eleUtil.doDropDownSelectByVisibleText(this.originDropdown, origin);
			ExtentReportListener.test.get().log(Status.INFO, "selecting value from Origin dropdown successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting Origin dropdown");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	
	/**
	 * This method is used to select value from Topic Dropdown
	 *
	 * @param topic in String format
	 * @return This will return the object of AddCustomerContactEventScreen class
	 */
	public AddCustomerContactEventScreen selectTopic(String topic) {		
		try {
			eleUtil.doDropDownSelectByVisibleText(this.topicDropdown, topic);
			ExtentReportListener.test.get().log(Status.INFO, "selecting value from Topic dropdown successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting Topic dropdown");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to select value from Sub Topic Dropdown
	 *
	 * @param subtopic in String format
	 * @return This will return the object of AddCustomerContactEventScreen class
	 */
	public AddCustomerContactEventScreen selectSubTopic(String subtopic) {		
		try {	
			this.wait(5);
			eleUtil.doDropDownSelectByVisibleText(this.subtopicDropdown, subtopic);
			ExtentReportListener.test.get().log(Status.INFO, "selecting value from Sub Topic dropdown successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting Sub Topic dropdown");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to enter value in Message textbox
	 *
	 * @param message in string format
	 * @return This will return the object of AddCustomerContactEventScreen class
	 */
	public AddCustomerContactEventScreen enterMessage(String text, String message) {		
		try {
			eleUtil.scrollToElementByActionsClass(this.messageTextArea.apply(text));
			eleUtil.doSendKeys(this.messageTextArea.apply(text), message);
			ExtentReportListener.test.get().log(Status.INFO, "Enter Message successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering message");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Submit button
	 *
	 * @param nothing
	 * @return This will return the object of CustomerDetail class
	 */
	public CustomerDetail clickOnSubmitButton() {
		try {
			eleUtil.doClick(this.submitButton);
			ExtentReportListener.test.get().log(Status.INFO, "Clicking on Submit Button successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while clicking on Submit Button");
			Assert.fail(e.getMessage());
		}
		return new CustomerDetail(driver);
	}

}
