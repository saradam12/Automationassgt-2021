package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class from {
    @Test
public void testSlider(){
    System.setProperty("webdriver.chrome.driver", "C:\\Projects\\SeleniumDrivers\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("http://rangeslider.js.org/");

    //To slide using action class
    slide(driver, 500);

    //To slide using jQuery
    slideUsingJQuery(driver, 100);


}

    public void slide(WebDriver driver, int value){

        WebElement slider=driver.findElement(By.id("js-rangeslider-0"));
        WebElement sliderHandle=driver.findElement(By.cssSelector("#top .rangeslider__handle"));
        int width=slider.getSize().getWidth();
        int x=(int)Float.parseFloat(sliderHandle.getCssValue("left").replace("px", ""));
        System.out.println(width);
        float min=10;
        float max=1000;
        float offsetX=width/(max-min)*value;
        System.out.println(offsetX);

        new Actions(driver).dragAndDropBy(sliderHandle, -x, 10).dragAndDropBy(sliderHandle, (int)offsetX, 10).perform();

    }

    public void slideUsingJQuery(WebDriver driver, int value){
        WebElement slider=driver.findElement(By.cssSelector("input[type='range']"));
        ((JavascriptExecutor)driver).executeScript("$(arguments[0]).val("+value+").change()", slider);

    }
}
