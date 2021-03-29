package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Q8 {
    // Verify Add to Cart works
    // Select 3rd item from index page and add to cart. Verify after adding,
    // the status of cart on top right corner changes from empty to 1
    WebDriver wd;

        @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }
@Test
    public void VerifyAddToCart ()throws InterruptedException {
    WebElement thirdDress = wd.findElement(By.xpath("//*[@id='homefeatured']/li[3]/div/div[2]/h5/a"));
   thirdDress.click();
    Thread.sleep(5000);

    WebElement addToCart = wd.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
    addToCart.click();
    Thread.sleep(5000);

    String expectedMessage = "There is 1 item in your cart.";
    WebElement elementMessage = wd.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/h2/span[2]"));
    Assert.assertEquals(expectedMessage, elementMessage.getText());

    WebElement proceedToCheckout = wd.findElement(By.linkText("Proceed to checkout"));
    proceedToCheckout.click();

    String expectedCart1 = "1";
    WebElement Cart1 = wd.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]"));
    Assert.assertEquals(expectedCart1, Cart1.getText());
    Thread.sleep(5000);
}

@After
    public void end (){ wd.close();}
}
