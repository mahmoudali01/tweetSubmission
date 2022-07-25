package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_login {
    private WebDriver driver;
    public P01_login(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement signInBTN(){
        return this.driver.findElement(By.cssSelector("a[href=\"/login\"]"));

    }
    public WebElement emailUsernamePhoneField(){

        return this.driver.findElement(By.cssSelector("input[name=\"text\"]"));
        //return this.driver.findElement(By.tagName("input"));

    }
    public WebElement passField(){

        return this.driver.findElement(By.cssSelector("input[name=\"password\"]"));
       // return this.driver.findElement(By.tagName('input'));

    }



    public void loginSteps(String phone , String password) throws InterruptedException {
        emailUsernamePhoneField().sendKeys(phone);
        emailUsernamePhoneField().sendKeys(Keys.ENTER);
        Thread.sleep(500);
        passField().sendKeys(password);
        passField().sendKeys(Keys.ENTER);
        Thread.sleep(500);

    }
}