package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class CollateralTypeScreen {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 20;

	private By collateralTypeDropdown = By.xpath("//select[contains(@class,'collateraltype')]");
	private By nextButton = By.xpath("//input[contains(@id,'PositionDetailsNext4')]");
	private By collateralDescriptionTextfield = By.xpath("//input[contains(@class,'collateral-desc')]");
	private By originalValueTextfield = By.xpath("(//input[contains(@class,'original-value')])[2]");
	private By currentValueTextfield = By.xpath("//input[contains(@class,'current-value')]");
	private By modelTextfield = By.xpath("//input[contains(@class,'vehicle-model')]");
	private By colorTextfield = By.xpath("//input[contains(@class,'vehicle-color')]");
	private By vehicleTypeDropdown = By.xpath("//select[contains(@class,'vehicle-type')]");
	private By policyNumberTextfield = By.xpath("//input[contains(@class,'insurance-policy')]");
	private By policyDescriptionTextfield = By.xpath("//input[contains(@class,'insurance-desc')]");
	private By coverageAmountTextfield = By.xpath("//input[contains(@class,'coverage-amount')]");
	private By premiumAmountTextfield = By.xpath("//input[contains(@class,'premium-amount')]");
	private By insuranceCompanyTextfield = By.xpath("//input[contains(@class,'insurance-company')]");
	private By collateralAddressLink = By.xpath("//*[@class='CustomPanelExpandable_title']");
	private By addressLine1Textfield = By.xpath("//*[contains(@class,'street ')]");
	private By addressLine2Textfield = By.xpath("//*[contains(@class,'street2 ')]");
	private By cityTextfield = By.xpath("//*[contains(@class,'city')]");
	private By countryDropdown = By.xpath("//select[contains(@id,'CountryInput')]");
	private By stateOrRegionDropdown = By.xpath("//select[contains(@id,'AddressRegion')]");
	private By zipOrPostalCodeTextfield = By.xpath("//*[contains(@class,'postCode')]");

	public CollateralTypeScreen(WebDriver driver) {
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
	public CollateralTypeScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to select Collateral Type
	 *
	 * @param collateralType in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen selectCollateralType(String collateralType) {
		try {
			eleUtil.waitForElementPresence(this.collateralTypeDropdown, 10);
			eleUtil.doDropDownSelectByVisibleText(this.collateralTypeDropdown, collateralType);
			ExtentReportListener.test.get().log(Status.INFO,
					"Select Collateral Type " + collateralType + " in Collateral Type page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Collateral Type " + collateralType + " in Collateral Type page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Collateral Description
	 *
	 * @param collateralDescription in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterCollateralDescription(String collateralDescription) {
		try {
			eleUtil.waitForElementPresence(this.collateralDescriptionTextfield, 10);
			eleUtil.doSendKeys(this.collateralDescriptionTextfield, collateralDescription);
			ExtentReportListener.test.get().log(Status.INFO, "Enter Collateral Description " + collateralDescription
					+ " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering Collateral Description "
					+ collateralDescription + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Original Value
	 *
	 * @param originalValue in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterOriginalValue(String originalValue) {
		try {
			eleUtil.waitForElementPresence(this.originalValueTextfield, 10);
			eleUtil.doSendKeys(this.originalValueTextfield, originalValue);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Original Value " + originalValue + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Original Value " + originalValue + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Current Value
	 *
	 * @param currentValue in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterCurrentValue(String currentValue) {
		try {
			eleUtil.waitForElementPresence(this.currentValueTextfield, 10);
			eleUtil.doSendKeys(this.currentValueTextfield, currentValue);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Current Value " + currentValue + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Current Value " + currentValue + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Model
	 *
	 * @param model in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterModel(String model) {
		try {
			eleUtil.waitForElementPresence(this.modelTextfield, 10);
			eleUtil.doSendKeys(this.modelTextfield, model);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Model " + model + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Model " + model + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Color
	 *
	 * @param color in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterColor(String color) {
		try {
			eleUtil.waitForElementPresence(this.colorTextfield, 10);
			eleUtil.doSendKeys(this.colorTextfield, color);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Color " + color + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Color " + color + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Vehicle Type
	 *
	 * @param vehicleType in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen selectVehicleType(String vehicleType) {
		try {
			eleUtil.waitForElementPresence(this.vehicleTypeDropdown, 10);
			eleUtil.doDropDownSelectByVisibleText(this.vehicleTypeDropdown, vehicleType);
			ExtentReportListener.test.get().log(Status.INFO,
					"Select Vehicle Type " + vehicleType + " in Collateral Type page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Vehicle Type " + vehicleType + " in Collateral Type page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Policy Number
	 *
	 * @param policyNumber in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterPolicyNumber(String policyNumber) {
		try {
			eleUtil.waitForElementPresence(this.policyNumberTextfield, 10);
			eleUtil.doSendKeys(this.policyNumberTextfield, policyNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Policy Number " + policyNumber + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Policy Number " + policyNumber + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Policy Description
	 *
	 * @param policyDescription in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterPolicyDescription(String policyDescription) {
		try {
			eleUtil.waitForElementPresence(this.policyDescriptionTextfield, 10);
			eleUtil.doSendKeys(this.policyDescriptionTextfield, policyDescription);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Policy Description " + policyDescription + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while entering Policy Description "
					+ policyDescription + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Coverage Amount
	 *
	 * @param coverageAmount in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterCoverageAmount(String coverageAmount) {
		try {
			eleUtil.waitForElementPresence(this.coverageAmountTextfield, 10);
			eleUtil.doSendKeys(this.coverageAmountTextfield, coverageAmount);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Coverage Amount " + coverageAmount + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Coverage Amount " + coverageAmount + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Premium Amount
	 *
	 * @param premiumAmount in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterPremiumAmount(String premiumAmount) {
		try {
			eleUtil.waitForElementPresence(this.premiumAmountTextfield, 10);
			eleUtil.doSendKeys(this.premiumAmountTextfield, premiumAmount);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Premium Amount " + premiumAmount + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Premium Amount " + premiumAmount + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter Insurance Company
	 *
	 * @param insuranceCompany in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterInsuranceCompany(String insuranceCompany) {
		try {
			eleUtil.waitForElementPresence(this.insuranceCompanyTextfield, 10);
			eleUtil.doSendKeys(this.insuranceCompanyTextfield, insuranceCompany);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Insurance Company " + insuranceCompany + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Insurance Company " + insuranceCompany + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Collateral Address Link
	 *
	 * @param nothing
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen clickOnCollateralAddressLink() {
		try {
			eleUtil.waitForElementToBeClickable(this.collateralAddressLink, 5);
			eleUtil.doClick(this.collateralAddressLink);
			wait(3);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Collateral Address Link on Collateral Type page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Collateral Address Link on Collateral Type page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter AddressLine1
	 *
	 * @param addressLine1 in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterAddressLine1(String addressLine1) {
		try {
			eleUtil.waitForElementPresence(this.addressLine1Textfield, 10);
			eleUtil.doSendKeys(this.addressLine1Textfield, addressLine1);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter AddressLine1 " + addressLine1 + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering AddressLine1 " + addressLine1 + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter City
	 *
	 * @param city in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterCity(String city) {
		try {
			eleUtil.waitForElementPresence(this.cityTextfield, 10);
			eleUtil.doSendKeys(this.cityTextfield, city);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter City " + city + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering City " + city + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select Country
	 *
	 * @param country in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen selectCountry(String country) {
		try {
			eleUtil.waitForElementPresence(this.countryDropdown, 10);
			eleUtil.doDropDownSelectByVisibleText(this.countryDropdown, country);
			ExtentReportListener.test.get().log(Status.INFO,
					"Select Country " + country + " in Collateral Type page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting Country " + country + " in Collateral Type page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to select StateOrRegion
	 *
	 * @param stateOrRegion in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen selectStateOrRegion(String stateOrRegion) {
		try {
			eleUtil.waitForElementPresence(this.stateOrRegionDropdown, 10);
			eleUtil.doDropDownSelectByVisibleText(this.stateOrRegionDropdown, stateOrRegion);
			ExtentReportListener.test.get().log(Status.INFO,
					"Select State/Region " + stateOrRegion + " in Collateral Type page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting State/Region " + stateOrRegion + " in Collateral Type page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to enter ZipOrPostalCode
	 *
	 * @param zipOrPostalCode in String format
	 * @return This will return the Object of CollateralTypeScreen class
	 */
	public CollateralTypeScreen enterZipOrPostalCode(String zipOrPostalCode) {
		try {
			eleUtil.waitForElementPresence(this.zipOrPostalCodeTextfield, 10);
			eleUtil.doSendKeys(this.zipOrPostalCodeTextfield, zipOrPostalCode);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter ZipOrPostalCode " + zipOrPostalCode + " in Collateral Type Screen page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering ZipOrPostalCode " + zipOrPostalCode + " in Collateral Type Screen page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Next button
	 *
	 * @param nothing
	 * @return This will return the Object of ElectronicAcceptanceDocuments class
	 */
	public ElectronicAcceptanceDocuments clickOnNextButton() {
		try {
			jsUtil.scrollPageDown();
			eleUtil.waitForElementToBeClickable(this.nextButton, 5);
			eleUtil.doClick(this.nextButton);
			wait(3);
			ExtentReportListener.test.get().log(Status.INFO,
					"Click on Next button on External Lien Information page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Next button on External Lien Information page");
			Assert.fail(e.getMessage());
		}
		return new ElectronicAcceptanceDocuments(driver);
	}

}
