package untils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class LoadConfig {
    private static EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getURLAdmin() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments.adminLoginUrl");
    }

    public static String getURLClient() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments.clientLoginUrl");
    }

    public static String getUserName(String auth) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments." + auth + ".username");
    }

    public static String getPassword(String auth) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments." + auth + ".password");
    }

    public static String getUserNamePartner30(String auth) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments." + auth + ".username30");
    }

    public static String getPasswordPartner30(String auth) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments." + auth + ".password30");
    }
    public static String getImagePath(String value, String type) {
        return System.getProperty("user.dir") + EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments.imagePath") + value + type;
    }
    public static String getScreenshotPath(String nameOfIMG) {
        return System.getProperty("user.dir") + EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("enviroments.screenShotPath") + nameOfIMG + ".png";
    }
}
