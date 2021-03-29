package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Q1to4 {
    WebDriver wd;

    // 1. Automation Script to verify the title of the page
    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @Test
    public void VerifyTitle() {
        wd.get("http://automationpractice.com/index.php");
        String expectedTitle = wd.getTitle();
        System.out.println("title = " + expectedTitle);
        Assert.assertEquals(expectedTitle, "My Store");
        wd.quit();
    }

    //2. Search dress code as Saree
    @Test
    public void SareeDressCode() {
        wd.get("http://automationpractice.com/index.php");
        String expectedDress = "Saree";
        byte found = 0;
        List<WebElement> rows = wd.findElements(By.xpath("//a[@title='Saree']"));
        for (WebElement row : rows) {
            if (row.getText().equals(expectedDress)) {
                found = 1;
                break;
            }
        }
        Assert.assertEquals(1, found);
    }

    // 3. Verify shopping cart is empty initially,
    // when clicked on empty cart, it brings you cart summary page with message "Your shopping cart is empty."

    @Test
    public void EmptyCart() throws InterruptedException {
        wd.get("http://automationpractice.com/index.php");
        WebElement clickElement = wd.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        clickElement.click();
        Thread.sleep(5000);
        String expectedMessage = "Your shopping cart is empty.";
        WebElement elementMessage = wd.findElement(By.xpath("//p[text()= 'Your shopping cart is empty.']"));
        Assert.assertEquals(expectedMessage, elementMessage.getText());
    }

    //4. Verify My Account Footer Section has links using an Array String
    // a. My orders b. My credit slips c. My addresses d. My personal info
    @Test
    public void findMyOrderFromMyAccount() {
        // a. My orders
        String verifyLinks = "My personal info";
       // List<WebElement> linkElements = wd.findElements(By.linkText("My orders"));
        //b. My credit slips  List<WebElement> linkElements = wd.findElements(By.linkText("My orders"));
        //c. My addresses List<WebElement> linkElements = wd.findElements(By.linkText("My addresses"));
        List<WebElement> linkElements = wd.findElements(By.linkText("My personal info"));
       String [] linkTexts = new String[linkElements.size()];
       int i = 0;

       //extract the link texts of each link element
        for (WebElement elements : linkElements){
            linkTexts[i] = elements.getText();
            i++;
        }

        //test each link
        for (String t : linkTexts){
            wd.findElement(By.linkText(t)).click();
                      if(wd.getTitle().equals(verifyLinks)){
                System.out.println("\"" + t + "\"" + " is not working.");
            } else {
                System.out.println("\"" + t + "\"" + " is working.");
            }
        }
    }
}