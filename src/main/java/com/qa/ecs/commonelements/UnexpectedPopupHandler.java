package com.qa.ecs.commonelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class UnexpectedPopupHandler {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private JavaScriptUtil jsUtil;

	// ****************** Locators ****************** //
	private By errorPopUp = By.xpath("//div[@class='Feedback_Message_Error']");
	private By errorPopUpMessage = By.xpath("//span[@class='Feedback_Message_Text']");
	private By closeErrorPopupIcon = By.xpath("//a[@title='Hide Message']");

	public UnexpectedPopupHandler(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	//String errorMessage = "We're sorry, there was an issue processing your request. Please try again or contact support.";
	
	public void closeUnExpectedErrorPopUp(int timeout) {
		int counter = 0;
		while (counter < timeout) {
			counter++;
			try {
				eleUtil.doClick(this.closeErrorPopupIcon);
				break;
			} catch (Exception e) {
				eleUtil.wait(1);
			}
		}
	}
	
}
