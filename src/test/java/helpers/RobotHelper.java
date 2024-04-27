package helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import untils.WaitABit;

import java.awt.*;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RobotHelper {
    public static Performable clearField(Target target) {
        return Task.where("{0] clear the field: " + target.getName(),
                actor -> {
                    actor.attemptsTo(
                            WaitUntil.the(target, isVisible()).forNoMoreThan(120).seconds(),
                            Click.on(target),
                            WaitABit.inSecond(3)
                    );
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_A);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        );
    }
}
