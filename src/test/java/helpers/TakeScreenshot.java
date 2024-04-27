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
    private final String nameOfImg;

    public TakeScreenshot(Target target, String nameOfImg) {
        this.target = target;
        this.nameOfImg = nameOfImg;
    }

    public static TakeScreenshot ofElement(Target target, String nameOfImg) {
        return Tasks.instrumented(TakeScreenshot.class, target, nameOfImg);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        File screenshot = (target.resolveFor(actor)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(LoadConfig.getScreenshotPath(nameOfImg)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
