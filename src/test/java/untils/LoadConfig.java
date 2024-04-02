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

}
