package sauce_demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage_Test {
    WebDriver driver;

    public CheckoutPage_Test(){
        this.driver = WebDriverSingleton.getDriver();
    }

    @Given("user on page cart.html")
    public void userLogedinOnInventoryPage(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
         driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        System.out.println("Execute :D");
    }
    @When("user click checkout")
    public void userClickCheckout(){
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("user redirect to page checkout setp one")
    public void checkRedirect (){
        String chekPage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println("CHeck" + chekPage);
        Assert.assertEquals("Checkout: Your Information", chekPage);

    }



}
