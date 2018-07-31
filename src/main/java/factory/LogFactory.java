package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFactory {

    public static Logger getLogger(Class aClass) {
        String name = aClass.getName();
        Logger logger = LogManager.getLogger(name);
        return logger;
    }
}
