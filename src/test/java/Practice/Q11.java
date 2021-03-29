package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q11 {
    WebDriver wd;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.get("https://www.toolsqa.com/automation-practice-form/");
        wd.manage().window().maximize();
    }

    @Test
    public void VerifyPartialLinkTest() throws InterruptedException {
        WebElement partialLink = wd.findElement(By.partialLinkText("automation-practice-form"));
        partialLink.click();
        Thread.sleep(5000);
    }

    @Test
    public void VerifyLinkTest() throws InterruptedException {
        WebElement Link = wd.findElement(By.linkText("automation-practice-table"));
        Link.click();
        Thread.sleep(5000);
    }
}
