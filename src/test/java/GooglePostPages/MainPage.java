package GooglePostPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Кемко on 12.03.2017.
 */
public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "z0")
    public WebElement writeLetterButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

}
