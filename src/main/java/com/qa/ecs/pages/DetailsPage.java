package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;


public class DetailsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	// ****************** Locators ****************** //
	private By familiarNameTextField = By.xpath("//input[contains(@id,'FamiliarName')]");
	private By maidenNameTextField = By.xpath("//input[contains(@id,'wtMaidenName')]");
	private By motherMaidenNameTextField = By.xpath("//input[contains(@id,'wtMotherMaidenName')]");
	private By totalHouseHoldMembersTextField = By.xpath("//input[contains(@id,'wtNumberHousehold')]");
	private By selectMaritalStatus = By.xpath("//select[contains(@id,'wtMaritalStatusInput')]");
	private By selectPreferredLanguage = By.xpath("//select[contains(@id,'wtPreferredLanguage')]");
	private By selectAlternateLanguage = By.xpath("//select[contains(@id,'wtAlternateLanguage')]");
	private By selectAgeRange = By.xpath("//select[contains(@id,'wtAgeBracket')]");
	private By selectGender = By.xpath("//select[contains(@id,'wtGender')]");
	private By selectEthnicity = By.xpath("//select[contains(@id,'wtenthnicity')]");
	private By previousButton = By.xpath("//input[contains(@class,'PreviousBtn')]");
	private By nextButton = By.xpath("//input[contains(@class,'NextBtn')]");

	private By descriptionTextField = By.xpath("//input[contains(@id,'wtDescription')]");

	public DetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to enter Familiar Name in textfield in Consumer Details
	 * Page
	 *
	 * @param familiarName in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage enterFamiliarName(String familiarName) {
		try {
			eleUtil.waitForElementPresence(this.familiarNameTextField, 10);
			eleUtil.doSendKeys(this.familiarNameTextField, familiarName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter " + familiarName + " in Consumer Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering " + familiarName + " in Consumer Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Maiden Name in textfield in Consumer Details
	 * Page
	 *
	 * @param maidenName in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage enterMaidenName(String maidenName) {
		try {
			eleUtil.waitForElementPresence(this.maidenNameTextField, 10);
			eleUtil.doSendKeys(this.maidenNameTextField, maidenName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter " + maidenName + " in Consumer Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering " + maidenName + " in Consumer Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Mother's Maiden Name in textfield in Consumer
	 * Details Page
	 *
	 * @param motherMaidenName in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage enterMotherMaidenName(String motherMaidenName) {
		try {
			eleUtil.waitForElementPresence(this.motherMaidenNameTextField, 10);
			eleUtil.doSendKeys(this.motherMaidenNameTextField, motherMaidenName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter " + motherMaidenName + " in Consumer Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering " + motherMaidenName + " in Consumer Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter TotalNumberOfHouseholdMember in input text field
	 * in Consumer Details Page
	 *
	 * @param totalNumberOfHouseholdMember in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage enterTotalNumberOfHouseholdMember(String totalNumberOfHouseMember) {
		try {
			eleUtil.waitForElementPresence(this.totalHouseHoldMembersTextField, 10);
			eleUtil.doSendKeys(this.totalHouseHoldMembersTextField, totalNumberOfHouseMember);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter " + totalNumberOfHouseMember + " in Consumer Details page is successfull");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering " + totalNumberOfHouseMember + " in Consumer Details page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Marital Status from drop down menu in Consumer
	 * Details Page
	 *
	 * @param maritalStatus in String format
	 * @return This will return the Object of WorkItemsScreen class
	 */
	public DetailsPage selectMaritalStatus(String maritalStatus) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectMaritalStatus, maritalStatus);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO, "Selected Marital Satus from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Marital Status from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Previous button in Consumer Details Page
	 *
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage clickOnPreviousBtn() {
		eleUtil.doClick(this.previousButton);
		return this;
	}

	/**
	 * This method is used to select Preferred Language from drop down menu in
	 * Consumer Details Page
	 *
	 * @param preferredLanguage in String format
	 * @return This will return the Object of WorkItemsScreen class
	 */
	public DetailsPage selectPreferredLanguage(String preferredLanguage) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectPreferredLanguage, preferredLanguage);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected Preferred Language'" + preferredLanguage + "' from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting preferred Language from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Alternate Language from drop down menu in
	 * Consumer Details Page
	 *
	 * @param alternateLanguage in String format
	 * @return This will return the Object of WorkItemsScreen class
	 */
	public DetailsPage selectAlternateLanguage(String alternateLanguage) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectAlternateLanguage, alternateLanguage);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected Alternate Language '" + alternateLanguage + "'from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting alternate Language from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Age Range from drop down menu in Consumer
	 * Details Page
	 *
	 * @param ageRange in String format
	 * @return This will return the Object of WorkItemsScreen class
	 */
	public DetailsPage selectAgeRange(String ageRange) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectAgeRange, ageRange);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected Age Range '" + ageRange + "' from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting age Range from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Gender from drop down menu in Consumer Details
	 * Page
	 *
	 * @param gender in String format
	 * @return This will return the Object of WorkItemsScreen class
	 */
	public DetailsPage selectGender(String gender) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectGender, gender);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected gender '" + gender + "'from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting gender from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Ethnicity from drop down menu in Consumer
	 * Details Page
	 *
	 * @param ethnicity in String format
	 * @return This will return the Object of WorkItemsScreen class
	 */
	public DetailsPage selectEthnicity(String ethnicity) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectEthnicity, ethnicity);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected ethnicity '" + ethnicity + "' from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting ethnicity from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	

	/**
	 * This method is used to click on Next button in Consumer Details Page
	 *
	 * @return This will return the Object of ConsumerDetails class
	 */
	public LocationInformation clickOnNextButton() {
		this.wait(5);
		jsUtil.scrollPageDown();
		eleUtil.waitForElementPresence(this.nextButton, 5);
		eleUtil.waitForElementToBeClickable(this.nextButton, 10);
		eleUtil.doClick(this.nextButton);
		return new LocationInformation(driver);
	}
}