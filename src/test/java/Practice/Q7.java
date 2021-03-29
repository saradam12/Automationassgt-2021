package Practice;

import cucumber.api.java.cs.A;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// Q7. Click on dresses-Change view from Grid to List-Click on 4th image-Click to see larger picture
// click next to see scroll all the images-close image(close button)
public class Q7 {
    WebDriver wd;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }
@Test
    public void ImageHandling() throws InterruptedException {
     WebElement clickElement = wd.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
    clickElement.click();
    Thread.sleep(5000);

    WebElement clickListElement = wd.findElement(By.xpath("//*[@id=\"list\"]/a"));
    clickListElement.sendKeys(Keys.PAGE_DOWN);
    Thread.sleep(5000);
    clickListElement.click();
    Thread.sleep(5000);

    WebElement clickPicElement = wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div/div[2]/h5/a"));
    clickPicElement.click();
    Thread.sleep(5000);

   WebElement LargerView= wd.findElement(By.xpath("//*[@id=\"thumb_16\"]"));
  LargerView.click();
   Thread.sleep(5000);

    WebElement slideView= wd.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div[1]/a[2]"));
    slideView.click();
    Thread.sleep(5000);

    for(int i=1; i<=2;i++){
        slideView = wd.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div[1]/a[2]"));
        slideView.click();
        Thread.sleep(3000); }

    WebElement CloseView= wd.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a"));
    CloseView.click();
    Thread.sleep(5000);
}
    @After
    public void end (){ wd.close();}
}
