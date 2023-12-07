import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {

    private static final Logger logger = LogManager.getLogger(LogHelper.class);

    public static void logDebug(String message) {
        logger.debug(message);
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }
}
