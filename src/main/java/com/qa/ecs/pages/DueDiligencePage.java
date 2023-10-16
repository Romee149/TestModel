package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JacksonUtils;
import com.qa.ecs.utils.JavaScriptUtil;

public class DueDiligencePage{

	private WebDriver driver;
	private ElementUtil eleUtil;

	private JavaScriptUtil jsUtil;
	
	private By selectBusinessStructure = By.xpath("//label[text()='Business Structure']/following-sibling::select");
	private By selectCountriesOfOperation = By
			.xpath("//label[text()='Countries of Operation']/following-sibling::div//div//select");
	private By selectCountryOfHeadquaters = By
			.xpath("//label[text()='Country of Headquarters']/following-sibling::select");
	private By previousButton = By.xpath("(//input[contains(@class,'PreviousButton')])[1]");
	private By nextButton = By.xpath("//input[contains(@class,'NextButton')]");
	
	public DueDiligencePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);

	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of CustomerDueDiligence class
	 * @return This will return the Object of AccountDetails class
	 */
	public DueDiligencePage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of EducationAndOccupationDetails class
	 */
	public EducationAndOccupationDetails clickOnNextButton(com.qa.ecs.pojo.request.CreateConsumer createConsumer) {	
		try {
			//jsUtil.scrollPageDown();
			//eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.wait(5);
			eleUtil.doClick(this.nextButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on CustomerDueDiligence page is successful");
					
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,		
					"Failed while clicking on Next button on CustomerDueDiligence page");
			Assert.fail(e.getMessage());
		}
		return new EducationAndOccupationDetails(driver);		
	}
	
	
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerRelatedParties class
	 */
	public CustomerRelatedParties clickOnNextButton(com.qa.ecs.pojo.request.CreateOrganization createOrgData) {
		try {
			eleUtil.waitForElementPresence(this.nextButton, 20);
			jsUtil.scrollPageDown();
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);		
			eleUtil.wait(5);
			jsUtil.clickElementByJS(eleUtil.getElement(this.nextButton));
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on OrganizationDueDiligence page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on OrganizationDueDiligence page");
			Assert.fail(e.getMessage());
		}
		return new CustomerRelatedParties(driver);
	}
	
	/**
	 * This method is used to click on previous button
	 *
	 * @param nothing
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation clickOnPreviousButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.previousButton, 5);
			eleUtil.doClick(this.previousButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on previous button on OrganizationDueDiligence Page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on previous button on OrganizationDueDiligence page");
			Assert.fail(e.getMessage());
		}
		return new ContactInformation(driver);
	}

}