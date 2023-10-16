package com.qa.ecs.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;
public class CustomerInformation {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private By createButton = By.xpath("//input[contains(@id,'Customer') and contains(@class,'CreateButton')]");
	private By noButtonOnPopUp = By.xpath("//input[@value='NO']");
	private By goToCustomerProfilePageLink = By.xpath("//a[contains(@id,'CustomerProfilePage_Link')]");
	private By addDocumentsMessage = By.xpath("(//*[contains(@class,'ModalMessage')]//*[@class='modal-text'])[2]");
	
	
	
	public CustomerInformation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of CustomerDueDiligence class
	 */
	public CustomerInformation wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	/**
	 * This method is used to click on Create button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerInformation class
	 */
	public CustomerInformation clickOnCreateButton() {
		try {
			eleUtil.waitForElementPresence(this.createButton, 20);
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.createButton, 5);	
			eleUtil.doClick(this.createButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Create button on CustomerInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Create button on CustomerInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to click on No button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerInformation class
	 */
	public CustomerInformation clickOnNoButtonOnPopup() {
		try {
			eleUtil.waitForElementPresence(this.noButtonOnPopUp, 5);
			eleUtil.doClick(this.noButtonOnPopUp);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on No button in Popup on CustomerInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on No button in Popup on CustomerInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	
	
	
	/**
	 * This method is used to click on "No, please take me to customer profile page." link
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerInformation class
	 */
	public String getAddDocumentsForCustomerMessageOnPopup() {
		String value=null;
		try {	
			eleUtil.waitForElementVisibility(this.addDocumentsMessage, 5);
			value = eleUtil.doGetText(this.addDocumentsMessage);
			ExtentReportListener.test.get().log(Status.INFO,
					"Get 'Would you like to add documents for this customer?' text message in Popup on CustomerInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while getting 'Would you like to add documents for this customer?' text message in Popup on CustomerInformation page");
			Assert.fail(e.getMessage());
		}
		return value;
	}
	
	
	/**
	 * This method is used to click on "No, please take me to customer profile page." link
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerInformation class
	 */
	public CustomerDetail clickOnNoPleaseTakeMeToCustomerProfilePageLinkOnPopup() {
		try {	
			eleUtil.waitForElementPresence(this.goToCustomerProfilePageLink, 5);
			eleUtil.doClick(this.goToCustomerProfilePageLink);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on 'No, please take me to customer profile page.' link in Popup on CustomerInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on 'No, please take me to customer profile page.' link in Popup on CustomerInformation page");
			Assert.fail(e.getMessage());
		}
		return new CustomerDetail(driver);
	}
	
	
	
}