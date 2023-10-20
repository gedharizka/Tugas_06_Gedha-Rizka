package sauce_demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Test {
    WebDriver driver;

    public Login_Test(){
        this.driver = WebDriverSingleton.getDriver();
    }

    @Given("user is on the Saucedemo login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters valid username and password")
    public void userEntersValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("clicks the login button")
    public void userClicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is redirected to the products page")
    public void userIsRedirectedToProductsPage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("user not input username")
    public void userNotInputUserName(){
        driver.findElement(By.id("user-name")).sendKeys("");
    }

    @When("user input valid password")
    public void userInputValidPassword(){
        driver.findElement(By.id("password")).sendKeys("admin123");
    }

    @Then("error message showing")

    public void showErrorRequired(){

        String errorElement = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Epic sadface: Username is required",errorElement);
    }

}
