package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;

import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class EducationAndOccupationDetails {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private JavaScriptUtil jsUtil;
	private By nextButton = By.xpath("//input[contains(@class,'Next')]");

	public EducationAndOccupationDetails(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);

	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of EducationAndOccupationDetails class
	 * 
	 */
	public EducationAndOccupationDetails wait(int waitInSecond) {

		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerInformation class
	 * @return This will return the Object of CustomerRelatedParties class
	 */
	public CustomerInformation clickOnNextButton() {

		try {
			jsUtil.scrollPageDown();
			//eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.wait(5);

			eleUtil.doClick(this.nextButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on BasicInformation page is successful");

		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on BasicInformation page");

			Assert.fail(e.getMessage());
		}
		return new CustomerInformation(driver);

	}
}