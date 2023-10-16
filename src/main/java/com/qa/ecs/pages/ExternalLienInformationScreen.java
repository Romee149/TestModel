package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ExternalLienInformationScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By lienPositionTextfield = By.xpath("//input[contains(@class,'lien-posn')]");
	private By creditLimitTextfield = By.xpath("//input[contains(@class,'credit-limit')]");
	private By nextButton = By.xpath("//input[contains(@id,'PositionDetailsNext3')]");
	private By financialInstitutionTextfield = By.xpath("//input[contains(@id,'financialInst')]");
	private By accountNumberTextfield = By.xpath("//input[contains(@class,'acct-number')]");
	private By monthlyPaymentAmountTextfield = By.xpath("//input[contains(@class,'monthly-payment')]");
	

	public ExternalLienInformationScreen(WebDriver driver) {
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
	public ExternalLienInformationScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to enter Lien Position
	 *
	 * @param lienPosition in String format
	 * @return This will return the Object of ExternalLienInformationScreen class
	 */
	public ExternalLienInformationScreen enterLienPosition(String lienPosition) {
		try {
			eleUtil.waitForElementPresence(this.lienPositionTextfield, 10);
			eleUtil.doSendKeys(this.lienPositionTextfield, lienPosition);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Lien Position " + lienPosition + " in External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Lien Position " + lienPosition + " in External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to enter Financial Institution
	 *
	 * @param financialInstitution in String format
	 * @return This will return the Object of ExternalLienInformationScreen class
	 */
	public ExternalLienInformationScreen enterFinancialInstitution(String financialInstitution) {
		try {
			eleUtil.waitForElementPresence(this.financialInstitutionTextfield, 10);
			eleUtil.doSendKeys(this.financialInstitutionTextfield, financialInstitution);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Financial Institution " + financialInstitution + " in External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Financial Institution " + financialInstitution + " in External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	/**
	 * This method is used to enter Account Number
	 *
	 * @param accountNumber in String format
	 * @return This will return the Object of ExternalLienInformationScreen class
	 */
	public ExternalLienInformationScreen enterAccountNumber(String accountNumber) {
		try {
			eleUtil.waitForElementPresence(this.accountNumberTextfield, 10);
			eleUtil.doSendKeys(this.accountNumberTextfield, accountNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Account Number " + accountNumber + " in External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Account Number " + accountNumber + " in External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to enter Monthly Payment Amount
	 *
	 * @param monthlyPaymentAmount in String format
	 * @return This will return the Object of ExternalLienInformationScreen class
	 */
	public ExternalLienInformationScreen enterMonthlyPaymentAmount(String monthlyPaymentAmount) {
		try {
			eleUtil.waitForElementPresence(this.monthlyPaymentAmountTextfield, 10);
			eleUtil.doSendKeys(this.monthlyPaymentAmountTextfield, monthlyPaymentAmount);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Monthly Payment Amount " + monthlyPaymentAmount + " in External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Monthly Payment Amount " + monthlyPaymentAmount + " in External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter Credit Limit
	 *
	 * @param creditLimit in String format
	 * @return This will return the Object of ExternalLienInformationScreen class
	 */
	public ExternalLienInformationScreen enterCreditLimit(String creditLimit) {
		try {
			eleUtil.waitForElementPresence(this.creditLimitTextfield, 10);
			eleUtil.doSendKeys(this.creditLimitTextfield, creditLimit);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Credit Limit " + creditLimit + " in External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Credit Limit " + creditLimit + " in External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.doClick(this.nextButton);
			wait(3);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return new CollateralTypeScreen(driver);
	}
	
}
