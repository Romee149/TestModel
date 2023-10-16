package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JacksonUtils;
import com.qa.ecs.utils.JavaScriptUtil;

public class ContactInformation {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	// ****************** Locators ****************** //
	private By phoneNumberTextField = By.xpath("//input[contains(@class,'phoneInput')]");
	private By phoneExtensionTextField = By.xpath("//input[contains(@class,'phoneExtension')]");
	private By selectPhoneType = By.xpath("//select[contains(@id,'wtPhoneType')]");
	private By verifiedPhoneDateTextField = By.xpath("//input[contains(@class,'verifiedPhDateInput')]");
	private By linkSetPhone = By.xpath("//span[text()='Set Phone Valid to/from date']");
	private By linkClearForPhoneValidToFromDate = By.xpath("//span[contains(text(),'Clear Phone')]");
	private By phoneValidFromDateTextField = By.xpath("//input[contains(@id,'wtValidFrom')]");
	private By phoneValidUntilDateTextField = By.xpath("//input[contains(@id,'wtValidUntil')]");
	private By emailTextField = By.xpath("//input[contains(@id,'wtEmail')]");
	private By selectEmailType = By.xpath("//select[contains(@id,'wtEmailType')]");
	private By emailVerifiedDateTextField = By.xpath("//input[contains(@id,'wtVerifiedDateInput2')]");
	private By emailValidFromDateTextField = By.xpath("//input[contains(@class,'emailValidFrmDateInput')]");
	private By emailValidUntilDateTextField = By.xpath("//input[contains(@class,'emailValidUnDateInput')]");
	private By selectPreferredContactMethod = By.xpath("//select[contains(@id,'wtcontactPreference')]");
	private By preferenceEmailCheckBox = By.xpath("//input[@type='checkbox' and contains(@class,'emailCheckBox')]");
	private By preferenceSMSCheckBox = By.xpath("//input[@type='checkbox' and contains(@class,'smsCheckBox')]");
	private By preferencePaperCheckBox = By.xpath("//input[@type='checkbox' and contains(@class,'paperCheckbox')]");
	private By preferencePushCheckBox = By.xpath("//input[@type='checkbox' and contains(@class,'pushcheckbox')]");
	private By linkSetEmailValidToFromDate = By.xpath("//span[contains(text(),'Set Email')]");
	private By linkClearEmailValidToFromDate = By.xpath("//span[contains(text(),'Clear Email')]");
	private By nextButton = By.xpath("//input[contains(@id,'Contact') and contains(@class, 'nextBtn')]");
	private By previousButton = By.xpath("(//input[contains(@class, 'PreviousButton')])[1]");
	private By actionTitle = By.xpath("//*[@class='tab-item active']/span");

	public ContactInformation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to enter Phone Number in text field in Contact
	 * Information Page
	 *
	 * @param phoneNumber in String format
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation enterPhoneNumber(String phoneNumber) {
		try {
			eleUtil.waitForElementPresence(this.phoneNumberTextField, 10);
			eleUtil.doSendKeys(this.phoneNumberTextField, phoneNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter \'" + phoneNumber + "\' in Contact Information page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering \'" + phoneNumber + "\' in Contact Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Email address in textfield in Contact
	 * Information Page
	 *
	 * @param emailAddress in String format
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation enterEmail(String emailAddress) {
		try {
			eleUtil.waitForElementPresence(this.emailTextField, 10);
			eleUtil.doSendKeys(this.emailTextField, emailAddress);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter \'" + emailAddress + "\' in Contact Information page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering \'" + emailAddress + "\' in Contact Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Previous button in Contact Information Page
	 *
	 * @return This will return the Object of LocationInformation class
	 */
	public LocationInformation clickOnPreviousButton() {
		eleUtil.scrollToElementByActionsClass(this.previousButton);
		eleUtil.doClick(this.previousButton);
		return new LocationInformation(driver);
	}

	/**
	 * This method is used to click on Next button in Contact Information Page
	 *
	 * @return This will return the Object of CustomerDueDiligence class
	 */
	public DueDiligencePage clickOnNextButton() {
		jsUtil.scrollPageDown();
		eleUtil.waitForElementToBeClickable(this.nextButton, 5);
		eleUtil.doClick(this.nextButton);
		return new DueDiligencePage(driver);
	}

	/**
	 * This method is used to fill all Mandatory Fields on Contact Information Page
	 *
	 * @param createConsumerData CreateConsumer
	 * @return This will return the Object of CustomerDueDiligence class
	 */
	public DueDiligencePage enterDataOnContactInformationPage(com.qa.ecs.pojo.request.CreateConsumer createConsumerData) {

		if (createConsumerData.getPartyPerson().getPhones().get(0).getData() != null)
			this.enterPhoneNumber(createConsumerData.getPartyPerson().getPhones().get(0).getData());

		if (createConsumerData.getPartyPerson().getEmails().get(0).getData() != null)
			this.enterEmail(createConsumerData.getPartyPerson().getEmails().get(0).getData());

		return this.clickOnNextButton();
	}

	/**
	 * This method is used to fill all Mandatory Fields on Contact Information Page
	 *
	 * @param phoneNumber
	 * @param email
	 * @return This will return the Object of CustomerDueDiligence class
	 */
	public DueDiligencePage enterDataOnContactInformationPage(com.qa.ecs.pojo.request.CreateOrganization createOrgData) {

		if (createOrgData.getPartyOrg().getPhones().get(0).getData() != null)
			this.enterPhoneNumber(createOrgData.getPartyOrg().getPhones().get(0).getData());

		if (createOrgData.getPartyOrg().getEmails().get(0).getData() != null)
			this.enterEmail(createOrgData.getPartyOrg().getEmails().get(0).getData());

		return this.clickOnNextButton();
	}

}