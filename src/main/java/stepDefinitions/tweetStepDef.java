package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.P01_login;
import pages.P02_Tweet;

import java.util.concurrent.TimeUnit;

public class tweetStepDef {
    WebDriver driver = null;
    P01_login login;

    P02_Tweet tweet;
    @Given("^user open browser and navigates to twitter then sign in with \"(.*)\" & \"(.*)\"$")
    public void userNavigationToTwitterAndLogin(String phone,String password) throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://twitter.com/");
        tweet =new P02_Tweet(driver);
        login =new P01_login(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login.signInBTN().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        login.loginSteps(phone,password);
        Thread.sleep(1000);
    }
    @When("^user enter \"(.*)\" on what's happening container$")
    public void clickContainer(String tweett) throws InterruptedException {
        tweet.whatHappeningElement().sendKeys(tweett);
    }
    @And("click Tweet")
    public void shareTweet() throws InterruptedException {
        String keysPressed =  Keys.chord(Keys.CONTROL, Keys.RETURN);
        tweet.whatHappeningElement().sendKeys(keysPressed) ;
        Thread.sleep(3000);
    }

    @Then("tweet is shared successfully")
    public void tweetSuccess() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //tweet entered from step 1
        String er ="test!";
        tweet.profileSection().click();
        //check the last added tweet in my profile
        String ar =tweet.lastTweet().getText();
        Assert.assertEquals(ar.equals(er),true);

        driver.navigate().to("https://twitter.com/home");

    }
    @Then("^error message \"(.*)\"$")
    public void saidBefore(String err) throws InterruptedException {
         System.out.println(err);
         //get error flash message text
         String ar = tweet.saidBefore().getText();
         //check err equals to error flash message text
         Assert.assertEquals(ar.equals(err),true);
         Thread.sleep(2000);
    }
    @When("user input an image at what's happening container")
    public void clickImageIcon() throws InterruptedException {
      // path to image
        String photo = System.getProperty("user.dir")+"\\src\\main\\resources\\test.png";
        tweet.imgInput().sendKeys(photo);
        Thread.sleep(1000);
    }
    @Then("photo is displayed on the container")
    public void photoDisplayed() throws InterruptedException {
               System.out.println(tweet.editBTNs().size());
               int er = 1;
               int ar = tweet.editBTNs().size();
              //check that there is 1 "edit" buttons for image in the tweet container
              Assert.assertEquals(er, ar);
     }
    @Then("2 photo is displayed on the container")
    public void twoPhotos() throws InterruptedException {
        System.out.println(tweet.editBTNs().size());
        int er = 2;
        int ar = tweet.editBTNs().size();
        //check that there are 2 "edit" buttons for photos in the tweet container

        Assert.assertEquals(er, ar);
    }
    @Then("3 photo is displayed on the container")
    public void threePhotos() throws InterruptedException {
        System.out.println(tweet.editBTNs().size());
        int er = 3;
        int ar = tweet.editBTNs().size();
        //check that there are 3 "edit" buttons for photos in the tweet container

        Assert.assertEquals(er, ar);
    }
    @Then("4 photo is displayed on the container and the image icon is disabled")
    public void fourPhotos() throws InterruptedException {
        System.out.println(tweet.editBTNs().size());
        int er = 4;
        int ar = tweet.editBTNs().size();
        //check that there are 4 "edit" buttons for photos in the tweet container
        Assert.assertEquals(er, ar);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //check an image input is disabled
        boolean er1 = tweet.imgInput().isEnabled();
        //aria-disabled attribute is set to true when the icon is disabled
        boolean er2 = Boolean.parseBoolean(tweet.addGif().getAttribute("aria-disabled"));
        //aria-disabled attribute is set to true when the icon is disabled
        boolean er3 = Boolean.parseBoolean(tweet.addPoll().getAttribute("aria-disabled"));
        //three assertions to check that image, Gif and pool icons are disabled
        Assert.assertFalse(er1);
        Assert.assertTrue(er2);
        Assert.assertTrue(er3);
    }
    @When("^user enters URL \"(.*)\"$")

    public void enterURL(String url) throws InterruptedException {
      tweet.whatHappeningElement().sendKeys(url);
    }
    @Then("thumbnail to the URL is displayed")

    public void thumbnailDisplayed() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //return whether the thumbnail is displayed or not
        boolean displayed = tweet.thumbnail().isDisplayed();
        Assert.assertTrue(displayed);
    }
   @Then("quit")
    public void quit(){
        driver.quit();
   }

}