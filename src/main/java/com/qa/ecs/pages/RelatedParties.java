package com.qa.ecs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class RelatedParties {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private JavaScriptUtil jsUtil;

	// ****************** Locators ****************** //
	private By selectAccountOwnershipDropdown = By.xpath("//label[text()='Account Ownership']/parent::div/following-sibling::div//select");
	private By selectAccountRelationshipTypeDropdown = By.xpath("//select[contains(@class,'account-relationship')]");
	private By nextButton = By.xpath("//input[contains(@class,'next-button')]");
	private By previousButton = By.xpath("//input[contains(@class,'Button') and @value='Previous']");
	private By description = By.xpath("//input[@class='description']");
	private By addRelatedPartyLink = By.xpath("//*[text()='Additional Related Party']");
	private By selectAddAccountRelTypeDropdown = By.xpath("//div[text()='Account Relationship Type']/following-sibling::div//span//select");
	private By inputFirstNameTextField = By.xpath("//input[contains(@id,'fnSearch')]");
	private By inputLastNameTextField = By.xpath("//input[contains(@id,'lnSearch')]");
	private By searchButton = By.xpath("//input[@value='Search']");
	private By selectSearchResultDropDown = By.xpath("//div[text()='Search Results:']//select");
	private By addPartyLink = By.xpath("//a[contains(@id,'AddBtn')]");
	
	public RelatedParties(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to select account ownership from drop down menu in RelatedParties Page
	 *
	 * @param currency in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties selectAccountOwnership(String owner) {
		try {
			eleUtil.waitForElementVisibility(this.selectAccountOwnershipDropdown, 40);
			eleUtil.doDropDownSelectByVisibleText(this.selectAccountOwnershipDropdown, owner);
			eleUtil.wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected account ownership " + owner + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting account ownership " + owner + "from drop down menu");
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
	public PositionDetails clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 20);
			eleUtil.doClick(this.nextButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on RelatedParties page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on RelatedParties page");
			Assert.fail(e.getMessage());
		}
		return new PositionDetails(driver);
	}
	
	/**
	 * This method is used to click on Previous button
	 *
	 * @param nothing
	 * @return This will return the Object of AccountDetails class
	 */
	public AccountDetails clickOnPreviousButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.previousButton, 5);
			eleUtil.doClick(this.previousButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on previous button on RelatedParties page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on previous button on RelatedParties page");
			Assert.fail(e.getMessage());
		}
		return new AccountDetails(driver);
	}
	
	/**
	 * This method is used to select Account Relationship Type from drop down menu in RelatedParties Page
	 *
	 * @param currency in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties selectAccountRelationshipType(String relationshipType) {
		try {eleUtil.waitForElementVisibility(this.selectAccountRelationshipTypeDropdown, 40);
			eleUtil.doDropDownSelectByVisibleText(this.selectAccountRelationshipTypeDropdown, relationshipType);
			eleUtil.wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Account Relationship Type " + relationshipType + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Account Relationship Type " + relationshipType + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter description after select account relation type in RelatedParties Page
	 *
	 * @param text in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties enterDescription(String text) {
		eleUtil.waitForElementVisibility(this.description, 20);
		eleUtil.doSendKeys(this.description, text);
		return this;
		
	}
	
	/**
	 * This method is used to click on Previous button
	 *
	 * @param nothing
	 * @return This will return the Object of AccountDetails class
	 */
	public RelatedParties clickOnAdditionalRelatedParty() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.addRelatedPartyLink, 40);
			eleUtil.doClick(this.addRelatedPartyLink);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Additional Related Party Link on RelatedParties page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Additional Related Party on RelatedParties page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select Account Relationship Type from drop down menu 
	 * under Add related party block in RelatedParties Page
	 *
	 * @param currency in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties selectAccountRelationshipTypeForAddRelatedParty(String relationshipType) {
		try {eleUtil.waitForElementVisibility(this.selectAddAccountRelTypeDropdown, 20);
			eleUtil.doDropDownSelectByVisibleText(this.selectAddAccountRelTypeDropdown, relationshipType);
			eleUtil.wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Account Relationship Type for add related party" + relationshipType + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Account Relationship Type for add related party " + relationshipType + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter First Name for add related party after select account relation type in RelatedParties Page
	 *
	 * @param text in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties enterFirstNameForAddAccountRelatedParty(String text) {
		eleUtil.waitForElementVisibility(this.inputFirstNameTextField, 20);
		eleUtil.doSendKeys(this.inputFirstNameTextField, text);
		return this;
	}
	
	/**
	 * This method is used to enter Last Name for add related party after select account relation type in RelatedParties Page
	 *
	 * @param text in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties enterLastNameForAddAccountRelatedParty(String text) {
		eleUtil.waitForElementVisibility(this.inputLastNameTextField, 20);
		eleUtil.doSendKeys(this.inputLastNameTextField, text);
		return this;
	}
	
	/**
	 * This method is used to click on Search button
	 *
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties clickOnSearch() {
		eleUtil.waitForElementToBeClickable(this.searchButton, 20);
		eleUtil.doClick(this.searchButton);
		return this;
	}
	
	/**
	 * This method is used to select Search Result from drop down menu 
	 * under Add related party block in RelatedParties Page
	 *
	 * @param currency in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties selectSearchResultForAddRelatedParty(int index) {
		eleUtil.doSelectByDropDownOptionsListIndex(this.selectSearchResultDropDown, index);
		return this;
	}
	
	/**
	 * This method is used to click on Add Party Link
	 *
	 * @return This will return the Object of RelatedParties class
	 */
	public RelatedParties clickOnAddParty() {
		eleUtil.waitForElementToBeClickable(this.addPartyLink, 40);
		eleUtil.doClick(this.addPartyLink);
		eleUtil.wait(2);
		return this;
	}
}

