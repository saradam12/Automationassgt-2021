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

public class Q9 {
// Verify Cart Functionality Works -Click on Dresses-CLick on the last image from the gallery
    //again click to go to View Larger Picture - Change the number of quantity to 3 - size to large
    //Click Add to Cart button - verify the pop up size, Quantity and Total Price
    //Close the button and web driver

    WebDriver wd;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @Test
    public void DressesMenu() throws InterruptedException {
        WebElement dresses = wd.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        dresses.click();
        Thread.sleep(3000);

        WebElement clickListElement = wd.findElement(By.xpath("//*[@id=\"list\"]/a"));
        clickListElement.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        clickListElement.click();
        Thread.sleep(3000);

        WebElement clickPicElement = wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div/div[2]/h5/a"));
        clickPicElement.click();
        Thread.sleep(3000);

        WebElement LargerView = wd.findElement(By.xpath("//*[@id=\"view_full_size\"]/span"));
        LargerView.click();
        Thread.sleep(5000);

        WebElement CloseLargerView = wd.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/a"));
        CloseLargerView.click();
        Thread.sleep(2000);

        WebElement addQuantity = wd.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        addQuantity.clear();
        Thread.sleep(2000);
        addQuantity.sendKeys("3");
        Thread.sleep(3000);

        WebElement selectSize = wd.findElement(By.xpath("//*[@id=\"group_1\"]"));
        selectSize.sendKeys("L");
        Thread.sleep(3000);

        WebElement AddToCart = wd.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        AddToCart.click();
        Thread.sleep(3000);

       String expectedSize = "Yellow, L";
        WebElement ActualSize = wd.findElement(By.xpath("//span[text()= 'Yellow, L']"));
        Assert.assertEquals(expectedSize, ActualSize.getText());

        String expectedQuantity = "3";
        WebElement ActualQuantity = wd.findElement(By.xpath("//span[text()= '3']"));
        Assert.assertEquals(expectedQuantity, ActualQuantity.getText());

//       String expectedTotal = "$49.20";
//       WebElement ActualTotal = wd.findElement(By.xpath("//span[text()='$49.20']"));
//       Assert.assertSame(expectedTotal, ActualTotal.getText());
//        // assertEquals(expectedTotal, ActualTotal.getText());
        Thread.sleep(3000);

        WebElement ClosePopUpWindow = wd.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
        ClosePopUpWindow.click();
        Thread.sleep(5000);
    }

   @After
  public void end (){ wd.close();}
    }



