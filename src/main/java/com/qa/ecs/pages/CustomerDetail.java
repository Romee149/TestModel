package com.qa.ecs.pages;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.function.TriFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.commonelements.CommonECSUtil;
import com.qa.ecs.commonelements.Tables;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class CustomerDetail {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private Tables tables;
	private CommonWidget commonWidget;
	private int timeout=30;
	

	// ****************** Locators ****************** //

	private By consumerNameText = By.xpath("//*[@class='profilepartyname']");
	private By accounstLink = By.xpath("//span[text()='Accounts']");
	private By plusIcon = By.xpath("//*[local-name()='svg' and contains(@class,'icon-plus-circle')]");
	private By activeTabName = By.xpath("//span[@class='Tabs_List']//div[contains(@class,'active')]/span");
	private By searchIcon = By.xpath("//*[local-name()='svg' and contains(@class,'icon-magnifier')]");
	private By accountNumber = By.xpath("(//span[@class='acctNbr'])[last()]");
	private By lastDoubleDownIcon = By.xpath("(//span[contains(@class,'double-down')])[last()]");
	private Function<Integer, By> multiPositonAccNum= (index) -> By.xpath("(//span[@class='posnAcctNbr'])["+index+"]");
	private Function<Integer, By> multiPositonProductName= (index) -> By.xpath("(//span[@class='posnName'])["+index+"]");
	private By moreLink = By.xpath("//div[contains(text(),'More')]");
	private By firstDoubleDownIcon = By.xpath("(//span[contains(@class, 'double-down')])[1]");
	private Function<String, By> overVeiwDisplayedTextLink = (displayedText) -> By.xpath("//span[text()='"+displayedText+"']");
	private Function<String, By> overVeiwDisplayedAccountNumberLink = (accountNum) -> By.xpath("//div[text()='"+accountNum+"']");
	private By selectRelationshipTypeDropdown = By.xpath("//select[contains(@class,'relType')]");
	private By organizationRadioBtn = By.xpath("//input[contains(@class,'OrganizationRadioButton')]");
	private By inputOrganizationNameTextField = By.xpath("//input[@class='OSFillParent' and @placeholder='Organization Name']");
	private By searchOrgButton = By.xpath("//input[contains(@class, 'searchOrgBtn')]");
	private By selectSearcResultDropDownForSearchOrg = By.xpath("//select[@class='OSFillParent Mandatory']");
	private Function<String, By> linkByVisibleText = (linkText) -> By.xpath("//a[text()='"+linkText+"']");
	private Function<String, By> buttonLocator =(text) -> By.xpath("//input[@value='"+text+"']");
	private Function<String, By> moreSubLink =(text) -> By.xpath("//div[@class='tooltipster-content']//*//span[text()='"+text+"']");
	private Function<String, By> textLabel =(text) -> By.xpath("//div[text()='"+text+"']");
	private Function<String, By> caseNumberColumnValue = (caseNumber) -> By.xpath("//a[@class='OpenCaseDocID' and text()='"+caseNumber+"']");
	private By contactDetailsTab = By.xpath("//span[@tabname='Contact Details']");
	private Function<String, By> tabText = (text) -> By.xpath("//span[text()='"+text+"']");
	private By feedbackMessage = By.xpath("//span[@class='Feedback_Message_Text']");
	private By inputNoteTextField = By.xpath("//*[contains(@class,'NoteTextInput')]");
	private By selectServiceCase = By.xpath("//select[contains(@id, 'Create_Case')]");
	private By addAccountPlusIcon = By.xpath("//a[@title='Add Account']//*[local-name()='svg' and contains(@class,'icon-plus-circle')]");
	private By positionText = By.xpath("//div[@class='GalleryItem']");
	private By alertMessage =  By.xpath("//div[contains(@class,'alertText')]/span");
	private By closeAlertMessageIcon = By.xpath("//span[contains(@id,'state')]");
	private By refreshLink = By.xpath("//a[@title='Refresh']");
	private Function<String, By> panelDetailEditButton = (panelDetailName) -> By.xpath("//span[text()='"+panelDetailName+"']//ancestor::*[@class='SectionExpandable_header']//*[local-name()='svg' and @class='icon icon-edit icon--small']");
	private Function<String, By> addIconForLabel = (labelName) -> By.xpath("//*[text()='"+labelName+"']//ancestor::div[@align='left' and @style]//*[local-name()='svg' and @class='icon icon-plus-circle icon--small']");
	private Function<String, By> eyeIconForLabel = (labelName) -> By.xpath("//*[text()='"+labelName+"']//ancestor::div[@align='left' and @style]//*[@class='fa fa-fw fa-eye']");
	private By activeMessageEventsTable = By.xpath("(//table[contains(@id,'messageContact')])[1]");
	private By firstAccountBox = By.xpath("(//*[@class='account-item']/div)[1]");
	
	
	
	
	public CustomerDetail(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		tables = new Tables(this.driver);
		commonWidget =  new CommonWidget(driver);
		
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public CustomerDetail wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to enter Familiar Name in textfield in Consumer Details
	 * Page
	 *
	 * @param familiarName in String format
	 * @return This will return the Object of ConsumerDetails class
	 */
	public String getConsumerName() {
		String value = null;
		try {
			eleUtil.waitForElementPresence(this.consumerNameText, 10);
			value = eleUtil.doGetText(this.consumerNameText);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Consumer Name in Customer Details page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Consumer Name in Customer Details page");
			Assert.fail(e.getMessage());
		}
		return value;
	}

	/**
	 * This method is used to click On Accounts Link in customer detail page	 
	 * 
	 * @param none
	 * @return This will return the Object of  CustomerDetail class
	 */
	public CustomerDetail clickOnAccountsLink() {
		eleUtil.waitForElementToBeClickable(this.accounstLink, 20);
		eleUtil.doClick(this.accounstLink);
		eleUtil.wait(2);
		return this;
	}
	
	
	/**
	 * This method is used to click On Accounts Link in customer detail page	 
	 * 
	 * @param none
	 * @return This will return the Object of  CustomerDetail class
	 */
	public AccountDetailTabScreen clickOnFirstAvailableAccount() {
		eleUtil.waitForElementToBeClickable(this.firstAccountBox, 20);
		eleUtil.doClick(this.firstAccountBox);
		eleUtil.wait(2);
		return new AccountDetailTabScreen(driver);
	}
	
	/**
	 * This method is used to click On plus icon in customer main page	 
	 * 
	 * @param none
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnPlusIconForAdd() {
		eleUtil.waitForElementToBeClickable(this.plusIcon, 20);
		eleUtil.doClick(this.plusIcon);
		return this;
	}
	
	/**
	 * This method is used to click On plus icon in customer main page	 
	 * 
	 * @param none
	 * @return This will return the Object of  AccountDetails class
	 */
	public AccountDetails clickOnPlusIconForAddAccount() {
		eleUtil.doClick(this.addAccountPlusIcon);
		eleUtil.wait(2);
		return new AccountDetails(driver);
	}
	
	/**
	 * This method is used to get active Tab Name on Customer Details page
	 *
	 * @param nothing
	 * @return This will return the active Tab Name in String format
	 */
	public String getActivateTabName() {
		String activeTabName = null;
		try {
			eleUtil.waitForElementPresence(this.activeTabName, 5);
			activeTabName = eleUtil.doGetText(this.activeTabName);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Active Tab Name in Customer Details page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Active Tab Name in Customer Details page");
			Assert.fail(e.getMessage());
		}
		return activeTabName;
	}


	/**
	 * This method is used to click On search magnifier icon in CustomerDetail page	 
	 * 
	 * @param none
	 * @return This will return the Object of  CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnSearchMagnifierIcon() {
		eleUtil.doClick(this.searchIcon);
		eleUtil.wait(2);
		return new CustomerSearchPage(driver);
	}
	
	/**
	 * This method is used to get account number from Customer Details page
	 *
	 * @param nothing
	 * @return This will return the  in String format
	 */
	public String getAccountNumberFromCustomerDetailPage() {
		String accountNumber = null;
		try {
			eleUtil.scrollToElementByActionsClass(this.lastDoubleDownIcon);
			eleUtil.waitForElementPresence(this.accountNumber, 10);
			accountNumber = eleUtil.doGetText(this.accountNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Account Number in Customer Details page is successful");
			return accountNumber;
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Account Number in Customer Details page");
			Assert.fail(e.getMessage());
		}
		return accountNumber;
	}
	
	/**
	 * This method is used to click On Latest created Double Down Icon icon in CustomerDetail page	 
	 * 
	 * @param none
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnLastDoubleDownIcon() {
		eleUtil.wait(2);
		jsUtil.clickElementByJS(eleUtil.getElement(this.lastDoubleDownIcon));
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to click On first Double Down Icon icon in CustomerDetail page	 
	 * 
	 * @param none
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnfirstDoubleDownIcon() {
		eleUtil.wait(2);
		jsUtil.clickElementByJS(eleUtil.getElement(this.firstDoubleDownIcon));
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to get Multi Position account number on Customer Details page
	 *
	 * @param nothing
	 * @return This will return the  in String format
	 */
	public String getMultiPositionAccountNumber(Integer positionIndex) {
		String accountNumber = null;
		try {
			eleUtil.scrollToElementByActionsClass(this.multiPositonAccNum.apply(positionIndex));
			eleUtil.waitForElementPresence(this.multiPositonAccNum.apply(positionIndex), 10);
			accountNumber = eleUtil.doGetText(this.multiPositonAccNum.apply(positionIndex));
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Multi Positon Account Number for position "+positionIndex+" in Customer Details page is successful");
			return accountNumber;
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Multi Positon Account Number for position "+positionIndex+" in Customer Details page");
			Assert.fail(e.getMessage());
		}
		return accountNumber;
	}
	
	/**
	 * This method is used to get Multi Position Product Type name on Customer Details page
	 *
	 * @param nothing
	 * @return This will return the  in String format
	 */
	public String getMultiPositionProductType(Integer positionIndex) {
		String productName = null;
		try {
			eleUtil.scrollToElementByActionsClass(this.multiPositonProductName.apply(positionIndex));
			eleUtil.waitForElementPresence(this.multiPositonProductName.apply(positionIndex), 10);
			productName = eleUtil.doGetText(this.multiPositonProductName.apply(positionIndex));
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Multi Positon Product Type Name for position "+positionIndex+" in Customer Details page is successful");
			return productName;
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Multi Positon Product Type for position "+positionIndex+" in Customer Details page");
			Assert.fail(e.getMessage());
		}
		return productName;
	}
	
	/**
	 * This method is used to click On more link in CustomerDetail page	 
	 * 
	 * @param none
	 * @return This will return the Objects of CustomerDetail class
	 */
	public CustomerDetail clickOnMoreLink() {
		eleUtil.doClick(this.moreLink);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to click value from Table
	 * 
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 *
	 * @return This will return the Objects of CustomerDetail class 
	 */
	public CustomerDetail clickOnValueFromSearchResultTable(String columnHeaderName, int rowIndex) {
		tables.clickOnValueFromSearchResultTable(columnHeaderName, rowIndex);
		return this;
	}
	
	/**
	 * This method is used to get value from Table
	 * 
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 *
	 * @return This will return value of specific rows and specific rows for Tables 
	 */
	public String getValueFromResultTable(String columnHeaderName, int rowIndex) {
		String value =tables.getValueFromSearchResultTable(columnHeaderName, rowIndex);
		return value;
	}
	
	/**
	 * This method is used to click value from Table
	 * 
	 * @param tableID in String format
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 *
	 * @return This will return the Objects of CustomerDetail class 
	 */
	public CustomerDetail clickOnValueFromTable(String tableID, String columnHeaderName, int rowIndex) {
		tables.clickOnValueInTable(tableID, columnHeaderName, rowIndex);
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to get value from Table
	 * 
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 *
	 * @return This will return value of specific rows and specific rows for Tables 
	 */
	public String getValueFromResultTable(String tableID, String columnHeaderName, int rowIndex) {
		String value=null;
		if(tableID.equals("Active Message Events"))
			value =tables.getValueFromTableByTableID(this.activeMessageEventsTable, columnHeaderName, rowIndex);
		else
			value =tables.getValueFromTableByTableID(tableID, columnHeaderName, rowIndex);
		return value;
	}
	
	/**
	 * This method is used to get value from Table
	 * 
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 *
	 * @return This will return value of specific rows and specific rows for Tables 
	 */
	public String getValueFromResultTableWithExpandableRows(String columnHeaderName, int rowIndex) {
		String value =tables.getValueFromTable("TableRecords ExpandableRows",columnHeaderName, rowIndex);
		return value;
		
	}

	/**
	 * This method is used to verify task text is displayed under Customer Task list in CustomerDetail page 
	 *
	 * @param taskText in String format
	 * @return This will return true or false in boolean format
	 */
	public boolean isDisplayedTaskList(String taskText) {
		eleUtil.waitForElementPresence(this.linkByVisibleText.apply(taskText), 20);
		boolean value = eleUtil.isDisplay(this.linkByVisibleText.apply(taskText));
		return value;
	}
	
	/**
	 * This method is used to verify Panel Title is displayed  
	 *
	 * @return This will return true or false in boolean format
	 */
	public boolean isDisplayedPanelTitle(String panelTitleText) {
		boolean value = new CommonECSUtil(driver).isDisplayedPanelTitle(panelTitleText);
		return value;
	}
	
	
	/**
	 * This method is used to click on Overview Displayed Text Link in CustomerDetail page	 
	 * 
	 * @param taskText in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnOverViewDisplayedTextLink(String taskText) {
		eleUtil.waitForElementVisibility(this.overVeiwDisplayedTextLink.apply(taskText),20);
		eleUtil.doClick(this.overVeiwDisplayedTextLink.apply(taskText));
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to click on Overview tab displayed Account Number in CustomerDetail page	 
	 * 
	 * @param taskText in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnOverViewTabDisplayedAccountNumberLink(String taskText) {
		eleUtil.waitForElementPresence(this.overVeiwDisplayedAccountNumberLink.apply(taskText), 20);
		jsUtil.scrollIntoView(this.overVeiwDisplayedAccountNumberLink.apply(taskText));
		jsUtil.clickElementByJS(this.overVeiwDisplayedAccountNumberLink.apply(taskText));
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to select account relationship for add account related party
	 *
	 * @param taskText in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail selectAccountRelationshipType(String type) {
		eleUtil.doSelectDropDownValue(selectRelationshipTypeDropdown, type);
		return this;	
	}
	
	/**
	 * This method is used to click on Organization Radio button under add count related party task  in CustomerDetail page	 
	 * 
	 *
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnOrganizationRadioBtn() {
		eleUtil.doClick(this.organizationRadioBtn);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to enter Organization name for search to add count related party task  in CustomerDetail page	 
	 * 
	 *
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail enterOrganizationNameForSearchForAddAccountsRelatedParty(String organizationName) {
		eleUtil.waitForElementVisibility(this.inputOrganizationNameTextField, 10);
		eleUtil.doSendKeys(this.inputOrganizationNameTextField,organizationName);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to click on search button of Organization for add related party 
	 *
	 * 
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnOrgSearchButton() {
		eleUtil.doClick(this.searchOrgButton);
		eleUtil.wait(10);
		return this;
	}
	
	/**
	 * This method is used to select account relationship for add account related party
	 *
	 * @param text in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public String getTextFromSearchResultDropDown(String text) {
		List<String> result= eleUtil.getAllOptionsForDropdown(this.selectSearcResultDropDownForSearchOrg);
		String value=null;
		for (String val: result) {
			if (val.contains(text)) {
				value = val;
				break;
			}
		}
		return value;	
	}
	
	/**
	 * This method is used to click on Button of Organization for add related party 
	 *
	 * 
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnButton(String text) {
		eleUtil.scrollToElementByActionsClass(this.buttonLocator.apply(text));
		eleUtil.waitForElementToBeClickable(this.buttonLocator.apply(text), 20);
		eleUtil.doClick(this.buttonLocator.apply(text));
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to click sub link of more link in CustomerDetail page	 
	 * 
	 * @param text is sub link text in string format
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail clickOnSubLinkOfMore(String text) {
		eleUtil.doClick(this.moreSubLink.apply(text));
		eleUtil.wait(10);
		return this;
	}
	
	/**
	 * This method is used to select search Result for add account related party
	 *
	 * @param taskText in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail selectSearchResultDropDown(String text) {
		String value = getTextFromSearchResultDropDown(text);
		eleUtil.doSelectDropDownValue(selectSearcResultDropDownForSearchOrg, value);
		return this;	
	}
	
	/**
	 * This method is used to scroll Page Down
	 * 
	 * 
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail scrollPageDown() {
		jsUtil.scrollPageDown();
		return this;
	}
	
	/**
	 * This method is used to refresh page
	 *
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail refreshPage() {
		eleUtil.refreshPage();
		eleUtil.wait(4);
		return this;
	}
	
	/**
	 * This method is used to refresh page
	 *
	 * @return This will return the Object of CustomerDetail class
	 */
	public AccountDetailTabScreen switchToAccountDetailTabScreen() {
		return new AccountDetailTabScreen(driver);
		
	}
	
	/**
	 * This method is used to get pop up message after click on submit button
	 *
	 * @param nothing
	 * @return This will return the popupMessage in String format
	 */
	public String getPopUpMessage(int timeout) {
		String popupSuccessMessage = new CommonECSUtil(driver).getPopUpMessage(timeout);
		return popupSuccessMessage;
	}
	
	/**
	 * This method is used to click on any provided text	 
	 * 
	 * @param text in string format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnText(String text) {
		int scrollCounter=0;
		int counter = 0;
		while (counter < 100) {
			try {
				eleUtil.scrollToElementByActionsClass(this.textLabel.apply(text));
				eleUtil.doClick(this.textLabel.apply(text));
				counter = 101;
			} catch (Exception e) {
				counter++;
				scrollCounter=scrollCounter+200;
				jsUtil.scrollPageDown(scrollCounter);
			}
		}
		return new AccountDetailTabScreen(driver);
	}
	
	public CommonWidget getCommonWidget() {
		return this.commonWidget;
	}
	
	/**
	 * This method is used to click on open case Doc ID
	 * 
	 * @return This will return the Object of WMIScreen class
	 */
	public WMIScreen clickOnOpenCaseDocId(String caseNumber) {
		try {
			eleUtil.waitForElementVisibility(this.caseNumberColumnValue.apply(caseNumber), 20);
			eleUtil.doClick(this.caseNumberColumnValue.apply(caseNumber));
			wait(20);
			eleUtil.switchToWindow(1);
			wait(5);
			ExtentReportListener.test.get().log(Status.INFO,
					"Clicked on Case Number successfully");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while clicking on Case Number");
			Assert.fail(e.getMessage());
		}
		return new WMIScreen(driver);}
		
		/**
		 * This method is used to switch to window
		 *
		 * @param windowNumber in Integer format
		 * @return This will return the Object of AddDocumentScreen class
		 */
		public AddDocumentScreen switchToNewDocWindow(int windowNumber) {
			eleUtil.switchToWindow(windowNumber);
			eleUtil.wait(2);
			return new AddDocumentScreen(driver);
		}
			
		
			
		
		/**
		 * This method is used to click on Tab text (Overview, Details, Transactions, Interest, Orders, Cards, Holds, Documents) 	
		 *
		 * @return This will return the Object of AccountDetailTabScreen class
		 */
		public CustomerDetail clickOnTab(String tabName) {
			jsUtil.scrollPageUp();
			eleUtil.waitForElementPresence(this.tabText.apply(tabName), timeout);
			eleUtil.doClick(this.tabText.apply(tabName));
			eleUtil.wait(5);
			return this;
		}
		
		
		/**
		 * This method is used to click on Tab text (Overview, Details, Transactions, Interest, Orders, Cards, Holds, Documents) 	
		 *
		 * @return This will return the Object of CustomerDetail class
		 */
		public CustomerDetail clickOnThreeDot(String tableName, int rowIndex) {
			tables.clickOnTableThreeDot(tableName, rowIndex);
			return this;
		}
		
		
		/**
		 * This method is used to click on Add button 	
		 *
		 * @return This will return the Object of CustomerDetail class
		 */
		public AddAddressScreen clickOnAddButton(String tableName) {
			tables.clickOnAddButton(tableName);
			return new AddAddressScreen(driver);
		}
		
		
		/**
		 * This method is used to click on Edit button 	
		 *
		 * @return This will return the Object of CustomerDetail class
		 */
		public CustomerDetail clickOnDetailPanelEditButton(String panelName) {
			eleUtil.doClick(this.panelDetailEditButton.apply(panelName));
			return this;
		}
		
		
		
		/**
		 * This method is used to click on Tab text (Overview, Details, Transactions, Interest, Orders, Cards, Holds, Documents) 	
		 *
		 * @return This will return the Object of AccountDetailTabScreen class
		 */
		public CustomerDetail clickOnLinkByVisibleText(String linkText) {
			eleUtil.waitForElementPresence(this.linkByVisibleText.apply(linkText), timeout);
			eleUtil.doClick(this.linkByVisibleText.apply(linkText));
			return this;
		}
		
		
		/**
		 * This method is used to click on Tab text (Overview, Details, Transactions, Interest, Orders, Cards, Holds, Documents) 	
		 *
		 * @return This will return the Object of AccountDetailTabScreen class
		 */
		public ModifyAddressScreen clickOnModifyAddressOption() {
			this.clickOnLinkByVisibleText("Modify Address");
			return new ModifyAddressScreen(driver);
		}
		
		
		//**************************Common Methods for Account Details and Consumer Details page - Start *********//
		
		public String getFeedbackMessage() {
			eleUtil.waitForElementPresence(this.feedbackMessage, timeout);
			return eleUtil.doGetText(this.feedbackMessage);
		}
		
		/**
		 * This method is used to get value for specific column header and specific row
		 * from any Table 
		 *
		 * @param columnHeaderName in String format
		 * @param rowIndex in integer format
		 * 
		 * @return This will return value in String format
		 */
		public String getValueFromTable(String tableID, String ColumnHeader, int rowIndex) {
			return tables.getValueFromTableByTableID(tableID, ColumnHeader, rowIndex);
		}
		
		
		/**
		 * This method is used to click on value for specific column header and specific row
		 * from any Table 
		 *
		 * @param tableID is text contains in table id in String format
		 * @param columnHeaderName in String format
		 * @param rowIndex in integer format
		 * 
		 * @return None
		 */
		public CustomerDetail clickOnValueInTable(String tableID, String ColumnHeader, int rowIndex) {
			tables.clickOnValueInTable(tableID, ColumnHeader, rowIndex);
			return this;
		}
		
		
		public CustomerDetail clickOnValueLinkInTable(String tableID, String ColumnHeader, int rowIndex) {
			tables.clickOnValueLinkInTable(tableID, ColumnHeader, rowIndex);
			return this;
		}
		
		
		
		//**************************Common Methods for Account Details and Consumer Details page - End *********//
		
		
		public WMIScreen getWMISCreen() {
			eleUtil.switchToWindow(1);
			return new WMIScreen(driver);
		}
		

	/**
		 * This method is used to enter customer note after click on Add Customer Note under customer task List in CustomerDetail page	 
		 * 
		 *
		 * @return This will return the Object of CustomerDetail class
		 */
		public CustomerDetail enterNoteText(String text) {
			eleUtil.waitForElementVisibility(this.inputNoteTextField, 10);
			eleUtil.doSendKeys(this.inputNoteTextField,text);
			eleUtil.wait(2);
			return this;
		}
		
		/**
		 * This method is used to select Customer Service Case from drop down
		 *
		 * @param text in String format
		 * @return This will return the Object of CustomerDetail class
		 */
		public CustomerDetail selectServiceCase(String text) {
			try {
				eleUtil.waitForElementVisibility(this.selectServiceCase, 10);
				eleUtil.doDropDownSelectByVisibleText(this.selectServiceCase, text);
				eleUtil.wait(1);
				ExtentReportListener.test.get().log(Status.INFO, "Selected customer service case: " + text + " from Dropdown is successful.");
			} catch (Throwable e) {
				ExtentReportListener.test.get().log(Status.FAIL,
						"Failed while selecting customer service case: " + text +" from drop down menu");
				Assert.fail(e.getMessage());
			}
			return this;
		}
		
		public String getAccountPostionInfoInOverView() {
			String value = eleUtil.doGetText(this.positionText);
			return value;
		}
		
		public String getAlertMessage() {
			String value = eleUtil.doGetText(this.alertMessage);
			return value;
		}
		
		
		public CustomerDetail closeAlertMessagePopup() {
			eleUtil.doClick(this.closeAlertMessageIcon);
			return this;
		}
		
		/**
		 * This method is used to click on refresh icon
		 *
		 * @return This will return the Object of CustomerDetail class
		 */
		public CustomerDetail clickOnRefreshIcon() {
			eleUtil.doClick(this.refreshLink);
			eleUtil.wait(2);
			return this;
		}
		
		
		
		public boolean isAddIconDisplayed(String labelName) {
			try{
				eleUtil.waitForElementPresence(this.addIconForLabel.apply(labelName), timeout);
			}catch(Exception e) {
				
			}
			return eleUtil.isElementExist(this.addIconForLabel.apply(labelName));			
		}
		
		public boolean isEyeIconDisplayed(String labelName) {
			try{
				eleUtil.waitForElementPresence(this.eyeIconForLabel.apply(labelName), timeout);
			}catch(Exception e) {
				
			}
			return eleUtil.isElementExist(this.eyeIconForLabel.apply(labelName));			
		}
		
		public AddDocumentScreen clickOnAddIconForLabel(String labelName) {
			
			int scrollCounter=0;
			int counter = 0;
			while (counter < 100) {
				try {
					eleUtil.doClick(this.addIconForLabel.apply(labelName));
					counter = 101;
				} catch (Exception e) {
					counter++;
					scrollCounter=scrollCounter+200;
					jsUtil.scrollPageDown(scrollCounter);
				}
			}
			
			
			return new AddDocumentScreen(driver);
		}
		
		public AddDocumentScreen clickOnEyeIconForLabel(String labelName) {
			
			int counter = 0;
			while (counter < 5) {
				try {
					eleUtil.scrollToElementByActionsClass(this.eyeIconForLabel.apply(labelName));
					eleUtil.doClick(this.eyeIconForLabel.apply(labelName));								
					counter = 10;
				} catch (Exception e) {
					counter++;
					jsUtil.scrollIntoView(this.eyeIconForLabel.apply(labelName));
				}
			}
			return new AddDocumentScreen(driver);
		}
		
		
		
		public AccountDetailTabScreen getAccountDetailTabScreen() {
			return new AccountDetailTabScreen(driver);
		}
		
		
		
		
			
}
