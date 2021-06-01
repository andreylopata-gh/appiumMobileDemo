import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DemoPage;

import java.net.MalformedURLException;

public class MainTest {
    DemoPage demoPage;

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        demoPage = new DemoPage();
    }

    @AfterMethod
    public void afterMethod() {}

    @AfterAll
    public void afterAll() {
        demoPage.closeDriver();
    }

    @Test
    public void buttonTest() throws Exception {
        demoPage.pressOkBtn();
        demoPage.pressApiDemoBtn();
        demoPage.pressViewBtn();
        demoPage.pressButtonsBtn();

         MobileElement elem1 = demoPage.getPerfomNormalBtn();
        // Do something next with elem1
    }

    @Test
    public void selectTest() throws Exception {
        demoPage.pressOkBtn();
        demoPage.pressApiDemoBtn();
        demoPage.pressViewBtn();
        demoPage.pressControlsBtn();
        demoPage.pressLightThemeBtn();
        demoPage.selectCheckBox1();

        MobileElement checkboxElem1 = demoPage.getElementById(demoPage.checkbox1Id);
        String actualCheckedResult = checkboxElem1.getAttribute("checked");

        Assert.assertEquals(actualCheckedResult,"true");
    }

    @Test
    public void scrollingTest() throws Exception {
        demoPage.pressOkBtn();
        demoPage.pressApiDemoBtn();
        demoPage.pressViewBtn();
        demoPage.pressAutoCompleteBtn();
        demoPage.pressScrollBtn();

        demoPage.scrollAction("BUTTON"); // possible to scroll to any element
    }

}

