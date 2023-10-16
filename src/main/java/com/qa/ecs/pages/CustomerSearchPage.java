package com.qa.ecs.pages;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.commonelements.CommonECSUtil;
import com.qa.ecs.commonelements.Tables;
import com.qa.ecs.commonelements.UnexpectedPopupHandler;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;

/**
 * This Class is used to provide Object Repo and Actions related to Login Screen
 *
 * @author Nahian Omar Faruqe
 * @version 1.0
 * @since 2022-09-28
 */
public class CustomerSearchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private Tables tables;	
	private CommonWidget commonWidget;
	private CommonECSUtil commonECSUtil;

	// ****************** Locators ****************** //
	private By firstNameTextField = By.xpath("//input[contains(@id,'FirstName')]");
	private By searchButton = By.xpath("//input[contains(@class,'Search')]");
	private By searchMessageText = By.xpath("//span[@class='searchMessage']");
	private By taskButton = By.xpath("//a[contains(@id,'TasksButton')]");
	private By addNewConsumerLink = By.xpath("//a[@taskkey='Add New Consumer']");
	private By addNewOrganizationLink = By.xpath("//a[@taskkey='Add New Organization']");
	private By searchResultTable = By.xpath("//table[contains(@class,'TableRecords')]");
	private BiFunction<String, String, By> searchResultTableData = (rowIndex,columnIndex) -> By
            .xpath("//table[contains(@class,'TableRecords')]//tr["+rowIndex+"]//td["+columnIndex+"]");
	private By consumerSearch = By.xpath("//*[text()='Search Consumer']/following-sibling::div//span");
	private By accountNumberTextField = By.xpath("//input[contains(@class,'accountNumber')]");
	private Function<String,By> consumerSearchOption = option-> By.xpath("//a[text()='"+option+"']");
	private By organizationNameTextField = By.xpath("//input[contains(@id,'OrganizationName')]");
	private Function<String,By> inputSearchTextField = searchField-> By.xpath("//input[contains(@class,'"+searchField+"')]");
	private Function<String,By> searchTypeDownArrow = (searchType) ->By.xpath("//*[text()='"+searchType+"']/following-sibling::div//span");	
	private By bankingGroupDropdown = By.xpath("//select[contains(@id,'AdvancedSearchModal')]");
	
	
	public CustomerSearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		tables = new Tables(this.driver);
		commonWidget =  new CommonWidget(driver);
		commonECSUtil = new CommonECSUtil(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to enter FirstName
	 *
	 * @param firstName FirstName value for Search
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage enterFirstName(String firstName) {
		try {
			eleUtil.waitForElementVisibility(this.firstNameTextField, 10);
			eleUtil.doSendKeys(this.firstNameTextField, firstName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Enter \'" + firstName + "\' in Search Panel is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while entering \'" + firstName + "\' in Search Panel");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Search Button
	 *
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnSearchButton() {
		try {
			eleUtil.waitForElementToBeClickable(this.searchButton, 20);
			eleUtil.doClick(this.searchButton);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO, "Clicked on Search button in Search Panel is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while clicking on Search button in Search Panel");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Search Button
	 *
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public AccountDetailTabScreen clickOnAccountSearchButton() {
		eleUtil.doClick(this.searchButton);
		wait(5);
		return new AccountDetailTabScreen(driver);
	}

	/**
	 * This method is used to get the SearchResult Message
	 *
	 * @return This will return the text in String format
	 */
	public String getSearchMessage() {
		String searchMessage = null;
		try {
			eleUtil.waitForElementPresence(this.searchMessageText, 5);
			searchMessage = eleUtil.doGetText(this.searchMessageText);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching the Search message " + searchMessage + " successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while Fetching the Search message");
			Assert.fail(e.getMessage());
		}
		return searchMessage;
	}
	
	
	/**
	 * This method is used to get the SearchResult Message
	 *
	 * @return This will return the text in String format
	 */
	public CustomerSearchPage selectBankingGroup(String bankingGroup) {		
		try {
			eleUtil.waitForElementPresence(this.bankingGroupDropdown, 5);
			eleUtil.doDropDownSelectByVisibleText(this.bankingGroupDropdown, bankingGroup);
			ExtentReportListener.test.get().log(Status.INFO,
					"Selecting Banking Group successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while selecting Banking Group");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on task button
	 *
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnTaskButton() {
		try {
			eleUtil.doClick(this.taskButton);
			ExtentReportListener.test.get().log(Status.INFO, "Click on Task button is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while clicking on Task button");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	/**
	 * This method is used to click on Add New Consumer Link
	 *
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public BasicInformation clickOnAddNewConsumerLink() {
		eleUtil.waitForElementToBeClickable(this.addNewConsumerLink, 20);
		eleUtil.doClick(this.addNewConsumerLink);
		return new BasicInformation(driver);
	}
	
	
	/**
	 * This method is used to click on Add New Organization Link
	 *
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public BasicInformation clickOnAddNewOrganizationLink() {
		eleUtil.waitForElementToBeClickable(this.addNewOrganizationLink, 20);
		eleUtil.doClick(this.addNewOrganizationLink);
		return new BasicInformation(driver);
	}
	
	/**
	 * This method is used to get value from Search Result Table
	 *
	 * @return This will return value in String format
	 */
	public String getValueFromSearchResultTable(String columnHeaderName, String rowIndex) {
        eleUtil.waitForElementPresence(this.searchResultTable, 10);
		WebElement table = eleUtil.getElement(this.searchResultTable);
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table,"th"));
		
        int columnIndex=0;
        for(int i =0 ; i<columns.size();i++) {
        	if(columnHeaderName.equalsIgnoreCase(columns.get(i)))
        		columnIndex=i+1;
        }
        
        String value = eleUtil.doGetText(this.searchResultTableData.apply(rowIndex,String.valueOf(columnIndex)));
        
        return value;

    }
	
	/**
	 * This method is used to click on Consumer Search down arrow
	 *
	 * @param searchOption in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnConsumerSearch() {
		try {
			eleUtil.waitForElementVisibility(this.consumerSearch, 20);
			eleUtil.doClick(this.consumerSearch);
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Click on Consumer Search Icon is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while clicking on Consumer Search Icon");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to elect Consumer Search Option(Options are Consumer, Account, Organization, Position Id)
	 *  from drop down menu in Dash board after log in
	 *
	 * @param searchOption in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnSearchTypeDownArrow(String searchType) {
		try {
			eleUtil.waitForElementVisibility(this.searchTypeDownArrow.apply(searchType), 20);
			eleUtil.doClick(this.searchTypeDownArrow.apply(searchType));
			wait(2);
			ExtentReportListener.test.get().log(Status.INFO, "Click on "+searchType+" drop down arrow is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL, "Failed while clicking on Consumer Search Icon");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Consumer Search Option(Options are Consumer, Account, Organization, Position Id)
	 *  from drop down menu in Dash board after log in
	 *
	 * @param searchOption in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnConsumerSearchOption(String searchOption) {
		eleUtil.waitForElementToBeClickable(this.consumerSearchOption.apply(searchOption), 20);
		eleUtil.doClick(this.consumerSearchOption.apply(searchOption));
		eleUtil.wait(4);
		return this;
	}
	
	
	/**
	 * This method is used to click on Organization on Consumer Search Option
	 *
	 * @param nothing
	 * @return This will return the Object of OrganizationSearchPage class
	 */
	public OrganizationSearchPage clickOnOrganizationOption() {
		eleUtil.doClick(this.consumerSearchOption.apply("Organization"));
		eleUtil.wait(1);
		return new OrganizationSearchPage(driver);
	}
	
	/**
	 * This method is used to enter AccountNumber For Search in Dash board
	 *
	 * @param accountNumber in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage enterAccountNumberForSearch(String accountNumber) {
		eleUtil.waitForElementToBeClickable(this.accountNumberTextField, 10);

		eleUtil.doSendKeys(this.accountNumberTextField, accountNumber);
		return this;
	}
	
	/**
	 * This method is used to enter AccountNumber For Search in Dash board
	 *
	 * @param accountNumber in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public String getMessageForInvalidAccountNumberForSearch() {
		String message =eleUtil.doGetText(this.searchMessageText);
		return message;
	}
	
	
	/**
	 * This method is used to enter OrganizationName
	 *
	 * @param orgname OrganizationName value for Search
	 * @return This will return the Object of OrganizationSearchPage class
	 */
	public CustomerSearchPage enterOrganizationName(String orgname) {
		eleUtil.waitForElementPresence(this.organizationNameTextField, 20);
		eleUtil.doSendKeys(this.organizationNameTextField, orgname);
		return this;
	}
	
	/**
	 * This method is used to enter search Text For Search in searchFieldName in Dash board
	 *
	 * @param accountNumber in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage enterSearchTextForSearch(String searchFieldName, String searchValue) {
		eleUtil.waitForElementPresence(this.inputSearchTextField.apply(searchFieldName),20);
		eleUtil.doSendKeys(this.inputSearchTextField.apply(searchFieldName), searchValue);
		return this;
	}
	
	/**
	 * This method is used to click on value from Search Result Table
	 *
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnValueFromSearchResultTable(String columnHeaderName, String rowIndex) {
		new UnexpectedPopupHandler(driver).closeUnExpectedErrorPopUp(5);
		eleUtil.waitForElementPresence(this.searchResultTable, 40);
		WebElement table = eleUtil.getElement(this.searchResultTable);
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table,"th"));
		
        int columnIndex=0;
        for(int i =0 ; i<columns.size();i++) {
        	if(columnHeaderName.equalsIgnoreCase(columns.get(i)))
        		columnIndex=i+1;
        }
        
        eleUtil.doClick(this.searchResultTableData.apply(rowIndex,String.valueOf(columnIndex)));
		this.wait(2);
        return new CustomerDetail(driver);
	}
	
	
	/**
	 * This method is used to enter data related to Consumer
	 *
	 * @param createConsumerData CreateConsumer
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail createConsumer(com.qa.ecs.pojo.request.CreateConsumer createConsumerData) {
		
		return this.clickOnAddNewConsumerLink()
				 .enterDataOnBasicInformationPage(createConsumerData)
				 .clickOnNextButton()				 
				 .enterDataOnLocationInformationPage(createConsumerData)
				 .enterDataOnContactInformationPage(createConsumerData)
				 .clickOnNextButton(createConsumerData)				
				 .clickOnNextButton()			
				 .clickOnCreateButton()				
				 .clickOnNoButtonOnPopup()				
				 .clickOnNoPleaseTakeMeToCustomerProfilePageLinkOnPopup();
	}
	
	
	/**
	 * This method is used to enter data related to Organization
	 *
	 * @param createOrgData CreateOrganization
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail createOrganization(com.qa.ecs.pojo.request.CreateOrganization createOrgData) {
		
		return this.clickOnAddNewOrganizationLink()
				 .enterDataOnBasicInformationPage(createOrgData)
				 .clickOnNextButton()				 
				 .enterDataOnLocationInformationPage(createOrgData)
				 .enterDataOnContactInformationPage(createOrgData)				 
				 .clickOnNextButton(createOrgData)				
				 .clickOnNextButton()			
				 .clickOnCreateButton()				
				 .clickOnNoButtonOnPopup()				
				 .clickOnNoPleaseTakeMeToCustomerProfilePageLinkOnPopup();
	}
	
	/**
	 * This method is used to check resfresh page
	 *
	 * @return This will return object of CustomerSearchPage
	 */
	public CustomerSearchPage refreshPage() {
		eleUtil.wait(1);
		driver.navigate().refresh();
		return this;
	}
	
	/**
	 * This method is used to click on Button  
	 *
	 * 
	 * @return This will return the Object of  CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnButton(String buttonText) {
		commonECSUtil.clickOnButton(buttonText);
		return this;
	}
	
	
	public CommonWidget getCommonWidget() {
		return this.commonWidget;
	}
	
}
