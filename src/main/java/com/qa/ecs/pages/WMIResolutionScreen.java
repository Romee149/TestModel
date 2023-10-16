package com.qa.ecs.pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class WMIResolutionScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	private By finalResolutionDropdown = By.xpath("//select[contains(@id,'TransactionDispositionReason')]");
	private By standardActionsOption = By.xpath("//span[text()='Standard Actions']");
	private By saveOption = By.xpath("//a[text()=' Save']");
	private By claimClosureNotificationPopupOKButton = By.xpath("//input[@name='btnOk']");
	private By frame = By.id("ContentPlaceHolder1_iPage");
	private By workFlowActions = By.xpath("//span[@class='ui-button-text' and text()='Workflow Actions']");
	private Function<String, By> workFlowActionsOption = (workFlowActionsOption) -> 
	By.xpath("//*[contains(text(),'"+workFlowActionsOption+"')]");

	public WMIResolutionScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		eleUtil.switchToDefaultContent();
		eleUtil.switchToFrame(this.frame);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of WMIResolutionScreen class
	 */
	public WMIResolutionScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
		
	/**
	 * This method is used to select value from Final Resolution drop down
	 * 
	 * @param selectType in String format
	 * @return This will return the Object of WMIResolutionScreen class
	 */
	public WMIResolutionScreen selectFinalResolution(String finalResolution) {
		eleUtil.waitForElementPresence(this.finalResolutionDropdown, 20);
		eleUtil.doDropDownSelectByVisibleText(this.finalResolutionDropdown,finalResolution);
		return this;
	}

	/**
	 * This method is used to select value from Final Resolution drop down
	 * 
	 * @param selectType in String format
	 * @return This will return the Object of WMIResolutionScreen class
	 */
	public CustomerDetail clickOkButtonOnClaimClosureNotificationPopup() {
		eleUtil.waitForElementPresence(this.claimClosureNotificationPopupOKButton, 20);
		eleUtil.doClick(this.claimClosureNotificationPopupOKButton);
		wait(5);
		eleUtil.switchToWindow(0);
		return new CustomerDetail(driver);
	}
	
	
	
	
	/**
	 * This method is used to MouseHover to WorkFlowActions and then click on First Approval Complete option
	 * 
	 * @param nothing
	 * @return This will return the Object of FundsTransferInternal class
	 */
	public WMIResolutionScreen moveToStandardActionsAndClickOnSaveOption() {
		try {
			eleUtil.waitForElementPresence(this.standardActionsOption, 20);
			eleUtil.moveToElementAndClick(this.standardActionsOption, this.saveOption);
			wait(5);
			eleUtil.switchToDefaultContent();
			eleUtil.switchToWindow(0);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"MouseHover to WorkFlowActions and then click on First Approval Complete option is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting First Approval Complete option");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to MouseHover to WorkFlowActions and then click on First Approval Complete option
	 * 
	 * @param nothing
	 * @return This will return the Object of FundsTransferInternal class
	 */
	public WMIResolutionScreen selectWorkFlowActionsOption(String workFlowActionOption) {
		try {
			eleUtil.waitForElementPresence(this.workFlowActions, 20);
			eleUtil.waitForElementVisibility(this.workFlowActions, 20);
			wait(5);
			eleUtil.moveToElementAndClick(this.workFlowActions, this.workFlowActionsOption.apply(workFlowActionOption));
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"MouseHover to WorkFlowActions and then click on First Approval Complete option is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting First Approval Complete option");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	
}
	

