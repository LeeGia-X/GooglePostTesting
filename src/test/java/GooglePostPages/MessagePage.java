package GooglePostPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Кемко on 11.03.2017.
 */
public class MessagePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div[class='ar6 T-I-J3 J-J5-Ji']")
    public WebElement backToIncomingButton;

    @FindBy(css = ".Ha")
    public WebElement closeLetterButton;

    @FindBy(css = ".amn")
    private WebElement messageAreaActivation;

    @FindBy(name = "to")
    private  WebElement emailArea;

    @FindBy(name = "subjectbox")
    private WebElement subjectArea;

    @FindBy(css = ".Am")
    private WebElement messageArea;

    @FindBy(css = ".aoO")
    public WebElement sendButton;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void messageInput(String message) {
        messageArea.click();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        messageArea.sendKeys(message);
    }
    public void emailAndSubjectInput (String email, String subject){
        emailArea.sendKeys(email);
        subjectArea.sendKeys(subject);
    }

    public void writeLetter(String email, String subject, String message){
        emailAndSubjectInput(email, subject);
        messageInput(message);
    }

    public void answerLetter(String message){
        messageAreaActivation.click();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".Am")));
        messageInput(message);
        sendButton.click();
    }
}
