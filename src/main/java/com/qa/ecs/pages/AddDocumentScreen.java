package com.qa.ecs.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AddDocumentScreen {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private CommonUtil commonUtil;
	private int timeout = 40;
	
	private Function<String, By> selectFromDropDown = (selectType)-> By.xpath("//div//label[text()='"+selectType+"']/parent::div//select[contains(@id,'Customer_Doc')]");
	private By inputNoteFieldText = By.xpath("//div//*[contains(@class, 'DocDescription')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	
	private By fileUploadLink = By.xpath("//*[local-name()='svg' and contains(@class,'icon-upload')]");
	
	private By editIconInDocWindow = By.xpath("//*[local-name()='svg' and contains(@class,'icon-edit')]");
	private By selectDocumentType = By.xpath("//div//label[text()='Document Type']/parent::div//select[contains(@id,'docType')]");
	private By docClassValue = By.xpath("//span[@class='ShowRecord_Value DocuemtnClass']");
	private By docTypeValue = By.xpath("//span[@class='ShowRecord_Value DocuemtnType']");
	
	public AddDocumentScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		commonUtil = new CommonUtil();
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in Integer format
	 * @return This will return the Object of AddDocumentScreen class
	 */
	public AddDocumentScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to select Order Type from Order Type drop down
	 * 
	 * @param orderType in String format
	 * @return This will return the Object of AddDocumentScreen class
	 */
	public AddDocumentScreen selectDocumentOptions(String selectType, String value) {
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
	 * This method is used to enter text in description input Field
	 *
	 * @param text in String format
	 * @return This will return the Object of AddDocumentScreen class
	 */
	public AddDocumentScreen enterDescriptionNote(String text) {
		eleUtil.waitForElementPresence(this.inputNoteFieldText, timeout);
		eleUtil.scrollToElementByActionsClass(this.inputNoteFieldText);
		eleUtil.doSendKeys(this.inputNoteFieldText, text);
		return this;
	}
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of AddDocumentScreen class
	 */
	public AddDocumentScreen clickOnSubmitButton() {			
		eleUtil.scrollToElementByActionsClass(this.submitButton);
		eleUtil.doClick(this.submitButton);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to upload File by taking File by name from
	 * ./resources/documents
	 *
	 * @param fileName FileName which need to upload
	 * @return This will return the Object of NewDocPage class
	 * @throws AWTException 
	 */
	public AddDocumentScreen uploadFile(String fileName) throws AWTException {
		eleUtil.waitForElementPresence(this.fileUploadLink, timeout);
		eleUtil.doClick(this.fileUploadLink);
		eleUtil.uploadFile(fileName);
		return this;
	}
	
	/**
	 * This method is used to switch to window
	 *
	 * @param windowNumber in Integer format
	 * @return This will return the Object of new window
	 */
	public AddDocumentScreen switchToNewDocWindow(int windowNumber) {
		eleUtil.switchToWindow(windowNumber);
		return this;
	}
	
	/**
	 * This method is used to get Customer Detail Page
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail getCustomerDetailPage() {			
		return new CustomerDetail(driver);
	}
	
//*******New Document details Window********/

	/**
	 * This method is used to get document Type value from new doc window
	 * Page
	 *
	 * @return This will return value in String format
	 */
	public String getDocType() {
		eleUtil.waitForElementPresence(this.docTypeValue, 10);
		String value = eleUtil.doGetText(this.docTypeValue);
		return value;
	}
	
	
/**
 * This method is used to click on Submit Button
 *
 * @param nothing
 * @return This will return the Object of AddDocumentScreen class
 */
public AddDocumentScreen clickOnDocEditIcon() {			
	eleUtil.doClick(this.editIconInDocWindow);
	eleUtil.wait(5);
	return this;
}

/**
 * This method is used to select Document Type from drop down
 * 
 * @param value in String format
 * @return This will return the Object of AddDocumentScreen class
 */
public AddDocumentScreen selectDocumentType(String value) {
	try {
		eleUtil.waitForElementPresence(this.selectDocumentType, 20);
		eleUtil.doDropDownSelectByVisibleText(this.selectDocumentType, value);
		eleUtil.wait(2);
		ExtentReportListener.test.get().log(Status.INFO,
				"Selected option " + value + " from Dropdown is successfully");
	} catch (Throwable e) {
		ExtentReportListener.test.get().log(Status.FAIL,
				"Failed while selecting option:" + value + " from drop down menu");
		Assert.fail(e.getMessage());
	}
	return this;
}
}
