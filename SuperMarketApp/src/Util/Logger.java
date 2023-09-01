package Util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger {
    public static FileHandler fh;
    public static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(String.valueOf(Logger.class));
    public static void startLogging(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String finURL = "/Users/stanislavtimuraev/Desktop/kkk/log_" + timeStamp + ".txt";
        try {
            fh = new FileHandler(finURL);
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            LOGGER.info("START APPLICATION");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
