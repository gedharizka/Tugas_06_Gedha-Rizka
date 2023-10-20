package sauce_demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart_Test {
    WebDriver driver;

    public AddToCart_Test(){
        this.driver = WebDriverSingleton.getDriver();
    }

    @Given("user is loggedin on inventory page")
    public void userLogedinOnInventoryPage(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click add to cart")
    public void addToCart(){
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("cart item increment")
    public void checkCartItem(){
        String itemCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).getText();
        Assert.assertEquals("1",itemCart);
    }


}
