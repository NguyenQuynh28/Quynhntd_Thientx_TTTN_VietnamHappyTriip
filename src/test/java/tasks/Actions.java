package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.AdminPage;

import net.serenitybdd.screenplay.targets.Target;

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
}
