package com.qa.ecs.pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class ElectronicAcceptanceDocuments {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;

	// ****************** Locators ****************** //
	private By previousButton = By.xpath("//input[contains(@class, 'PreviousButton')]");
	//private By submitButton = By.xpath("//input[contains(@class, 'submitButton')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	private Function<Integer, By> agreementCodeTextField = (index) -> By.xpath(
			"(//span[contains(text(),'Agreement Code')]/following-sibling::input[contains(@class,'agreement-code')])["
					+ index + "]");
	private Function<Integer, By> versionTextField = (index) -> By.xpath(
			"(//span[contains(text(),'Version')]/parent::div/following-sibling::input[contains(@class,'version')])["
					+ index + "]");
	private Function<Integer, By> addAdditionalDocLink = (index) -> By.xpath(
			"(//span[contains(text(), 'Add Additional Document')])["+index +"]");
	private Function<Integer,By> selectDocTypeDropdown = (index) -> By.xpath("(//select[contains(@class,'document-type')])["+index+"]");
	private Function<String, By> locatorsForText = (text) ->By.xpath("//span[text()='"+text+"']"); 
	private By accountCreateConfirmMessage = By.xpath("//span[@class='Feedback_Message_Text']");
	private Function<Integer, By> signedByTextField = (index) -> By.xpath("(//span[contains(text(),'Signed By')]/parent::div//input)["
					+ index + "]");
	private Function<Integer, By> selectAgreementCodeAndVersionDropdown = (index) ->By.xpath("(//select[contains(@name,'AgreementCodeVersion')])["+index+"]");
	private By selectAgreementCodeVersionDropDown = By.xpath("//label[text()='Agreement code - Version']");
	
	public ElectronicAcceptanceDocuments(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of PositionDetails class
	 */
	public PositionDetails clickOnPreviousButton() {
		try {
			eleUtil.waitForElementToBeClickable(this.previousButton, 5);
			eleUtil.doClick(this.previousButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Previous button on ElectronicAcceptanceDocuments page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Previous button on ElectronicAcceptanceDocuments page");
			Assert.fail(e.getMessage());
		}
		return new PositionDetails(driver);
	}

	/**
	 * This method is used to click on submit button
	 *
	 * @param nothing
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnSubmitButton() {
		try {
			eleUtil.waitForElementVisibility(this.submitButton, 10);
			eleUtil.doClick(this.submitButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on submit button on ElectronicAcceptanceDocuments page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on submit button on ElectronicAcceptanceDocuments page");
			Assert.fail(e.getMessage());
		}
		return new CustomerDetail(driver);
	}

	/**
	 * This method is used to enter Agreement code in ElectronicAcceptanceDocuments
	 * page
	 *
	 * @param nothing
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments enterAgreementCode(String text, Integer index) {
		eleUtil.scrollToElementByActionsClass(this.agreementCodeTextField.apply(index));
		eleUtil.waitForElementVisibility(this.agreementCodeTextField.apply(index), 10);
		String val =null;
		try {
		val = eleUtil.getAttributeValue(this.agreementCodeTextField.apply(index), "value");
		}catch(StaleElementReferenceException se) {
			eleUtil.wait(6);
			val = eleUtil.getAttributeValue(this.agreementCodeTextField.apply(index), "value");
		}
		if (val.equals("") && eleUtil.isEnabled(this.agreementCodeTextField.apply(index))) {
			eleUtil.wait(1);
			eleUtil.doSendKeys(this.agreementCodeTextField.apply(index), text);
		}
		return this;
	}
	
	/**
	 * This method is used to get Count For Text in ElectronicAcceptanceDocuments
	 * page
	 *
	 * @param text in String format
	 * @return This will return the number count of visible text in ElectronicAcceptanceDocuments class
	 */
	public int getCountForText(String text) {
		int count = eleUtil.getElements(this.locatorsForText.apply(text)).size();
		return count;
	}

	/**
	 * This method is used to enter Version in ElectronicAcceptanceDocuments page
	 *
	 * @param value to enter in String format
	 * @param index in Integer format for different position
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments enterVersion(String value, Integer index) {
		eleUtil.scrollToElementByActionsClass(this.versionTextField.apply(index));
		eleUtil.waitForElementVisibility(this.versionTextField.apply(index), 10);
		String val = null;
		boolean state = false; 
		try {
			val = eleUtil.getAttributeValue(this.versionTextField.apply(index), "value");
		}catch(StaleElementReferenceException se) {
			eleUtil.wait(5);
			val = eleUtil.getAttributeValue(this.versionTextField.apply(index), "value");
		}
		
		try {
			state = eleUtil.isEnabled(this.versionTextField.apply(index));
		}catch(StaleElementReferenceException se) {
			eleUtil.wait(5);
			state = eleUtil.isEnabled(this.versionTextField.apply(index));
		}
		
		if (val.equals("") && state) {
			eleUtil.doSendKeys(this.versionTextField.apply(index), value);
			eleUtil.wait(2);
		}
		return this;
	}
	
	/**
	 * This method is used to click on add additional document link
	 *
	 * @param index number in integer format
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments clickOnAddAdditionalDocumentLink(Integer index) {
		eleUtil.waitForElementToBeClickable(this.addAdditionalDocLink.apply(index), 5);
		eleUtil.doClick(this.addAdditionalDocLink.apply(index));
		return this;
	}
	
	/**
	 * This method is used to select product type from drop down menu in Position Details Page
	 *
	 * @param productType in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public ElectronicAcceptanceDocuments selectDocumentType(String docType, Integer indexNumber) {
		try {
			eleUtil.waitForElementVisibility(this.selectDocTypeDropdown.apply(indexNumber), 10);
			eleUtil.doDropDownSelectByVisibleText(this.selectDocTypeDropdown.apply(indexNumber), docType.trim());
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected document type " + docType + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting document type " + docType + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	public String getPopUpMessage(int timeout) {
		eleUtil.waitForElementVisibility(this.submitButton, 10);
		eleUtil.doClick(this.submitButton);
		int counter = 0;
		String popupMessage = null;
		System.out.println("Before While = "+popupMessage);
		while (counter < timeout && popupMessage == null) {
			System.out.println("Inside While counter = "+popupMessage+counter);
			counter++;
			try {
				popupMessage = eleUtil.doGetText(this.accountCreateConfirmMessage);
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
	
	
	public CustomerDetail getCustomerDetails() {
		return new CustomerDetail(driver);
	}
	
	public CollateralDescriptionScreen getCollateralDescriptionScreen() {
		return new CollateralDescriptionScreen(driver);
	}
	
	/**
	 * This method is used to enter Agreement code in ElectronicAcceptanceDocuments
	 * page
	 *
	 * @param nothing
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments enterSignedByCode(String text, Integer index) {
		eleUtil.scrollToElementByActionsClass(this.signedByTextField.apply(index));
		eleUtil.waitForElementVisibility(this.signedByTextField.apply(index), 10);
		String val =null;
		try {
		val = eleUtil.getAttributeValue(this.signedByTextField.apply(index), "value");
		}catch(StaleElementReferenceException se) {
			eleUtil.wait(6);
			val = eleUtil.getAttributeValue(this.signedByTextField.apply(index), "value");
		}
		if (val.equals("") && eleUtil.isEnabled(this.signedByTextField.apply(index))) {
			eleUtil.wait(1);
			eleUtil.doSendKeys(this.signedByTextField.apply(index), text);
		}
		return this;
	}
	
	/**
	 * This method is used to select product type from drop down menu in Position Details Page
	 *
	 * @param productType in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public ElectronicAcceptanceDocuments selectAgreementCodePlusVersionType(String value, int index) {
		try {
			eleUtil.waitForElementVisibility(this.selectAgreementCodeAndVersionDropdown.apply(index), 10);
			eleUtil.doDropDownSelectByVisibleText(this.selectAgreementCodeAndVersionDropdown.apply(index), value);
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected AgreementCodePlusVersion type " + value + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting AgreementCodePlusVersion type " + value + "from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to select product type from drop down menu in Position Details Page
	 *
	 * @param productType in String format
	 * @return This will return the Object of PositionDetails class
	 */
	public ElectronicAcceptanceDocuments selectAgreementCodePlusVersionType(int dropdownOptionListIndex, int index) {
		try {
			eleUtil.waitForElementVisibility(this.selectAgreementCodeAndVersionDropdown.apply(index), 10);
			List<String> options = eleUtil.getAllOptionsForDropdown(this.selectAgreementCodeAndVersionDropdown.apply(index));
			String value = options.get(dropdownOptionListIndex);
			eleUtil.doDropDownSelectByVisibleText(this.selectAgreementCodeAndVersionDropdown.apply(index), value);
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Selected AgreementCodePlusVersion type " + value + "from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting AgreementCodePlusVersion type from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to get value true if Agreement Code And Version Input Text Box Exist in ElectronicAcceptanceDocuments
	 * page
	 *
	 * @param index in Integer format
	 * @return This will return value in boolean 
	 */
	public boolean isAgreementCodeAndVersionCodeInputTextBoxExist(int index) {
		if (eleUtil.isElementExist(this.agreementCodeTextField.apply(index)) && eleUtil.isElementExist(this.versionTextField.apply(index))) {
			return true;}
		else {
			return false;
			}
	}
	
	/**
	 * This method is used to get Count For select AgreementCodeVersion Drop Down in ElectronicAcceptanceDocuments
	 * page
	 *
	 * @return This will return the number count of visible AgreementCode-Version label text  in ElectronicAcceptanceDocuments class
	 */
	public int countOfSelectAgreementCodeVersionDropDown() {
		int count = eleUtil.getElements(this.selectAgreementCodeVersionDropDown).size();
		return count;		
	}
	
	/**
	 * This method is used to get value true if Select AgreementCode-Version DropDown Exist 
	 * in ElectronicAcceptanceDocuments page
	 *
	 *
	 * @return This will return value in boolean 
	 */
	public boolean isSelectAgreementCodeVersionDropDownExist() {
		if (eleUtil.isElementExist(this.selectAgreementCodeVersionDropDown)) {
			return true;}
		else {
			return false;
			}
	}
}
