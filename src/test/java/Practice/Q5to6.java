package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q5to6 {
    WebDriver wd;
    Actions action;



    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @Test
    //5.Verify the Newsletter section works
    public void VerifyNewsletterSection() throws InterruptedException {
        //user enters email in email field
        WebElement emailElement = wd.findElement(By.cssSelector("#newsletter-input"));
        String email = "aarikal@gmail.com";
        emailElement.sendKeys(email);
        WebElement nextButtonElement = wd.findElement(By.xpath("//*[@id=\"newsletter_block_left\"]/div/form/div/button"));
        nextButtonElement.click();
        Thread.sleep(5000);
        String expectedMessage = "Newsletter:You have successfully subscribed to this newsletter.";
        WebElement elementMessage = wd.findElement(By.xpath("//*[@id=\"columns\"]/p"));
        Assert.assertEquals(expectedMessage, elementMessage.getText());
    }

    @Test
    public void VerifyNewsletterSection1() throws InterruptedException {
        //user enters wrong email in email field
        WebElement emailElement = wd.findElement(By.cssSelector("#newsletter-input"));
        String email = "aarika.luzaanewa27@gmailcom";
        emailElement.sendKeys(email);
        WebElement nextButtonElement = wd.findElement(By.xpath("//*[@id=\"newsletter_block_left\"]/div/form/div/button"));
        nextButtonElement.click();
        Thread.sleep(5000);
        String expectedMessage = "Newsletter : Invalid email address.";
        WebElement elementMessage = wd.findElement(By.xpath("//*[@id=\"columns\"]/p"));
        Assert.assertEquals(expectedMessage, elementMessage.getText());
    }

    //    // 6. Scroll bar: Click on Women menu, change the price range using automation to maximum $53 to $53.
//    slide(wd, 500);

   @Test
   public void ScrollPriceRange () {


        /*action = new Actions(wd);
       boolean isRight = true;
       if (isRight) {
           int noOfMoves =0;
           for (int i = 0; i < noOfMoves; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        } else {
           //for(int i=0;i<noOFMoves;i++){
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
        //}
       }*/

            wd.get("http://automationpractice.com/index.php?id_category=3&controller=category");
            wd.manage().window().maximize();
            WebElement leftSlider = wd.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
            leftSlider.sendKeys(Keys.PAGE_DOWN);

            for (int i=1;i<=100;i++){
                leftSlider.sendKeys(Keys.ARROW_RIGHT);
            }

            WebElement priceElement = wd.findElement(By.xpath("//*[@id=\"layered_price_range\"]"));
                    //("//*[@id=\"layered_price_slider\"]/a[1]"));

       //*[@id="layered_price_range"]
            String priceText = priceElement.getText();
            System.out.println(priceText);
            String ExpectedText = "$53.00 - $53.00";



            if (priceText.equals(ExpectedText)) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
            }
        }
    }



