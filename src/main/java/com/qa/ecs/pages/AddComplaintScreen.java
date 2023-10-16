package com.qa.ecs.pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AddComplaintScreen {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 40;
	
	private Function<String, By> selectFromDropDown = (selectType)-> By.xpath("//select[contains(@class, '"+ selectType +"')]");
	private By inputComplaintSummaryFieldText = By.xpath("//div//*[contains(@class, 'ComplaintSummaryInput')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	
	
	public AddComplaintScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of AddComplaintScreen class
	 */
	public AddComplaintScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to select Order Type from Order Type drop down
	 * 
	 * @param orderType in String format
	 * @return This will return the Object of AddComplaintScreen class
	 */
	public AddComplaintScreen selectComplaintOptions(String selectType, String value) {
		try {
			eleUtil.waitForElementPresence(this.selectFromDropDown.apply(selectType), 20);
			eleUtil.doDropDownSelectByVisibleText(this.selectFromDropDown.apply(selectType), value);
			eleUtil.wait(2);
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected Type " + selectType + " from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Type:" + selectType + " from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter text in Complaint Summary Field Text
	 *
	 * @param text in String format
	 * @return This will return the Object of AddComplaintScreen class
	 */
	public AddComplaintScreen enterTransferAmount(String text) {
		eleUtil.waitForElementPresence(this.inputComplaintSummaryFieldText, timeout);
		eleUtil.scrollToElementByActionsClass(this.inputComplaintSummaryFieldText);
		eleUtil.doSendKeys(this.inputComplaintSummaryFieldText, text);
		return this;
	}
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnSubmitButton() {			
		eleUtil.scrollToElementByActionsClass(this.submitButton);
		eleUtil.doClick(this.submitButton);
		eleUtil.wait(5);
		
		return new CustomerDetail(driver);
	}
}
