package com.qa.ecs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;

/**
 * This Class is used to provide Object Repo and Actions related to Login Screen
 *
 * @author Nahian Omar Faruqe
 * @version 1.0
 * @since 2022-09-28
 */
public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    private String userName;
    private String password;
    

    // ****************** Locators ****************** //
    private By userNameTextField = By.xpath("//input[contains(@id,'Username')]");
    private By passwordTextField = By.xpath("//input[contains(@id,'Password')]");
    private By loginButton = By.xpath("//input[contains(@id,'Login')]");
        

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
        
    }
    
    public LoginPage(WebDriver driver, String userName, String password) {
    	this.userName = userName;
    	this.password = password;
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    /**
     * This method is used to enter UserName
     *
     * @param username Username value for Login
     * @return This will return the Object of LoginPage class
     */
	public LoginPage enterUserName(String username) {
		try {
			eleUtil.waitForElementPresence(this.userNameTextField, 20);
			eleUtil.doSendKeys(this.userNameTextField, username);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter UserName \'" + username + "\' in Login page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering UserName \'" + username + "\' in Login page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

    /**
     * This method is used to enter Password
     *
     * @param password Password value for Login
     * @return This will return the Object of LoginPage class
     */
	public LoginPage enterPassword(String password) {
		try {
			eleUtil.doSendKeys(this.passwordTextField, password);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter Password \'" + password + "\' in Login page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering Password \'" + password + "\' in Login page");
			Assert.fail(e.getMessage());
		}
		return this;
	}

    /**
     * This method is used to click on Login button
     *
     * @return This will return the Object of LoginPage class
     */
	public LoginPage clickLoginButton() {
		try {
			eleUtil.doClick(this.loginButton);
			ExtentReportListener.test.get().log(Status.INFO, "Click on Login button is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while clicking on Login button");
			Assert.fail(e.getMessage());
		}
		return this;
	}

    /**
     * This method is used to enter the credentials on Login Page
     *
     * @param userName Username value for Login
     * @param password Password value for Login
     * @return This will return the Object of CustomerSearchPage class
     */
    public CustomerSearchPage doLogin() {     	
        return this.doLogin(this.userName,this.password);
    }


    /**
     * This method is used to enter the credentials on Login Page
     *
     * @param userName Username value for Login
     * @param password Password value for Login
     * @return This will return the Object of CustomerSearchPage class
     */
    public CustomerSearchPage doLogin(String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickLoginButton();
        return new CustomerSearchPage(this.driver);
    }
    
    
    
    
    
    //****************************************************************************************//
    //************************** End To End Navigation Methods *******************************//
    //****************************************************************************************//
    
    public CustomerDetail loginAndNavigateToConsumerDetails(String consumerFirstName, String consumerLastName) {
      return this.doLogin()
			.enterSearchTextForSearch("FirstName",consumerFirstName)
			.enterSearchTextForSearch("LastName",consumerLastName)
			.clickOnSearchButton().clickOnValueFromSearchResultTable("Last Name", "1");
    }

    
    public AccountDetailTabScreen loginAndNavigateToConsumerAccountDetails(String consumerFirstName, String consumerLastName, String accountNumber) {
       return this.loginAndNavigateToConsumerDetails(consumerFirstName, consumerLastName).clickOnText(accountNumber);
    }
    
}

