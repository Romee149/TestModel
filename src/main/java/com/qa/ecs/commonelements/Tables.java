package com.qa.ecs.commonelements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.function.TriFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.ecs.listeners.ExtentReportListener;
import com.qa.ecs.pages.CustomerDetail;
import com.qa.ecs.pages.CustomerSearchPage;
import com.qa.ecs.utils.ElementUtil;

/**
 * This Class is used to provide Generic Methods related to Common Application
 * Element
 *
 * @author Nahian Omar Faruqe
 * @version 1.0
 * @since 2023-06-20
 */

public class Tables {

	private WebDriver driver;
	private ElementUtil eleUtil;
	int timeout = 60;

	private By searchResultTable = By.xpath("//table[contains(@class,'TableRecords')]");
	private BiFunction<Integer, String, By> searchResultTableData = (rowIndex, columnIndex) -> By
			.xpath("//table[contains(@class,'TableRecords')]//tr[" + rowIndex + "]//td[" + columnIndex + "]");
	private Function<String, By> resultTable = (tableType) -> By.xpath("//table[contains(@class,'"+tableType+"')]");
	private TriFunction<String, Integer, String, By> searchResultTableCellValue = (tableInfo, rowIndex, columnIndex) -> By
			.xpath("//table[contains(@class,'"+tableInfo+"')]//tr[" + rowIndex + "]//td[" + columnIndex
					+ "]");
	private Function<String, By> table = (tableId) ->  By.xpath("//table[contains(@id,'"+tableId+"')]");
	private TriFunction<String , Integer, Integer, By> tableData = (tableId, rowIndex, columnIndex) -> By
			.xpath("//table[contains(@id,'"+tableId+"')]//tbody//tr["+rowIndex+"]//td["+columnIndex+"]");
	
	private TriFunction<String , Integer, Integer, By> tableDataLink = (tableId, rowIndex, columnIndex) -> By
			.xpath("//table[contains(@id,'"+tableId+"')]//tbody//tr["+rowIndex+"]//td["+columnIndex+"]//a");
	
	private BiFunction<String,String, By> tableRowThreeDot = (tableName, row) -> By.xpath("(//span[text()='"+tableName+"']//ancestor::div[contains(@id,'SectionExpandable')]//table/tbody//tr)["+row+"]//span[contains(@class,'ellipsis')]");
	
	private Function<String, By> tableAddButton = (tableName) -> By.xpath("//span[text()='"+tableName+"']//ancestor::div[contains(@id,'SectionExpandable')]//*[local-name()='svg' and contains(@class,'icon-plus-circle')]");
	
	
	// ***** This Class should have common methods related to Web Tables Interaction

	public Tables(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	/**
	 * This method is used to provide wait
	 *
	 * @param waitInSecond waitSecond in String format
	 * @return This will return the Object of Tables class
	 */
	public Tables wait(int waitInSecond) {
		eleUtil.wait(waitInSecond);
		return this;
	}

	/**
	 * This method is used to get value for specific column header and specific row
	 * from Table
	 *
	 * @param columnHeaderName in String format
	 * @param rowIndex         in integer format
	 * 
	 * @return This will return the value from table
	 */
	public String getValueFromSearchResultTable(String columnHeaderName, int rowIndex) {
		eleUtil.waitForElementPresence(this.searchResultTable, 20);
		WebElement table = eleUtil.getElement(this.searchResultTable);
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table, "th"));

		int columnIndex = 0;
		for (int i = 0; i < columns.size(); i++) {
			if (columnHeaderName.equalsIgnoreCase(columns.get(i)))
				columnIndex = i + 1;
		}

		String value = eleUtil.doGetText(this.searchResultTableData.apply(rowIndex, String.valueOf(columnIndex)));

