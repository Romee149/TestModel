package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ModifyVehicleDetailsScreen {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout=20;
	
	
	private By vehicleModelTextField = By.xpath("//input[contains(@class,'vehicle-model')]");
	private By submitButton = By.xpath("//input[@value='Submit']");


	public ModifyVehicleDetailsScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of ModifyVehicleDetailsScreen class
	 */
	public ModifyVehicleDetailsScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to set Model
	 *
	 * @param model in String format
	 * @return This will return the Object of ModifyVehicleDetailsScreen class
	 */
	public ModifyVehicleDetailsScreen enterModel(String model) {
		eleUtil.waitForElementPresence(this.vehicleModelTextField, timeout);
		eleUtil.doSendKeys(this.vehicleModelTextField, model);
		return this;
	}

	
	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnSubmitButton() {			
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.scrollToElementByActionsClass(this.submitButton);
				eleUtil.doClick(this.submitButton);								
				counter = 10;
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.submitButton);
			}
		}
		return new AccountDetailTabScreen(driver);
	}
	
	
	
}
