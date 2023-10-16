package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class CollateralDescriptionScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By collateralRecordDescriptionTextfield = By.xpath("//input[contains(@class,'collateral-description')]");
	private By nextButton = By.xpath("//input[contains(@id,'PositionDetailsNext2')]");

	public CollateralDescriptionScreen(WebDriver driver) {
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
	public CollateralDescriptionScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to enter Collateral Record Description
	 *
	 * @param collateralRecordDescription in String format
	 * @return This will return the Object of CollateralRecordDescription class
	 */
	public CollateralDescriptionScreen enterCollateralRecordDescription(String collateralRecordDescription) {
		try {
			eleUtil.waitForElementPresence(this.collateralRecordDescriptionTextfield, 10);
			eleUtil.doSendKeys(this.collateralRecordDescriptionTextfield, collateralRecordDescription);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Collateral Record Description " + collateralRecordDescription + " in Collateral Description page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Collateral Record Description " + collateralRecordDescription + " in Collateral Description page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of ExternalLienInformationScreen class
	 */
	public ExternalLienInformationScreen clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.doClick(this.nextButton);
			wait(3);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on Collateral Description page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on Collateral Description page");
			Assert.fail(e.getMessage());
		}
		return new ExternalLienInformationScreen(driver);
	}
	
}
