package com.qa.ecs.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JacksonUtils;
import com.qa.ecs.utils.JavaScriptUtil;
public class LocationInformation {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	// ****************** Locators ****************** //
	private By taxAddressCheckbox = By.xpath("//div[contains(@class,'TaxAddress')]//input");
	private By differentMailingAddressCheckbox = By
			.xpath("//label[contains(text(),'Different Mailing')]/following-sibling::input");
	private By addressLine1TextField = By.xpath("//input[contains(@class,'addline1')]");
	private By addressLine2TextField = By.xpath("//input[contains(@class,'addline2')]");
	private By addressLine3TextField = By.xpath("//input[contains(@class,'addline3')]");
	private By addressLine4TextField = By.xpath("//input[contains(@class,'addline4')]");
	private By cityTextField = By.xpath("//input[contains(@class,'cityInput1')]");
	private By postalCodeTextField = By.xpath("//input[contains(@class,'postCodeInput')]");
	private By addressLabelTextField = By.xpath("//input[contains(@class,'addressLabel')]");
	private By verifiedDateTextField = By.xpath("//input[contains(@class,'verifiedDateInpt')]");
	private By selectCountry = By.xpath("//select[contains(@class,'cntryInput')]");
	private By selectState = By.xpath("//select[contains(@class,'regionInput')]");
	private By selectAddressType = By.xpath("//select[contains(@class,'addTypeEntryInput')]");
	private By saveButton = By.xpath("//input[contains(@class,'addressSaveBtn1')]");
	private By previousButton = By
			.xpath("//div[contains(@id,'wtbuttonsCN')]//input[contains(@class,'PreviousButton')]");
	private By nextButton = By.xpath("//input[contains(@class,'NextButton')]");
	private By linkShowMore = By.xpath(
			"//a[contains(@id,'wttoggleAddressLines') and not(contains(@id,'2'))]//span[contains(text(), 'SHOW MORE')]");
	private By linkHide = By.xpath("//span[text()= 'HIDE']");
	private By linkSetAddressValidToFromDates = By.xpath(
			"//div[contains(@id,'wtvalidAddrDT') and not(contains(@id,'2'))]//span[contains(text(), 'Set Address')]");
	private By validDateFromTextField = By.xpath("//input[contains(@class,'validFrmDateInput')]");
	private By validDateUntilTextField = By.xpath("//input[contains(@class,'validUntilDate1Inpt')]");
	private By linkClearAddressValidToFromDates = By.xpath("//span[contains(text(), 'Clear Address')]");
	public LocationInformation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public LocationInformation wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	/**
	 * This method is used to click on TaxAddress Checkbox
	 *
	 * @param nothing
	 * @return This will return the Object of LocationInformation class
	 */
	public LocationInformation clickOnTaxAddressCheckbox() {
		try {	
			eleUtil.waitForElementPresence(this.nextButton, 5);
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.doClick(this.taxAddressCheckbox);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on TaxAddress Checkbox on LocationInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on TaxAddress Checkbox on LocationInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter addressLine1
	 *
	 * @param addressLine1 addressLine1 value
	 * @return This will return the Object of LocationInformation class
	 */
	public LocationInformation enterAddressLine1(String addressLine1) {
		try {
			eleUtil.doSendKeys(this.addressLine1TextField, addressLine1);
			ExtentReportListener.test.get().log(Status.INFO,
					"Entering AddressLine1 \'"+addressLine1+"\' on LocationInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering AddressLine1 \'"+addressLine1+"\' on LocationInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	/**
	 * This method is used to enter city
	 *
	 * @param city city value
	 * @return This will return the Object of LocationInformation class
	 */
	public LocationInformation enterCity(String city) {
		try {
			eleUtil.doSendKeys(this.cityTextField, city);
			ExtentReportListener.test.get().log(Status.INFO, "Entering City \'"+city+"\' on LocationInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering City \'"+city+"\' on LocationInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to enter postalCode
	 *
	 * @param postalCode postalCode value
	 * @return This will return the Object of LocationInformation class
	 */
	public LocationInformation enterPostalCode(String postalCode) {
		try {
			eleUtil.doSendKeys(this.postalCodeTextField, postalCode);
			ExtentReportListener.test.get().log(Status.INFO,
					"Entering PostalCode \'"+postalCode+"\' on LocationInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering PostalCode \'"+postalCode+"\' on LocationInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	/**
	 * This method is used to click on Save button
	 *
	 * @param nothing
	 * @return This will return the Object of LocationInformation class
	 */
	public LocationInformation clickOnSaveButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.doClick(this.saveButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Save button on LocationInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Save button on LocationInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 10);
			eleUtil.doClick(this.nextButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on LocationInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on LocationInformation page");
			Assert.fail(e.getMessage());
		}
		return new ContactInformation(driver);
	}
	
	
	/**
	 * This method is used to fill all Mandatory Fields on Location Information Page
	 *
	 * @param addressLine1
	 * @param city
	 * @param postalCode
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation enterMandatoryFieldOnLocationInformationPage(String addressLine1, String city, String postalCode) {
		this.clickOnTaxAddressCheckbox();
		this.enterAddressLine1(addressLine1);
		this.enterCity(city);
		this.enterPostalCode(postalCode);
		this.clickOnSaveButton();
		eleUtil.wait(5);
		return this.clickOnNextButton();
	}
	
	
	/**
	 * This method is used to fill all Mandatory Fields on Location Information Page
	 *
	 * @param createConsumerData CreateConsumer
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation enterDataOnLocationInformationPage(com.qa.ecs.pojo.request.CreateConsumer createConsumerData) {
		
		this.clickOnTaxAddressCheckbox();
		
		if(createConsumerData.getAddresses().get(0).getStreet() != null)
			this.enterAddressLine1(createConsumerData.getAddresses().get(0).getStreet());
		
		if(createConsumerData.getAddresses().get(0).getCity() != null)
			this.enterCity(createConsumerData.getAddresses().get(0).getCity());
		
		if(createConsumerData.getAddresses().get(0).getPostCode() != null)
			this.enterPostalCode(createConsumerData.getAddresses().get(0).getPostCode());
		
		this.clickOnSaveButton();
		
		eleUtil.wait(5);
		
		return this.clickOnNextButton();
	}
	
	
	/**
	 * This method is used to fill all Mandatory Fields on Location Information Page
	 *
	 * @param createConsumerData CreateConsumer
	 * @return This will return the Object of ContactInformation class
	 */
	public ContactInformation enterDataOnLocationInformationPage(com.qa.ecs.pojo.request.CreateOrganization createOrgData) {
		
		this.clickOnTaxAddressCheckbox();
		
		if(createOrgData.getAddresses().get(0).getStreet() != null)
			this.enterAddressLine1(createOrgData.getAddresses().get(0).getStreet());
		
		if(createOrgData.getAddresses().get(0).getCity() != null)
			this.enterCity(createOrgData.getAddresses().get(0).getCity());
		
		if(createOrgData.getAddresses().get(0).getPostCode() != null)
			this.enterPostalCode(createOrgData.getAddresses().get(0).getPostCode());
		
		this.clickOnSaveButton();
		
		eleUtil.wait(5);
		
		return this.clickOnNextButton();
	}
	
}