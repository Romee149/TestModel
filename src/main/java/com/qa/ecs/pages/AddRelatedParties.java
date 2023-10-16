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

public class AddRelatedParties {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;

	// ****************** Locators ****************** //
	private By selectRequestParty = By.xpath("//select[contains(@id, 'requestPartySelect')]");
	private By selectCustomerRelationshipTypeDropdown = By.xpath("//select[contains(@class, 'custRelationshipTypeInput')]");
	private By selectPartyRelationTypeDescriptionDropDown = By.xpath("//select[contains(@class, 'PartyRelTypeDescInput')]");
	private By inputFirstNameTextField = By.xpath("//input[contains(@class, 'FirstNameSearch')]");
	private By inputLastNameTextField = By.xpath("//input[contains(@class, 'LastNameSearch')]");
	private By searchButton = By.xpath("//input[contains(@id,'customerSearchBtn')]");
	private By selectSearchPartyDropDown = By.xpath("//select[contains(@class,'selectPartyDropdown')]");
	private By submitBtn = By.xpath("//input[@value='Submit']");
		
	public AddRelatedParties(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to select Request Party from drop down menu in Add and modify customer RelatedParties Page
	 *
	 * @param owner in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties selectRequestParty(int dropdownOptionListIndex) {
		try {
			eleUtil.waitForElementVisibility(this.selectRequestParty, 40);
			List<String> options = eleUtil.getAllOptionsForDropdown(this.selectRequestParty);
			String value = options.get(dropdownOptionListIndex);
			eleUtil.doDropDownSelectByVisibleText(this.selectRequestParty, value);
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Request Party " + value + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Request Party from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select Customer Relationship Type from drop down menu in RelatedParties Page
	 *
	 * @param currency in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties selectCustomerRelationshipTypeFromDropdown(String relationshipType) {
		try {
			eleUtil.waitForElementVisibility(this.selectCustomerRelationshipTypeDropdown, 40);
			eleUtil.doDropDownSelectByVisibleText(this.selectCustomerRelationshipTypeDropdown, relationshipType);
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
	 * This method is used to select Party Relation Type Description from drop down menu in Add and modify customer RelatedParties Page
	 *
	 * @param owner in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties selectPartyRelationTypeDescription(String text) {
		try {
			eleUtil.waitForElementVisibility(this.selectPartyRelationTypeDescriptionDropDown, 40);
			eleUtil.doDropDownSelectByVisibleText(this.selectPartyRelationTypeDescriptionDropDown, text);
			eleUtil.wait(4);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Party Relation Type Description " + text + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Party Relation Type Description " + text + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter First Name for add related party after select Customer relation type 
	 *
	 * @param text in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties enterFirstNameForAddCustomerRelatedParty(String text) {
		eleUtil.scrollToElementByActionsClass(this.inputFirstNameTextField);
		eleUtil.waitForElementVisibility(this.selectSearchPartyDropDown, 40);
		eleUtil.doSendKeys(this.inputFirstNameTextField, text);
		eleUtil.wait(1);
		return this;
	}
	
	/**
	 * This method is used to enter Last Name for add related party after 
	 * select Customer relation type
	 *
	 * @param text in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties enterLastNameForAddCustomerRelatedParty(String text) {
		eleUtil.scrollToElementByActionsClass(this.inputLastNameTextField);
		eleUtil.doSendKeys(this.inputLastNameTextField, text);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to click on Search button
	 *
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties clickOnSearch() {
		eleUtil.scrollToElementByActionsClass(this.searchButton);
		eleUtil.doClick(this.searchButton);
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to select Search Party from drop down menu 
	 * under Add related party block
	 *
	 * @param currency in String format
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties selectSearchParty(String relationshipType) {
		try {eleUtil.scrollToElementByActionsClass(this.selectSearchPartyDropDown);
			eleUtil.waitForElementVisibility(this.selectSearchPartyDropDown, 40);
			eleUtil.doSelectDropDownContainValue(this.selectSearchPartyDropDown, relationshipType);
			eleUtil.wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected Search Result for add related party" + relationshipType + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Search Result for add related party " + relationshipType + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on submit button
	 *
	 * @return This will return the Object of RelatedParties class
	 */
	public AddRelatedParties clickOnSubmitBtn() {
		eleUtil.waitForElementToBeClickable(this.submitBtn, 20);
		eleUtil.doClick(this.submitBtn);
		eleUtil.wait(1);
		return this;
	}
	
	public CustomerDetail getCustomerDetailPage() {
		return new CustomerDetail(driver);
	}
}

