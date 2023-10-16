package com.qa.ecs.base;

import java.util.Properties;

import com.qa.ecs.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ecs.factory.DriverFactory;

@Listeners({com.qa.ecs.listeners.ExtentReportListener.class, com.qa.ecs.listeners.TestAllureListener.class})


/**
 * This Class is used to manage all pages objects
 *
 * @author Nahian Omar Faruqe
 * @version 1.0
 * @since 2022-09-28
 */
public class BaseTest {

	protected String baseUrl;
    DriverFactory df;
    ExtentTest extentLogger;
    WebDriver driver;
    protected Properties prop;
    protected LoginPage loginPage;
    protected CustomerSearchPage customerSearchPage;
    protected CustomerDetail customerDetail;
    protected AccountCreatePage accountCreatePage;
    protected PositionDetails positionDetails;
    protected AccountDetails accountDetails;
    protected RelatedParties relatedParties;
    protected ElectronicAcceptanceDocuments electAcceptanceDoc;
    protected AccountDetailTabScreen accountDetailTabScreen;
    protected WorkflowPage workflowPage;
    protected CommonWidget commonWidget;
    protected AddComplaintScreen addComplaintScreen;
    protected AddDocumentScreen addDocScreen;
    protected WMIScreen wmiScreen;
    protected AddCustomerContactEventScreen addCustomerContactEventScreen;
    protected AddRelatedParties addRelatedParties;
    protected VaultPage vaultPage;
    
    protected CustomerInformation customerInformation;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        df = new DriverFactory();
        prop = df.init_prop();        
        driver = df.init_driver(prop);
        baseUrl = df.base_url;
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, df.userName, df.password);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
