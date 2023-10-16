package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class CustomerRelatedParties {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private JavaScriptUtil jsUtil;
	//private OrganizationDueDiligence orgDueDiligence;

	// ****************** Locators ****************** //
	private By selectCustomerRelationTypeDropdown = By.xpath("//label[text()='Customer Relationship Type']/parent::div//following-sibling::div//select");
	private By selectPartyRelationTypeDropdown = By.xpath("//label[text()='Party Relationship Type']/parent::div//following-sibling::div//select");
	private By selectPartyRelationRoleDropdown = By.xpath("//label[text()='Party Relationship Role']/parent::div//following-sibling::div//select");
	private By previousButton = By.xpath("(//input[contains(@class,'PreviousButton')])[1]");
	private By nextButton = By.xpath("//input[contains(@class,'NextButton')]");
	
	public CustomerRelatedParties(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		//orgDueDiligence = new OrganizationDueDiligence(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of CustomerRelatedParties class
	 */
	public CustomerRelatedParties wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerInformation class
	 */
	public CustomerInformation clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			jsUtil.scrollPageDown();
			//eleUtil.waitForElementToBeClickable(this.nextButton, 20);
			eleUtil.wait(5);
			jsUtil.clickElementByJS(eleUtil.getElement(this.nextButton));
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on CustomerRelatedParties page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on CustomerRelatedParties page");
			Assert.fail(e.getMessage());
		}
		return new CustomerInformation(driver);
	}
	
	/**
	 * This method is used to click on previous button
	 *
	 * @param nothing
	 * @return This will return the Object of OrganizationDueDiligence class
	 */
	public DueDiligencePage clickOnPreviousButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.previousButton, 5);
			eleUtil.doClick(this.previousButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on previous button on CustomerRelatedParties page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on previous button on CustomerRelatedParties page");
			Assert.fail(e.getMessage());
		}
		return new DueDiligencePage(driver);
	}
	
}
