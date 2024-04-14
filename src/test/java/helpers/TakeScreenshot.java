package helpers;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import untils.LoadConfig;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot implements Performable {
    private final Target target;

    public TakeScreenshot(Target target) {
        this.target = target;
    }

    public static TakeScreenshot ofElement(Target target) {
        return Tasks.instrumented(TakeScreenshot.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        File screenshot = (target.resolveFor(actor)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(LoadConfig.getScreenshotPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
