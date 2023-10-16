package com.qa.ecs.pages;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.function.TriFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.ecs.commonelements.CommonECSUtil;
import com.qa.ecs.commonelements.Tables;
import com.qa.ecs.commonelements.UnexpectedPopupHandler;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.utils.CommonUtil;
import com.qa.ecs.utils.ElementUtil;
import com.qa.ecs.utils.JavaScriptUtil;

public class AccountDetailTabScreen {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private Tables tables;
	private CommonWidget commonWidget;
	private CommonECSUtil commonECSUtil;
	private int timeout = 20;

	// ****************** Locators ****************** //
	private By accountNumber = By.xpath("//*[contains(@id,'wtAccountNumberExpr')]");
	private By accountOpenDate = By.xpath("//span[contains(@id, 'wtAcctOpDt')]");
	private By searchMagnifierIcon = By.xpath("//*[local-name()='svg' and contains(@class,'icon-magnifier')]");
	private By plusIconForAddBeneficiary = By.xpath("//div[text()='Beneficiaries']/following-sibling::div//*[local-name()='svg' and contains(@class,'icon-plus')]");
	private By beneficiaryFirstName = By.xpath("//input[contains(@name,'FirstName')]");
	private By beneficiaryLastName = By.xpath("//input[contains(@name,'LastName')]");
	private Function<String, By> buttonLocator =(text) -> By.xpath("//input[@value='"+text+"']");
	private By beneficiaryPercentage = By.xpath("//input[@class='beneficiary-percentage OSFillParent']");
	private By beneficiaryTable = By.xpath("//div[contains(@class,'Benificiaries')]//*//table");
	private BiFunction<Integer, String, By> beneficiariesTableCellValue = (rowIndex, columnHeader) -> By
			.xpath("//div[contains(@class,'Benificiaries')]//*//table//tr[" + rowIndex + "]//td[" + columnHeader + "]");
	private Function<String, By> overVeiwDisplayedTextLink = (displayedText) -> By.xpath("//span[text()='"+displayedText+"']");
	private By refreshIcon = By.xpath("//*[local-name()='svg' and contains(@class,'icon-refresh')]");
	private By availableBalance = By.xpath("//label[contains(@name,'AvailableBalance')]");
	private By ledgerBalance = By.xpath("//label[contains(@name,'LedgerBalance')]");
	
	private By transactionsTable = By.xpath("//table[contains(@id,'TransactionsTable')]");
	
	private BiFunction<Integer, String, By> transactionsTableData = (rowIndex, columnIndex) -> By
			.xpath("//table[contains(@id,'TransactionsTable')]//tbody//tr["+rowIndex+"]//td["+columnIndex+"]");
	private By doubleDownArrowIcon = By.xpath("//span[contains(@class, 'double-down')]");
	private Function<String, By> singleDownArrowIcon = (labelText) -> By.xpath("//label[text()='"+labelText+"']/parent::div/following-sibling::div//span");
	private BiFunction<Integer, Integer, By> tAccountTableData = (rowIndex, columnIndex) -> By
			.xpath("//table[contains(@id,'TAC')]//tbody//tr["+rowIndex+"]//td["+columnIndex+"]");
	private By openCasesTab = By.xpath("//span[contains(@id,'openCasesTab')]");
	private By selectClosingDispositionDropDown = By.xpath("//select[contains(@id,'Closing_Disposition')]");
	private By standardActionLink = By.xpath("//span[text()='Standard Actions']");
	private By saveLink = By.xpath("//span[text()='Standard Actions']/parent::a/following-sibling::ul//li//a[contains(text(), 'Save')]");
	private By closeWindowLink = By.xpath("//span[text()=' Close Window']");
	private Function<String, By> linkText = (text) -> By.xpath("//a[text()='"+text+"']");
	private Function<String, By> tabText = (text) -> By.xpath("//span[text()='"+text+"']");
	private Function<String, By> text = (text) -> By.xpath("//div[text()='"+text+"']");
	private By closingDispositionLabelText = By.xpath("//span[contains(@id,'Closing_Disposition')]");
	private By addAccPartyRelatedNewWindowIframe = By.xpath("//iframe[@id='ContentPlaceHolder1_iPage']");
	
