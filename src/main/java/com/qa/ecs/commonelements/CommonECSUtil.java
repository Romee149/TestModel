package com.qa.ecs.commonelements;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.function.TriFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.ElementUtil;

public class CommonECSUtil {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private Function<String, By> buttonLocator =(text) -> By.xpath("//input[@value='"+text+"']");
	private Function<String, By> panelHeadTitle = (text) ->By.xpath("//div[@class= 'Panel_header']//div[text()='"+text+"']");
	private By popupMessage = By.xpath("//span[@class='Feedback_Message_Text']");
		
	public CommonECSUtil(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of Tables class
	 */
	public CommonECSUtil wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to click on Button  
	 *
	 * 
	 * @return This will return the Object of Table class
	 */
	public CommonECSUtil clickOnButton(String text) {
		eleUtil.doClick(this.buttonLocator.apply(text));
		eleUtil.wait(4);
		return this;
	}
	
	/**
	 * This method is used to verify Panel Title is displayed  
	 *
	 * @return This will return true or false in boolean format
	 */
	public boolean isDisplayedPanelTitle(String panelTitleText) {
		eleUtil.waitForElementVisibility(this.panelHeadTitle.apply(panelTitleText), 20);
		boolean value = eleUtil.isDisplay(this.panelHeadTitle.apply(panelTitleText));
		return value;
	}
	
	/**
	 * This method is used to get pop up message after click on submit button
	 *
	 * @param nothing
	 * @return This will return the popupMessage in String format
	 */
	public String getPopUpMessage(int timeout) {
		int counter = 0;
		String popupMessage = null;
		System.out.println("Before While = "+popupMessage);
		while (counter < timeout && popupMessage == null) {
			System.out.println("Inside While counter = "+popupMessage+counter);
			counter++;
			try {
				popupMessage = eleUtil.doGetText(this.popupMessage);
				System.out.println("Inside After While counter = "+popupMessage+counter);
				eleUtil.wait(1);
			} catch (Throwable e) {
				System.out.println("In Catch = "+popupMessage+counter);
				eleUtil.wait(1);
			}
		}
		System.out.println("Finally  = "+popupMessage+counter);
		return popupMessage;
	}

}
