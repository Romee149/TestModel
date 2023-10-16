package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecs.utils.ElementUtil;

public class OrganizationSearchPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	// ****************** Locators ****************** //
	private By organizationNameTextField = By.xpath("//input[contains(@id,'OrganizationName')]");
	private By searchButton = By.xpath("//input[contains(@class,'Search')]");
	
	public OrganizationSearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of OrganizationSearchPage class
	 */
	public OrganizationSearchPage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to enter OrganizationName
	 *
	 * @param orgname OrganizationName value for Search
	 * @return This will return the Object of OrganizationSearchPage class
	 */
	public OrganizationSearchPage enterOrganizationName(String orgname) {
		eleUtil.waitForElementPresence(this.organizationNameTextField, 10);
		eleUtil.doSendKeys(this.organizationNameTextField, orgname);
		return this;
	}

	
	/**
	 * This method is used to click on Search Button
	 *
	 * @return This will return the Object of OrganizationSearchPage class
	 */
	public OrganizationSearchPage clickOnSearchButton() {
		eleUtil.doClick(this.searchButton);
		wait(2);
		return this;
	}

}