		return value;
	}

	/**
	 * This method is used to click on value for specific Column and specific row
	 * from Table
	 *
	 * @param columnHeaderName in String format
	 * @param rowIndex         in integer format
	 * 
	 * @return This will return the Object of Tables class
	 */
	public Tables clickOnValueFromSearchResultTable(String columnHeaderName, int rowIndex) {
		new UnexpectedPopupHandler(driver).closeUnExpectedErrorPopUp(5);
		eleUtil.waitForElementPresence(this.searchResultTable, 10);
		WebElement table = eleUtil.getElement(this.searchResultTable);
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table, "th"));

		int columnIndex = 0;
		for (int i = 0; i < columns.size(); i++) {
			if (columnHeaderName.equalsIgnoreCase(columns.get(i)))
				columnIndex = i + 1;
		}

		eleUtil.doClick(this.searchResultTableData.apply(rowIndex, String.valueOf(columnIndex)));
		this.wait(5);
		return this;
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
	public String getValueFromTable(String tableInfo, String columnHeaderName, int rowIndex) {
		String value = null;
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(eleUtil.getElement(resultTable.apply(tableInfo)), "th"));
		int columnIndex = 0;
		for (int i = 0; i < columns.size(); i++) {
			if (columnHeaderName.equalsIgnoreCase(columns.get(i)))
				columnIndex = i + 1;
		}

		value = eleUtil.doGetText(this.searchResultTableCellValue.apply(tableInfo, rowIndex, String.valueOf(columnIndex)));
		return value;
		
	}
	
	/**
	 * This method is used to click on value in table 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return none
	 */
	public void clickOnValueInTable(String tableID, String columnHeader, int rowIndex) {
		eleUtil.doClick(this.getTableCellElementByTableID(tableID, columnHeader, rowIndex));
	}
	
	
	/**
	 * This method is used to click on value in table 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return none
	 */
	public void clickOnValueLinkInTable(String tableID, String columnHeader, int rowIndex) {
		eleUtil.doClick(this.getTableCellElementLinkByTableID(tableID, columnHeader, rowIndex));
	}
	
	/**
	 * This method is used to get value from table by providing tableID, columnHeader and index number of row 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return the cell value from table
	 */
	public String getValueFromTableByTableID(String tableID, String columnHeader, int rowIndex) {
		return eleUtil.doGetText(this.getTableCellElementByTableID(tableID, columnHeader, rowIndex));
	}
	
	/**
	 * This method is used to get By locator for table elements 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return By locator for table elements
	 */
	public By getTableCellElementByTableID(String tableID, String ColumnHeader, int rowIndex) {
		try{
			eleUtil.waitForElementPresence(this.tableData.apply(tableID, 1, 1), timeout);
			eleUtil.waitForElementVisibility(this.tableData.apply(tableID, 1, 1), timeout);
		}catch(Exception e) {}
		eleUtil.scrollToElementByActionsClass(this.tableData.apply(tableID, 1, 1));		
		WebElement table = eleUtil.getElement(this.table.apply(tableID));
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table,"th"));		
        int columnIndex=0;
        for(int i =0 ; i<columns.size();i++) {
        	if(ColumnHeader.equalsIgnoreCase(columns.get(i))) {
        		columnIndex=i+1;
        		break;
        	}
        }        
        return this.tableData.apply(tableID, rowIndex, columnIndex);
	}
	
	
	
	/**
	 * This method is used to get By locator for table elements 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return By locator for table elements
	 */
	public WebElement getTableCellElementByTableID(By tableLocator, String ColumnHeader, int rowIndex) {
		
			int columnIndex=0;
			eleUtil.waitForElementPresence(tableLocator, timeout);
			eleUtil.waitForElementVisibility(tableLocator, timeout);
			List<WebElement> columnHeaderList = eleUtil.getElement(tableLocator).findElements(By.tagName("th"));
			for(int i=0;i<columnHeaderList.size();i++) {
				String columnHeaderValue = columnHeaderList.get(i).getText();
				if(columnHeaderValue.trim().equalsIgnoreCase(ColumnHeader.trim())) {
					columnIndex=i;
					break;	
				}
			}
			
			List<WebElement> rowList = eleUtil.getElement(tableLocator).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
			WebElement row = rowList.get(rowIndex);
			List<WebElement> columnList =	row.findElements(By.tagName("td"));
			WebElement column = columnList.get(columnIndex);
			
			return column;
			
	}
	
	/**
	 * This method is used to get By locator for table elements 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return By locator for table elements
	 */
	public By getTableCellElementLinkByTableID(String tableID, String ColumnHeader, int rowIndex) {
		eleUtil.waitForElementPresence(this.tableData.apply(tableID, 1, 1), 30);
		eleUtil.scrollToElementByActionsClass(this.tableData.apply(tableID, 1, 1));		
		WebElement table = eleUtil.getElement(this.table.apply(tableID));
		List<String> columns = eleUtil.getAllOptionsofElements(eleUtil.getElements(table,"th"));		
        int columnIndex=0;
        for(int i =0 ; i<columns.size();i++) {
        	if(ColumnHeader.equalsIgnoreCase(columns.get(i)))
        		columnIndex=i+1;
        }        
        return this.tableDataLink.apply(tableID, rowIndex, columnIndex);
	}
	
	
	/**
	 * This method is used to get By locator for table elements 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return By locator for table elements
	 */
	public void clickOnTableThreeDot(String tableName, int row) {
		eleUtil.waitForElementPresence(this.tableRowThreeDot.apply(tableName, String.valueOf(row)), 30);			
		eleUtil.doClick(this.tableRowThreeDot.apply(tableName, String.valueOf(row)));		
	}
	
	
	/**
	 * This method is used to click on Add Button for the provided table 
	 * 
	 * @param tableName in string format
	 * @return Nothing
	 */
	public void clickOnAddButton(String tableName) {
		eleUtil.waitForElementPresence(this.tableAddButton.apply(tableName), 30);			
		eleUtil.doClick(this.tableAddButton.apply(tableName));		
	}
	
	
	/**
	 * This method is used to click on value in table 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return none
	 */
	public void clickOnValueInTable(By tableLocator, String columnHeader, int rowIndex) {
		eleUtil.doClick(this.getTableCellElementByTableID(tableLocator, columnHeader, rowIndex));
	}
	
	/**
	 * This method is used to get value from table by providing tableID, columnHeader and index number of row 
	 * 
	 * @param tableID in string format
	 * @param columnHeader in String format
	 * @param rowIndex in Integer format
	 * @return This will return the cell value from table
	 */
	public String getValueFromTableByTableID(By tableLocator, String columnHeader, int rowIndex) {
		return eleUtil.doGetText(this.getTableCellElementByTableID(tableLocator, columnHeader, rowIndex));
	}
	
}
