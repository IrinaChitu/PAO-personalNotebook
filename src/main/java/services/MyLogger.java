package services;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MyLogger {
    private MyLogger() {}

    static private Formatter CSVFormat = new Formatter() { // TXT formatter
        public String format(LogRecord record) {
            Date timestamp = new Date();
            String action = record.getMessage();
            String loggerName = record.getLoggerName();

            String log = timestamp + ": " + action + " - " + loggerName + "\n";
            return log;
        }
    };

    public static Logger getInstance() throws IOException {
        Logger logger = Logger.getLogger("personalNotebook.Logger");

        FileHandler fileHandler = new FileHandler("./src/main/resources/logging.txt", true);
        fileHandler.setFormatter(MyLogger.CSVFormat);
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);

        return logger;
    }
}
