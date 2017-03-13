import GooglePostPages.GooglePost;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGmailPost {
    private WebDriver driver;
    By postLocator = By.linkText("Почта");
    By usernameLocator = By.id("Email");
    By passwordLocator = By.id("Passwd");
    By nextButtonLocator = By.id("next");
    By loginButtonLocator = By.id("signIn");
    String url = "https://www.google.by";
    String username = "iryna.kemko@gmail.com";
    String password = "q1w2e3r4t5y6u7qwertyu";
    GooglePost googlePost;

    //mail authorization
    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(postLocator).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(nextButtonLocator).click();
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    //letter writing and sending
    @Ignore
    public void sendLetter(){
        googlePost = new GooglePost(driver);
        googlePost.mainPage().writeLetterButton.click();
        googlePost.messagePage().writeLetter("LeeX@tut.by","Test","TestGmailLetter");
        googlePost.messagePage().sendButton.click();
    }

    //draft letter writing
    @Ignore
    public void letterDraft(){
        googlePost = new GooglePost(driver);
        googlePost.messagePage().writeLetter("LeeX@tut.by","Test","TestGmailDraft");
        googlePost.messagePage().closeLetterButton.click();
    }

    //letter answering
    @Ignore
    public void replyLetter() {
        googlePost = new GooglePost(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector(".yW"));
        for (WebElement el:elements) {
            if (el.findElement(By.cssSelector("span")).getAttribute("email").equals("leex@tut.by")) {
                System.out.println(el.findElement(By.cssSelector("span")).getAttribute("email")+"*");
                el.click();
                googlePost.messagePage().answerLetter("TestGmailAnswer");
                googlePost.messagePage().backToIncomingButton.click();
            }
            else
                System.out.println(el.findElement(By.cssSelector("span")).getAttribute("email"));
        }
    }

    //browser closing
    @AfterTest
    public void tearDown() {
        //Close the browser
        //if (driver != null)
        //    driver.quit();
    }
}