	private Function<String, By> table = (tableId) ->  By.xpath("//table[contains(@id,'"+tableId+"')]");
	private TriFunction<String , Integer, Integer, By> tableData = (tableId, rowIndex, columnIndex) -> By
			.xpath("//table[contains(@id,'"+tableId+"')]//tbody//tr["+rowIndex+"]//td["+columnIndex+"]");
	
	private By currentHoldsAmount = By.xpath("//div[contains(@id,'TotalCurrentHolds')]//span[contains(@id,'BalSummaryHoldsExp')]");
	private By futureHoldsAmount = By.xpath("//div[contains(@id,'TotalFutureHolds')]//span[contains(@id,'BalSummaryHoldsExp')]");
	private By currentHoldsExpandArrow = By.xpath("//div[contains(@id,'CurrentHold_arrow')]");
	private By currentHoldsClearingAmount = By.xpath("//*[contains(@id,'CurrentHolds')]//span[contains(@id,'ClearingExpr')]");
	private By feedbackMessage = By.xpath("//span[@class='Feedback_Message_Text']");
	private By closeErrorPopupIcon = By.xpath("//a[@title='Hide Message']");
	private Function<String, By> moreSubLink =(text) -> By.xpath("//div[@class='tooltipster-content']//*//span[text()='"+text+"']");
	
	private By moreLink = By.xpath("//div[contains(text(),'More')]");
	
	private By futureHoldsPreAuthAmount = By.xpath("//*[contains(@id,'FutureHolds')]//span[contains(@id,'PreAuthExpr')]");
	private Function<String, By> expandArrowInBalanceSummary = (text) -> By.xpath("//div[contains(@id,'"+text+"_arrow')]");
	private BiFunction<String, String, By> threeDotIcon = (tableName, rowIndex) -> By.xpath("(//table[contains(@id,'"+tableName+"')]//span[contains(@class,'ellipsis')])["+rowIndex+"]");
	private By customerOverviewTabLink = By.xpath("//div[text()='Customer Overview']");
	private By selectServiceCase = By.xpath("//select[contains(@class,'CaseType')]");
	private By linkedCollateralDetailsTableColumnExpandLink = By.xpath("//span[@class='fa fa-fw fa-angle-double-down']");
	private Function<String, By> expandedLinkedCollateralDetailsTableCategoryExpandArrowIcon = (categoryName) -> By.xpath("//label[text()='"+categoryName+"']//ancestor::*[@class='AccordionVertical_item']//span[@class='fa fa-fw fa-angle-down']");
	private Function<String, By> expandedCategoryLabelValue = (labelName) -> By.xpath("//td[text()='"+labelName+"']//following-sibling::td");
	private By threeDotIconForCollateralEntriesVehicle = By.xpath("//*[contains(@id,'Collateral_PE')]//*[@class='fa fa-fw fa-ellipsis-v']");
	private By selectCloseAccountReason = By.xpath("//select[contains(@class,'CloseAccountReason')]");
	private By checkBox = By.xpath("//input[@class='checkbox']");
	private By accountPanelSubHead = By.xpath("//div[contains(@class,'ButtonDropdown_text') and contains(@id, 'wtPanelSubHeader')]");
	private By positionSummaryStatus = By.xpath("//div[contains(@id, 'statusVal')]");
	private Function<String, By> positionSummaryLabelValue = (labelText)-> By.xpath("//span[contains(@id, '"+labelText+"')]");
	private BiFunction <String, String, By> accountDetailsRecordValue = (tableName, recordName) -> By.xpath("//table[contains(@id, '"+tableName+"')]//td[contains(text(), '"+recordName+"')]/following-sibling::td");
	private By accountClosedTitleLabelText = By.xpath("//span[@class='ClosedAccountsTitle_Lbl']");
	
