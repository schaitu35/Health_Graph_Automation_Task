package utils;

import constants.AppConstants;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropReader {

    @SneakyThrows
    public Properties initProps(){
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(AppConstants.CONFIG_PATH);
        properties.load(fileInputStream);
        return properties;
    }

}
