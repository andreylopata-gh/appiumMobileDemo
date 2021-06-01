package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private AndroidDriver<MobileElement> driver;
    private DesiredCapabilities cap;
    private WebDriverWait wait;
    //private TouchAction touchAction;

    public BaseTest() throws MalformedURLException {
        //AppiumDriverLocalService appiumService = AppiumDriverLocalService.buildDefaultService();
        this.init();
    }

    public void init() throws MalformedURLException {
        this.cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.253.101:5555");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

        cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
        cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");

        this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 10);
       // this.touchAction = new TouchAction(driver);

    }

    public void clickAndWaitId(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id(id))).click();
    }

    public void clickById(String id, Integer numberOfElem) {
        driver.findElementsById(id).get(numberOfElem).click();
    }

    public void clickByTextContain (String text) {
        driver.findElementByXPath("//*[@text='" + text + "']").click();
    }

    public void clickById(String text) {
        driver.findElementById(text).click();
    }

    public MobileElement getElementByText(String text) {
       return this.driver.findElementByXPath("//*[@text='" + text + "']");
    }

    public MobileElement getElementById(String text) {
        return this.driver.findElementById(text);
    }

    public MobileElement getPerfomActionById (String id) {
//        return this.touchAction.tap(TapOptions.tapOptions()
//                .withElement(ElementOption.element(driver.findElement(By
//                        .id(id)))))
//                .perform();
        return this.driver.findElementById(id);
    }

    public void scroll(String text){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
    }

    public void scrollTo()throws Exception{
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.80);
        int bottom_y = (int)(height*0.20);

        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);

       // TouchAction touchAction = new TouchAction(driver);
       // touchAction.press(x, top_y).moveTo(x, bottom_y).release().perform();
    }


    public void closeDriver(){
        this.driver.close();
    }


}


