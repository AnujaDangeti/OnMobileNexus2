package vom;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class calculator3 {
    static WebDriver driver;
    @BeforeClass
    public static void a() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "7.0");
        capabilities.setCapability("deviceName", "Nexus 5 API 24");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl,capabilities);
    }
    @Test
    public void b() throws Exception {
        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();

        WebElement sub= driver.findElement(By.id("com.android.calculator2:id/op_sub"));
        sub.click();
        WebElement two= driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        two.click();
        WebElement equalTo = driver.findElement(By.id("com.android.calculator2:id/eq"));
        equalTo.click();
        //locate the edit box of the calculator by using By.tagName()
        String results=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        if(results.equals("6"))
        {
            System.out.println("Test passed.....");
        }
        else
        {
            System.out.println("Test failed.....");
        }
    }
    @AfterClass
    public static void c(){
        //close the app
        driver.quit();
    }


}