	public AccountDetailTabScreen(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		tables = new Tables(driver);
		commonWidget =  new CommonWidget(driver);
		commonECSUtil = new CommonECSUtil(driver);
	}
	
	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of AccountDetails class
	 */
	public AccountDetailTabScreen wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}
	
	/**
	 * This method is used to get account Number on AccountDetails page
	 *
	 * @param none
	 * @return This will return the accountNumber in String format
	 */
	public String getAccountNumber() {
		String accountNumber = null;
		try {
			eleUtil.waitForElementPresence(this.accountNumber, 5);
			accountNumber = eleUtil.doGetText(this.accountNumber);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Account Number in Account Detail page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Account Number in Account Detail page");
			Assert.fail(e.getMessage());
		}
		return accountNumber;
	}
	
	/**
	 * This method is used to get Account created date on accountDetails page
	 *
	 * @param nothing
	 * @return This will return the account open date in String format
	 */
	public String getAccountOpenDate() {
		String accountOpenDate = null;
		try {
			eleUtil.waitForElementPresence(this.accountOpenDate, 5);
			accountOpenDate = eleUtil.doGetText(this.accountOpenDate);
			ExtentReportListener.test.get().log(Status.INFO,
					"Fetching Account open date: "+accountOpenDate+" in Account Detail page is successful");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Account  open date: "+accountOpenDate+" in Account Detail page");
			Assert.fail(e.getMessage());
		}
		return accountOpenDate;
	}
	
	/**
	 * This method is used to click on Search magnifier icon at right corner of AccountDetails page
	 *
	 * @param nothing
	 * @return This will return the objects of CustomerSearchPage class
	 */
	public CustomerSearchPage clickOnSearchMagnifierIcon() {
		eleUtil.doClick(this.searchMagnifierIcon);
		eleUtil.wait(2);
		return new CustomerSearchPage(driver);
		}
	
	/**
	 * This method is used to scroll Page Down
	 * 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen scrollPageDown() {
		jsUtil.scrollPageDown();
		return this;
	}
	
	/**
	 * This method is used to click On plus icon to add beneficiary in Account Detail Tab Screen	 
	 * 
	 * @param none
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnPlusIconForAddBeneficiary() {
		eleUtil.waitForElementToBeClickable(this.plusIconForAddBeneficiary, 40);
		eleUtil.doClick(this.plusIconForAddBeneficiary);
		return this;
	}
	
	/**
	 * This method is used to enter First Name of Beneficiary in Add Beneficiary panel 
	 *
	 * @return This will return object of  AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen enterBeneficiaryFirstName(String firstName) {
		eleUtil.doSendKeys(beneficiaryFirstName, firstName);
		eleUtil.wait(1);
		return this;
	}
	
	/**
	 * This method is used to enter First Name of Beneficiary in Add Beneficiary panel 
	 *
	 * @return This will return object of  AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen enterBeneficiaryLastName(String firstName) {
		eleUtil.doSendKeys(beneficiaryLastName, firstName);
		eleUtil.wait(1);
		return this;
	}
	
	/**
	 * This method is used to click on Button which type='submit' 
	 *
	 * @param text in String format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnButton(String text) {
		eleUtil.scrollToElementByActionsClass(this.buttonLocator.apply(text));
		eleUtil.doClick(this.buttonLocator.apply(text));
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to verify Panel Title is displayed 
	 *  
	 * @param panelTitleText in String format
	 * @return This will return true or false in boolean format
	 */
	public boolean isDisplayedPanelTitle(String panelTitleText) {
		boolean value = commonECSUtil.isDisplayedPanelTitle(panelTitleText);
		return value;
	}
	
	/**
	 * This method is used to enter First Name of Beneficiary in Add Beneficiary panel 
	 * 
	 * @param percentAmount in String format
	 * @return This will return object of  AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen enterBeneficiaryPercentage(String percentAmount) {
		eleUtil.doSendKeys(this.beneficiaryPercentage, percentAmount);
		eleUtil.wait(4);
		return this;
	}
	
	/**
	 * This method is used to get pop up message after click on submit button
	 *
	 * @param nothing
	 * @return This will return the popupMessage in String format
	 */
	public String getPopUpMessage(int timeout) {
		String popupSuccessMessage = commonECSUtil.getPopUpMessage(timeout);
		return popupSuccessMessage;
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
	 * This method is used to get value for specific column header and specific row
	 * from Table 
	 *
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 * @param tableInfo provides text 
	 * 		which contains in class of locator for that specific table in string format
	 * 
	 * @return This will return the Object of Tables class
	 */
	public String getValueFromBeneficiariesTable(String columnHeaderName, int rowIndex) {
		String value = null;
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(eleUtil.getElement(this.beneficiaryTable), "th"));
		int columnIndex = 0;
		for (int i = 0; i < columns.size(); i++) {
			if (columnHeaderName.equalsIgnoreCase(columns.get(i)))
				columnIndex = i + 1;
		}
		eleUtil.waitForElementPresence(this.beneficiariesTableCellValue.apply(rowIndex, String.valueOf(columnIndex)), 20);
		value = eleUtil.doGetText(this.beneficiariesTableCellValue.apply(rowIndex, String.valueOf(columnIndex)));
		return value;
	}
	
	/**
	 * This method is used to click on Overview Displayed Text Link in AccountDetailTabScreen page	 
	 * 
	 * @param taskText in String format
	 * @return This will return the Object of CustomerDetail class
	 */
	public AccountDetailTabScreen clickOnOverViewDisplayedTextLink(String taskText) {
		eleUtil.waitForElementVisibility(this.overVeiwDisplayedTextLink.apply(taskText),20);
		eleUtil.doClick(this.overVeiwDisplayedTextLink.apply(taskText));
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
	public String getValueFromResultTable(String columnHeaderName, int rowIndex) {
		String value =tables.getValueFromSearchResultTable(columnHeaderName, rowIndex);
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
	public String getValueFromResultTable(String tableID, String columnHeaderName, int rowIndex) {
		String value =tables.getValueFromTableByTableID(tableID, columnHeaderName, rowIndex);
		return value;
	}
	
	
	/**
	 * This method is used to click on refresh icon	 
	 * 
	 * @param text is sub link text in string format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnRefreshIcon() {
		eleUtil.doClick(this.refreshIcon);
		eleUtil.wait(5);
		return this;
	}
	
	
	/**
	 * This method is used to get Available Account Balance from Balance Summary 
	 * 
	 * @return This will return Available Account Balance in String format
	 */
	public String getAvailableAccountBalance() {
		eleUtil.waitForElementPresence(this.availableBalance, timeout);
		return eleUtil.doGetText(this.availableBalance);
	}
	
	/**
	 * This method is used to get Ledger Balance from Balance Summary 
	 * 
	 * @return This will return Ledger Balance in String format
	 */
	public String getLedgerBalance() {
		return eleUtil.doGetText(this.ledgerBalance);
	}
	
	
	/**
	 * This method is used to get Current Holds amount from Balance Summary 
	 * 
	 * @return This will return current holds amount in String format
	 */
	public String getCurrentHoldsAmount() {
		return eleUtil.doGetText(this.currentHoldsAmount);
	}
	
	/**
	 * This method is used to get Future Holds amount from Balance Summary 
	 * 
	 * @return This will return future hold amount in String format
	 */
	public String getFutureHoldsAmount() {
		return eleUtil.doGetText(this.futureHoldsAmount);
	}
	
	/**
	 * This method is used to click on expand Row  
	 * 
	 * @param text is sub link text in string format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnCurrentHoldsExpandButton() {
		eleUtil.doClick(this.currentHoldsExpandArrow);
		return this;
	}
	
	/**
	 * This method is used to click on expand arrow next to the text (Ex: CurrentHold, FutureHold) in Balance Summary section 
	 * 
	 * @param textForExpand is in string format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnExpandBtnFromBalanceSummarySection(String textForExpand) {
		eleUtil.doClick(this.expandArrowInBalanceSummary.apply(textForExpand));
		return this;
	}
	
	/**
	 * This method is used to click on refresh icon	 
	 * 
	 * @param text is sub link text in string format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public String getCurrentHoldsClearingAmount() {
		return eleUtil.doGetText(this.currentHoldsClearingAmount);
	}
	
	/**
	 * This method is used to get Amount for FutureHolds Pre-Auth After expand arrow of Future Holds in Balance summary section	 
	 *
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public String getFutreHoldsPreAuthAmount() {
		return eleUtil.doGetText(this.futureHoldsPreAuthAmount);
	}
	
	
	/**
	 * This method is used to switch to CustomerDetail page
	 *
	 * @return This will return the Object of CustomerDetail class
	 */
	public CustomerDetail switchToCustomerDetailPage() {
		return new CustomerDetail(driver);
		
	}
	
	/**
	 * This method is used to switch to ModifyVehicleDetailsScreen page
	 *
	 * @return This will return the Object of ModifyVehicleDetailsScreen class
	 */
	public ModifyVehicleDetailsScreen switchToModifyVehicleDetailsScreen() {
		return new ModifyVehicleDetailsScreen(driver);
		
	}
	
	/**
	 * This method is used to switch to ModifyInsuranceDetailsScreen page
	 *
	 * @return This will return the Object of ModifyInsuranceDetailsScreen class
	 */
	public ModifyInsuranceDetailsScreen switchToModifyInsuranceDetailsScreen() {
		return new ModifyInsuranceDetailsScreen(driver);
		
	}
	
	
	/**
	 * This method is used to switch to ModifyCollateralDetailsScreen page
	 *
	 * @return This will return the Object of ModifyCollateralDetailsScreen class
	 */
	public ModifyCollateralDetailsScreen switchToModifyCollateralDetailsScreen() {
		return new ModifyCollateralDetailsScreen(driver);
		
	}
	
	/**
	 * This method is used to switch to ModifyAddressScreen page
	 *
	 * @return This will return the Object of ModifyAddressScreen class
	 */
	public ModifyAddressScreen switchToModifyAddressScreen() {
		return new ModifyAddressScreen(driver);
		
	}
	
	/**
	 * This method is used to get value for specific column header and specific row
	 * from Transactions Table 
	 *
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 * 
	 * @return This will return value in String format
	 */
	public String getValueFromTransactionsTable(String ColumnHeader, int rowIndex) {
		WebElement table = eleUtil.getElement(this.transactionsTable);
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table,"th"));
		
        int columnIndex=0;
        for(int i =0 ; i<columns.size();i++) {
        	if(ColumnHeader.equalsIgnoreCase(columns.get(i)))
        		columnIndex=i+1;
        }
        return eleUtil.doGetText(this.transactionsTableData.apply(rowIndex,String.valueOf(columnIndex)));
	}
	
	/**
	 * This method is used to click on double down arrow icon 
	 *
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnDoubleDownArrowIcon() {
		eleUtil.scrollToElementByActionsClass(this.doubleDownArrowIcon);
		eleUtil.waitForElementToBeClickable(this.doubleDownArrowIcon, 10);
		eleUtil.doClick(this.doubleDownArrowIcon);
		return this;
	}
	
	/**
	 * This method is used to click on single down arrow icon 
	 *
	 * @param labelText in String format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnSingleDownArrowIcon(String labelText) {
		int counter = 0;
		while (counter < 5) {
			try {
				eleUtil.scrollToElementByActionsClass(this.singleDownArrowIcon.apply(labelText));
				eleUtil.doClick(this.singleDownArrowIcon.apply(labelText));
				jsUtil.scrollPageDown(200);
				counter = 10;
			} catch (Exception e) {
				counter++;
				jsUtil.scrollPageDown(200);
			}
		}
		
		return this;
	}
	
	/**
	 * This method is used to get value for specific column header and specific row
	 * from Transactions Table 
	 *
	 * @param tableId is in String format which text contains in table id
	 * @param columnHeaderName in String format
	 * @param rowIndex in integer format
	 * 
	 * @return This will return value in String format
	 */
	public String getValueFromTable(String tableId, int rowIndex, int columnIndex) {
		eleUtil.scrollToElementByActionsClass(this.tableData.apply(tableId,rowIndex,columnIndex));
		eleUtil.waitForElementVisibility(this.tableData.apply(tableId, rowIndex,columnIndex),10);
		return eleUtil.doGetText(this.tableData.apply(tableId, rowIndex,columnIndex));
	}
	
	/**
	 * This method is used to get Text From CaseOpen Tab	 
	 * 
	 * @return This will return text in String format
	 */
	public String getTextFromCaseOpenTab() {
		return eleUtil.doGetText(this.openCasesTab);
	}
	
	/**
	 * This method is used to click on link text 	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnLink(String t) {
		eleUtil.doClick(this.linkText.apply(t));
		return this;
	}
	 
		
	/**
	 * This method is used to switch to new window	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen switchToWindow(int windowIndexNumber) {
		eleUtil.switchToWindow(windowIndexNumber);
		return this;
	}
	
	/**
	 * This method is used to switch to new window	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen switchToAddAccRelatedPartyWindowIframe() {
		eleUtil.switchToFrameIfExists(this.addAccPartyRelatedNewWindowIframe);
		return this;
	}
	
	/**
	 * This method is used to select Closing Disposition Option	from drop down
	 * 
	 * @param visibleText in drop down list in String format
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen selectClosingDispositionOption(String visibleText) {
		this.switchToAddAccRelatedPartyWindowIframe();
		eleUtil.doDropDownSelectByVisibleText(this.selectClosingDispositionDropDown, visibleText);
		eleUtil.switchToDefaultContent();
		return this;
	}
	
	/**
	 * This method is used to mouse hover on Standard Actions Link and then click on save link	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen mouseHoverStandardActionsAndClickOnSave() {
		eleUtil.moveToElementAndClick(this.standardActionLink, this.saveLink);
		return this;
	}
	
	/**
	 * This method is used to click on close window	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnCloseWindow() {
		eleUtil.doClick(this.closeWindowLink);
		return this;
	}
	
	public String getTextForClosingDispositionLabel() {
		this.switchToAddAccRelatedPartyWindowIframe();
		String text= eleUtil.doGetText(this.closingDispositionLabelText);
		eleUtil.switchToDefaultContent();
		return text;
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
	 * This method is used to click on three dot icon present in table under Overview tab section	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnThreeDotIconInTable(String tableID) {
		return this.clickOnThreeDotIconInTable(tableID, "1");
	}
	
	
	/**
	 * This method is used to click on three dot icon present in table under Overview tab section	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnThreeDotIconInTable(String tableID, String rowIndex) {
		eleUtil.waitForElementPresence(this.threeDotIcon.apply(tableID,rowIndex), 40);
		eleUtil.doClick(this.threeDotIcon.apply(tableID,rowIndex));
		eleUtil.wait(2);
		return this;
	}
	
	public CommonWidget getCommonWidget() {
		return this.commonWidget;
	}
	
	
	public String getFeedbackMessage() {
		String value="";
		int counter=0;
		eleUtil.waitForElementPresence(this.feedbackMessage, 20);
		while(counter<10) {
			counter++;
			value = eleUtil.doGetText(this.feedbackMessage);
			if(value.trim()!="")
				break;
			else
				this.wait(1);
		}
		return value;
	}
	
	
	/**
	 * This method is used to click on Tab text (Overview, Details, Transactions, Interest, Orders, Cards, Holds, Documents) 	
	 *
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnTab(String tabName) {
		eleUtil.waitForElementPresence(this.tabText.apply(tabName), 40);
		eleUtil.doClick(this.tabText.apply(tabName));
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to click on text (Customer Overview, Search) 	
	 *
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnText(String text) {
		eleUtil.waitForElementPresence(this.text.apply(text), 40);
		eleUtil.doClick(this.text.apply(text));
		eleUtil.wait(5);
		return this;
	}
	
	
	/**
	 * This method is used to click sub link of more link in CustomerDetail page	 
	 * 
	 * @param text is sub link text in string format
	 * @return This will return the Object of CustomerDetail class
	 */
	public AccountDetailTabScreen clickOnSubLinkOfMore(String text) {
		eleUtil.waitForElementPresence(this.moreSubLink.apply(text), 20);
		eleUtil.doClick(this.moreSubLink.apply(text));
		
		return this;
	}
	
	
	/**
	 * This method is used to click On more link in CustomerDetail page	 
	 * 
	 * @param none
	 * @return This will return the Object of CustomerDetail class
	 */
	public AccountDetailTabScreen clickOnMoreLink() {
		eleUtil.doClick(this.moreLink);
		eleUtil.wait(2);
		return this;
	}
	
	/**
	 * This method is used to click On more link in Account Details page	 
	 * 
	 * @param none
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnCustomerOverviewLink() {
		eleUtil.waitForElementPresence(this.customerOverviewTabLink, 20);
		eleUtil.doClick(this.customerOverviewTabLink);
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to click on link text by Java script Executor	 
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnLinkByJS(String t) {
		//eleUtil.scrollToElementByActionsClass(this.linkText.apply(t));
		jsUtil.clickElementByJS(this.linkText.apply(t));
		eleUtil.wait(2);
		return this;
	}
	
	public void closeUnExpectedErrorPopUp(int timeout) {
		int counter = 0;
		while (counter < timeout) {
			counter++;
			try {
				eleUtil.doClick(this.closeErrorPopupIcon);
				break;
			} catch (Exception e) {
				eleUtil.wait(1);
			}
		}
	}
	
	/**
	 * This method is used to refresh page
	 *
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen refreshPage() {
		driver.navigate().refresh();
		eleUtil.wait(10);
		return this;
	}
	
	/**
	 * This method is used to select Account Service Case from drop down
	 *
	 * @param text in String format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen selectServiceCase(String text) {
		try {
			eleUtil.waitForElementVisibility(this.selectServiceCase, 10);
			eleUtil.doDropDownSelectByVisibleText(this.selectServiceCase, text);
			eleUtil.wait(1);
			ExtentReportListener.test.get().log(Status.INFO, "Selected account service case: " + text + " from Dropdown is successful.");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while selecting account service case: " + text +" from drop down menu");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to Expand Linked Collateral Details Table First Row
	 *
	 * @param nothing
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen expandLinkedCollateralDetailsTableFirstRow() {
		try {
			eleUtil.waitForElementVisibility(this.linkedCollateralDetailsTableColumnExpandLink, 10);
			eleUtil.doClick(this.linkedCollateralDetailsTableColumnExpandLink);
			eleUtil.wait(1);
			ExtentReportListener.test.get().log(Status.INFO, "Expand Linked Collateral Details Table First Row");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while expanding Linked Collateral Details Table First Row");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	
	/**
	 * This method is used to Expand Linked Collateral Details Table Category by taking Category Name
	 *
	 * @param categoryName in String format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen expandLinkedCollateralDetailsTableCategory(String categoryName) {
		try {
			jsUtil.scrollIntoView(this.expandedLinkedCollateralDetailsTableCategoryExpandArrowIcon.apply(categoryName));
			eleUtil.waitForElementVisibility(this.expandedLinkedCollateralDetailsTableCategoryExpandArrowIcon.apply(categoryName), 20);

			jsUtil.clickElementByJS(this.expandedLinkedCollateralDetailsTableCategoryExpandArrowIcon.apply(categoryName));
			eleUtil.wait(1);
			ExtentReportListener.test.get().log(Status.INFO, "Expand Linked Collateral Details Table Category");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while expanding Linked Collateral Details Table Category");
			Assert.fail(e.getMessage());
		}
		return this;
	}
	
	/**
	 * This method is used to Fetching Expanded Category Label Value
	 *
	 * @param labelName in String format
	 * @return This will return the Label's value in String format
	 */
	public String getExpandedCategoryLabelValue(String labelName) {
		String value=null;
		try {
			eleUtil.waitForElementVisibility(this.expandedCategoryLabelValue.apply(labelName), 20);
			value = eleUtil.doGetText(this.expandedCategoryLabelValue.apply(labelName));
			eleUtil.wait(1);
			ExtentReportListener.test.get().log(Status.INFO, "Fetching Expanded Category Label Value");
		} catch (Throwable e) {
			ExtentReportListener.test.get().log(Status.FAIL,
					"Failed while fetching Expanded Category Label Value");
			Assert.fail(e.getMessage());
		}
		return value;
	}
	
	
	
	public AccountDetailTabScreen clickOnThreeDotForCollateralEntriesVehicle() {
		jsUtil.clickElementByJS(this.threeDotIconForCollateralEntriesVehicle);
		return this;
	}
	
	/**
	 * This method is used to select Close Account Reason Option from drop down
	 * 
	 * @param visibleText in drop down list in String format
	 * 
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen selectCloseAccountReason(String visibleText) {
		eleUtil.waitForElementVisibility(this.selectCloseAccountReason, timeout);
		eleUtil.doDropDownSelectByVisibleText(this.selectCloseAccountReason, visibleText);
		eleUtil.switchToDefaultContent();
		return this;
	}
	
	/**
	 * This method is used to click on check box for Do not generate workflow case
	 *
	 * @param text in String format
	 * @return This will return the Object of AccountDetailTabScreen class
	 */
	public AccountDetailTabScreen clickOnCheckBox() {
		eleUtil.waitForElementToBeClickable(this.checkBox, timeout);
		jsUtil.clickElementByJS(this.checkBox);
		//eleUtil.doClick(this.checkBox);
		eleUtil.wait(5);
		return this;
	}
	
	/**
	 * This method is used to get Text From Account SubHead Panel	 
	 * 
	 * @return This will return text in String format
	 */
	public String getTextFromAccountSubHeadPanel() {
		return eleUtil.doGetText(this.accountPanelSubHead);
	}
	
	/**
	 * This method is used to get Text From Account Position Summary Label Text	 
	 * 
	 * @return This will return text in String format
	 */
	public String getTextFromAccountPositionSummaryLabelText(String text) {
		eleUtil.scrollToElementByActionsClass(this.positionSummaryLabelValue.apply(text));
		String value= eleUtil.doGetText(this.positionSummaryLabelValue.apply(text));
		return value;
	}
	
	/**
	 * This method is used to get Text From Account position summary status	 
	 * 
	 * @return This will return text in String format
	 */
	public String getTextForPositionSummaryStatus() {
		eleUtil.scrollToElementByActionsClass(this.positionSummaryStatus);
		String value= eleUtil.doGetText(this.positionSummaryStatus);
		return value;
	}
	
	/**
	 * This method is used to get Record value From table under Details tab	
	 *  
	 * @param tableName in String format
	 * @param recordName in String format 
	 * @return This will return value in String format
	 */
	public String getRecordValueFromTablesUnderDetailsTab(String tableName, String recordName) {
		eleUtil.scrollToElementByActionsClass(this.accountDetailsRecordValue.apply(tableName, recordName));
		String value= eleUtil.doGetText(this.accountDetailsRecordValue.apply(tableName, recordName));
		return value;
		
	}
	
	public int getClosedAccountNumberInClosedAccountSection() {
		eleUtil.scrollToElementByActionsClass(this.accountClosedTitleLabelText);
		String closedAccountTitleLabel = eleUtil.doGetText(this.accountClosedTitleLabelText);
		String a= closedAccountTitleLabel.split(" ")[2];
        String value=a.replaceAll("[()]", "");
        return Integer.valueOf(value);
        
	}
	
	public AccountDetailTabScreen scrollPageUp() {
		jsUtil.scrollPageUp();
		return this;
	}
}

