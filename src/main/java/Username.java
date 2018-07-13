
import org.omg.CORBA.PERSIST_STORE;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;








public class Username {
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement name;

    Actions action;

    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    private WebElement registerLink;
    public void registerLink() {
        registerLink.click();














    }

}
