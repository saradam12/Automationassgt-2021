package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q12 {
    WebDriver wd;

    @Test
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("http://demo.guru99.com/test/drag_drop.html");
        wd.manage().window().maximize();
 //   }

 //   @Test
  //  public void dragBankBlock() {
        //Element which needs to drag.
        WebElement From= wd.findElement(By.xpath("//*[@id=\"credit2\"]/a"));

        //Element on which need to drop.
        WebElement To=wd.findElement(By.xpath("//*[@id=\"bank\"]/li"));

        //Using Action class for drag and drop.
        Actions act=new Actions(wd);

        //Dragged and dropped.
        act.dragAndDrop(From, To).build().perform();

        String expectedText = "0";
        WebElement ActualText = wd.findElement(By.id("t7"));
        Assert.assertEquals(expectedText, ActualText.getText());

        String expectedText1 = "0";
        WebElement ActualText1 = wd.findElement(By.id("t8"));
        Assert.assertEquals(expectedText1, ActualText1.getText());
   // }

   // @Test
   // public void drag5000BlockToDebitSide() {
        //Element which needs to drag.
        WebElement From1= wd.findElement(By.xpath("//*[@id=\"fourth\"]/a"));

        //Element on which need to drop.
        WebElement To1=wd.findElement(By.xpath("//*[@id=\"amt7\"]/li"));

        //Using Action class for drag and drop.
        Actions act1=new Actions(wd);

        //Dragged and dropped.
        act1.dragAndDrop(From1, To1).build().perform();

//        String expectedText = "5000";
//        WebElement ActualText = wd.findElement(By.xpath("//*[@id=\"t7\"]"));
//        Assert.assertEquals(expectedText, ActualText.getText());
//
//        String expectedText1 = "0";
//        WebElement ActualText1 = wd.findElement(By.id("t8"));
//        Assert.assertEquals(expectedText1, ActualText1.getText());
//    }
//
//    @Test
//    public void dragSalesBlock() {
        //Element which needs to drag.
        WebElement From2= wd.findElement(By.xpath("//*[@id=\"credit1\"]/a"));

        //Element on which need to drop.
        WebElement To2=wd.findElement(By.xpath("//*[@id=\"loan\"]/li"));

        //Using Action class for drag and drop.
        Actions act2=new Actions(wd);

        //Dragged and dropped.
        act2.dragAndDrop(From2, To2).build().perform();

//        String expectedText = "0";
//        WebElement ActualText = wd.findElement(By.id("t7"));
//        Assert.assertEquals(expectedText, ActualText.getText());
//
//        String expectedText1 = "0";
//        WebElement ActualText1 = wd.findElement(By.id("t8"));
//        Assert.assertEquals(expectedText1, ActualText1.getText());
//    }
//
//    @Test
//    public void drag5000BlockToCreditSide() {
        //Element which needs to drag.
        WebElement From3= wd.findElement(By.xpath("//*[@id=\"fourth\"]/a"));

        //Element on which need to drop.
        WebElement To3=wd.findElement(By.xpath("//*[@id=\"amt8\"]/li"));

        //Using Action class for drag and drop.
        Actions act3=new Actions(wd);

        //Dragged and dropped.
        act3.dragAndDrop(From3, To3).build().perform();

//        String expectedText = "0";
//        WebElement ActualText = wd.findElement(By.xpath("//*[@id=\"t7\"]"));
//        Assert.assertEquals(expectedText, ActualText.getText());
//
//        String expectedText1 = "5000";
//        WebElement ActualText1 = wd.findElement(By.id("t8"));
//        Assert.assertEquals(expectedText1, ActualText1.getText());
//    }
//
//    public void PerfectButtonDisplayed() throws InterruptedException{
        String expectedButton = "Perfect";
        byte found = 0;
        List< WebElement> perfectButton = wd.findElements(By.xpath("//*[@id=\"equal\"]/a"));
        for (WebElement button : perfectButton){
            if(button.getText().equals(expectedButton)){
                found=1;
                break;
            }
        }
    }
}

