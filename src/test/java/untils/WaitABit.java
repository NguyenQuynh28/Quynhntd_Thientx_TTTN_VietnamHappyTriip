package untils;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class WaitABit {
    public static Performable inSecond(int second) {
        return Task.where("{0} wait in: " + second + "second",
                actor -> {
                    try {
                        Thread.sleep(second * 1000L);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        );
    }
}
