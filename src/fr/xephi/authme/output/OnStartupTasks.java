package fr.xephi.authme.output;

import org.apache.logging.log4j.LogManager;
import org.bukkit.Bukkit;

import java.util.logging.Logger;


/**
 * Contains actions such as migrations that should be performed on startup.
 */
public class OnStartupTasks {

    OnStartupTasks() {
    }

    /**
     * Sets up the console filter if enabled.
     *
     * @param settings the settings
     * @param logger   the plugin logger
     */
    public static void setupConsoleFilter(Logger logger) {
        // Try to set the log4j filter
        try {
            Class.forName("org.apache.logging.log4j.core.filter.AbstractFilter");
            setLog4JFilter();
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            // log4j is not available
            ConsoleFilter filter = new ConsoleFilter();
            logger.setFilter(filter);
            Bukkit.getLogger().setFilter(filter);
            Logger.getLogger("Minecraft").setFilter(filter);
        }
    }

    // Set the console filter to remove the passwords
    private static void setLog4JFilter() {
        org.apache.logging.log4j.core.Logger logger;
        logger = (org.apache.logging.log4j.core.Logger) LogManager.getRootLogger();
        logger.addFilter(new Log4JFilter());
    }

}
