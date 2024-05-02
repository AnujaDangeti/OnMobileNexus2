package vom;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class messenger_ {

    static WebDriver driver;

    @BeforeClass
    public static void a() throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "7.0");
        capabilities.setCapability("deviceName", "Nexus 5 API 24");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
        capabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, capabilities);
    }

    @Test
    public void b() {

        driver.findElement(By.id("com.google.android.apps.messaging:id/action_search")).click();
        driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view")).click();
        driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("9381625328");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")).click();
        driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text")).click();
        driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hi,,,,,How are you");
        driver.findElement(By.id("com.google.android.apps.messaging:id/send_message_button")).click();
    }
    @AfterClass
    public static void c() {
        //close the app
        driver.quit();
    }
}