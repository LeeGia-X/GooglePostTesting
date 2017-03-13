package GooglePostPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Кемко on 13.03.2017.
 */
public class GooglePost {
    WebDriver driver;

    public GooglePost(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage mainPage() {return new MainPage(driver);}
    public MessagePage messagePage() {return new MessagePage(driver);}
}
