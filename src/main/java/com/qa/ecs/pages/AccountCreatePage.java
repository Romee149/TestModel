package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AccountCreatePage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private AccountDetails accountDetails;
	private RelatedParties relatedParties;
	private PositionDetails positionDetails;
	private ElectronicAcceptanceDocuments electronicDoc;
	private JavaScriptUtil jsUtil;
	
	// ****************** Locators ****************** //
	private By addNewAccountLink = By.xpath("//span[text()='Add New Account']");
	
	public AccountCreatePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
		accountDetails= new AccountDetails(driver);
		relatedParties = new RelatedParties(driver);
		positionDetails =new PositionDetails(driver);
		electronicDoc = new ElectronicAcceptanceDocuments(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of AccountCreatePage class
	 */
	public AccountCreatePage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to click On Add New Account
	 *
	 * @param none
	 * @return This will return the Object of AccountCreatePage class
	 */
	public AccountCreatePage clickOnAddNewAccount() {
		eleUtil.doClick(this.addNewAccountLink);
		return this;
	}
	
	/**
	 * This method is used to enter mandatory fields on AccountDetails Page
	 *
	 * @param firstName FirstName value for Search
	 * @return This will return the Object of AccountCreatePage class
	 */
	public AccountCreatePage enterMandatoryFieldsOnAccountDetailsPage() {
		return this;
		
	}
}
