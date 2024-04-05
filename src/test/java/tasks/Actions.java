package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.AdminPage;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;
import untils.LoadConfig;

import java.nio.file.Path;

public class Actions {
    public static Performable inputData(Target target, String value) {
        return Task.where("{0} input data",
                Clear.field(target),
                Enter.theValue(value).into(target)
        );
    }
    public static Performable chooseOption(Target target, Target targetList, String value) {
        return Task.where("{0} choose options",
                Click.on(target),
                Click.on(targetList.of(value))
        );
    }
    public static Performable upLoadIMG(Target target, String type) {
        return Task.where("Upload image",
                Upload.theFile(Path.of(LoadConfig.getImagePath(type))).to(target));
    }
}
