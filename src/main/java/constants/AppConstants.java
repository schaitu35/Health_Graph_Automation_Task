package constants;

import java.io.File;

public interface AppConstants {

    String BASE_PATH = System.getProperty("user.dir");
    String CONFIG_PATH = BASE_PATH +  File.separator + "src/test/resources/configuration.properties";
}
