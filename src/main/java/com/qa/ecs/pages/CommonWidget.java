package com.qa.ecs.pages;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class CommonWidget {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private int timeout = 40;

	private AddOrderScreen addOrderScreen;

	private static AddHoldScreen addHoldScreen=null;
	private static AddComplaintScreen addComplaintScreen=null;
	private static PostTransactionScreen postTransactionScreen=null;
	private static AddDocumentScreen addDocumentScreen=null;
	
	private By searchIcon = By.xpath("//a[@title='Customer and Account Search']");
	private By threeLineTasksIconLink = By.xpath("//*[contains(text(),'Tasks')]//div//span");
	private By transactionCodeDropdown = By.xpath("//select[contains(@id,'TransactionCode')]");
	private Function<String, By> taskTextListLink = (taskText) -> By.xpath("//a[text()='" + taskText + "']");
	private By startDateTextField = By.xpath("//div[contains(@id,'StartDate')]//input[contains(@id,'txtInputDate') and @aria-required]");
	private By durationDropdown = By.xpath("//select[contains(@id,'holdDuration')]");
	private By submitButton = By.xpath("//input[@value='Submit']");
	private By holdAmountTextField = By.xpath("//input[contains(@id,'HoldAmount')]");
	private By avtarDropdownButton =  By.xpath("//div[@class='Header_userInfo']//div[contains(@class,'ButtonDropdown_icon')]");
	private By logoutLink =  By.xpath("//div[@class='Header_userInfo']//a[contains(@id,'logoutLink') and text()='Logout']");
	private By workFlowIcon =  By.xpath("//a[@title='Workflow']");
	private Function<String, By> customerTaskTextListLink = (taskText) -> By.xpath("//span[text()='" + taskText + "']");
	private By selectAddPartyServiceCase = By.xpath("//select[contains(@id, 'Party')]");
	private By vaultIcon =  By.xpath("//a[@title='The Vault']");
	private By enterSearchCriteriaPopUpLabel = By.xpath("//table[contains(@id,'FieldsTable')]//label[@srcfieldname]");
	private By enterSearchCriteriaPopUpCaseNumberTextfield = By.xpath("//input[@srcfieldname='Case Number']");
	private By enterSearchCriteriaHeadLabel = By.xpath("//div[@class=\"moption-modal--title\"]");
	private By statusDropdown = By.xpath("(//select[@srcfieldname='Status'])[2]");
	private By enterSearchCriteriaPopUpSearchButton = By.xpath("//input[@value='Search']");
	private BiFunction<String, Integer, By> searchResultColumnValueByRow = (columnKey, rowIndex) -> By.xpath("(//span[@key='"+columnKey+"'])["+rowIndex+"]");
	
	public CommonWidget(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		addOrderScreen =  new AddOrderScreen(driver);
		addComplaintScreen =  new AddComplaintScreen(driver);
		addDocumentScreen =  new AddDocumentScreen(driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public CommonWidget wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	
	/**
	 * This method is used to click on Avatar dropdown button
	 *
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget clickOnAvatarDropdown() {
		eleUtil.doClick(this.avtarDropdownButton);
		return this;
	}
	
	
	/**
	 * This method is used to click on Logout link
	 *
	 * @param nothing
	 * @return This will return the Object of LoginPage class
	 */
	public LoginPage clickOnLogoutLink() {
		eleUtil.waitForElementPresence(this.logoutLink, timeout);
		eleUtil.doClick(this.logoutLink);
		return new LoginPage(driver);
	}
	
	
	/**
	 * This method is used to click on Logout link
	 *
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public LoginPage logout() {
		this.clickOnAvatarDropdown();
		return this.clickOnLogoutLink();		
	}
	
	/**
	 * This method is used to click on WorkFlow Icon
	 *
	 * @param nothing
	 * @return This will return the Object of WorkFlow class
	 */
	public WorkflowPage clickOnWorkflowIcon() {
		eleUtil.waitForElementPresence(this.workFlowIcon, timeout);
		eleUtil.doClick(this.workFlowIcon);
		return new WorkflowPage(driver);
	}

	/**
	 * This method is used to click three Line Tasks Icon Link in CommonWidgets page
	 * 
	 * @param none
	 * @return This will return the Object of CustomerDetail class
	 */
	public CommonWidget clickOnThreeLineTasksIconLink() {
		eleUtil.waitForElementPresence(this.threeLineTasksIconLink, timeout);
		eleUtil.doClick(this.threeLineTasksIconLink);
		eleUtil.wait(5);
		return this;
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnSearchIcon() {
		eleUtil.doClick(searchIcon);
		return new CustomerSearchPage(driver);
	}

	/**
	 * This method is used to select transaction code from drop down menu in Account
	 * Details Page
	 *
	 * @param transactionCode in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget selectTransactionCode(String transactionCode) {
		try {
			eleUtil.doDropDownSelectByVisibleText(this.transactionCodeDropdown, transactionCode);
			ExtentReportListener.test.get().log(Status.INFO,
					"Selected transaction code " + transactionCode + " from Dropdown is successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting transaction code from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}

	
	/**
	 * This method is used to select transaction code from drop down menu in Account
	 * Details Page
	 *
	 * @param transactionCode in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget selectTransactionCode(String transactionCode, int waitInSecond) {
		int counter = 0;
		while (counter < waitInSecond) {
			try {
				return this.clickOnTaskLinkText(transactionCode);
			} catch (Throwable t) {
				counter++;
				wait(1);
			}
		}
		return this.clickOnTaskLinkText(transactionCode);
	}

	/**
	 * This method is used to verify task text is displayed under Customer Task list
	 * in CustomerDetail page
	 *
	 * @param taskText in String format
	 * @return This will return true or false in boolean format
	 */
	public boolean isDisplayedTaskList(String taskText) {
		boolean value = eleUtil.isDisplay(this.taskTextListLink.apply(taskText));
		return value;
	}
	
	/**
	 * This method is used to click on task list text under Account Task Link
	 * list in AccountDetail page
	 * 
	 * @param taskText in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget clickOnTaskLinkText(String taskText) {
		try {
		eleUtil.waitForElementPresence(this.taskTextListLink.apply(taskText), timeout);	
		eleUtil.waitForElementVisibility(this.taskTextListLink.apply(taskText), timeout);
		}catch(Exception e) {}
		jsUtil.scrollIntoView(this.taskTextListLink.apply(taskText));
		eleUtil.doClick(this.taskTextListLink.apply(taskText));
		eleUtil.wait(2);				
		return this;
	}
	
	/**
	 * This method is used to click on task list text under Customer Task Link 
	 * list in CustomerDetail page
	 * 
	 * @param taskText in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget clickOnCustomerTaskLinkText(String taskText) {
		eleUtil.waitForElementPresence(this.customerTaskTextListLink.apply(taskText), timeout);
		eleUtil.scrollToElementByActionsClass(this.customerTaskTextListLink.apply(taskText));
		eleUtil.doClick(this.customerTaskTextListLink.apply(taskText));
		eleUtil.wait(2);		
		return this;
	}
	
	/**
	 * This method is used to set start date
	 *
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget enterStartDate() {
		String startDate = new CommonUtil().getCurrentDateTime("MM/dd/yyyy hh:mm:ss a");
		eleUtil.doSendKeys(this.startDateTextField, startDate);
		return this;
	}
	
	/**
	 * This method is used to set Duration
	 *
	 * @param value in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget selectDuration(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.durationDropdown, value);
		return this;
	}
	
	/**
	 * This method is used to set hold amount
	 *
	 * @param amount in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget enterHoldAmount(String amount) {
		eleUtil.scrollToElementByActionsClass(this.holdAmountTextField);
		eleUtil.doSendKeys(this.holdAmountTextField, amount);
		return this;
	}	
	
	/**
	 * This method is used to click on Submit Button
	 *
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget clickOnSubmitButton() {			
		int counter = 0;
		while (counter < 5) {
			try {
				//eleUtil.doClick(this.submitButton);
				jsUtil.clickElementByJS(this.submitButton);
				counter = 10;
			} catch (Exception e) {
				counter++;
				jsUtil.scrollIntoView(this.submitButton);
			}
		}
		return this;
	}
	
	/**
	 * This method is used to click on Submit button after add service case
	 * 
	 * @return This will return the Object of WMIScreen class
	 */
	public WMIScreen clickOnSubmitBtn() {
		try {
			eleUtil.waitForElementPresence(this.submitButton, 20);
			int counter = 0;
			while (counter < 5) {
				try {
					eleUtil.scrollToElementByActionsClass(this.submitButton);
					eleUtil.doClick(this.submitButton);
					counter = 10;
				} catch (Exception e) {
					counter++;
					jsUtil.scrollIntoView(this.submitButton);
				}
			}
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on submit button after add service case is successful");
			wait(4);
			eleUtil.switchToWindow(1);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"Switch to WMI window is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on submit button");
			Assert.fail(e.getMessage());
		}
		return new WMIScreen(driver);}
	
	/**
	 * This method is used to select party for customer from drop down
	 *
	 * @param text in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public CommonWidget selectParty(String text) {
		try {
			eleUtil.waitForElementVisibility(this.selectAddPartyServiceCase, 40);
			eleUtil.doSelectDropDownContainValue(this.selectAddPartyServiceCase, text);
			eleUtil.wait(5);
			ExtentReportListener.test.get().log(Status.INFO, "Selected party for customer service case: " + text + " from Dropdown is successful.");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting party for customer service case: " + text +" from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to click on Vault Icon
	 *
	 * @param nothing
	 * @return This will return the Object of WorkFlow class
	 */
	public VaultPage clickOnVaultIcon() {
		eleUtil.waitForElementPresence(this.vaultIcon, timeout);
		eleUtil.doClick(this.vaultIcon);
		eleUtil.wait(5);
		return new VaultPage(driver);
	}
	
	/**
	 * This method is used to verify label in Enter Search Criteria PopUp 
	 * 
	 * @param labelName
	 * @return This will result in boolean format
	 */
	public boolean isLabelOfEnterSearchCriteriaPopupExist(String labelName) {
		boolean status=false;
		try {		
			List<String> list = eleUtil.getAllOptionsOfElement(this.enterSearchCriteriaPopUpLabel);
			status = list.contains(labelName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Search Button in Enter Search Criteria PopUp successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Search Button in Enter Search Criteria PopUp");
			Assert.fail(e.getMessage());
		}
		return status;
	}
	
	/**
	 * This method is used to select status option from status dropdown
	 *
	 * @param value in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget selectSatus(String value) {
		eleUtil.doDropDownSelectByVisibleText(this.statusDropdown, value);
		return this;
	}
	
	/**
	 * This method is used to set Duration
	 *
	 * @param value in String format
	 * @return This will return the Object of CommonWidget class
	 */
	public String getEnterSearchCriteriaHeadLabel() {
		String value = eleUtil.doGetText(this.enterSearchCriteriaHeadLabel);
		return value;
	}
	
	/**
	 * This method is used to click on Search button in Enter Search Criteria PopUp 
	 * 
	 * @param nothing
	 * @return This will return the Object of CommonWidget class
	 */
	public CommonWidget clickOnSearchButtonInEnterSearchCriteriaPopup() {
		try {
			eleUtil.waitForElementVisibility(this.enterSearchCriteriaPopUpSearchButton, timeout);
			eleUtil.doClick(this.enterSearchCriteriaPopUpSearchButton);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Search Button in Enter Search Criteria PopUp successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Search Button in Enter Search Criteria PopUp");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to get search result column value by row  
	 * 
	 * @param columnKeyValue in String format
	 * @param rowNumber in integer format
	 * 
	 * @return This will return value in String format
	 */
	public String getSeachResultColumnValueByRow(String columnKeyValue, int rowNumber) {
		String value=null;
		try {
			eleUtil.waitForElementVisibility(this.searchResultColumnValueByRow.apply(columnKeyValue, rowNumber), timeout);
			value = eleUtil.doGetText(this.searchResultColumnValueByRow.apply(columnKeyValue,rowNumber));
			ExtentReportListener.test.get().log(Status.INFO,
					"Column value for '"+columnKeyValue+"' of "+rowNumber+" is successfuly");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while getting search result column value");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	public AccountDetailTabScreen getAccountDetailTabScreen() {
		return new AccountDetailTabScreen(driver);
	}
	
	public CustomerDetail getCustomerDetailPage() {
		return new CustomerDetail(driver);
	}
	
	public AddOrderScreen getAddOrderScreen() {
		return this.addOrderScreen;
	}
	
	public WorkflowPage getWorkflowPage() {
		return new WorkflowPage(driver);
	}
	
	public AddHoldScreen getAddHoldScreen() {
		return new AddHoldScreen(driver);
	}
	
	public DisputeTransactionScreen getDisputeTransactionScreen() {
		return new DisputeTransactionScreen(driver);
	}
	
	public AddComplaintScreen getAddComplaintScreen() {
		return new AddComplaintScreen(driver);
	}
	
	public PostTransactionScreen getPostTransactionScreen() {
		return new PostTransactionScreen(driver);
	}
	
	public AddDocumentScreen getDocumentScreen() {
		return new AddDocumentScreen(driver);
	}
	
	public AddRelatedParties getAddRelatedPartiesPage() {
		return new AddRelatedParties(driver);
	}

	
	public ProfileUpdateTaxIDScreen getProfileUpdateTaxIDScreen() {	
		return new ProfileUpdateTaxIDScreen(driver);
	}
	
	
	public AddCustomerContactEventScreen getAddCustomerContactEventScreen() {	
		return new AddCustomerContactEventScreen(driver);
	}
	
	public VaultPage getVaultPage() {	
		return new VaultPage(driver);
	}

	// ****************************************************************************************//
	// ************************** End To End Navigation Methods *******************************//
	// ****************************************************************************************//

	public AccountDetailTabScreen postTransaction(String transactionCode, String amount, int timeout) {
		return this.clickOnThreeLineTasksIconLink().wait(timeout)
				.clickOnTaskLinkText("Post a Transaction")
				.wait(timeout).selectTransactionCode(transactionCode).wait(timeout).getPostTransactionScreen().enterAmount(amount).wait(timeout)
				.clickOnSubmitButton().wait(timeout).clickOnConfirmButton();
	}
	
	
	public AccountDetailTabScreen postTransaction(String transactionCode, String accountNumber,  String amount, int timeout) {
		return this.clickOnThreeLineTasksIconLink().wait(timeout).clickOnTaskLinkText("Post a Transaction")
				.wait(timeout).selectTransactionCode(transactionCode).wait(timeout).getPostTransactionScreen().enterAmount(amount).wait(timeout)
				.enterToAccountNumber(accountNumber).clickOnSubmitButton().wait(timeout).clickOnConfirmButton();
	}

	public AccountDetailTabScreen addHold(String duration, String holdAmount, int timeout) {
		return this.clickOnThreeLineTasksIconLink().wait(timeout).clickOnTaskLinkText("Add Hold").wait(timeout)
				.getAddHoldScreen().enterStartDate().selectDuration(duration).enterHoldAmount(holdAmount).clickOnSubmitButton();
	}
	
	public AccountDetailTabScreen addHold(String holdType, String startDate, String duration, String holdAmount, int timeout) {
		return this.clickOnThreeLineTasksIconLink().wait(timeout).clickOnTaskLinkText("Add Hold").wait(timeout)
				.getAddHoldScreen().selectHoldType(holdType).enterStartDate(startDate).selectDuration(duration).enterHoldAmount(holdAmount)
				.clickOnSubmitButton();
	}
	
	//****************************************************************************************//
    //************************** End To End Navigation Methods *******************************//
    //****************************************************************************************//
    
	
	public CommonWidget addOrder(String duration, String holdAmount, int timeout) {
		return this.clickOnThreeLineTasksIconLink()
			  .wait(timeout)
			  .clickOnTaskLinkText("Add Order")
			  .wait(timeout)
			  .enterStartDate()
			  .selectDuration(duration)
			  .enterHoldAmount(holdAmount)
			  .wait(2)
			  .clickOnSubmitButton();			  
	}
	
	
	
	public AccountDetailTabScreen addOrder(String orderType, String accountNumber, String positionAccountNumber, String transferAmount) {
		return this.clickOnThreeLineTasksIconLink()
			  .clickOnTaskLinkText("Add Order")
			  .getAddOrderScreen()
			  .selectOrderType(orderType)
			  .clickOnTransferToCustomerPositionCheckbox()
			  .selectAccountNumber(accountNumber)
			  .wait(5)
			  .selectPositionAccountNumber(positionAccountNumber)
			  .clickOnTransferDateSendNowCheckbox()
			  .wait(10)
			  .enterTransferAmount(transferAmount)
			  .clickOnSubmitButton()
			  .clickOnConfirmButton();			  
	}
	
	public AccountDetailTabScreen addOrder(String orderType, String routingNumber, String accTitle, String accNumber, String accType, String transferAmount) {
		return this.clickOnThreeLineTasksIconLink()
			  .clickOnTaskLinkText("Add Order")
			  .wait(5)
			  .getAddOrderScreen()
			  .selectOrderType(orderType)
			  .enterRoutingNumber(routingNumber)
			  .enterAccountTitle(accTitle)
			  .enterAccountNumber(accNumber)
			  .selectAccountType(accType)
			  .wait(2)
			  .clickOnTransferDateSendNowCheckbox()
			  .enterTransferAmount(transferAmount)
			  .clickOnSubmitButton()
			  .clickOnConfirmButton();			  
	}
	
	public AccountDetailTabScreen addOrder(String orderType, String routingNumber, String accTitle, String accNumber, String accType, String transferDate, String transferAmount) {
		return this.clickOnThreeLineTasksIconLink()
			  .clickOnTaskLinkText("Add Order")
			  .wait(5)
			  .getAddOrderScreen()
			  .selectOrderType(orderType)
			  .enterRoutingNumber(routingNumber)
			  .enterAccountTitle(accTitle)
			  .enterAccountNumber(accNumber)
			  .selectAccountType(accType)
			  .wait(2)
			  .enterTransferDate(transferDate)
			  .enterTransferAmount(transferAmount)
			  .clickOnSubmitButton()
			  .clickOnConfirmButton();			  
	}
	
	public AccountDetailTabScreen addOrderForSelectedParty(String partyName, String orderType, String routingNumber, String accTitle, String accNumber, String accType, String transferAmount) {
		return this.clickOnThreeLineTasksIconLink()
			  .clickOnTaskLinkText("Add Order")
			  .selectParty(partyName)
			  .wait(5)
			  .getAddOrderScreen()
			  .selectOrderType(orderType)
			  .enterRoutingNumber(routingNumber)
			  .enterAccountTitle(accTitle)
			  .enterAccountNumber(accNumber)
			  .selectAccountType(accType)
			  .wait(2)
			  .clickOnTransferDateSendNowCheckbox()
			  .enterTransferAmount(transferAmount)
			  .clickOnSubmitButton()
			  .clickOnConfirmButton();			  
	}
	
	public AccountDetailTabScreen addOrderForSelectedParty(String partyName, String orderType, String routingNumber, String accTitle, String accNumber, String accType, String transferDate, String transferAmount) {
		return this.clickOnThreeLineTasksIconLink()
			  .clickOnTaskLinkText("Add Order")
			  .selectParty(partyName)
			  .wait(5)
			  .getAddOrderScreen()
			  .selectOrderType(orderType)
			  .enterRoutingNumber(routingNumber)
			  .enterAccountTitle(accTitle)
			  .enterAccountNumber(accNumber)
			  .selectAccountType(accType)
			  .wait(2)
			  .enterTransferDate(transferDate)
			  .enterTransferAmount(transferAmount)
			  .clickOnSubmitButton()
			  .clickOnConfirmButton();			  
	}
	
}
