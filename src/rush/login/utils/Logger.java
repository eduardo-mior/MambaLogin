package rush.login.utils;

import static org.bukkit.Bukkit.getLogger;

/**
 * @author Mior
 * @version 1.0
 * @category utils
 */

public class Logger {

	public static void info(String info) {
		getLogger().info("§f[Login] " + info);
	}
	
	public static void warn(String warn) {
		getLogger().warning("§e[Login] " + warn);
	}
	
	public static void error(String error) {
		getLogger().severe("§c[Login] " + error);
	}
}
