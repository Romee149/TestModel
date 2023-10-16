package com.qa.ecs.pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class PositionDetails {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private JavaScriptUtil jsUtil;

	// ****************** Locators ****************** //
	private By accountNumberTextField = By.xpath("//input[contains(@class,'account-number')]");
	private By selectAccountGroupDropdown = By.xpath("//select[contains(@class,'account-group')]");
	
	private Function<Integer,By> selectProductTypeDropdown = (index) -> By.xpath("(//select[contains(@class,'product-type')])["+index+"]");
	private Function<Integer,By> positionNameTextField = (index) ->By.xpath("(//input[contains(@class,'position-name')])["+index+"]");
	private Function<Integer,By> productCodeTextField = (index) ->By.xpath("(//input[contains(@class,'product-code')])["+index+"]");
	private Function<Integer,By> selectCurrencyDropdown = (index) ->By.xpath("(//select[contains(@class,'currency')])["+index+"]");
	private Function<Integer,By> selectDepartmentIdDropdown = (index) ->By.xpath("(//select[contains(@class,'acctSegdept')])["+index+"]");
	private Function<Integer,By> selectVerticalDropdown = (index) ->By.xpath("(//select[contains(@class,'acctSegvert')])["+index+"]");
	private Function<Integer,By> enterPromoCodeLink = (index) ->By.xpath("(//span[contains(text(),'ENTER PROMO CODE')])["+index+"]");
	private Function<Integer,By> deleteIcon = (index) -> By.xpath("(//*[local-name()='svg' and contains(@class,'trash')])["+index+"]");
	
	private By nextButton = By.xpath("//input[contains(@class,'next-button')]");
	private By previousButton = By.xpath("//input[contains(@class,'PreviousButton')]");
	private By addAdditionalPositionLink = By.xpath("//span[text()='Add Additional Position']");
	private Function<Integer,By> positonNumber = (index) -> By.xpath("(//span[contains(@id,'positionNumber')])["+index+"]");
	private By creditLimitTextfield = By.xpath("//input[contains(@id,'CreditLimitInput')]");
	private By addCollateralCheckbox = By.xpath("//input[contains(@id,'collateralValue')]");
	
	public PositionDetails(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to enter account number in text field in Position Details Page
	 *
	 * @param accountNumber in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails enterAccountNumber(String accountNumber) {
		try {
			eleUtil.waitForElementPresence(this.accountNumberTextField, 10);
			eleUtil.doSendKeys(this.accountNumberTextField, accountNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter account number " + accountNumber + " in Position Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering account number " + accountNumber + " in Position Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	/**
	 * This method is used to enter Credit Limit in Position Details Page
	 *
	 * @param creditLimit in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails enterCreditLimit(String creditLimit) {
		try {
			eleUtil.waitForElementPresence(this.creditLimitTextfield, 10);
			eleUtil.doSendKeys(this.creditLimitTextfield, creditLimit);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter credit limit " + creditLimit + " in Position Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering credit limit " + creditLimit + " in Position Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select Account Group from drop down menu in Position Details Page
	 *
	 * @param group in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails selectAccountGroup(String group) {
		try {
			eleUtil.waitForElementVisibility(this.selectAccountGroupDropdown,20);
			eleUtil.doDropDownSelectByVisibleText(this.selectAccountGroupDropdown, group);
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected account group " + group + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting account group " + group + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select product type from drop down menu in Position Details Page
	 *
	 * @param productType in String format
	 * @param indexNumber in Integer format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails selectProductType(String productType, Integer indexNumber) {
		try {
			eleUtil.waitForElementToBeClickable(this.selectProductTypeDropdown.apply(indexNumber), 10);
			eleUtil.doDropDownSelectByVisibleText(this.selectProductTypeDropdown.apply(indexNumber), productType.trim());
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO, "Selected product type " + productType + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting product type " + productType + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter Position Name in text field in Position Details Page
	 *
	 * @param positionName in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails enterPositionName(String positionName, Integer indexNumber) {
		try {
			eleUtil.waitForElementPresence(this.positionNameTextField.apply(indexNumber), 10);
			eleUtil.doSendKeys(this.positionNameTextField.apply(indexNumber), positionName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter position name " + positionName + " in Position Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering position name " + positionName + " in Position Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select Department Id from drop down menu in Position Details Page
	 *
	 * @param departmentId in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails selectDepartmentId(String departmentId, Integer indexNumber) {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.selectDepartmentIdDropdown.apply(indexNumber), 10);
			eleUtil.doDropDownSelectByVisibleText(this.selectDepartmentIdDropdown.apply(indexNumber), departmentId);
			wait(4);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Department Id " + departmentId + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Department Id " + departmentId + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select Vertical from drop down menu in Position Details Page
	 *
	 * @param group in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails selectVertical(String vertical, Integer indexNumber) {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.selectVerticalDropdown.apply(indexNumber), 10);
			eleUtil.doDropDownSelectByVisibleText(this.selectVerticalDropdown.apply(indexNumber), vertical);
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Vertical " + vertical + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Vertical " + vertical + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	
	/**
	 * This method is used to click on Add Collateral Checkbox
	 *
	 * @param nothing
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails clickOnAddCollateralCheckbox() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.addCollateralCheckbox, 5);
			eleUtil.doClick(this.addCollateralCheckbox);
			wait(3);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Add Collateral Checkbox on PositionDetails page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Add Collateral Checkbox on PositionDetails page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.doClick(this.nextButton);
			wait(3);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on PositionDetails page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on PositionDetails page");
			Assert.fail(e.getMessage());
		}
		return new ElectronicAcceptanceDocuments(driver);
	}
	
	/**
	 * This method is used to click on Previous button
	 *
	 * @param nothing
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties clickOnPreviousButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.previousButton, 5);
			eleUtil.doClick(this.previousButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on previous button on PositionDetails page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on previous button on PositionDetails page");
			Assert.fail(e.getMessage());
		}
		return new RelatedParties(driver);
	}
	
	/**
	 * This method is used to click on Add Additional Position Link
	 *
	 * @param nothing
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails clickOnAddAdditionalPositionLink() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.addAdditionalPositionLink, 10);
			eleUtil.doClick(this.addAdditionalPositionLink);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Add AdditionalPositionLink on PositionDetails page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on previous button on PositionDetails page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to get Account Number after select Product Type
	 *
	 * @return This will return accountNumber from accountNumberTextField which is auto generated
	 */
	public String getAccountNumber() {
		eleUtil.scrollToElementByActionsClass(this.accountNumberTextField);
		eleUtil.waitForElementVisibility(this.accountNumberTextField, 10);
		String accountNumber = eleUtil.getAttributeValue(this.accountNumberTextField, "value");
		return accountNumber;
	}
	
	/**
	 * This method is used to get Position Number for Multi-Position  after select Product Type
	 *
	 * @return This will return positionInfo from Position Text which is auto generated
	 */
	public String getPositionInfo(Integer index) {
		eleUtil.waitForElementPresence(this.positonNumber.apply(index),20);
		eleUtil.scrollToElementByActionsClass(this.positonNumber.apply(index));
		String postionText = eleUtil.doGetText(this.positonNumber.apply(index));
		return postionText;
	}
	
}

