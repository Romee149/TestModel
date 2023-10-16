package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class BasicInformation {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private CommonUtil commonUtil;
	private JavaScriptUtil jsUtil;

	// ********************* Consumer Related Locators ********************//
	private By prefixTextField = By.xpath("//input[contains(@id,'Prefix')]");
	private By firstNameTextField = By.xpath("//input[contains(@id,'FirstName')]");
	private By middleNameTextField = By.xpath("//input[contains(@id,'MiddleName')]");
	private By lastNameTextField = By.xpath("//input[contains(@id,'LastName')]");
	private By suffixTextField = By.xpath("//input[contains(@id,'Suffix')]");
	private By dateOfBirthTextField = By.xpath("//input[contains(@id,'BirthDate')]");
	private By tinTypeDropdown = By.xpath("//select[contains(@id,'TinTypPerson')]");
	private By taxIDTextField = By.xpath("//input[contains(@id,'TaxId')]");
	private By countriesOfCitizenshipDropdown = By.xpath("//select[contains(@id,'countryCitizen')]");
	private By addLink = By.xpath("//span[text()='Add']");
	private By countryOfResidencyDropdown = By.xpath("//select[contains(@id,'CountryResidence')]");
	private By residencyStatusDropdown = By.xpath("//select[contains(@id,'ResidencyStatus')]");
	private By bankEmployeeStatusDropdown = By.xpath("//select[contains(@id,'EmployeeStatus')]");

	// ********************* Organization related Locators ********************//
	private By organizationNameTextField = By.xpath("//input[contains(@id, 'wtOrganizationName')]");
	private By dbaName = By.xpath("//input[contains(@id, 'wtDBAName')]");
	private By establishedDateTextField = By.xpath("//input[contains(@id, 'wtEstDate')]");
	private By selectTaxIdTypeDropdown = By.xpath("//select[contains(@id, 'wttinType')]");
	private By taxIdTextField = By.xpath("//input[contains(@id, 'wtOrgTaxId')]");
	private By cancelButton = By.xpath("//input[contains(@class,'CancelBtn')]");

	// ********************* Common Locators for Organization and Consumer ********************//
	private By nextButton = By.xpath("//input[contains(@id,'FirstNextButton')]");

	public BasicInformation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		commonUtil = new CommonUtil();
		jsUtil = new JavaScriptUtil(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	// ********************* Function related to Consumer ********************//

	/**
	 * This method is used to enter Prefix
	 *
	 * @param prefix Prefix value
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterPrefix(String prefix) {
		try {
			eleUtil.doSendKeys(this.prefixTextField, prefix);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Prefix \'" + prefix + "\' in BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Prefix \'" + prefix + "\' in BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter FirstName
	 *
	 * @param firstName FirstName value
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterFirstName(String firstName) {
		try {
			eleUtil.doSendKeys(this.firstNameTextField, firstName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Entering FirstName \'"+firstName+"\' on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering FirstName \'"+firstName+"\' on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter MiddleName
	 *
	 * @param middleName MiddleName value
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterMiddleName(String middleName) {
		try {
			eleUtil.doSendKeys(this.middleNameTextField, middleName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Entering MiddleName on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering MiddleName on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter LastName
	 *
	 * @param lastName LastName value
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterLastName(String lastName) {
		try {
			eleUtil.doSendKeys(this.lastNameTextField, lastName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Entering LastName \'"+lastName+"\'  on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering LastName \'"+lastName+"\' on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Suffix
	 *
	 * @param suffix Suffix value
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterSuffix(String suffix) {
		try {
			eleUtil.doSendKeys(this.suffixTextField, suffix);
			ExtentReportListener.test.get().log(Status.INFO, "Entering Suffix on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering Suffix on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter DateOfBirth
	 *
	 * @param dateOfBirth DateOfBirth value
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterDateOfBirth(String dateOfBirth) {
		try {
			dateOfBirth = dateOfBirth.split("-")[1]+dateOfBirth.split("-")[2]+dateOfBirth.split("-")[0];
			eleUtil.sendNumericKeysByKeypad(this.dateOfBirthTextField, dateOfBirth.replace("/", ""));
			ExtentReportListener.test.get().log(Status.INFO,
					"Entering DateOfBirth \'" + dateOfBirth + "\' on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering DateOfBirth \'" + dateOfBirth + "\'on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter taxID
	 *
	 *
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation enterTaxID(String taxID) {
		try {
			eleUtil.sendNumericKeysByKeypad(this.taxIDTextField, taxID);
			ExtentReportListener.test.get().log(Status.INFO, "Entering TaxID \'"+taxID+"\' on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering TaxID \'"+taxID+"\' on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Residency Status from dropdown
	 *
	 *
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation selectResidencyStatus(String residencyStatus) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.residencyStatusDropdown, residencyStatus);
			ExtentReportListener.test.get().log(Status.INFO, "Select \'" + residencyStatus
					+ "\' from Residency Status dropdown on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting \'" + residencyStatus
					+ "\' from Residency Status dropdown on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Add Link
	 *
	 * @param nothing
	 * @return This will return the Object of BasicInformation class
	 */
	public BasicInformation clickOnAddLink() {
		try {
			eleUtil.scrollToElementByActionsClass(this.nextButton);
			eleUtil.doClick(this.addLink);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Add Link on BasicInformation page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Add Link on BasicInformation page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	// ********************* Function related to Organization ********************//

	/**
	 * This method is used to enter organization name
	 *
	 * @param name organization name value in String format
	 * @return This will return the Object of BasicOrganizationInformation class
	 */
	public BasicInformation enterOrganizationName(String name) {
		try {
			eleUtil.waitForElementPresence(this.organizationNameTextField, 10);
			eleUtil.doSendKeys(this.organizationNameTextField, name);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter organization name \'" + name + "\' in Basic Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering organization name \'" + name + "\' in Basic Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter TaxId
	 *
	 * @param taxId value in String format
	 * @return This will return the Object of BasicOrganizationInformation class
	 */
	public BasicInformation enterTaxId(String taxId) {
		try {
			boolean flag = true;
			int counter = 0;
			while (flag && counter < 15) {
				try {
					counter++;
					eleUtil.sendNumericKeysByKeypad(this.taxIdTextField, taxId);
					flag = false;
				} catch (StaleElementReferenceException se) {
					this.wait(1);
				}
			}
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter TaxId \'" + taxId + "\' in Basic Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering TaxId \'" + taxId + "\' in Basic Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Tax Id Type from drop down menu in
	 * BasicOrganizationInformation page
	 *
	 * @param taxIdType in String format
	 * @return This will return the Object of BasicOrganizationInformation class
	 */
	public BasicInformation selectTaxIdType(String taxIdType) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.selectTaxIdTypeDropdown, taxIdType);
			eleUtil.switchToDefaultContent();
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected "+taxIdType+" taxIdType from Dropdown in Basic Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting "+taxIdType+" taxIdType from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of ConsumerDetails class
	 */
	public BasicInformation clickOnDBANameTextfield() {
		try {
			eleUtil.doClick(this.dbaName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on DBA Name textfield on Basic Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on DBA Name textfield on Basic Information page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	// ********************* Function Common to Consumer and Organization ********************//

	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.doClick(this.nextButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on Basic Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on Basic Information page");
			Assert.fail(e.getMessage());
		}
		return new DetailsPage(driver);
	}

	// ********************* Function related to EndToEnd Flow ********************//

	/**
	 * This method is used to fill all Mandatory Fields on Basic Information Page
	 *
	 * @param createConsumerData CreateConsumer
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage enterDataOnBasicInformationPage(com.qa.ecs.pojo.request.CreateConsumer createConsumerData) {

		if (createConsumerData.getPartyPerson().getFirstName() != null)
			this.enterFirstName(createConsumerData.getPartyPerson().getFirstName());

		if (createConsumerData.getPartyPerson().getLastName() != null)
			this.enterLastName(createConsumerData.getPartyPerson().getLastName());

		if (createConsumerData.getPartyPerson().getBirthDate() != null)
			this.enterDateOfBirth(createConsumerData.getPartyPerson().getBirthDate());

		if (createConsumerData.getPartyPerson().getTin() != null)
			this.enterTaxID(createConsumerData.getPartyPerson().getTin());

		this.clickOnAddLink();

		return this.clickOnNextButton();

	}

	/**
	 * This method is used to fill all Mandatory Fields on Basic Information Page
	 *
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param taxID
	 * @return This will return the Object of ConsumerDetails class
	 */
	public DetailsPage enterDataOnBasicInformationPage(com.qa.ecs.pojo.request.CreateOrganization createOrgData) {

		if (createOrgData.getPartyOrg().getName() != null)
			this.enterOrganizationName(createOrgData.getPartyOrg().getName());

		this.selectTaxIdType("SSN");

		if (createOrgData.getPartyOrg().getTin() != null)
			this.enterTaxId(createOrgData.getPartyOrg().getTin());

		this.clickOnDBANameTextfield();

		return this.clickOnNextButton();
	}

}
