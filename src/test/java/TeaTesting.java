import static org.junit.Assert.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.NewThreadAction;

public class TeaTesting {



    ExtentReports report; // needed to create test (report)
    ExtentTest test; // needed to create test (report)



Actions action;




    @FindBy(xpath="//*[@id=\"txtUsername\"]")
    private WebElement registerLink;

    public void registerLink() {
        registerLink.click();
    }
    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    private WebElement name;



    WebDriver driver;
    @Before                  // before test runs
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Development\\web_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Homepage home = PageFactory.initElements(driver, Homepage.class);


//        report = new ExtentReports(Constant.filepath + Constant.report, false);  // Used for report - file location
//        test = report.startTest("Test Registration.");

    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);     // doesn't quit for 3000ms
        driver.quit();
        report.endTest(test);   //ends test
        report.flush(); // ends report
    }


    @Given("^the login page$")
    public void the_login_page()  {
        driver.get("https://qa-trials641.orangehrmlive.com/auth/login");
    }
    @When("^I login$")

    public void i_login()  {
action = new Actions(driver);
driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("AdminAdmin");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).submit();
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab()  {

        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")).click();

    }


    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab()  {


        WebElement myDynamicElement = (new WebDriverWait(driver, 20)) .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")));


                driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")).click();

    }

    @When("^I fill out the Employee Details correctly$")
    public void i_fill_out_the_Employee_Details_correctly() {
        action = new Actions(driver);



       WebElement myDynamicElement = (new WebDriverWait(driver, 30)) .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Rayyan");
        driver.findElement(By.xpath("//*[@id=\"middleName\"]")).sendKeys("Anddd");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("wwww");
        action.sendKeys("L").perform();
        action.sendKeys(Keys.RETURN).perform();


driver.findElement(By.xpath("//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")).click();
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button()  {

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Rayyan");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("A");
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("A");
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions    throw new PendingException();
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"systemUserSaveBtn\"]")).click();;
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created()  {

        driver.findElement(By.xpath("//*[@id=\"employee_name_quick_filter_employee_list_value\"]")).sendKeys("Rayyan");


    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection()  {
        driver.findElement(By.xpath("//*[@id=\"employee_name_quick_filter_employee_list_dropdown\"]/div[3]")).click();
        action.sendKeys(Keys.RETURN).perform();
        driver .findElement(By.xpath("//*[@id=\"quick_search_icon\"]")).submit();






        }
    }



