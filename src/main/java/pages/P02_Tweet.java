package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02_Tweet {
    private WebDriver driver;
    public P02_Tweet(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement whatHappeningElement(){
        return this.driver.findElement(By.className("public-DraftStyleDefault-block"));
    }
    public WebElement tweetBTN(){
        //return this.driver.findElement(By.cssSelector("div[aria-disabled=\"false\"]"));
        return this.driver.findElement(By.cssSelector("div[dir=\"auto\"] > span[class=\"css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0\"]"));
    }
    public WebElement recentTweet(){
        return this.driver.findElement(By.cssSelector("div[class=\"css-1dbjc4n r-18u37iz\"] > span[class=\"css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0\"]"));

    }
    public List<WebElement> alretTweet(){
        return this.driver.findElements(By.cssSelector("span[class=\"css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0\"]"));

    }
    public WebElement photoIcon(){

          return this.driver.findElement(By.cssSelector("div[aria-label=\"Add photos\"]"));
//        return this.driver.findElement(By.xpath("//input[@accept=\"image/jpeg,image/png,image/webp,image/gif,video/mp4,video/quicktime\"]"));
//
//        return this.driver.findElement(By.cssSelector("div[aria-label=\"Add photos or video\"] > input[class=\"r-8akbif r-orgf3d r-1udh08x r-u8s1d r-xjis5s r-1wyyakw\"]"));

    }
    public WebElement imgInput(){
          return this.driver.findElement(By.xpath("//input[@accept]"));

    }
    public WebElement addPoll(){

        return this.driver.findElement(By.cssSelector("div[aria-label=\"Add poll\"]"));
    }
    public WebElement addGif(){

        return this.driver.findElement(By.cssSelector("div[aria-label=\"Add a GIF\"]"));
    }

    public List<WebElement> editBTNs(){
        return this.driver.findElements(By.cssSelector("div[aria-label=\"Edit media\"]"));
    }
   public WebElement saidBefore(){
        return this.driver.findElement(By.cssSelector("div[aria-live=\"assertive\"] > span[class=\"css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0\"]"));
   }
public WebElement profileSection(){
    return this.driver.findElement(By.cssSelector("a[aria-label=\"Profile\"]"));
}
    public WebElement lastTweet(){
        return this.driver.findElement(By.cssSelector("div[data-testid=\"tweetText\"] > span[class=\"css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0\"]"));
    }
    public WebElement thumbnail(){
        return this.driver.findElement(By.cssSelector("div[data-testid=\"card.wrapper\"]"));
    }


}




