package pages;

import io.appium.java_client.MobileElement;
import utils.BaseTest;

import java.net.MalformedURLException;


public class DemoPage extends BaseTest {
    final private String changeLogApplyId = "com.touchboarder.android.api.demos:id/buttonDefaultPositive";
    final private String apiDemosText = "API Demos";
    final private String viewsText = "Views";
    final private String controlsText = "Controls";
    final private String lightThemeText = "01. Light Theme";
    final private String buttonsText = "Buttons";
    final private String autoCompleteText = "Auto Complete";
    final private String scrollText = "3. Scroll";
    final public String normalBtn = "com.touchboarder.android.api.demos:id/button_normal";
    final public String checkbox1Id = "com.touchboarder.android.api.demos:id/check1";

    public DemoPage() throws MalformedURLException {
        super();
    }

    public void pressOkBtn(){
        this.clickAndWaitId(this.changeLogApplyId);
    }

    public void pressApiDemoBtn() {
        this.clickByTextContain(this.apiDemosText);
    }

    public void pressViewBtn() {
        this.clickByTextContain(this.viewsText);
    }

    public void pressButtonsBtn() {
        this.clickByTextContain(this.buttonsText);
    }

    public void pressControlsBtn() {
        this.clickByTextContain(this.controlsText);
    }

    public void pressLightThemeBtn() {
        this.clickByTextContain(this.lightThemeText);
    }

    public void selectCheckBox1() {
        this.clickById(this.checkbox1Id);
    }

    public void pressNormalBtn() {
        this.clickById(this.normalBtn);
    }

    public MobileElement getPerfomNormalBtn() {return this.getPerfomActionById(normalBtn);}

    public void pressAutoCompleteBtn() {
        this.clickByTextContain(this.autoCompleteText);
    }

    public void pressScrollBtn() {
        this.clickByTextContain(this.scrollText);
    }

    public void scrollAction(String textContain){
        this.scroll(textContain);
    }



}
