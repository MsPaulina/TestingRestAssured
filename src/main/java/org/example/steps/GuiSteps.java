package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.Assertion;

import java.util.List;

import static org.junit.Assert.*;


public class GuiSteps {

    public WebDriver driver;


    @Given("I open browser and navigate to Language School website")
    public void iOpenBrowserAndNavigateToLanguageSchoolWebsite() {
        driver = new ChromeDriver();

        driver.navigate().to("http://localhost:4200/");
        driver.manage().window().maximize();
    }


    @And("^I login as (.*) with the password (.*)$")
    public void iLoginAsAdmin(String username, String password) throws InterruptedException {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("username")).sendKeys(username);

//        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.name("loginBtn")).click();

//        Locator sss =
//        loginPage = new LoginPage(this);
//        loginPage.loginToPage(username,password);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//         else{
//             username
//         }
    }

    @And("^I see welcome message as (.*)$")
    public void iSeeWelcomeMessage(String user) throws InterruptedException {

        String message = "Witaj, zalogowałeś się jako " + user + ". Możesz stąd zarządzać kursami.Tutaj.";
        String extractedMessage = driver.findElement(By.name("welcomeMsg")).getText();
        Thread.sleep(5000);
        assertEquals(extractedMessage, message);

    }

    @And("I verify I can see Add New Course Button")
    public void iVerifyICanSeeAddNewCourseButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.name("newCourseBtn")).isDisplayed();
        driver.findElement(By.name("newCourseBtn")).click();
        Thread.sleep(5000);

    }


//    @And("I go to courses page to verify I can see Add New Course Button")
//    public void iGoToCoursesPageToVerifyICanSeeAddNewCourseButton() {
//
//        driver.findElement(By.name("coursesTab")).click();
//
//    }

    @And("^I add a (.*) course with the (.*) as description")
    public void iAddANewCourseWithTheFollowingDetails(String courseName, String courseDesc) throws InterruptedException {
        driver.findElement(By.id("courseName")).isDisplayed();
        driver.findElement(By.id("courseName")).sendKeys(courseName);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(courseDesc);
        Thread.sleep(5000);

        driver.findElement(By.name("submitNewCourse")).click();
        driver.navigate().refresh();
        Thread.sleep(5000);

//        driver.findElement(By.id("courseName")).sendKeys(courseName);


    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }

    @And("I navigate to Students tab")
    public void iNavigateToStudentsTab() throws InterruptedException {
        driver.findElement(By.name("studentsTab")).click();
        Thread.sleep(5000);

    }

    @And("I delete the first student and verify it is not present in the table")
    public void iDeleteTheFirstStudentAndVerifyItIsNotPresentInTheTable() throws InterruptedException {
        Thread.sleep(5000);
        String firstStudentNameBefore = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[1]/td[3]")).getText();
        System.out.println(firstStudentNameBefore);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[1]/td[5]/img")).click();
        Thread.sleep(5000);
        //comparison
        String studentNameAfter = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[1]/td[3]")).getText();
        assertNotEquals(firstStudentNameBefore, studentNameAfter);
    }

    @And("I navigate to Courses tab")
    public void iNavigateToCoursesTab() throws InterruptedException {
        driver.findElement(By.name("coursesTab")).click();
        Thread.sleep(5000);

    }

    @And("I cannot see Add New Course button")
    public void iCannotSeeAddNewCourseButton() {
//        driver.findElement(By.name("newCourseBtn")).click();
        assertEquals(0, driver.findElements(By.name("newCourseBtn")).size());

    }

    @And("I cannot see button to delete a student")
    public void iCannotSeeButtonToDeleteAStudent() {


    }

    @And("I am able to logout")
    public void iAmAbleToLogout() throws InterruptedException {
        driver.findElement(By.name("logoutBtn")).click();
        Thread.sleep(5000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/h1")).getText(), "Zaloguj");

    }

    @And("I do not see welcome message")
    public void iDoNotSeeWelcomeMessage() throws InterruptedException {
        driver.findElement(By.name("WrongLoginDetails")).isDisplayed();
        Thread.sleep(5000);
    }


//    assertTrue(registrationConfirmation
//                       .getText()
//                .contains("Welcome to your account. Here you can manage all of your personal information and orders."));
}
