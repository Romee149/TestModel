package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class PostTransactionScreen {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 20;
	
	
	private By amountTextField = By.xpath("//input[contains(@id,'TranAmount')]");
	private By commentTextField = By.xpath("//input[contains(@id,'Comment')]");
	private By confirmButton = By.xpath("//input[contains(@id,'SubmitButton')]");
	private By toAccountNumberTextField = By.xpath("(//input[contains(@id,'ToAccountNumber')])[2]");
	
	
	public PostTransactionScreen(WebDriver driver) {
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
	public PostTransactionScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to set amount
	 *
	 * @param amount in String format
	 * @return This will return the Object of PostTransactionScreen class
	 */
	public PostTransactionScreen enterAmount(String amount) {
		eleUtil.doSendKeys(this.amountTextField, amount);
		return this;
	}
		
	
	/**
	 * This method is used to set to Account Number
	 *
	 * @param amount in String format
	 * @return This will return the Object of PostTransactionScreen class
	 */
	public PostTransactionScreen enterToAccountNumber(String accountNumber) {
		eleUtil.waitForElementPresence(this.toAccountNumberTextField, timeout);
		eleUtil.doSendKeys(this.toAccountNumberTextField, accountNumber);
		return this;
	}

	/**
	 * This method is used to click on Comment Textfield
	 *
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public PostTransactionScreen clickOnCommentTextfield() {
		eleUtil.doClick(this.commentTextField);
		return this;
	}
	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public PostTransactionScreen clickOnSubmitButton() {
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.waitForElementPresence(this.confirmButton, timeout);	
				if(eleUtil.isEnabled(this.confirmButton)) {
					eleUtil.doClick(this.confirmButton);
					eleUtil.wait(4);
					counter = 10;
				}else {
					counter++;
					wait(1);
				}
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.confirmButton);
			}
		}
		return this;
	}

	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public AccountDetailTabScreen clickOnConfirmButton() {
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.waitForElementPresence(this.confirmButton, timeout);	
				if(eleUtil.isEnabled(this.confirmButton)) {
					eleUtil.doClick(this.confirmButton);
					eleUtil.wait(2);
					counter = 10;
				}else {
					counter++;
					wait(1);
				}
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.confirmButton);
			}
		}
		return new AccountDetailTabScreen(driver);
	}
	
	
	
}
